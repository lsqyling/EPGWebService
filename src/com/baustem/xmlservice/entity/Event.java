package com.baustem.xmlservice.entity;

import java.io.Serializable;

public class Event extends IdEntity implements Serializable {

	private static final long serialVersionUID = -4819226662563834253L;
	/**
	 * 派生属性便于生成数据库表名
	 */
	private String tableName;
	/**
	 * 派生属性便于生成对象
	 */
	private String playUrl;
	private String postUrl;
	private Long endTime;

	private Integer ONID;
	private Integer TSID;
	private Integer SID;
	private Integer EID;

	private Long startTime;
	private Long duration;

	private String eventName;
	private String eventName_language;

	private String eventText_language;

	public Event() {
		super();
	}

	public Event(String tableName, Integer oNID, Integer tSID, Integer sID,
			Integer eID, Long startTime, Long duration, String eventName,
			String eventName_language, String eventText_language) {
		super();
		this.tableName = tableName;
		ONID = oNID;
		TSID = tSID;
		SID = sID;
		EID = eID;
		this.startTime = startTime;
		this.duration = duration;
		this.eventName = eventName;
		this.eventName_language = eventName_language;
		this.eventText_language = eventText_language;
	}

	public Event(Integer oNID, Integer tSID, Integer sID, Integer eID,
			Long startTime, Long duration, String eventName,
			String eventName_language, String eventText_language) {
		super();
		ONID = oNID;
		TSID = tSID;
		SID = sID;
		EID = eID;
		this.startTime = startTime;
		this.duration = duration;
		this.eventName = eventName;
		this.eventName_language = eventName_language;
		this.eventText_language = eventText_language;
	}
	/**
	 * 派生的setter and getter method
	 * @return
	 */
	public String getTableName() {
		return tableName;
	}

	public String getPlayUrl() {
		return playUrl;
	}

	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
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

	public Integer getEID() {
		return EID;
	}

	public void setEID(Integer eID) {
		EID = eID;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName_language() {
		return eventName_language;
	}

	public void setEventName_language(String eventName_language) {
		this.eventName_language = eventName_language;
	}

	public String getEventText_language() {
		return eventText_language;
	}

	public void setEventText_language(String eventText_language) {
		this.eventText_language = eventText_language;
	}

	@Override
	public String toString() {
		return "Event [tableName=" + tableName + ", ONID=" + ONID + ", TSID="
				+ TSID + ", SID=" + SID + ", EID=" + EID + ", startTime="
				+ startTime + ", duration=" + duration + ", eventName="
				+ eventName + ", eventName_language=" + eventName_language
				+ ", eventText_language=" + eventText_language + "]";
	}

}