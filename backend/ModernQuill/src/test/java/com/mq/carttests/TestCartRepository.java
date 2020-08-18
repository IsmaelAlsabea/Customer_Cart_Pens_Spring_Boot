package com.mq.carttests;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mq.app.ModernQuillApplication;
import com.mq.entities.Cart;
import com.mq.repositories.CartRepository;

@SpringBootTest(classes = ModernQuillApplication.class)
@Transactional
class TestCartRepository {

	@Autowired
	CartRepository cr;
	
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	

	@ParameterizedTest
	@CsvSource({"2,1,5,20"})
	@Rollback
	void saveCart(int cartId, int cId, int pId, int quantity) {
		Cart cart= new Cart(cartId, cId, pId, quantity);
		
		Assertions.assertDoesNotThrow(()->{
					Cart cartReturned= cr.save(cart);
					System.out.println(cartReturned);
				});
	}
	
	@ParameterizedTest
	@CsvSource({"1,6"})
	void getAllByCartId(int cartId, int cartSize) {
		Set<Cart> cartItems= cr.findBycartId(cartId);
		Assertions.assertEquals(cartSize, cartItems.size());
		System.out.println(cartItems);
	}
	
	@ParameterizedTest
	@CsvSource({"3"})
	void getLastElement(int lastElementId) {
		Cart c = cr.findTopByOrderByCartIdDesc();
		Assertions.assertEquals(lastElementId, c.getCartId());
	}
	

}
