package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="REGNumberGenratorSequence")
public class REGNumberGenratorSequence {

	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="REGNumberGenrator")
	@SequenceGenerator(name="SEQ_generator",sequenceName="REGNumberGenrator")
	private int REGGeneratorValue;
	
	private int PresentYear=2017;
	
	private String REGNumber="REG"+"/"+this.REGGeneratorValue+"/"+this.PresentYear;

	public int getREGGeneratorValue() {
		return REGGeneratorValue;
	}

	public void setREGGeneratorValue(int rEGGeneratorValue) {
		REGGeneratorValue = rEGGeneratorValue;
	}

	public String getREGNumber() {
		return REGNumber;
	}

	public void setREGNumber(String rEGNumber) {
		REGNumber = rEGNumber;
	}

	public int getPresentYear() {
		return PresentYear;
	}

	public void setPresentYear(int presentYear) {
		PresentYear = presentYear;
	}
	
}
