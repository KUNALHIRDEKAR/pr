package com.icici.ivault.repository;

import java.util.List;

import com.icici.ivault.model.Request_Details;

public interface Request_Details_Repository {
	void save(Request_Details request_Details);

	List<Request_Details> getRequestedDenominations(Integer requestHeaderSeq);

	List<Request_Details> getRequestDetails();
}
