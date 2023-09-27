package com.employe.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employe.customexception.InvalidSalaryException;
import com.employe.entity.Empl;
import com.employe.service.EmplService;

@RestController
@RequestMapping("/empl")
public class EmplController {
	public static Logger log = Logger.getLogger(EmplController.class);
	@Autowired
	EmplService es;

	@PostMapping("/setAll")
	public String setAll(@RequestBody List<Empl> e) throws InvalidSalaryException {
		return es.setAll(e);
	}

	@GetMapping("/getAll")
	public List<Empl> getAll() {
		PropertyConfigurator.configure("log.properties");
		log.info(es.getAll());
		log.info("Object returns Controller class");
		return es.getAll();
	}

	@PostMapping("/set")
	public String set(@RequestBody Empl e) throws InvalidSalaryException {
		return es.set(e);
	}
}
