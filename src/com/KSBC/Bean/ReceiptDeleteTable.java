package com.KSBC.Bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ReceiptDeleteTable")
public class ReceiptDeleteTable {
	@Id
	@Column(name="DeleteNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int DeleteNumber;
	private int MonthlyReportSLNumber;
	private int ChallanGenerateSLNumber;
	private String Reason;
	private String operator;
	private String IP;
	private String Type;
	private LocalDate TimeWhenDeleted;
	public int getDeleteNumber() {
		return DeleteNumber;
	}
	public void setDeleteNumber(int deleteNumber) {
		DeleteNumber = deleteNumber;
	}
	public int getMonthlyReportSLNumber() {
		return MonthlyReportSLNumber;
	}
	public void setMonthlyReportSLNumber(int monthlyReportSLNumber) {
		MonthlyReportSLNumber = monthlyReportSLNumber;
	}
	public int getChallanGenerateSLNumber() {
		return ChallanGenerateSLNumber;
	}
	public void setChallanGenerateSLNumber(int challanGenerateSLNumber) {
		ChallanGenerateSLNumber = challanGenerateSLNumber;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public LocalDate getTimeWhenDeleted() {
		return TimeWhenDeleted;
	}
	public void setTimeWhenDeleted(LocalDate timeWhenDeleted) {
		TimeWhenDeleted = timeWhenDeleted;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
}
