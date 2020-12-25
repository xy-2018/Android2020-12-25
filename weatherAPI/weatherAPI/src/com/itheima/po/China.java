package com.itheima.po;

public class China {
	private Integer id;
	private String name;
	public China() {
		super();
	}
	public China(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "China [id=" + id + ", name=" + name + "]";
	}
	
}
