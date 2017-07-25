package entity;

import java.sql.Date;

public class Cost{
	private Integer id;//资费ID
	private String name;//资费名称
	private Integer baseDuration;//包在线时长
	private Float baseCost;//月固定费
	private Float unitCost;//单位费用
	private String status;//状态，0：开通，1：暂停
	private String descr;//资费信息说明
	private Date createTime;//创建日期
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	private Date startTime;//启用日期
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Float getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}
	public Float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
