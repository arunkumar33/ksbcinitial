package com.KSBC.Bean;

import java.sql.Timestamp;

@javax.persistence.Entity
@javax.persistence.Table(name="ChairmanSignature")
public class ChairmanSignature
{
  @javax.persistence.Id
  @javax.persistence.Column(name="SerialNumber")
  @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  public int SerialNumber;
  private java.sql.Blob ChairmanSignature;
  private String Name;
  private Timestamp FromDate;
  private Timestamp ToDate;
  private String AdditionalInfo;
  
  public ChairmanSignature() {}
  
  public int getSerialNumber()
  {
    return SerialNumber;
  }
  
  public void setSerialNumber(int serialNumber) { SerialNumber = serialNumber; }
  
  public java.sql.Blob getChairmanSignature() {
    return ChairmanSignature;
  }
  
  public void setChairmanSignature(java.sql.Blob chairmanSignature) { ChairmanSignature = chairmanSignature; }
  






  public String getName()
  {
    return Name;
  }
  
  public void setName(String name) { Name = name; }
  
  public Timestamp getFromDate()
  {
    return FromDate;
  }
  
  public void setFromDate(Timestamp fromDate) { FromDate = fromDate; }
  
  public Timestamp getToDate() {
    return ToDate;
  }
  
  public void setToDate(Timestamp toDate) { ToDate = toDate; }
  
  public String getAdditionalInfo() {
    return AdditionalInfo;
  }
  
  public void setAdditionalInfo(String additionalInfo) { AdditionalInfo = additionalInfo; }
}
