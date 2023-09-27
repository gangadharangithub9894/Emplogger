package com.employe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employe.customexception.InvalidSalaryException;
import com.employe.dao.EmplDao;
import com.employe.entity.Empl;

@Service
public class EmplService {
	public static Logger log=Logger.getLogger(EmplService.class);
	@Autowired
	EmplDao ed;

	public String setAll(List<Empl> e) throws InvalidSalaryException {
		List<Empl> em=e.stream().filter(s->s.getSalary()<50000).collect(Collectors.toList());
		if(em.isEmpty()) {
			throw new InvalidSalaryException("Salary Above 50000");
		}
		else {
			return ed.setAll(em);
		}
		
	}

	public List<Empl> getAll() {
		PropertyConfigurator.configure("log.properties");
		log.info(ed.getAll());
		log.info("Objects return Service class");
		return ed.getAll();
	}

	
	
	public String set(Empl e) throws InvalidSalaryException {
		if(e.getSalary()<50000) {
			return ed.set(e);
		}
		else {
			throw new InvalidSalaryException("Salary Above 50000");
		}
		
	}


}
