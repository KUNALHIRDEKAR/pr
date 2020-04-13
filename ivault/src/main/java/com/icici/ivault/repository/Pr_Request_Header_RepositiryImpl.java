package com.icici.ivault.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icici.ivault.model.Denomination;
import com.icici.ivault.model.Pr_Request_Header;

/**
 * 
 * @author Kunal Hirdekar
 *  Date: 03/04/2020
 *
 */
@Repository
public class Pr_Request_Header_RepositiryImpl implements Pr_Request_Header_Repositiry {

	private Logger logger = Logger.getLogger(Pr_Request_Header_RepositiryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Pr_Request_Header save(Pr_Request_Header pr_Request_Header) {

		Session session = this.sessionFactory.openSession();
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(pr_Request_Header);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (!session.isOpen()) {
				session.close();
			}

		}
		return pr_Request_Header;
	}

	@Override
	public List<Pr_Request_Header> findAll() {
		List<Pr_Request_Header> pr_Request_HeaderList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Pr_Request_Header");
			pr_Request_HeaderList = (ArrayList<Pr_Request_Header>)query.list();
			System.out.println("DenominationList:::::::::::"+pr_Request_HeaderList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return pr_Request_HeaderList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return pr_Request_HeaderList;

	}

	@Override
	public List<Pr_Request_Header> pendingRecord(Integer status) {
		List<Pr_Request_Header> pr_Request_HeaderList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Pr_Request_Header prRequestHeader where prRequestHeader.reqStatus=0");
			pr_Request_HeaderList = (ArrayList<Pr_Request_Header>)query.list();
			System.out.println("DenominationList:::::::::::"+pr_Request_HeaderList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return pr_Request_HeaderList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return pr_Request_HeaderList;
	}
	@Override
	public List<Pr_Request_Header> processedRecord() {
		List<Pr_Request_Header> pr_Request_HeaderList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Pr_Request_Header prRequestHeader where prRequestHeader.reqStatus=1 ANd prRequestHeader.flag=0");
			pr_Request_HeaderList = (ArrayList<Pr_Request_Header>)query.list();
			System.out.println("DenominationList:::::::::::"+pr_Request_HeaderList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return pr_Request_HeaderList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return pr_Request_HeaderList;
	}

	@Override
	public void approveRequest(Integer requestHdrSeq) {
		
		Session session = this.sessionFactory.openSession();
		
		try {
			
			Query query = session.createQuery("from com.icici.ivault.model.Pr_Request_Header");
			List<Pr_Request_Header> pr_Request_HeaderList = (ArrayList<Pr_Request_Header>)query.list();
			for(Pr_Request_Header pr_Request_Header:pr_Request_HeaderList) 
			{
				if(pr_Request_Header.getRequestHeaderSeq()==requestHdrSeq)
				{
					pr_Request_Header.setReqStatus(1);
					sessionFactory.getCurrentSession().saveOrUpdate(pr_Request_Header);	
					System.out.println(pr_Request_Header);
				}
			}
			//query.
			//sessionFactory.getCurrentSession().saveOrUpdate(pr_Request_Header);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (!session.isOpen()) {
				session.close();
			}

		}
	}

	@Override
	public void acknowStatus(int requestHeaderSeq) {
	Session session = this.sessionFactory.openSession();
		
		try {
			
			Query query = session.createQuery("from com.icici.ivault.model.Pr_Request_Header");
			List<Pr_Request_Header> pr_Request_HeaderList = (ArrayList<Pr_Request_Header>)query.list();
			for(Pr_Request_Header pr_Request_Header:pr_Request_HeaderList) 
			{
				if(pr_Request_Header.getRequestHeaderSeq()==requestHeaderSeq)
				{
					pr_Request_Header.setFlag(1);
					sessionFactory.getCurrentSession().saveOrUpdate(pr_Request_Header);	
					System.out.println(pr_Request_Header);
				}
			}
			//query.
			//sessionFactory.getCurrentSession().saveOrUpdate(pr_Request_Header);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (!session.isOpen()) {
				session.close();
			}

		}

		
	}


	
}
