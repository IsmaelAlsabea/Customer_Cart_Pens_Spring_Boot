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
import com.mq.services.OrderService;

@SpringBootTest (classes = ModernQuillApplication.class)
@Transactional
class TestOrderService {

	@Autowired
	OrderService oServ;
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	@Rollback
	void testCreateOrder() {
		SimpleDateFormat dateTimeInCST = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Setting the time zone
		dateTimeInCST.setTimeZone(TimeZone.getTimeZone("CST"));
		Order or= new Order (0, 10, 2, dateTimeInCST.format(new Date()) );
		
		Assertions.assertNotEquals(0, oServ.createOrder(or).getoId());
		System.out.println();
	}

	
	@ParameterizedTest
	@CsvSource({"1, 2"})
	void testFindBycId(int id, int size) {
		
		Set<Order> orders = oServ.getAllOrdersByCustomerId(1);
		Assertions.assertEquals(size, orders.size());
		System.out.println(orders);
	}
	
	@ParameterizedTest
	@CsvSource({"3, 3, 1", "1, 1, 1"})
	void testfindById(int oid, int cartId, int cId) {
		
		Order o = oServ.getById(oid);
		Assertions.assertEquals(cartId, o.getCartId());
		Assertions.assertEquals(cId, o.getcId());
		System.out.println(o);
	}
	

}
