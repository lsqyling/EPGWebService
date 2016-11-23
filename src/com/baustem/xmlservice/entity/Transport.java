package com.baustem.xmlservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transport extends StrIdEntity implements Serializable {

	private static final long serialVersionUID = 2105219010418755793L;
	/**
	 * 派生属性，便于生成数据库表
	 */
	private String tableName;

	private String frequency;
	private Integer PMTPID;
	private Integer PCRPID;

	private List<ES> esList = new ArrayList<ES>();

	public Transport() {
		super();
	}

	public Transport(String tableName, String frequency, Integer pMTPID,
			Integer pCRPID, List<ES> esList) {
		super();
		this.tableName = tableName;
		this.frequency = frequency;
		PMTPID = pMTPID;
		PCRPID = pCRPID;
		this.esList = esList;
	}

	public Transport(String frequency, Integer pMTPID, Integer pCRPID,
			List<ES> esList) {
		super();
		this.frequency = frequency;
		PMTPID = pMTPID;
		PCRPID = pCRPID;
		this.esList = esList;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getPMTPID() {
		return PMTPID;
	}

	public void setPMTPID(Integer pMTPID) {
		PMTPID = pMTPID;
	}

	public Integer getPCRPID() {
		return PCRPID;
	}

	public void setPCRPID(Integer pCRPID) {
		PCRPID = pCRPID;
	}

	public List<ES> getEsList() {
		return esList;
	}

	public void setEsList(List<ES> esList) {
		this.esList = esList;
	}

	@Override
	public String toString() {
		return "Transport [tableName=" + tableName + ", frequency=" + frequency
				+ ", PMTPID=" + PMTPID + ", PCRPID=" + PCRPID + "]";
	}

}
