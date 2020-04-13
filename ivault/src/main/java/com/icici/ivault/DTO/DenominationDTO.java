package com.icici.ivault.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DenominationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int imdSeq;
	private int imdDenoId;
	private int imdIcmcID;
	private int imdDenoType;
	private int imdSeriesId;
	private int imdDenomination;
	private String imdDescription;
	private Date imdActivationDt;
	private int imdCoinsLowHigh;
	private int imdPrFlag;
	private int imdDelFlag;
	private String imdCreatedBy;
	private Date imdCreatedOn;
	private String imdModifiedBy;
	private Date imdModifiedOn;
	private String imdApprovedBy;
	private Date imdApprovedOn;
	private int imdSseq;
	private int imdStatus;
	private String imdRejectReason;
	private int imdCountInBundle;
	
	// Extra Variable
	private int imdNoOfBundle;
	private int imdCalDenoRowValue;  // calculation of each row
	private int imdValue;
	private int itihsSeckLockNo;
	private int itihsValue; // total coins and bundle value
	private long total;
//	public List<DenominationDTO> DenominationFormList;
	
}
