package com.itheima.po;

public class County {
	private Integer id;
	private String name;
	private String weather_id;
	public County() {
		super();
	}
	public County(Integer id, String name, String weather_id) {
		super();
		this.id = id;
		this.name = name;
		this.weather_id = weather_id;
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
	public String getWeather_id() {
		return weather_id;
	}
	public void setWeather_id(String weather_id) {
		this.weather_id = weather_id;
	}
	@Override
	public String toString() {
		return "County [id=" + id + ", name=" + name + ", weather_id=" + weather_id + "]";
	}
}
