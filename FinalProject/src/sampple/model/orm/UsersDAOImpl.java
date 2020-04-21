package sampple.model.orm;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import sampple.model.Uinfo;
import sampple.model.Users;
import sampple.model.dao.UsersDAO;
import sampple.util.CryptUtil;
import sampple.util.LogUtil;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private SessionFactory sessionFacotry;

	private static Logger logger = LogUtil.getLogger();

	@Autowired
	public UsersDAOImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	private static final String HQL_QUERY_ID = "From Users WHERE EMAIL=:userName";

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
	public Map<String, Object> queryUser(Users user) {

		Map<String, Object> info = new HashMap<String, Object>();
		// 不通過
		String msg = "09";
		// 需加密
		String password = new CryptUtil().encoding(user.getPassword());
		// String password = user.getPassword();
		Query<Users> query = sessionFacotry.getCurrentSession().createQuery(HQL_QUERY_ID, Users.class)
				.setParameter("userName", user.getEmail());
		Users result = query.getSingleResult();

		// 帳號是否存在
		if (!result.getDeleteFlag().equals("Y")) {
			// 是否激活
			if (result.getStatus().equalsIgnoreCase("N")) {
				msg = "03";
			}
			// 驗證密碼
			else if (result.getPassword().equals(password)) {
				// 通過
				Users ub = new Users();
				ub.setEmail(result.getEmail());

				Uinfo uinfo = new Uinfo();
				uinfo.setName(result.getUinfo().getName());
				uinfo.setUtype(result.getUinfo().getUtype());

				ub.setUinfo(uinfo);

				info.put("uBean", ub);
				msg = "01";

			} else {
				// 密碼錯誤
				msg = "02";
			}
		} else {
			// 帳號凍結
			msg = "04";
		}
		info.put("msg", msg);
		return info;
	}

	@Override
	public boolean update(Users user) {
		boolean status = false;
		try {
			Session session = sessionFacotry.getCurrentSession();
			Query<Users> query = session.createQuery(HQL_QUERY_ID, Users.class).setParameter("userName",
					user.getEmail());
			Users result = query.getSingleResult();
			
			if (result != null) {
				result.getUinfo().setName(user.getUinfo().getName());
				result.getUinfo().setBirth(user.getUinfo().getBirth());
				result.getUinfo().setTel(user.getUinfo().getTel());
				result.getUinfo().setAddr(user.getUinfo().getAddr());
				result.getUinfo().setAdemail(user.getUinfo().getAdemail());
				session.update(result);
				status = true;
			}

		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return status;
	}

	@Override
	public boolean updateStatus(int syssn) {
		boolean status = false;

		try {
			Session session = sessionFacotry.getCurrentSession();
			Query<Users> query = session.createQuery("from Users where SYS_SN=:sys", Users.class);
			query.setParameter("sys", syssn);
			Users user = query.getSingleResult();

			user.setStatus("Y");
			session.update(user);
			status = true;

		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return status;
	}

	@Override
	public boolean verifyEmail(String email) {
		boolean status = false;

		Session session = sessionFacotry.getCurrentSession();
		Query<Users> query = session.createQuery("from Users where EMAIL=:email", Users.class);
		query.setParameter("email", email);

		if (query.uniqueResult() != null) {
			status = true;
			return status;
		}

		return status;
	}

	@Override
	public Users query(String email) {
		Session session = sessionFacotry.getCurrentSession();
		Query<Users> query = session.createQuery("from Users where EMAIL=:email", Users.class);
		query.setParameter("email", email);
		Users user = query.getSingleResult();
		return user;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		boolean status = false;

		try {
			Session session = sessionFacotry.getCurrentSession();
			Query<Users> query = session.createQuery("from Users where EMAIL=:email", Users.class);
			query.setParameter("email", email);
			Users user = query.getSingleResult();

			user.setPassword(new CryptUtil().encoding(password));
			session.update(user);
			status = true;

		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return status;
	}
	
	@Override
	public void updatePicture(Users user) {
		Session session = sessionFacotry.getCurrentSession();
		Query<Users> query = session.createQuery(HQL_QUERY_ID, Users.class).setParameter("userName",
				user.getEmail());
		Users result = query.getSingleResult();
		
		result.getUinfo().setPicture(user.getUinfo().getPicture());
		session.update(result);
	}

}
