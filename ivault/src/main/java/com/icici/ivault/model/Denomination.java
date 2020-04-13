package com.icici.ivault.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;


/**
 * 
 * @author Kunal Hirdekar
 * Date:02/04/2020
 * 
 */
@Entity(name = "Denomination")
@Table(name = "IV_M_DENOMINATION_TBL212")
@Data
@ToString
public class Denomination {
	/*
	 * Discription: Denomination table can be represent by this class
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IMD_SEQ")
	private int imdSeq;

	@Column(name = "IMD_DENO_ID")
	private int imdDenoId;

	@Column(name = "IMD_ICMC_ID")
	private int imdIcmcID;

	@Column(name = "IMD_DENO_TYPE")
	private int imdDenoType;

	@Column(name = "IMD_SERIES_ID")
	private int imdSeriesId;

	@Column(name = "IMD_DENOMINATION")
	private int imdDenomination;

	@Column(name = "IMD_DENO_DESCRIPTION")
	private String imdDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMD_ACTIVATION_DT")
	private Date imdActivationDt;

	@Column(name = "IMD_COINS_LOW_HIGH")
	private int imdCoinsLowHigh;

	@Column(name = "IMD_PR_FLAG")
	private int imdPrFlag;

	@Column(name = "IMD_DEL_FLAG")
	private int imdDelFlag;

	@Column(name = "IMD_CREATED_BY")
	private String imdCreatedBy;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMD_CREATED_ON")
	private Date imdCreatedOn;

	@Column(name = "IMD_MODIFIED_BY")
	private String imdModifiedBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMD_MODIFIED_ON")
	private Date imdModifiedOn;

	
	@Column(name = "IMD_APPROVED_BY")
	private String imdApprovedBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMD_APPROVED_ON")
	private Date imdApprovedOn;

	@Column(name = "IMD_S_SEQ")
	private int imdSseq;

	@Column(name = "IMD_STATUS")
	private int imdStatus;

	@Column(name = "IMD_REJECT_REASON")
	private String imdRejectReason;

	@Column(name = "IMD_COUNT_IN_BUNDLE")
	private int imdCountInBundle;
	
}
