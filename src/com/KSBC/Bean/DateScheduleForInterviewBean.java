package com.KSBC.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DateScheduleForInterviewBean")
public class DateScheduleForInterviewBean {
	@Id
	@Column(name="RegNumber",nullable=false,unique=true)
	private String RegNumber;
	public String getRegNumber() {
		return RegNumber;
	}
	public void setRegNumber(String regNumber) {
		RegNumber = regNumber;
	}
	public Date getDateOfSchedule() {
		return DateOfSchedule;
	}
	public void setDateOfSchedule(Date dateOfSchedule) {
		DateOfSchedule = dateOfSchedule;
	}
	private Date DateOfSchedule;
	
}
