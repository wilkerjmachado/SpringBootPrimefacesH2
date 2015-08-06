package org.enquete.test;

import org.enquete.app.service.PerguntaService;
import org.enquete.framework.boot.SpringBootJsfApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootJsfApplication.class)
@WebAppConfiguration
public class SpringBootJsfApplicationTests {

	@Autowired
	private PerguntaService perguntaService;
	
	@Test
	public void contextLoads() {
		
	}

}
