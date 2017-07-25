package entity;

import java.io.Serializable;

public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//private Integer accountId;
	private String serviceName;
	
	//◊∑º” Ù–‘
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getAccountId() {
//		return accountId;
//	}
//	public void setAccountId(Integer accountId) {
//		this.accountId = accountId;
//	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
