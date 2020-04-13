package com.icici.ivault.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author Kunal Hirdekar
 *
 */

@Entity
@Table(name = "Rqst_Dtls_tbl_final09881")
@Data
@ToString
public class Request_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestSequence;
	
	@OneToOne(targetEntity = Pr_Request_Header.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestHeaderSeq")
	private Pr_Request_Header prRequestHeader;
	private int imdDenomination;
	private int imdSeq;
	private long amount;
	private int imdCountInBundle;
	private int reqInwardNo;

	public Request_Details() {
		// TODO Auto-generated constructor stub
	}

	public Request_Details(int requestSequence, Pr_Request_Header prRequestHeader, int imdDenomination, int imdSeq,
			long amount, int imdCountInBundle, int reqInwardNo) {
		super();
		this.requestSequence = requestSequence;
		this.prRequestHeader = prRequestHeader;
		this.imdDenomination = imdDenomination;
		this.imdSeq = imdSeq;
		this.amount = amount;
		this.imdCountInBundle = imdCountInBundle;
		this.reqInwardNo = reqInwardNo;
	}



}
