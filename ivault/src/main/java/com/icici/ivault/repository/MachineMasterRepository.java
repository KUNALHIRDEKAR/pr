package com.icici.ivault.repository;

import java.util.List;

import com.icici.ivault.model.MachineMaster;

/**
 * 
 * @author Kunal Hirdekar
 * Date:06/04/2020
 *
 */
public interface MachineMasterRepository {

	void saveMachine(MachineMaster machineMaster);

	List<MachineMaster> getAllMachineList();

	void enableMachin(Integer machineID);

	void disableMachine(Integer machineID);

	List<MachineMaster> getActiveMachinList();

}
