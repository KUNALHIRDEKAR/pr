package com.icici.ivault.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icici.ivault.DTO.DenominationDTO;
import com.icici.ivault.DTO.DenominationList;
import com.icici.ivault.DTO.Pr_Request_HeaderDTO;
import com.icici.ivault.DTO.Request_DetailsDTO;
import com.icici.ivault.model.Denomination;
import com.icici.ivault.model.Pr_Request_Header;
import com.icici.ivault.model.Request_Details;
import com.icici.ivault.repository.Pr_Request_Header_Repositiry;
import com.icici.ivault.repository.ProcessRoomRepository;
import com.icici.ivault.repository.Request_Details_Repository;

/**
 * 
 * @author Kunal Hirdekar Date: 02/04/2020
 */

@Service
public class ProcessRoomServiceImpl implements ProcessRoomService {

	@Autowired
	private ProcessRoomRepository processRoomRepository;

	@Autowired
	Pr_Request_Header_Repositiry pr_Request_Header_Repositiry;

	@Autowired
	Request_Details_Repository request_Details_Repository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<DenominationDTO> getAllDenomination() {

		List<Denomination> denoinationList = processRoomRepository.getAllDenomination();
		List<DenominationDTO> denominationDTOList = new ArrayList();
		for (Denomination denomination : denoinationList) {
			DenominationDTO denominationDTO = new DenominationDTO();
			BeanUtils.copyProperties(denomination, denominationDTO);
			denominationDTOList.add(denominationDTO);
		}
		return denominationDTOList;
	}

	/*
	 * denominationListSave(-,-) is use to save processRoom request
	 * 
	 * @see
	 * com.icici.ivault.service.ProcessRoomService#denominationListSave(com.icici.
	 * ivault.DTO.DenominationList)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void denominationListSave(DenominationList denominationList) {
		List<DenominationDTO> denominationDTOList = denominationList.getDenominationFormList();
		System.out.println("DenominationDTO" + denominationDTOList);
		List<Request_Details> request_DetailsList = new ArrayList();
		Pr_Request_Header pr_Request_Header = new Pr_Request_Header();
		pr_Request_Header.setRequestBy("ICMC_PR_USER");
		pr_Request_Header.setReqStatus(0);
		pr_Request_Header.setRequestedAmount(0);
		pr_Request_Header.setFlag(0);
		pr_Request_Header.setReqIcmcId("ICMCADR003");
		System.out.println("Pr_Request_Header:::::::::::::::::::" + pr_Request_Header);
		Pr_Request_Header pr_Request_Header2 = pr_Request_Header_Repositiry.save(pr_Request_Header);
		System.out.println("Pr_Request_Header2:::::::::::::::::::" + pr_Request_Header2);

		for (DenominationDTO denoDTO : denominationDTOList) {

			denoDTO.setTotal(denoDTO.getImdDenomination() * (denoDTO.getImdCountInBundle() * 1000));
			Denomination d = new Denomination();
			Request_Details request_Details = new Request_Details();
			Request_DetailsDTO request_DetailsDTO = new Request_DetailsDTO();
			request_DetailsDTO.setImdSeq(denoDTO.getImdSeq());
			request_DetailsDTO.setImdDenomination(denoDTO.getImdDenomination());
			request_DetailsDTO.setImdCountInBundle(denoDTO.getImdCountInBundle());
			request_DetailsDTO.setAmount(denoDTO.getTotal());
			request_DetailsDTO.setReqInwardNo(00);
			request_DetailsDTO.setPrRequestHeader(pr_Request_Header2);
			// grandTotal = grandTotal + denoDTO.getTotal();
			BeanUtils.copyProperties(request_DetailsDTO, request_Details);
			request_DetailsList.add(request_Details);

			request_Details_Repository.save(request_Details);

		}

	}

	/*
	 * To get Status of Process Room Request
	 * 
	 * @see com.icici.ivault.service.ProcessRoomService#getAllUnapprovesRequest()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Integer> getAllUnapprovesRequest() {
		List<Integer> reqStatus = new ArrayList();
		int countPending = 0;
		int countApproved = 0;
		int countReject = 0;
		List<Pr_Request_Header> req = pr_Request_Header_Repositiry.findAll();

		for (Pr_Request_Header pr_Request_Header : req) {
			if (pr_Request_Header.getReqStatus() == 0) {
				countPending++;
			} else if (pr_Request_Header.getReqStatus() == 1) {
				countApproved++;
			} else if (pr_Request_Header.getReqStatus() == 2) {
				countReject++;
			} else {

			}
			System.out.println(pr_Request_Header);
		}

		reqStatus.add(countPending);
		reqStatus.add(countApproved);
		reqStatus.add(countReject);

		System.out.println(reqStatus);
		return reqStatus;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pr_Request_HeaderDTO> pendingRecord(Integer status) {
		List<Pr_Request_Header> pr_Request_HeaderList = pr_Request_Header_Repositiry.pendingRecord(status);
		List<Pr_Request_HeaderDTO> pr_Request_HeaderDTOList = new ArrayList<>();

		for (Pr_Request_Header pr_Request_Header : pr_Request_HeaderList) {
			Pr_Request_HeaderDTO pr_Request_HeaderDTO = new Pr_Request_HeaderDTO();
			BeanUtils.copyProperties(pr_Request_Header, pr_Request_HeaderDTO);
			pr_Request_HeaderDTOList.add(pr_Request_HeaderDTO);
		}
		return pr_Request_HeaderDTOList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pr_Request_HeaderDTO> processedRecord() {
		List<Pr_Request_Header> pr_Request_HeaderList = pr_Request_Header_Repositiry.processedRecord();
		List<Pr_Request_HeaderDTO> pr_Request_HeaderDTOList = new ArrayList<>();

		for (Pr_Request_Header pr_Request_Header : pr_Request_HeaderList) {
			Pr_Request_HeaderDTO pr_Request_HeaderDTO = new Pr_Request_HeaderDTO();
			BeanUtils.copyProperties(pr_Request_Header, pr_Request_HeaderDTO);
			pr_Request_HeaderDTOList.add(pr_Request_HeaderDTO);
		}
		return pr_Request_HeaderDTOList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Pr_Request_Header> getRequest() {
		List<Pr_Request_Header> pr_Request_HeaderList = pr_Request_Header_Repositiry.pendingRecord(0);
		return pr_Request_HeaderList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Request_DetailsDTO> getRequestedDenominations(Integer requestHeaderSeq) {
		List<Request_Details> getRequestedDenominations = request_Details_Repository
				.getRequestedDenominations(requestHeaderSeq);
		List<Request_DetailsDTO> getRequestedDenominationsDTO = new ArrayList();
		for (Request_Details request_Details : getRequestedDenominations) {
			if (request_Details.getPrRequestHeader().getRequestHeaderSeq() == requestHeaderSeq) {
				Request_DetailsDTO request_DetailsDTO = new Request_DetailsDTO();
				BeanUtils.copyProperties(request_Details, request_DetailsDTO);
				getRequestedDenominationsDTO.add(request_DetailsDTO);
			}
		}
		return getRequestedDenominationsDTO;
	}

	/*
	 * (DATE:05/04/2020)
	 * 
	 * @see
	 * com.icici.ivault.service.ProcessRoomService#approveRequest(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void approveRequest(Integer requestHdrSeq) {

		pr_Request_Header_Repositiry.approveRequest(requestHdrSeq);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Request_Details> getRequestDetails() {
		List<Request_Details> getRequestedDenominations = request_Details_Repository.getRequestDetails();
		List<Request_Details> getRequestedDenominationsBO = new ArrayList();
		for (Request_Details request_Details : getRequestedDenominations) {
			System.out.println("********************" + request_Details.getPrRequestHeader().getReqStatus());
			if (request_Details.getPrRequestHeader().getReqStatus() == 1) {
				Request_Details request_Details1 = new Request_Details();
				BeanUtils.copyProperties(request_Details, request_Details1);
				getRequestedDenominationsBO.add(request_Details1);
			}
		}
		System.out.println("##########" + getRequestedDenominations);
		return getRequestedDenominationsBO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void acknowStatus(int requestHeaderSeq) {
		// TODO Auto-generated method stub
		pr_Request_Header_Repositiry.acknowStatus(requestHeaderSeq);
	}

}
