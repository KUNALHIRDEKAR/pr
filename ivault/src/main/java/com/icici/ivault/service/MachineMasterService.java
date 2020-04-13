package com.icici.ivault.service;

import java.util.List;

import com.icici.ivault.DTO.MachineMasterDTO;
import com.icici.ivault.model.MachineMaster;
/**
 * 
 * @author Kunal Hirdekar
 * Date:06/04/2020
 *
 */
public interface MachineMasterService {

	void saveMachine(MachineMasterDTO machineMasterDTO);

	List<MachineMaster> getAllMachineList();

	void enableMachin(Integer machineID);

	void disableMachine(Integer machineID);

	List<MachineMaster> getActiveMachinList();

	
	
	
}
