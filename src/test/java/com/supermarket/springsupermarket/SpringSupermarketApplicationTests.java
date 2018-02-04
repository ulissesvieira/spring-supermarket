package com.supermarket.springsupermarket;

import com.springsupermarket.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={Application.class})
@SpringBootTest
public class SpringSupermarketApplicationTests {

	@Test
	public void contextLoads() {
	}

}
