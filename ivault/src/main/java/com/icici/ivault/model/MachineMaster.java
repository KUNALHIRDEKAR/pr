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
 * Date: 06/04/2020
 *
 */
@Entity
@Table(name="Mchn_Mstr_TBL22")
@Data
@ToString
public class MachineMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int machineID;
	private String machineCompany;
	private String machineIcmcId;
	private  String machineName;
	private int activeStatus;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMD_CREATED_ON")
	private Date machineAddedOn;

	

}
