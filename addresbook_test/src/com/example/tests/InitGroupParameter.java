package com.example.tests;

public class InitGroupParameter implements Comparable <InitGroupParameter>  {
	public String nameGroup;
	public String head;
	public String foot;

	public InitGroupParameter(String nameGroup, String head, String foot) {
		this.nameGroup = nameGroup;
		this.head = head;
		this.foot = foot;
	}
	
	public InitGroupParameter() {
	}

	@Override
	public String toString() {
		return "InitGroupParameter [nameGroup=" + nameGroup + ", head=" + head
				+ ", foot=" + foot + "]";
	}
	
	@Override
	public int hashCode() {
	//	final int prime = 31;
		int result = 1;
	//	result = prime * result
	//			+ ((nameGroup == null) ? 0 : nameGroup.hashCode());
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
		InitGroupParameter other = (InitGroupParameter) obj;
		if (nameGroup == null) {
			if (other.nameGroup != null)
				return false;
		} else if (!nameGroup.equals(other.nameGroup))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(InitGroupParameter other) {
		
		return this.nameGroup.toLowerCase().compareTo(other.nameGroup.toLowerCase());
	}
}