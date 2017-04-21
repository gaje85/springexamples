package com.bioauth.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "politicalparties", catalog = "votemanagement")

public class PoliticalParties {

	int id;
	String partyName;
	String candidateName;
	String symbolPath;
	
	public PoliticalParties(){
		
	}
	
	public PoliticalParties(int id,String partyName,String candidatename,String symbolPath){
		this.id = id;
		this.partyName = partyName;
		this.candidateName = candidatename;
		this.symbolPath = symbolPath;
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
	@Column(name = "partyname")
	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	@Column(name = "candidatename")
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	@Column(name = "symbolpath")
	public String getSymbolPath() {
		return symbolPath;
	}

	public void setSymbolPath(String symbolPath) {
		this.symbolPath = symbolPath;
	}
	
}
