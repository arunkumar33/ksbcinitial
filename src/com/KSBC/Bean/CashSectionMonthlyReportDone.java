package com.KSBC.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CashSectionMonthlyReportDone")
public class CashSectionMonthlyReportDone {
	

	@Id
	@Column(name="ReceiptNo")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ReceiptNo;

	private String Name;
	private String operator;

	
	public int getReceiptNo() {
		return ReceiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		ReceiptNo = receiptNo;
	}
	public String getEnrollNo() {
		return EnrollNo;
	}
	public void setEnrollNo(String enrollNo) {
		EnrollNo = enrollNo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getParticulars() {
		return Particulars;
	}
	public void setParticulars(String particulars) {
		Particulars = particulars;
	}
	public String getPaymode() {
		return Paymode;
	}
	public void setPaymode(String paymode) {
		Paymode = paymode;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getEntFee() {
		return EntFee;
	}
	public void setEntFee(int entFee) {
		EntFee = entFee;
	}
	public int getKLA() {
		return KLA;
	}
	public void setKLA(int kLA) {
		KLA = kLA;
	}
	public int getIC() {
		return IC;
	}
	public void setIC(int iC) {
		IC = iC;
	}
	public int getMisc() {
		return Misc;
	}
	public void setMisc(int misc) {
		Misc = misc;
	}
	public int getKAWF() {
		return KAWF;
	}
	public void setKAWF(int kAWF) {
		KAWF = kAWF;
	}
	public int getSTAMP() {
		return STAMP;
	}
	public void setSTAMP(int sTAMP) {
		STAMP = sTAMP;
	}
	public int getBCIAWF() {
		return BCIAWF;
	}
	public void setBCIAWF(int bCIAWF) {
		BCIAWF = bCIAWF;
	}
	public int getFDS() {
		return FDS;
	}
	public void setFDS(int fDS) {
		FDS = fDS;
	}
	public Date getChallanCreatedDate() {
		return TodoListCompletedList;
	}
	public void setChallanCreatedDate(Date challanCreatedDate) {
		TodoListCompletedList = challanCreatedDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	private String EnrollNo;
	private String place;
	private String Particulars;
	private String Paymode;
	private int Amount;
	private int EntFee;
	private int KLA;
	private int IC;
	private int Misc;
	private int KAWF;
	private int STAMP;
	private int BCIAWF;
	private int FDS;
private Date TodoListCompletedList;

}
