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
import com.icici.ivault.model.MachineMaster;

/**
 * 
 * @author Kunal Hirdekar Date:06/04/2020
 *
 */
@Repository
public class MachineMasterRepositoryImpl implements MachineMasterRepository {
	private Logger logger = Logger.getLogger(MachineMasterRepositoryImpl.class);

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

	@Override
	public void saveMachine(MachineMaster machineMaster) {
		// TODO Auto-generated method stub
		logger.info("Start MachineMasterRepositoryImpl saveMachine()");

		Session session = this.sessionFactory.openSession();
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(machineMaster);
			logger.info("End MachineMasterRepositoryImpl saveMachine()");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	/*
	 * (To get All the Machine )
	 * 
	 * @see com.icici.ivault.repository.MachineMasterRepository#getAllMachineList()
	 */
	@Override
	public List<MachineMaster> getAllMachineList() {

		List<MachineMaster> machineMasterList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.MachineMaster");
			machineMasterList = (ArrayList<MachineMaster>) query.list();
			logger.info("End MachineMasterRepositoryImpl getAllMachineList()");
			return machineMasterList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public void enableMachin(Integer machineID) {
		List<MachineMaster> machineMasterList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.MachineMaster");
			machineMasterList = (ArrayList<MachineMaster>) query.list();
			for (MachineMaster machineMaster : machineMasterList) {
				if (machineMaster.getMachineID() == machineID) {
					machineMaster.setActiveStatus(1);
					sessionFactory.getCurrentSession().saveOrUpdate(machineMaster);

				}
			}
			logger.info("End MachineMasterRepositoryImpl getAllMachineList()");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void disableMachine(Integer machineID) {
		List<MachineMaster> machineMasterList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("from com.icici.ivault.model.MachineMaster");
			machineMasterList = (ArrayList<MachineMaster>) query.list();
			for (MachineMaster machineMaster : machineMasterList) {
				if (machineMaster.getMachineID() == machineID) {
					machineMaster.setActiveStatus(0);
					sessionFactory.getCurrentSession().saveOrUpdate(machineMaster);

				}
			}
			logger.info("End MachineMasterRepositoryImpl getAllMachineList()");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<MachineMaster> getActiveMachinList() {
		List<MachineMaster> machineMasterList = new ArrayList();
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session
					.createQuery("from com.icici.ivault.model.MachineMaster machinMas where machinMas.activeStatus=1");
			machineMasterList = (ArrayList<MachineMaster>) query.list();
			logger.info("End MachineMasterRepositoryImpl getActiveMachinList()");
		return machineMasterList;
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
