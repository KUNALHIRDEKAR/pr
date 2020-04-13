package com.icici.ivault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icici.ivault.DTO.Request_DetailsDTO;
import com.icici.ivault.model.Pr_Request_Header;
import com.icici.ivault.model.Request_Details;
import com.icici.ivault.service.ProcessRoomService;

/**
 * 
 * @author Kunal Hirdekar Date: 04/04/2020
 */
@Controller
public class IvaultCotroller {
	@Autowired
	ProcessRoomService processRoomService; 
	
	
	/*
	 * TO process Request in in iVault
	 */
	@RequestMapping("/ivalut")
	public String processRequest(Model model) {
		List<Pr_Request_Header> pr_Request_HeaderList = processRoomService.getRequest();
		model.addAttribute("pr_Request_HeaderList", pr_Request_HeaderList);

		return "ivaultProcess";
	}
	@RequestMapping("/getRequestedDenominations")
	public String getRequestedDenominations(@RequestParam("requestHeaderSeq") Integer requestHeaderSeq,Model model)
	{
		List<Request_DetailsDTO> request_DetailsDTOList =processRoomService.getRequestedDenominations(requestHeaderSeq);
		model.addAttribute("request_DetailsDTOList",request_DetailsDTOList);
		model.addAttribute("requestHeaderSeq",requestHeaderSeq);
		return"approverPRrequest";
	}
	@RequestMapping("/approveRequest")
	public String approveRequest(@RequestParam("requestHeaderSeq") Integer requestHeaderSeq)
	{
		processRoomService.approveRequest(requestHeaderSeq);
		return "redirect:/ivalut";
	}
}
