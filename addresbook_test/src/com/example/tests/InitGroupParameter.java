package com.example.tests;

public class InitGroupParameter implements Comparable <InitGroupParameter>  {
	private String nameGroup;
	private String head;
	private String foot;
	private String id;

	public String getId() {
		return id;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public String getHead() {
		return head;
	}

	public String getFoot() {
		return foot;
	}

	public InitGroupParameter(String nameGroup, String head, String foot) {
		this.nameGroup = nameGroup;
		this.head = head;
		this.foot = foot;
	}
	
	public InitGroupParameter() {
	}
	
	public InitGroupParameter withId(String id) {
		this.id = id;
		return this;
	}

	public InitGroupParameter withName(String name) {
		this.nameGroup = name;
		return this;
	}
	public InitGroupParameter withHead(String head) {
		this.head = head;
		return this;
	}
	public InitGroupParameter withFooter(String foot) {
		this.foot = foot;
		return this;
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

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public void setId(String id) {
		this.id = id;
	}


}