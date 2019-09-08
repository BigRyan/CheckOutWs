package com.example.demo.integrations;

import com.example.demo.model.Watch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void testCheckout() {
		String requestJson = "[\"001\",\"001\",\"001\", \"003\"]";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON);
		HttpEntity<String> request_entity = new HttpEntity<String>(requestJson,headers);

		ResponseEntity<String> response_entity = this.restTemplate
				.postForEntity("/checkout", request_entity, String.class);

		assertThat(response_entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response_entity.getBody()).isEqualTo("{\"price\":\"250\"}");
	}

	@Test
	public void testFindWatchByNo() {
		ResponseEntity<Watch> response_entity = this.restTemplate
				.getForEntity("/watches/001",  Watch.class);
		Watch watch = response_entity.getBody();
		assertThat(response_entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(watch.getWatchNo()).isEqualTo("001");
	}

}
