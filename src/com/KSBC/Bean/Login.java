package com.KSBC.Bean;

import java.sql.Date;

public class Login {
private String USerName;
private String Password;
private String Department;
private Date LastPasswordChange;
public Date getLastPasswordChange() {
	return LastPasswordChange;
}
public void setLastPasswordChange(Date lastPasswordChange) {
	LastPasswordChange = lastPasswordChange;
}
public String getUSerName() {
	return USerName;
}
public void setUSerName(String uSerName) {
	USerName = uSerName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
}
