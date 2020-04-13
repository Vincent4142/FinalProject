package sampple.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sampple.model.Users;
import sampple.model.service.UsersService;

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
	public String processSignUp(@RequestParam("name") String name,
			@RequestParam("id") String id,@RequestParam("addr") String addr,
			@RequestParam("gender") String gender,@RequestParam("birth") String birth,
			@RequestParam("tel") String tel,Model model) {
		String statas="signup";
		// Step1. check user Input is match or not
		
		
		// Step2. Send Verify Email to user
		 
		
		
		return "" ;// home page
	}
	//信箱註冊驗證信激活
	@GetMapping(path="/signup.action")
	public String processSignUpAction(Model model) {
		return "";
	}
	
	/* forgot password controller */
	@PostMapping(path = "/memorycover")
	public String processCoverPw(Model model) {
		String statas="memorycover";
		// Step1. check user Input is match or not
		
		
		// Step2. Send Verify Email to user
		 
		
		
		return "" ;// login page
	}
	
	//忘記密碼信箱驗證信
	@GetMapping(path="/memorycover.action")
	public String processCoverPwAction(Model model) {
		return "";
	}
}
