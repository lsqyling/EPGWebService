package com.baustem.xmlservice.entity;

import java.io.Serializable;

public class ES extends StrIdEntity implements Serializable {

	private static final long serialVersionUID = -6321704113662569842L;
	/**
	 * 派生属性，便于生成数据库表
	 */
	private String tableName;

	private String streamType;
	private Integer PID;

	private String scrambled;
	private String languageCode;

	public ES() {
		super();
	}

	public ES(String tableName, String streamType, Integer pID,
			String scrambled, String languageCode) {
		super();
		this.tableName = tableName;
		this.streamType = streamType;
		PID = pID;
		this.scrambled = scrambled;
		this.languageCode = languageCode;
	}

	public ES(String streamType, Integer pID, String scrambled,
			String languageCode) {
		super();
		this.streamType = streamType;
		PID = pID;
		this.scrambled = scrambled;
		this.languageCode = languageCode;
	}

	public ES(String streamType, Integer pID, String scrambled) {
		super();
		this.streamType = streamType;
		PID = pID;
		this.scrambled = scrambled;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStreamType() {
		return streamType;
	}

	public void setStreamType(String streamType) {
		this.streamType = streamType;
	}

	public Integer getPID() {
		return PID;
	}

	public void setPID(Integer pID) {
		PID = pID;
	}

	public String getScrambled() {
		return scrambled;
	}

	public void setScrambled(String scrambled) {
		this.scrambled = scrambled;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	@Override
	public String toString() {
		return "ES [tableName=" + tableName + ", streamType=" + streamType
				+ ", PID=" + PID + ", scrambled=" + scrambled
				+ ", languageCode=" + languageCode + "]";
	}

}
