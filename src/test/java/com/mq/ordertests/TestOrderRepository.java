package com.mq.ordertests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mq.app.ModernQuillApplication;
import com.mq.entities.Order;
import com.mq.repositories.OrderRepository;


@SpringBootTest (classes = ModernQuillApplication.class)
@Transactional
class TestOrderRepository {

	@Autowired
	OrderRepository oRepo;
	
//	@BeforeAll
//	void setUp() throws Exception {
//	}
//
//	@AfterAll
//	void tearDown() throws Exception {
//	}


//	@Autowired
//	OrderRepository oRepo;
	
	@Test
	@Rollback
	void testCreateOrder() {
		SimpleDateFormat dateTimeInCST = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Setting the time zone
		dateTimeInCST.setTimeZone(TimeZone.getTimeZone("CST"));
		Order or= new Order (0, 1, 1, 4,dateTimeInCST.format(new Date()) );
		
		Assertions.assertNotEquals(0, oRepo.save(or).getoId());
		System.out.println();
	}

	
	@ParameterizedTest
	@CsvSource({"1, 5"})
	void testFindBycId(int id, int size) {
		
		Set<Order> orders = oRepo.findBycId(1);
		Assertions.assertEquals(size, orders.size());
		System.out.println(orders);
	}
	
	@ParameterizedTest
	@CsvSource({"1, 4"})
	void testfindById(int id, int quantity) {
		
		Order o = oRepo.findById(id).get();
		Assertions.assertEquals(quantity, o.getQuantity());
		System.out.println(o);
	}
	
	
}
















