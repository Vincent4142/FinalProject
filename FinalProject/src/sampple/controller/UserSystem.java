package sampple.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sampple.model.Uinfo;
import sampple.model.Users;
import sampple.model.service.UsersService;
import sampple.util.AdMailUtils;
import sampple.util.MailUtils;

@Controller
public class UserSystem {
	private UsersService usersService;

	@Autowired
	public UserSystem(UsersService usersService) {
		this.usersService = usersService;
	}

	/* login Check */
	@PostMapping(path = "/login")
	public String processLoginCheck(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (email == null || email.length() == 0) {
			errors.put("name", "name is required.");
		}

		if (password == null || password.length() == 0) {
			errors.put("pwd", "password is required.");
		}

		if (!errors.isEmpty()) {
			return "loginSystem.jsp";
		}
		
		model.addAttribute("user", email);
		model.addAttribute("pwd", password);
		
		String msg = usersService.query(new Users(email, password));

		switch (msg) {
		case "09":
			// cant find user
		case "04":
			// user is frozen
		case "02":
			// wrong password
		case "01":
			/* cookie setting here */
			
			
			// 轉至會員資料頁面
			//return "loginSuccess";
		default:
			// error handler
		}

		
		return "loginSystem.jsp";
	}
	
	/* sign up controller */
	@PostMapping(path = "/signup")
	public String processSignUp(@RequestParam("email") String email,
			@RequestParam("password") String password,@RequestParam("name") String name,
			@RequestParam("id") String id,@RequestParam("addr") String addr,
			@RequestParam("gender") String gender,@RequestParam("birth") String birth,
			@RequestParam("tel") String tel,@RequestParam(defaultValue = "N", value = "ademail") String ademail,Model model) throws AddressException, MessagingException, GeneralSecurityException, IOException {
		
		System.out.println("test123:"+ademail);
		//送出註冊驗證信狀態
		String type="sign";
		//空值代表沒勾選，因此設為N
		//if(ademail==null) {
		//	ademail="N";
		//}
		
		// Step1. check user Input is match or not
		Users users=new Users();
		users.setEmail(email);
		users.setPassword(password);
		users.setStatus("N");
		
		Uinfo uinfo=new Uinfo();
		uinfo.setName(name);
		uinfo.setId(id);
		uinfo.setAddr(addr);
		uinfo.setGender(gender);
		uinfo.setBirth(birth);
		uinfo.setTel(tel);
		uinfo.setAdemail(ademail);
		uinfo.setUtype("N");
		
		users.setUinfo(uinfo);
		uinfo.setUsers(users);
		
		boolean status = usersService.insert(users);
		
		//若同意寄送廣告，則將該用戶信箱加入email.txt
		FileWriter fw=new FileWriter("C:/DataSource/FinalProject/FinalProject/WebContent/email.txt",true);
		if(ademail.equalsIgnoreCase("Y")) {
			fw.write(email+"\r\n");
			fw.flush();
			fw.close();
		}
		
		
		// Step2. Send Verify Email to user
		String url="<a href='http://localhost:8080/FinalProject/signup.action?sys_sn="
					+ users.getSysSn() + "  '>按此進行作業</a>";
		MailUtils.sendMail(type, users, url);
		
		
		return "index.jsp" ;// home page
	}
	//信箱註冊驗證信激活
	@GetMapping(path="/signup.action")
	public String processSignUpAction(@RequestParam("sys_sn") int syssn,Model model) {
		boolean status = usersService.updateStatus(syssn);
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
		usersService.updatePassword(email, password);
		return "loginSystem.jsp";
	}
}
