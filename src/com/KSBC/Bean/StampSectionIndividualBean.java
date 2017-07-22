package com.KSBC.Bean;

import java.sql.Timestamp;

@javax.persistence.Entity
@javax.persistence.Table(name="StampSectionIndividualBean")
public class StampSectionIndividualBean {
  @javax.persistence.Id
  @javax.persistence.Column(name="SerialNumber")
  @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private long SerialNumber;
  private String name;
  private String place;
  private long stampFee;
  private String paymentMode;
  private long netAmount;
  
  public StampSectionIndividualBean() {}
  
  public long getSerialNumber() { return SerialNumber; }
  
  public void setSerialNumber(long serialNumber) {
    SerialNumber = serialNumber;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) { this.name = name; }
  
  public String getPlace() {
    return place;
  }
  
  public void setPlace(String place) { this.place = place; }
  

  private long totalStamps;
  
  private long postalCharges;
  
  private long grossAmount;
  
  private long totalAmount;
  
  private String ReceiptNumber;
  private Timestamp ChallanCreatedDate;
  private String remarks;
  public String getPaymentMode()
  {
    return paymentMode;
  }
  
  public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
  






  public long getNetAmount()
  {
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
