package com.icici.ivault.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icici.ivault.DTO.MachineMasterDTO;
import com.icici.ivault.model.MachineMaster;
import com.icici.ivault.repository.MachineMasterRepository;
/**
 * 
 * @author Kunal Hirdekar
 * Date: 06/04/2020	
 */
@Service
public class MachineMasterServiceImpl implements MachineMasterService {

	@Autowired
	private MachineMasterRepository machineMasterRepository;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveMachine(MachineMasterDTO machineMasterDTO) {
		MachineMaster machineMaster=new MachineMaster(); 
		BeanUtils.copyProperties(machineMasterDTO,machineMaster);
		System.out.println("Master DTO"+machineMaster);
		machineMasterRepository.saveMachine(machineMaster);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<MachineMaster> getAllMachineList() {
		List<MachineMaster> machineMasterList=machineMasterRepository.getAllMachineList();
		return machineMasterList;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void enableMachin(Integer machineID) {
		machineMasterRepository.enableMachin(machineID);
	
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void disableMachine(Integer machineID) {
		machineMasterRepository.disableMachine(machineID);
	}
	@Override
	public List<MachineMaster> getActiveMachinList() {
		List<MachineMaster> getActiveMachinList =machineMasterRepository.getActiveMachinList();
		return getActiveMachinList;
	}
	
	
	

}
