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

import com.icici.ivault.AllConstants.AllConstant;
import com.icici.ivault.DTO.DenominationDTO;
import com.icici.ivault.DTO.Pr_Request_HeaderDTO;
import com.icici.ivault.model.ChatMassage;
import com.icici.ivault.model.Denomination;
import com.icici.ivault.service.DenominationService;
import com.icici.ivault.service.ProcessRoomService;

/**
 * 
 * 
 * @author Kunal Hirdekar Date: 02/04/2020
 *
 */
@Controller
public class DenominationController {
	/*
	 * Fields denominationService
	 */

	@Autowired
	private DenominationService denominationService;
	@Autowired
	private ProcessRoomService processRoomService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		List<Integer> reqStatus = processRoomService.getAllUnapprovesRequest();
		System.out.println(reqStatus);
		List<Pr_Request_HeaderDTO> pr_Request_HeaderDTOList=processRoomService.pendingRecord(0);
		List<Pr_Request_HeaderDTO> pr_Request_HeaderDTOPendingList=processRoomService.processedRecord();
		/*ChatMassage chatMassage=new ChatMassage();
		model.addAttribute("chatMassage",chatMassage);
		*/model.addAttribute("pr_Request_HeaderDTOList", pr_Request_HeaderDTOList);
		model.addAttribute("pr_Request_HeaderDTOPendingList",pr_Request_HeaderDTOPendingList);
		model.addAttribute("status", reqStatus);

		return AllConstant.WELCOME_PAGE;
	}
	@RequestMapping("/acknow")
	public String acknow(@RequestParam("flag") int requestHeaderSeq)
	{
		System.out.println("requestHeaderSeq****"+requestHeaderSeq);
		processRoomService.acknowStatus(requestHeaderSeq);
		return "redirect:/welcome";
	}
	@RequestMapping("/addDeno")
	public String addDenoIntoList(Model model) {
		DenominationDTO denominationDTO = new DenominationDTO();
		model.addAttribute(AllConstant.GET_DENO_ATTRIBUTE, denominationDTO);
		return AllConstant.GET_DENO_PAGE;
	}

	@RequestMapping(value = "processDenomination", method = RequestMethod.POST)
	public String processDenomination(@ModelAttribute("denominationDTO") DenominationDTO denominationDTO, Model model) {

		Denomination deno = new Denomination();
		BeanUtils.copyProperties(denominationDTO, deno);
		denominationService.addDenomination(denominationDTO);
		model.addAttribute("deno", "RECORD ADDED/UPDATED SUCCESSFULLY");

		return AllConstant.NEW_DENO_ADDED;
	}

	@RequestMapping(value = "/getViewDetails", method = RequestMethod.GET)
	public String getView(Model model) {
		List<DenominationDTO> denominationDTOList = denominationService.getDenominationList();
		model.addAttribute("denoList", denominationDTOList);
		return AllConstant.GET_DENO_LIST_VIEW;
	}

}
