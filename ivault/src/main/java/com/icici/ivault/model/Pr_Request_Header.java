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

import lombok.Data;
import lombok.ToString;
/**
 * 
 * @author Kunal Hirdekar
 *
 */

@Entity
@Table(name = "PR_RQST_HDR_tbl_final0981")
@Data
@ToString
public class Pr_Request_Header {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestHeaderSeq;

	private long requestedAmount;

	private String requestBy;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestOn;

	private String reqIcmcId;

	private int reqStatus;
	private int flag;
}
