package com.itheima.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.po.China;
import com.itheima.po.City;
import com.itheima.po.County;
import com.itheima.service.ChinaService;

@Controller
public class ChinaController {
	@Autowired
	private ChinaService chinaservice;
	@RequestMapping("/China")
	@ResponseBody
	public List<China> findChinaProvince(HttpSession session) {
		List<China> Chinalist = chinaservice.findChinaProvince();
		return Chinalist;
	}

	/**
	 * 这个才是路径
	 * @param session
	 * @param Adm1_id
	 * @return
	 */
	@GetMapping("/China/{Adm1_id}")
	@ResponseBody
	public List<City> findChinaCity(HttpSession session,@PathVariable Integer Adm1_id) {
		List<City> Citylist = chinaservice.findChinaCity(Adm1_id);
		return Citylist;
	}
	@GetMapping("/China/{Adm1_id}/{Adm2_id}")
	@ResponseBody
	public List<County> findChinaCounty(HttpSession session,@PathVariable Integer Adm1_id,@PathVariable Integer Adm2_id) {
		List<County> Countylist = chinaservice.findChinaCounty(Adm2_id);
		return Countylist;
	}
}
