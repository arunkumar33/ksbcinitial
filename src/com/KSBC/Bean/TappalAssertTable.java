package com.KSBC.Bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@javax.persistence.Entity
@javax.persistence.Table(name="TappalAssertTable")
public class TappalAssertTable
{
  @javax.persistence.Id
  @Column(name="SerialNumber")
  @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
  private int SerialNumber;
  private String ITAssert;
  private String CPUAssertNumber;
  private String HardwareConfiguration;
  private String MonitorAssertNumber;
  private String MonitorSLNo;
  private String Description;
  
  public TappalAssertTable() {}
  
  public String getDescription()
  {
    return Description;
  }
  
  public void setDescription(String description)
  {
    Description = description;
  }
  

  private String MonitorMake;
  
  private String CPUMake;
  
  private String IPAddress;
  
  private String UserName;
  private String PrinterMake;
  private String PrinterModel;
  private String Remarks;
  private Timestamp InsertedDate;
  public int getSerialNumber()
  {
    return SerialNumber;
  }
  
  public void setSerialNumber(int serialNumber)
  {
    SerialNumber = serialNumber;
  }
  
  public String getITAssert()
  {
    return ITAssert;
  }
  
  public void setITAssert(String iTAssert)
  {
    ITAssert = iTAssert;
  }
  
  public String getCPUAssertNumber()
  {
    return CPUAssertNumber;
  }
  
  public void setCPUAssertNumber(String cPUAssertNumber)
  {
    CPUAssertNumber = cPUAssertNumber;
  }
  
  public String getHardwareConfiguration()
  {
    return HardwareConfiguration;
  }
  
  public void setHardwareConfiguration(String hardwareConfiguration)
  {
    HardwareConfiguration = hardwareConfiguration;
  }
  
  public String getMonitorAssertNumber()
  {
    return MonitorAssertNumber;
  }
  
  public void setMonitorAssertNumber(String monitorAssertNumber)
  {
    MonitorAssertNumber = monitorAssertNumber;
  }
  
  public String getMonitorSLNo()
  {
    return MonitorSLNo;
  }
  
  public void setMonitorSLNo(String monitorSLNo)
  {
    MonitorSLNo = monitorSLNo;
  }
  
  public String getMonitorMake()
  {
    return MonitorMake;
  }
  
  public void setMonitorMake(String monitorMake)
  {
    MonitorMake = monitorMake;
  }
  
  public String getCPUMake()
  {
    return CPUMake;
  }
  
  public void setCPUMake(String cPUMake)
  {
    CPUMake = cPUMake;
  }
  
  public String getIPAddress()
  {
    return IPAddress;
  }
  
  public void setIPAddress(String iPAddress)
  {
    IPAddress = iPAddress;
  }
  



  public String getUserName()
  {
    return UserName;
  }
  
  public void setUserName(String userName)
  {
    UserName = userName;
  }
  
  public String getPrinterMake()
  {
    return PrinterMake;
  }
  
  public void setPrinterMake(String printerMake)
  {
    PrinterMake = printerMake;
  }
  
  public String getPrinterModel()
  {
    return PrinterModel;
  }
  
  public void setPrinterModel(String printerModel)
  {
    PrinterModel = printerModel;
  }
  
  public String getRemarks()
  {
    return Remarks;
  }
  
  public void setRemarks(String remarks)
  {
    Remarks = remarks;
  }
  
  public Timestamp getInsertedDate()
  {
    return InsertedDate;
  }
  
  public void setInsertedDate(Timestamp insertedDate)
  {
    InsertedDate = insertedDate;
  }
}
