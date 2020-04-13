package sampple.model.dao;

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
	public String queryUser(Users user);

	/**
	 * 修改密碼, 註銷帳號
	 * 
	 * @param Users
	 * @param String
	 * @return boolean
	 * 
	 */
	public boolean updatePwd(Users user, String type);
}
