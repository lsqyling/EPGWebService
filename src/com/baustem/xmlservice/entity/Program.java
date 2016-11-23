package com.baustem.xmlservice.entity;

import java.io.Serializable;

public class Program extends IdEntity implements Serializable {

	private static final long serialVersionUID = -3757075790462529713L;

	/**
	 * 派生属性，便于生成数据库表
	 */
	private String tableName;

	private Integer ONID;
	private Integer TSID;
	private Integer SID;

	private Integer logicalNumber;
	private String name;

	private String multilingualName;
	private String multilingualName_language;

	private String provider;
	private String serviceType;

	private String scrambled;

	private Transport transport;

	public Program() {
		super();
	}

	public Program(String tableName, Integer oNID, Integer tSID, Integer sID,
			Integer logicalNumber, String name, String multilingualName,
			String multilingualName_language, String provider,
			String serviceType, String scrambled, Transport transport) {
		super();
		this.tableName = tableName;
		ONID = oNID;
		TSID = tSID;
		SID = sID;
		this.logicalNumber = logicalNumber;
		this.name = name;
		this.multilingualName = multilingualName;
		this.multilingualName_language = multilingualName_language;
		this.provider = provider;
		this.serviceType = serviceType;
		this.scrambled = scrambled;
		this.transport = transport;
	}

	public Program(Integer oNID, Integer tSID, Integer sID,
			Integer logicalNumber, String name, String multilingualName,
			String multilingualName_language, String provider,
			String serviceType, String scrambled, Transport transport) {
		super();
		ONID = oNID;
		TSID = tSID;
		SID = sID;
		this.logicalNumber = logicalNumber;
		this.name = name;
		this.multilingualName = multilingualName;
		this.multilingualName_language = multilingualName_language;
		this.provider = provider;
		this.serviceType = serviceType;
		this.scrambled = scrambled;
		this.transport = transport;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getONID() {
		return ONID;
	}

	public void setONID(Integer oNID) {
		ONID = oNID;
	}

	public Integer getTSID() {
		return TSID;
	}

	public void setTSID(Integer tSID) {
		TSID = tSID;
	}

	public Integer getSID() {
		return SID;
	}

	public void setSID(Integer sID) {
		SID = sID;
	}

	public Integer getLogicalNumber() {
		return logicalNumber;
	}

	public void setLogicalNumber(Integer logicalNumber) {
		this.logicalNumber = logicalNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMultilingualName() {
		return multilingualName;
	}

	public void setMultilingualName(String multilingualName) {
		this.multilingualName = multilingualName;
	}

	public String getMultilingualName_language() {
		return multilingualName_language;
	}

	public void setMultilingualName_language(String multilingualName_language) {
		this.multilingualName_language = multilingualName_language;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getScrambled() {
		return scrambled;
	}

	public void setScrambled(String scrambled) {
		this.scrambled = scrambled;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@Override
	public String toString() {
		return "Program [tableName=" + tableName + ", ONID=" + ONID + ", TSID="
				+ TSID + ", SID=" + SID + ", logicalNumber=" + logicalNumber
				+ ", name=" + name + ", multilingualName=" + multilingualName
				+ ", multilingualName_language=" + multilingualName_language
				+ ", provider=" + provider + ", serviceType=" + serviceType
				+ ", scrambled=" + scrambled + "]";
	}

}
