package com.mq.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mq.entities.Pen;
import com.mq.repositories.PenRepository;

@Component
@Service
public class PenServiceImpl implements PenService {

	@Autowired
	PenRepository pr;
	
	@Override
	public Pen getPenById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Pen> getAllPens() {
		return (List<Pen>) pr.findAll();
	}
	
	@Override
	public List<Pen> getPensByName(String name) {
		return pr.findByName(name);
	}


	@Override
	public List<Pen> getPenOrderAscending(boolean ascending) {
		List<Pen> pens = (List<Pen>) pr.findAll();
		
		Comparator<Pen> costOrderer = (pen1, pen2)->{
			if(pen1.getCost() < pen2.getCost()) {
				return -1;
			}
			if(pen1.getCost() > pen2.getCost()) {
				return 1;
			}
			return 0;
		};
		
		Collections.sort(pens, costOrderer);
			
		if(ascending) {
			return pens;
		}
		else {
			Collections.reverse(pens);
			return pens;
		}
	}

	
}
