package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.ChinaDao;
import com.itheima.po.China;
import com.itheima.po.City;
import com.itheima.po.County;
import com.itheima.service.ChinaService;
@Service
public class ChinaServiceImol implements ChinaService {
	@Autowired
	private ChinaDao chinaDao;
	
	@Override
	public List<China> findChinaProvince() {
		// TODO Auto-generated method stub
		return this.chinaDao.findChinaProvince();
	}

	@Override
	public List<City> findChinaCity(Integer Adm1_id) {
		// TODO Auto-generated method stub
		return this.chinaDao.findChinaCity(Adm1_id);
	}

	@Override
	public List<County> findChinaCounty(Integer Adm2_id) {
		// TODO Auto-generated method stub
		return this.chinaDao.findChinaCounty(Adm2_id);
	}

}
