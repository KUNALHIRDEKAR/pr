package com.icici.ivault.DTO;

import lombok.Data;
import lombok.ToString;
/**
 * 
 * @author Kunal Hirdekar
 *
 */
@Data
@ToString
public class MachineRegisterDTO {
	private int machineRegisterId;
	private int machineID;
	private int activeStatus;
	private String machineCompany;
	private String machineIcmcId;
	private  String machineName;

}
