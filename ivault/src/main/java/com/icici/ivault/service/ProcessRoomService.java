package com.icici.ivault.service;

import java.util.List;

import com.icici.ivault.DTO.DenominationDTO;
import com.icici.ivault.DTO.DenominationList;
import com.icici.ivault.DTO.Pr_Request_HeaderDTO;
import com.icici.ivault.DTO.Request_DetailsDTO;
import com.icici.ivault.model.Pr_Request_Header;
import com.icici.ivault.model.Request_Details;

public interface ProcessRoomService {

	List<DenominationDTO> getAllDenomination();

	void denominationListSave(DenominationList denominationList);

	List<Integer> getAllUnapprovesRequest();

	List<Pr_Request_HeaderDTO> pendingRecord(Integer status);

	List<Pr_Request_Header> getRequest();

	List<Request_DetailsDTO> getRequestedDenominations(Integer requestHeaderSeq);

	void approveRequest(Integer requestHdrSeq);

	List<Pr_Request_HeaderDTO> processedRecord();

	List<Request_Details> getRequestDetails();

	void acknowStatus(int requestHeaderSeq);

}
