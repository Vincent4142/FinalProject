package sampple.model.dao;

import java.util.List;
import java.util.Map;

import sampple.model.Uinfo;
import sampple.model.Users;

public interface UsersDAO {
	/**
	 * 註冊帳號
	 * 
	 * @param Users
	 * @return boolean
	 * 
	 */
	public boolean insertUser(Users user);

	/**
	 * 帳號登入
	 * 
	 * @param Users
	 * @return String
	 * 
	 */
	public Map<String, Object> queryUser(Users user);

	/**
	 * 修改密碼, 註銷帳號
	 * 
	 * @param Users
	 * @param String
	 * @return boolean
	 * 
	 */
	public boolean update(Users user);
	
	public boolean updateStatus(int syssn);
	
	public boolean verifyEmail(String email);
	
	public Users query(String email);
	
	public boolean updatePassword(String email,String password);
	
	//修改使用者頭像
	public void updatePicture(Users user);
		
	
	

}
