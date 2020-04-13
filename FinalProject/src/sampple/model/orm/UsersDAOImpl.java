package sampple.model.orm;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import sampple.model.Users;
import sampple.model.dao.UsersDAO;
import sampple.util.LogUtil;

@Repository
public class UsersDAOImpl implements UsersDAO {

	
	private SessionFactory sessionFacotry;
	
	private static Logger logger = LogUtil.getLogger();

	@Autowired
	public UsersDAOImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}
	
	private static final String HQL_QUERY_ID = "From Users WHERE email = :userName";
	
	
	@Override
	public boolean insertUser(Users user) {
		boolean status = false;

		try {
			Session session = sessionFacotry.getCurrentSession();
			session.saveOrUpdate(user);

			status = true;
		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}

		return status;
	}

	@Override
	public String queryUser(Users user) {
		// 不通過
				String msg = "09";
				// 需加密
				String password = user.getPassword();
				try {
					Session session = sessionFacotry.getCurrentSession();
					Query<Users> query = session.createQuery(HQL_QUERY_ID, Users.class).setParameter("userName",
							user.getEmail());
					Users result = query.getSingleResult();

					if (!result.getDeleteFlag().equals("Y")) {
						if (result.getPassword().equals(password)) {
							// 通過
							msg = "01";
						} else {
							// 密碼錯誤
							msg = "02";
						}
					} else {
						// 帳號凍結
						msg = "04";
					}
				} catch (Exception e) {
					logger.log(Level.ERROR, e);
				}
				return msg;
	}

	@Override
	public boolean updatePwd(Users user, String type) {
		boolean status = false;
		try {
			Session session = sessionFacotry.getCurrentSession();

			if (type.equals("Y")) {
				user.setDeleteFlag("Y");
			}

			session.update(user);

			status = true;
		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return status;
	}

}
