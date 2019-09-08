package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testCheckout() {
		String url = "endpoint url";
		String requestJson = "{\"001\",:\"002\",:\"003\"}";
		HttpEntity<String> request_entity = new HttpEntity<String>(requestJson);
		ResponseEntity<String> response_entity = this.restTemplate
				.postForEntity("/checkout", request_entity, String.class);

		assertThat(response_entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response_entity.getBody()).isEqualTo("{\"price\":\"12345\"}");
	}

}
