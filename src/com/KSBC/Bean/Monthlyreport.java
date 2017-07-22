package com.KSBC.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Monthlyreport")


public class Monthlyreport {

	@Id
	@Column(name="SerialNumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SerialNumber;
	
	
public int SubscriptionFee;
public int CostReceipts;
public int SeniorContribution;
public int InterestOnFD;
public int SaleOfStamp;
public int others;
public int closingFD;
public int SaleOfStampMonthly;
public int SLF;
public int MLF;
public int LMF;
public int total;
}
