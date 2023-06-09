package com.project.Phase3EndProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Phase3EndProject.Entity.Reports;
import com.project.Phase3EndProject.Repository.ProductRepository;
import com.project.Phase3EndProject.Repository.ReportRepository;
import com.project.Phase3EndProject.Repository.UserRepository;

@Controller
public class PurchaseReports {
	@Autowired
	ProductRepository p_repo;
	@Autowired
	UserRepository u_repo;
	@Autowired
	ReportRepository r_repo;

	@RequestMapping("/purchasereports")
	public String page(ModelMap model) {
		List<Reports> l_products = r_repo.orderbylastdate();
		model.addAttribute("l_products", l_products);
		List<Reports> users = r_repo.userReport();
		System.out.println(users);
		model.addAttribute("m_users", users);
		List<Reports> brands = r_repo.brandReport();
		model.addAttribute("m_prod", brands);
		return "purchasereports";
	}

}
