package com.mq.services;

import java.util.List;

import com.mq.entities.Pen;

public interface PenService {
	
	Pen getPenById(int id);
	List<Pen> getAllPens();
	List<Pen> getPensByName(String name);
	
	List<Pen> getPenOrderAscending(boolean ascending);
}
