package com.icici.ivault.DTO;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DenominationList {

	private List<DenominationDTO> denominationFormList;
/*	private int itihsSeckLockNo;
	private int itihsValue; // total coins and bundle value
	private String itithsUserName;
	private String itithsBranchSolId;
	private String itithIcmcId;
*/
}
