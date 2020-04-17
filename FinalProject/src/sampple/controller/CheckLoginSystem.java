package sampple.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sampple.model.Uinfo;
import sampple.model.Users;
import sampple.model.service.UsersService;
import sampple.util.VerifyUtil;

@Controller
@SessionAttributes(names = { "identity" }) // "errors" ,
public class CheckLoginSystem {
	private UsersService usersService;

	@Autowired
	public CheckLoginSystem(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping(path = "/check")
	public void processRepeatAction(@RequestParam("email") String email, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println(email);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		// 驗證Email格式

		if (new VerifyUtil().chkEmail(email)) {
			boolean status = usersService.verifyEmail(email);
			System.out.println(status);
			out.print(status);
		}

	}

	@PostMapping(path = "/login")
	public String processLoginSystemAction(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> errors = new HashMap<>();
		response.setContentType("text/html;charset=UTF-8");

		model.addAttribute("errors", errors);

		// 驗證帳號、密碼格式
		if ((email == null || email.length() == 0) && (password == null || password.length() == 0)) {
			if (!new VerifyUtil().chkLogin(email, password)) {
				return "loginSystem.jsp";
			}
		}
		String msg = null;
		Map<String, Object> info = usersService.queryUser(new Users(email, password));
		if (info.get("msg") != null) {
			System.out.println("msg" + msg);
			msg = (String) info.get("msg");

		}
		switch (msg) {
		// 查無帳號
		case "09":
			errors.put("msg", "找不到帳號");
			break;
		// 被凍結
		case "04":
			errors.put("msg", "帳號已被凍結");
			break;
		// 註冊後未開通
		case "03":
			errors.put("msg", "請至信箱收取驗證信");
			break;
		// 密碼錯誤
		case "02":
			errors.put("msg", "密碼錯誤");
			break;
		// 通過
		case "01":
			// 建立身分物件存於Session
			Users ub = (Users) info.get("uBean");
			model.addAttribute("identity", ub);
			System.out.println("name: " + ub.getUinfo().getName());
			// 建立cookie來儲存使用者資訊
			Cookie cookie = new Cookie("user", email + "&" + password);
			cookie.setPath("/");
			cookie.setMaxAge(1 * 60 * 60 * 2); // 二小時的有效時間
			response.addCookie(cookie);

			// 轉至首頁
			return "index.jsp";

		default:
			// error handler
		}

		// 若有錯誤返回登入頁面

		if (!errors.isEmpty()) {
			return "loginSystem.jsp";
		}

		return "loginSystem.jsp";
	}

}
