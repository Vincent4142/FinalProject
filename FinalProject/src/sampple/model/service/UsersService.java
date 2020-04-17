package sampple.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sampple.model.Uinfo;
import sampple.model.Users;
import sampple.model.dao.UsersDAO;


@Service
public class UsersService {
private UsersDAO usersDao;
	
	public UsersService() {
		
	}

	@Autowired
	public UsersService(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}
	
	/**
	 *  註冊帳號
	 *  @param Users
	 *  @return boolean
	 *  
	 * */
	public boolean insert(Users user) {
		return usersDao.insertUser(user);
	}
	
	/**
	 *  帳號登入
	 *  @param Users
	 *  @return String
	 *  
	 * */
	public Map<String, Object> queryUser(Users user) {
		return usersDao.queryUser(user);
	}
	
	/**
	 * 	修改密碼, 註銷帳號
	 *  @param Users
	 *  @param String
	 *  @return boolean
	 *  
	 * */
	public boolean updatePwd(Users user, String type) {
		return usersDao.updatePwd(user, type);
	}
	
	//註冊驗證信修改激活狀態為Y
	public boolean updateStatus(int syssn) {
		return usersDao.updateStatus(syssn);
	}
	
	//忘記密碼頁面用來先驗證使用者所輸入的帳號(EMAIL)是否存在
	public boolean verifyEmail(String email) {
		return usersDao.verifyEmail(email);
	}
	
	//用來查詢修改密碼信所需的Users
	public Users query(String email){
		return usersDao.query(email);
	}
	
	//修改密碼頁面用來修改成使用者輸入的密碼
	public boolean updatePassword(String email,String password) {
		
		return usersDao.updatePassword(email, password);
	}
	
	//
	public Uinfo identity(Users user) {
		return usersDao.identity(user);
	}

}
