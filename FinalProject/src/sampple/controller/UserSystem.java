package sampple.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sampple.model.Uinfo;
import sampple.model.Users;
import sampple.model.service.UsersService;
import sampple.util.AdMailUtils;
import sampple.util.CryptUtil;
import sampple.util.MailUtils;
import sampple.util.VerifyUtil;

@Controller
public class UserSystem {
	private UsersService usersService;

	@Autowired
	public UserSystem(UsersService usersService) {
		this.usersService = usersService;
	}

	
	/* sign up controller */
	@PostMapping(path = "/signup")
	public String processSignUp(@RequestParam("email") String email,
			@RequestParam("password") String password,@RequestParam("name") String name,
			@RequestParam("id") String id,@RequestParam("addr") String addr,
			@RequestParam("gender") String gender,@RequestParam("birth") String birth,
			@RequestParam("tel") String tel,@RequestParam(defaultValue = "N", value = "ademail") String ademail,Model model) throws AddressException, MessagingException, GeneralSecurityException, IOException {
		
		if (!new VerifyUtil().chkLogin(email, password)) {
			
			return "RigsterPage.jsp";
		}
		//送出註冊驗證信狀態
		String type="sign";
	
		
		// Step1. check user Input is match or not
		Users users=new Users();
		users.setEmail(email);
		
		users.setPassword(new CryptUtil().encoding(password));
		users.setStatus("N");
		users.setDeleteFlag("N");
		
		Uinfo uinfo=new Uinfo();
		uinfo.setName(name);
		uinfo.setId(id);
		uinfo.setAddr(addr);
		uinfo.setGender(gender);
		uinfo.setBirth(birth);
		uinfo.setTel(tel);
		uinfo.setAdemail(ademail);
		uinfo.setUtype("N");
		uinfo.setPicture("/user_img/head.jpg");
		
		users.setUinfo(uinfo);
		uinfo.setUsers(users);
		
		boolean status = usersService.insert(users);
		
		//若同意寄送廣告，則將該用戶信箱加入email.txt
		FileWriter fw=new FileWriter("C:/DataSource/FinalProject/FinalProject/WebContent/email.txt",true);
		if(ademail.equalsIgnoreCase("Y")) {
			//"\r\n"
			fw.write(email+",");
			fw.flush();
			fw.close();
		}
		
		
		// Step2. Send Verify Email to user
		String url="<a href='http://localhost:8080/FinalProject/signup.action?sys_sn="
					+ users.getSysSn() + "  '>按此進行作業</a>";
		MailUtils.sendMail(type, users, url);
		
		if(status) {
			
			model.addAttribute("msg", "註冊成功！請至信箱收取驗證信");
		}
		return "index.jsp" ;// home page
	}
	//信箱註冊驗證信激活
	@GetMapping(path="/signup.action")
	public String processSignUpAction(@RequestParam("sys_sn") int syssn,Model model) {
		boolean status = usersService.updateStatus(syssn);
		
		if(status) {
			
			model.addAttribute("msg", "帳號激活成功！");
		}
		return "loginSystem.jsp";
	}
	
	/* forgot password controller */
	@PostMapping(path = "/memorycover")
	public String processCoverPw(@RequestParam("email") String email,Model model) throws AddressException, UnsupportedEncodingException, MessagingException, GeneralSecurityException {
		String type="memorycover";
		// Step1. check user Input is match or not
		
		boolean status = usersService.verifyEmail(email);
		
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (status==false) {
			errors.put("no", "查無此帳號!");
			return "forgetPwdPage.jsp";
		}

		
		// Step2. Send Verify Email to user
		String url="<a href='http://localhost:8080/FinalProject/updatePwdPage.controller?email="
				+ email + "  '>按此進行作業</a>";
		Users user = usersService.query(email);
		
		MailUtils.sendMail(type, user, url);
		
		
		model.addAttribute("msgs", "請至信箱收取密碼修改信!");
		return "loginSystem.jsp" ;// login page
	}
	
	//忘記密碼信箱驗證信
	@GetMapping(path="/updatePwdPage.controller")
	public String updatePwdPageController(@RequestParam("email") String email,Model model) {
		model.addAttribute("email", email);
		return "updatePwdPage.jsp";
	}
	
	
	//忘記密碼頁面
	@PostMapping(path="/memorycover.action")
	public String processCoverPwAction(@RequestParam("password") String password,
			@RequestParam("email") String email,Model model) {
		
		if (!new VerifyUtil().chkLogin(email, password)) {
			
			return "updatePwdPage.jsp";
		}
		
		usersService.updatePassword(email, password);
		
		model.addAttribute("updatemsg", "修改密碼成功!");
		return "loginSystem.jsp";
	}
	
	// 顯示基本資料頁面
		@GetMapping(path = "/update.action")
		public String processUpdateAction(HttpServletRequest request, HttpServletResponse response, Model model) {
			Users ub = (Users) request.getSession().getAttribute("identity");

			Users result = usersService.query(ub.getEmail());
			Map<String, String> data = new HashMap<>();
			// 取得基本資料
			data.put("nickName", result.getUinfo().getName());
			data.put("gender", result.getUinfo().getGender());
			data.put("birth", result.getUinfo().getBirth());
			data.put("phone", result.getUinfo().getTel());
			data.put("address", result.getUinfo().getAddr());
			data.put("picture", result.getUinfo().getPicture());
			model.addAttribute("data", data);
			return "update.jsp";
		}
		//修改基本資料
		@RequestMapping(path = "/updateData.action", method = RequestMethod.POST)
		public String processUpdateData(@RequestParam("name") String name, @RequestParam("birth") String birth,
				@RequestParam("tel") String tel, @RequestParam("addr") String addr, Model model, 
				HttpServletResponse response, HttpServletRequest request) throws IOException {

			PrintWriter out = response.getWriter();
			// 更新資料
			Users users = (Users) request.getSession().getAttribute("identity");
			
			Uinfo uinfo = new Uinfo();
			uinfo.setName(name);
			uinfo.setBirth(birth);
			uinfo.setTel(tel);
			uinfo.setAddr(addr);
			
			
			users.setUinfo(uinfo);
			uinfo.setUsers(users);
			
			boolean status = usersService.update(users);
			out.print(status);
			
			return "update.action";
		}
		//上傳頭像
		@PostMapping(path = "/upload.action")
		public String processUploadAction(@RequestParam("files") MultipartFile picture,HttpServletResponse response,HttpServletRequest request) throws IllegalStateException, IOException  {
			PrintWriter out = response.getWriter();
			
			Users users = (Users) request.getSession().getAttribute("identity");
			
			//取得檔名
			String fileName=picture.getOriginalFilename();
			//存到資料庫的路徑名稱
			String flie="/user_img/"+users.getEmail()+fileName;
			//上傳至資料夾存放
			String savePath ="C:/DataSource/FinalProject/user_img/"+users.getEmail()+fileName;
			File saveFile = new File(savePath);
			picture.transferTo(saveFile);
			
			//將圖片路徑存到資料庫
			Uinfo uinfo = new Uinfo();
			uinfo.setPicture(flie);
			users.setUinfo(uinfo);
			uinfo.setUsers(users);
			
			usersService.updatePicture(users);
			
			
			return "update.jsp";
		}
		// 登出
		@GetMapping(path = "/logout.do")
		public String processLogoutAction(HttpServletRequest request) throws IOException {
			request.getSession().invalidate();
			return "index.jsp";
		}
		
		
}
