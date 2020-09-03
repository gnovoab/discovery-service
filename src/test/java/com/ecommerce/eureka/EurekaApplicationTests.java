
//Namespace
package com.ecommerce.eureka;

//Imports
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

/**
 * Integration test
 */
@ActiveProfiles("integrationTest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EurekaApplicationTests {

	@LocalServerPort
	private transient int port;

	@Autowired
	private transient TestRestTemplate restTemplate;

	@Test
	void contextLoads() { }

	@Test
	public void healthOk() {
		ResponseEntity<JsonNode> entity = restTemplate.getForEntity("/actuator/health", JsonNode.class);
		Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void shouldStartEurekaServer() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:" + this.port + "/eureka/apps", String.class);
		Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
	}


}
