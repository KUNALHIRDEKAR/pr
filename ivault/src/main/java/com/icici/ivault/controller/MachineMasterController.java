package com.icici.ivault.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icici.ivault.DTO.MachineMasterDTO;
import com.icici.ivault.DTO.Request_DetailsDTO;
import com.icici.ivault.model.MachineMaster;
import com.icici.ivault.model.Request_Details;
import com.icici.ivault.service.MachineMasterService;
import com.icici.ivault.service.ProcessRoomService;

/**
 * 
 * @author Kunal Hirdekar Date:06/04/2020
 *
 */
@Controller
public class MachineMasterController {

	@Autowired
	private MachineMasterService machineMasterService;

	@Autowired
	private ProcessRoomService processRoomService;

	@RequestMapping("/machineAllocation")
	public String machineAllocation(Model model) {

		return "machineAllocation";
	}

	/*
	 * To add new Machine into database
	 */
	@RequestMapping("/addMachine")
	public String addMachine(Model model) {
		MachineMasterDTO machineMasterDTO = new MachineMasterDTO();
		model.addAttribute("machineMaster", machineMasterDTO);
		return "addMachine";

	}

	@RequestMapping(name = "saveMachine", method = RequestMethod.POST)
	public String saveMachine(@ModelAttribute("machineMaster") MachineMasterDTO machineMasterDTO) {
		MachineMaster machineMaster = new MachineMaster();
		System.out.println(machineMasterDTO);

		BeanUtils.copyProperties(machineMasterDTO, machineMaster);
		machineMaster.setActiveStatus(1);
		machineMasterService.saveMachine(machineMasterDTO);
		// machineMasterService.addMachine(machineMaster);
		return "redirect:/machineAllocation";
	}

	@RequestMapping("/getAllMachineList")
	public String getAllMachineList(Model model) {
		List<MachineMaster> machineMasterList = machineMasterService.getAllMachineList();
		model.addAttribute("machineMasterList", machineMasterList);
		return "registerMachine";
	}

	@RequestMapping("/enable")
	public String enableMachin(@RequestParam("machineID") Integer machineID) {
		machineMasterService.enableMachin(machineID);
		return "redirect:/getAllMachineList";
	}

	@RequestMapping("/disable")
	public String disableMachine(@RequestParam("machineID") Integer machineID) {
		machineMasterService.disableMachine(machineID);
		return "redirect:/getAllMachineList";

	}

	@RequestMapping("/cashAllocation")
	public String cashAllocation(Model model) {
		List<MachineMaster> activeMachineMasterList = machineMasterService.getActiveMachinList();
		List<Request_Details> request_DetailsDTOList = processRoomService.getRequestDetails();
		model.addAttribute("request_DetailsDTOList", request_DetailsDTOList);
		model.addAttribute("activeMachineMasterList", activeMachineMasterList);

		return "processCashAndSave";
	}
	      
	@RequestMapping("/processCash")
	public String processCash() {
		return "redirect:/machineAllocation";
	}

}
