package com.icici.ivault.DTO;

import java.util.Date;

import com.icici.ivault.model.Request_Details;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pr_Request_HeaderDTO {
	private int requestHeaderSeq;

	private long requestedAmount;

	private String requestBy;

	private Date requestOn;

	private String reqIcmcId;

	private int reqStatus;

	private Request_Details request_Details;
	
	private int flag;

}
