package com.KSBC.Bean;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="FileUploadBean")
public class FileUploadBean {
	@Id
	@Column(name="RegNumber",nullable=false,unique=true)
	private String RegNumber;
	@Column(name="DOBCertificate")
    @Lob
	private Blob DOBCertificate;
	public String getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
	public Blob getDOBCertificate() {
		return DOBCertificate;
	}
	public void setDOBCertificate(Blob dOBCertificate) {
		DOBCertificate = dOBCertificate;
	}
	public Blob getPhoto() {
		return Photo;
	}
	public void setPhoto(Blob photo) {
		Photo = photo;
	}
	public Blob getChallanScanedCopy() {
		return ChallanScanedCopy;
	}
	public void setChallanScanedCopy(Blob challanScanedCopy) {
		ChallanScanedCopy = challanScanedCopy;
	}
	
	
	@Column(name="Photo")
    @Lob
	private Blob Photo;
	@Column(name="ChallanScanedCopy")
    @Lob
	
	private Blob ChallanScanedCopy;
	
}
