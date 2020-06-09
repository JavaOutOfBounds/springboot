package com.javaoutofbounds.drools.beans;

import java.io.Serializable;

/*
 * @Author javaoutofbound
 */

public class Subscribe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String offerName;
	private String clientName;
	private boolean sync;
	private String syncStartDate;
	private String syncEndDate;
	private int discountInPercentage;
	
	
	public Subscribe() {
		super();
	}
	
	public Subscribe(String offerName, String clientName, boolean sync, String syncStartDate, String syncEndDate,
			int discountInPercentage) {
		super();
		this.offerName = offerName;
		this.clientName = clientName;
		this.sync = sync;
		this.syncStartDate = syncStartDate;
		this.syncEndDate = syncEndDate;
		this.discountInPercentage = discountInPercentage;
	}

	@Override
	public String toString() {
		return "Subscribe [offerName=" + offerName + ", clientName=" + clientName + ", isSync=" + sync
				+ ", syncStartDate=" + syncStartDate + ", syncEndDate=" + syncEndDate + ", discountInPercentage="
				+ discountInPercentage + "]";
	}

	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public String getSyncStartDate() {
		return syncStartDate;
	}
	public void setSyncStartDate(String syncStartDate) {
		this.syncStartDate = syncStartDate;
	}
	public String getSyncEndDate() {
		return syncEndDate;
	}
	public void setSyncEndDate(String syncEndDate) {
		this.syncEndDate = syncEndDate;
	}
	public int getDiscountInPercentage() {
		return discountInPercentage;
	}
	public void setDiscountInPercentage(int discountInPercentage) {
		this.discountInPercentage = discountInPercentage;
	}
	
	
	
	

}
