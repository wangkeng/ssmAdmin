package com.wang.ssm.baseModel;

public class ZtreeModel {

	private int id ;
	private String name ;
	private int pid ;
	private boolean isParent ;
	private boolean open = false ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean getIsOpen() {
		return open;
	}
	public void setIsOpen(boolean open) {
		this.open = open;
	}
	
	
}
