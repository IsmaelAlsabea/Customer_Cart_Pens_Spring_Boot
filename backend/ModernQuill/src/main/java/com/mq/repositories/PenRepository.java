package com.mq.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mq.entities.Pen;

@Component
@Repository 
public interface PenRepository extends CrudRepository<Pen,Integer>{
	List<Pen> findByName(String name);
	
	List<Pen> findByCost(int cost);
}
