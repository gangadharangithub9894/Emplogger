package com.employe.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employe.entity.Empl;
import com.employe.repository.EmplRepository;
@Repository
public class EmplDao {
	public static Logger log=Logger.getLogger(EmplDao.class);
	@Autowired
	EmplRepository er;
	public String setAll(List<Empl> em) {
	er.saveAll(em);
	return "Saved AllData";
	}
	public List<Empl> getAll() {
		return er.findAll();
	}
	public String set(Empl e) {
		er.save(e);
		return "Saved";
	}

}
