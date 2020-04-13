package com.icici.ivault.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author Kunal Hirdekar
 * Date: 06/04/2020
 */
@Entity
@Table(name="Mchn_Rgstr_TBL22")
@Data
@ToString
public class MachineRegister {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int machineRegisterId;
	private int machineID;
	private int activeStatus;
	private String machineCompany;
	private String machineIcmcId;
	private  String machineName;

}
