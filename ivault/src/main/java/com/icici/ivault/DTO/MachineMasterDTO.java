package com.icici.ivault.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author Kunal hirdekar Date: 06/04/2020
 *
 */
@Data
@ToString
public class MachineMasterDTO {

	private int machineID;
	private String machineCompany;
	private String machineIcmcId;
	private String machineName;
	private int activeStatus;
	private Date machineAddedOn;

	public MachineMasterDTO(int machineID, String machineCompany, String machineIcmcId, String machineName,
			Date machineAddedOn) {
		super();
		this.machineID = machineID;
		this.machineCompany = machineCompany;
		this.machineIcmcId = machineIcmcId;
		this.machineName = machineName;
		this.machineAddedOn = machineAddedOn;
	}

	public MachineMasterDTO() {
		// TODO Auto-generated constructor stub
	}

}
