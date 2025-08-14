package com.tss.model;

import java.sql.Date;
import java.time.LocalDate;

public class LeaveRequest {
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	  private int id;
	    private int userId;
	    private Date startDate;
	    private Date endDate;
	    private String reason;
	    private String status;
	    
	    public String getRejectionReason() {
			return rejectionReason;
		}
		public void setRejectionReason(String rejectionReason) {
			this.rejectionReason = rejectionReason;
		}
		public LocalDate getDecisionDate() {
			return decisionDate;
		}
		public void setDecisionDate(LocalDate decisionDate) {
			this.decisionDate = decisionDate;
		}
		private String rejectionReason;        
	    private LocalDate decisionDate;       
}
