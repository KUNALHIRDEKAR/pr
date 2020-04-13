package com.icici.ivault.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icici.ivault.DTO.DenominationDTO;
import com.icici.ivault.DTO.DenominationList;
import com.icici.ivault.DTO.Pr_Request_HeaderDTO;
import com.icici.ivault.model.Pr_Request_Header;
import com.icici.ivault.service.ProcessRoomService;

/**
 * 
 * @author Kunal Hirdekar This is ProcessRoom controller use to get unprocess
 *         cash from Vault
 */

@Controller
public class ProcessRoomController {

	/**
	 * process room getDenominationPage(-,-) method is use for request to vault user
	 */
	@Autowired
	private ProcessRoomService processRoomService;

	@RequestMapping("/processRoom")
	public String getDenominationPage(Model model) {
		DenominationList denominationList = new DenominationList();
		List<DenominationDTO> listDenominationDTO = processRoomService.getAllDenomination();
		denominationList.setDenominationFormList(listDenominationDTO);
		model.addAttribute("deno", denominationList);
		return "finalPR";
	}
	
	@RequestMapping(value = "/processRequest", method = RequestMethod.POST)
	public String ivaultProcess(@ModelAttribute("denominationList") DenominationList denominationList,
		 Model model) {
		System.out.println("Hello");
		processRoomService.denominationListSave(denominationList);

		return "redirect:/welcome";
	}
	@RequestMapping("/pendingRecord")
	public String pendingRecord(@RequestParam("status") Integer status,Model model)
	{
		List<Pr_Request_HeaderDTO> pr_Request_HeaderDTOList=processRoomService.pendingRecord(status);
		model.addAttribute("pr_Request_HeaderDTOList", pr_Request_HeaderDTOList);
	System.out.println(pr_Request_HeaderDTOList); 
		return "pendingRecord";
	}
	

	
	
		


}
