package com.mq.carttests;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mq.app.ModernQuillApplication;
import com.mq.entities.Cart;
import com.mq.services.CartService;

@SpringBootTest(classes= ModernQuillApplication.class)
@Transactional
class TestCartService {
	
	@Autowired
	CartService cs;
	
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
	
	

//	@ParameterizedTest
//	@CsvSource({"2,1,5,20"})
//	@Rollback
//	void testCreateCart(int cartId, int cId, int pId, int quantity) {
//	Cart cart= new Cart(cartId, cId, pId, quantity);
//		
//		Assertions.assertDoesNotThrow(()->{
//					Cart cartReturned=cs.createCart(cart);
//					Assertions.assertNotNull(cartReturned);
//					System.out.println(cartReturned);	
//				});
//		
//	}
	
	@Test
	@Rollback
	void testCreateAllCarts() {
	Cart cart= new Cart(10,4,6, 100);
	Cart cart2= new Cart(10,4,5,2000);
	Set<Cart> cartSet= new HashSet<>();
	cartSet.add(cart); 
	cartSet.add(cart2);
		
	Assertions.assertDoesNotThrow(()->{
				Set<Cart> cartsReturned=cs.createAllCarts(cartSet);
				Assertions.assertNotNull(cartsReturned);
				System.out.println(cartSet);
			});
	}

	@ParameterizedTest
	@CsvSource({"1,6"})
	void testGetAllByCartId(int cartId, int cartSize) {
		Set<Cart> cartItems= cs.getAllCartItemsByCartId(cartId);
		Assertions.assertEquals(cartSize, cartItems.size());
		System.out.println(cartItems);
	}
	
	@ParameterizedTest
	@CsvSource({"3"})
	void getLastElementId(int lastElementId) {
		int cartId = cs.getLastElementId();
		Assertions.assertEquals(lastElementId, cartId);
	}

}
