package com.icici.ivault.repository;

import java.util.List;

import com.icici.ivault.model.Pr_Request_Header;
/**
 * 
 * @author Kunal Hirdekar
 * Date 02/04/2020
 *
 */
public interface Pr_Request_Header_Repositiry {
	Pr_Request_Header save(Pr_Request_Header pr_Request_Header);

	List<Pr_Request_Header> findAll();

	List<Pr_Request_Header> pendingRecord(Integer status);

	void approveRequest(Integer requestHdrSeq);

	
	List<Pr_Request_Header> processedRecord();

	void acknowStatus(int requestHeaderSeq);
}
