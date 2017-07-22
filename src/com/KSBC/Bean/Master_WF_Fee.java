package com.KSBC.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Master_WF_Fee")
public class Master_WF_Fee {
	public int getWFFee() {
		return WFFee;
	}
	public void setWFFee(int wFFee) {
		WFFee = wFFee;
	}
	public int getLateFee() {
		return LateFee;
	}
	public void setLateFee(int lateFee) {
		LateFee = lateFee;
	}
	@Id
private int WFFee;
private int LateFee;
}
