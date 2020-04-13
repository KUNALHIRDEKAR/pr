package com.icici.ivault.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity(name = "Branch")
@Table(name = "IV_M_BRANCH")
@Data
@ToString
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "IMB_SEQ")
	private int imbSeq;

	@Column(name = "IMB_BRANCH_ID")
	private String imbBranchId;

	@Column(name = "IMB_BANK_ID")
	private String imbBankId;

	@Column(name = "IMB_SOL_ID")
	private String imbSolId;

	@Column(name = "IMB_BRANCH_NAME")
	private String imbBranchName;

	@Column(name = "IMB_ADDRESS1")
	private String imbAdd1;

	@Column(name = "IMB_ADDRESS2")
	private String imbAdd2;

	@Column(name = "IMB_LOCATION")
	private String imbLocation;

	@Column(name = "IMB_PINCODE")
	private int imbPinCode;

	@Column(name = "IMB_PRIMARY_ICMC_ID")
	private String imbPrimaryIcmcId;

	@Column(name = "IMB_SECONDARY_ICMC_ID")
	private String imbSecondIcmcId;

	@Column(name = "IMB_RBI_ID")
	private String imbRbiID;

	@Column(name = "IMB_ZONE")
	private String imbZone;

	@Column(name = "IMB_REGION")
	private String imbRegion;

	@Column(name = "IMB_DEL_FLAG")
	private int imbDelFlag;

	@Column(name = "IMB_STATUS")
	private int imbStatus;

	@Column(name = "IMB_REASON_FOR_DELETION")
	private String imbReasonForDel;

	@Column(name = "IMB_CREATED_BY")
	private String imvCreatedBy;

	@Column(name = "IMB_CREATED_ON")
	private Date imbCreatedOn;

	@Column(name = "IMB_MODIFIED_BY")
	private String imbModifiedBy;

	@Column(name = "IMB_MODIFIED_ON")
	private Date imbModifiedOn;

	@Column(name = "IMB_APPROVED_BY")
	private String imbApprovedBy;

	@Column(name = "IMB_APPROVED_ON")
	private Date imbApprovedOn;

	@Column(name = "IMB_S_SEQ")
	private int imbShadowSeq;

	@Column(name = "IMB_ACTIVE")
	private int imbActive;
}
