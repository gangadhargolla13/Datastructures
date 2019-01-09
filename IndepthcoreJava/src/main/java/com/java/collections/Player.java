package com.java.collections;

import java.io.Serializable;

public class Player implements Serializable,Cloneable {

	private static final long serialVersionUID = 2017L;
	private String name;
	private int rank;
	private int highest;
	private float avarage;
	private String country;
	
	public Player(String name1){
		this(name1,0,0,0.0f,null);
	}
	public Player(String name, int rank, int highest, float avarage,String country) {
		super();
		this.name = name;
		this.rank = rank;
		this.highest = highest;
		this.avarage = avarage;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getHighest() {
		return highest;
	}

	public void setHighest(int highest) {
		this.highest = highest;
	}

	public float getAvarage() {
		return avarage;
	}

	public void setAvarage(float avarage) {
		this.avarage = avarage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(avarage);
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + highest;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Float.floatToIntBits(avarage) != Float
				.floatToIntBits(other.avarage))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (highest != other.highest)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", rank=" + rank + ", highest="
				+ highest + ", avarage=" + avarage + ", country=" + country
				+ "]";
	}
	
	@Override
	public Player clone() throws CloneNotSupportedException{
		return (Player)super.clone();
	}
}
