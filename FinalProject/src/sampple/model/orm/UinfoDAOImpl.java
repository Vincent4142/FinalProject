package sampple.model.orm;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import sampple.model.Uinfo;
import sampple.model.dao.UinfoDAO;
import sampple.util.LogUtil;


@Repository
public class UinfoDAOImpl implements UinfoDAO {

	private SessionFactory sessionFacotry;

	private static Logger logger = LogUtil.getLogger();

	@Autowired
	public UinfoDAOImpl(@Qualifier(value = "sessionFactory") SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}
	
	private static final String HQL_QUERY_INFO = "From U_INFO WHERE SYS_SN = :sysSn";
	
	@Override
	public boolean insertInfo(Uinfo uinfo) {
		boolean status = false;
		try {
			Session session = sessionFacotry.getCurrentSession();
			session.saveOrUpdate(uinfo);

			status = true;
		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return status;
	}

	@Override
	public Uinfo queryInfo(int sysSn) {
		Uinfo result = null;
		try {
			Session session = sessionFacotry.getCurrentSession();
			Query<Uinfo> query = session.createQuery(HQL_QUERY_INFO, Uinfo.class).setParameter("sysSn", sysSn);
			
			result = query.getSingleResult();
		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}
		return result;
	}

	@Override
	public boolean updateInfo(Uinfo uinfo) {
		boolean status = false;

		try {
			Session session = sessionFacotry.getCurrentSession();
			session.update(uinfo);

			status = true;
		} catch (Exception e) {
			logger.log(Level.ERROR, e);
		}

		return status;
	}

}
