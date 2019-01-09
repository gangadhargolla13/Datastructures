package com.java.collections;

public class Umpair implements Comparable<Object>{
	
	private String name;
	private Integer noMatches;
	private String county;
	

	public int compareTo(Object o) {
		Umpair umpair = (Umpair)o;
		int val = this.noMatches.compareTo(umpair.getNoMatches());
		if(val == 0){
			val = this.county.compareTo(umpair.getCounty());
		}
		return val;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNoMatches() {
		return noMatches;
	}


	public void setNoMatches(int noMatches) {
		this.noMatches = noMatches;
	}


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
	}

}
