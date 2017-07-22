package com.KSBC.Bean;

import java.sql.Timestamp;

@javax.persistence.Entity
@javax.persistence.Table(name="StampSectionAssociationBean")
public class StampSectionAssociationBean {
  @javax.persistence.Id
  @javax.persistence.Column(name="SerialNumber")
  @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private long SerialNumber;
  private String district;
  private String associationName;
  private long stampFee;
  private String ReceiptNumber;
  private String paymentMode;
  private long deduction;
  
  public StampSectionAssociationBean() {}
  
  public long getSerialNumber() {
    return SerialNumber;
  }
  
  public void setSerialNumber(long serialNumber) { SerialNumber = serialNumber; }
  

  private Timestamp ChallanCreatedDate;
  
  private long netAmount;
  
  private long totalStamps;
  
  private long postalCharges;
  
  private long grossAmount;
  private long totalAmount;
  private String remarks;
  public String getDistrict()
  {
    return district;
  }
  
  public void setDistrict(String district) { this.district = district; }
  
  public String getAssociationName()
  {
    return associationName;
  }
  
  public void setAssociationName(String associationName) { this.associationName = associationName; }
  
  public String getPaymentMode()
  {
    return paymentMode;
  }
  
  public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
  
  public long getDeduction()
  {
    return deduction;
  }
  
  public void setDeduction(long deduction) { this.deduction = deduction; }
  
  public long getNetAmount() {
    return netAmount;
  }
  
  public void setNetAmount(long netAmount) { this.netAmount = netAmount; }
  
  public long getTotalStamps() {
    return totalStamps;
  }
  
  public void setTotalStamps(long totalStamps) { this.totalStamps = totalStamps; }
  
  public long getPostalCharges() {
    return postalCharges;
  }
  
  public void setPostalCharges(long postalCharges) { this.postalCharges = postalCharges; }
  
  public long getStampFee()
  {
    return stampFee;
  }
  
  public void setStampFee(long stampFee) { this.stampFee = stampFee; }
  
  public long getGrossAmount() {
    return grossAmount;
  }
  
  public void setGrossAmount(long grossAmount) { this.grossAmount = grossAmount; }
  
  public String getRemarks()
  {
    return remarks;
  }
  
  public void setRemarks(String remarks) { this.remarks = remarks; }
  
  public long getTotalAmount() {
    return totalAmount;
  }
  
  public void setTotalAmount(long totalAmount) { this.totalAmount = totalAmount; }
  
  public Timestamp getChallanCreatedDate() {
    return ChallanCreatedDate;
  }
  
  public void setChallanCreatedDate(Timestamp challanCreatedDate) { ChallanCreatedDate = challanCreatedDate; }
  
  public String getReceiptNumber() {
    return ReceiptNumber;
  }
  
  public void setReceiptNumber(String receiptNumber) { ReceiptNumber = receiptNumber; }
}
