package com.icici.ivault.DTO;

import com.icici.ivault.model.Pr_Request_Header;

import lombok.Data;
import lombok.ToString;
/**
 * 
 * @author Kunal Hirdekar
 *
 */
@Data
@ToString
public class Request_DetailsDTO {
	private int requestSequence;

	private Pr_Request_Header prRequestHeader;

	private int imdDenomination;
	private int imdSeq;
	private long amount;
	private int imdCountInBundle;
	private int reqInwardNo;

}
