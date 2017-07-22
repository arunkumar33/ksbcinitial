package com.KSBC.Bean;

import java.sql.Timestamp;

@javax.persistence.Entity
@javax.persistence.Table(name="TappalComplaintInword")
public class TappalComplaintInword { @javax.persistence.Id
  @javax.persistence.Column(name="SerialNumber")
  @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private int SerialNumber;
  
  public TappalComplaintInword() {}
  private String Name;
  private String Address;
  public int getSerialNumber() { return SerialNumber; }
  

  public void setSerialNumber(int serialNumber) { SerialNumber = serialNumber; }
  private String particular;
  
  public String getName() { return Name; }
  private String Remarks;
  
  public void setName(String name) { Name = name; }
  private String InworldNumber;
  
  public String getAddress() { return Address; }
  

  public void setAddress(String address) { Address = address; }
  
  private Timestamp OutWorldDate;
  public String getParticular() { return particular; }
  
  public void setParticular(String particular) {
    this.particular = particular;
  }
  
  public String getRemarks() { return Remarks; }
  
  public void setRemarks(String remarks) {
    Remarks = remarks;
  }
  
  public String getInworldNumber() {
    return InworldNumber;
  }
  
  public void setInworldNumber(String inworldNumber) { InworldNumber = inworldNumber; }
  
  public Timestamp getOutWorldDate() {
    return OutWorldDate;
  }
  
  public void setOutWorldDate(Timestamp outWorldDate) { OutWorldDate = outWorldDate; }
}
