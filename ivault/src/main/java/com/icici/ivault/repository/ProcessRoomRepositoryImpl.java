package com.icici.ivault.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icici.ivault.model.Denomination;

/**
 * 
 * @author Kunal Hirdekar Date: 02/04/2020
 *
 */
@Repository
public class ProcessRoomRepositoryImpl implements ProcessRoomRepository {

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
	 * To get all deomination which eligible for ProcessRoom
	 * 
	 * @see com.icici.ivault.repository.ProcessRoomRepository#getAllDenomination()
	 */
	@Override
	public List<Denomination> getAllDenomination() {
		List<Denomination> denominationList = new ArrayList<Denomination>();
		Session session = this.sessionFactory.openSession();
		try {

			Query query = session.createQuery("from com.icici.ivault.model.Denomination deno where deno.imdPrFlag=1");
			denominationList = (ArrayList<Denomination>) query.list();
			System.out.println(denominationList);
			return denominationList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

}
