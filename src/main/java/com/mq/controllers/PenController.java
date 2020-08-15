package com.mq.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mq.entities.Pen;
import com.mq.services.PenService;


@Component
@RestController
@CrossOrigin("*")
public class PenController {

	@Autowired
	PenService ps;
	
	@RequestMapping(value="/pens", method = RequestMethod.GET)
	public List<Pen> getAllPens(@RequestParam(required=false) Boolean ascending, @RequestParam(required=false) String name){
		
		if(ascending != null)
			return this.ps.getPenOrderAscending(ascending);
		if(name != null)
			return this.ps.getPensByName(name);
		else
			return this.ps.getAllPens();
	}
	
	@RequestMapping(value="/pens/{id}", method = RequestMethod.GET)
	public Pen getPenById(@PathVariable Integer id){
		return this.ps.getPenById(id);
	}
	
}
