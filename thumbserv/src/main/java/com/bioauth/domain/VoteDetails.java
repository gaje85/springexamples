package com.bioauth.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "votedetails", catalog = "votemanagement")

public class VoteDetails {

	int id;
	int partyid;
	long aadhaarid;
	
	
	public VoteDetails(){
		
	}
	
	public VoteDetails(int id,int partyid,int userid){
		this.id = id;
		this.partyid = partyid;
		this.aadhaarid = userid;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "partyid")
	public int getPartyid() {
		return partyid;
	}

	public void setPartyid(int partyid) {
		this.partyid = partyid;
	}
	@Column(name = "aadhaarid")
	public long getAadhaarid() {
		return aadhaarid;
	}

	public void setAadhaarid(long aadhaarid) {
		this.aadhaarid = aadhaarid;
	}
	
}
