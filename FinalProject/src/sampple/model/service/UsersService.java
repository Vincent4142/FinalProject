package sampple.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String query(Users user) {
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
	
	public boolean updateStatus(int syssn) {
		return usersDao.updateStatus(syssn);
	}
	
	public boolean verifyEmail(String email) {
		return usersDao.verifyEmail(email);
	}
	
	public Users query(String email){
		return usersDao.query(email);
	}
	
	public boolean updatePassword(String email,String password) {
		
		return usersDao.updatePassword(email, password);
	}
	
	public List<Users> queryAll(){
		return usersDao.queryAll();
	}
}
