package sampple.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sampple.model.Users;
import sampple.model.dao.UsersDAO;


@Service
public class UsersService {
private UsersDAO usersDao;
	
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
	public boolean update(Users user, String type) {
		return usersDao.updatePwd(user, type);
	}
}
