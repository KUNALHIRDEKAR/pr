package com.icici.ivault.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icici.ivault.model.Pr_Request_Header;
import com.icici.ivault.model.Request_Details;
/**
 * 
 * @author Kunal Hirdekar
 * Date: 03/04/2020
 */
@Repository
public class Request_Details_RepositoryImpl implements Request_Details_Repository {
	private Logger logger = Logger.getLogger(Pr_Request_Header_RepositiryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Request_Details request_Details) {
		Session session = this.sessionFactory.openSession();
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(request_Details);	
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}finally {
				if(!session.isOpen())
				{
					session.close();
				}
			}

	
	}

	@Override
	public List<Request_Details> getRequestedDenominations(Integer requestHeaderSeq) {
		List<Request_Details> Request_DetailsList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Request_Details requestDetails");
			 Request_DetailsList= (ArrayList<Request_Details>)query.list();
			System.out.println("DenominationList:::::::::::"+ Request_DetailsList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return  Request_DetailsList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return  Request_DetailsList;
}

	@Override
	public List<Request_Details> getRequestDetails() {
		List<Request_Details> request_DetailsList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Request_Details requestDetails");
			 request_DetailsList= (ArrayList<Request_Details>)query.list();
			System.out.println("DenominationList:::::::::::"+ request_DetailsList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return  request_DetailsList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return  request_DetailsList;
	}

}
