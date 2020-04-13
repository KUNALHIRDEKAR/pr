package com.icici.ivault.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icici.ivault.model.Denomination;
/**
 * 
 * @author Kunal Hirdekar
 * Date:02/04/2020
 * DenominationRepositoryImpl is a Repository class use to perform
 * persistance opration 
 */
@Repository
public class DenominationRepositoryImpl implements DenominationRepository {
	private Logger logger = Logger.getLogger(DenominationRepositoryImpl.class);

	/*
	 * Fields sessionFactory
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * addNewDeno(-,-) use to save new Denominations.
	 * with the help of denomination [Denomination denomination] parameter come from 
	 * DenominationService
	 */
	@Override
	public Denomination addNewDeno(Denomination denomination) {
		logger.info("Inside DenominationRepositoryImpl addNewDeno()"+denomination);
		System.out.println(" DenominationRepositoryImpl"+denomination);
		Session session = this.sessionFactory.openSession();
		
		Denomination denomination2=new Denomination();
		try {
			System.out.println("Save Object");
			sessionFactory.getCurrentSession().saveOrUpdate(denomination);
			logger.info("End DenominationRepositoryImpl addNewDeno()");
			return denomination2;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		
		return denomination2;
	}

	@Override
	public List<Denomination> getDenominationList() {
		List<Denomination> denominationList=new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.Denomination");
			denominationList = (ArrayList<Denomination>)query.list();
			System.out.println("DenominationList:::::::::::"+denominationList);
			logger.info("End DenominationRepositoryImpl getDenominationList()");
			return denominationList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return denominationList;
	}

}
