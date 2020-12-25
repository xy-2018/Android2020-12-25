package com.itheima.dao;

import java.util.List;

import com.itheima.po.China;
import com.itheima.po.City;
import com.itheima.po.County;

public interface ChinaDao {
	public List<China> findChinaProvince();
	public List<City> findChinaCity(Integer Adm1_id);
	public List<County> findChinaCounty(Integer Adm2_id);
}
