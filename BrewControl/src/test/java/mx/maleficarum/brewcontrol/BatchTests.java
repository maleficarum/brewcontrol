package mx.maleficarum.brewcontrol;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import mx.maleficarum.brewcontrol.controller.BatchController;

import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BatchTests {


	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private BatchController batchController;
	private static HttpHeaders headers;

	@BeforeAll
	public static void runBeforeAllTestMethods() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	void contextLoads() {
		assertThat(batchController).isNotNull();
	}

	@Test
	void testTransfer() throws JSONException, URISyntaxException {
		/*JSONObject user = new JSONObject();
		user.put("source", "admin");
		user.put("amount", "12345");
		user.put("cardToken", "ABCD");


		HttpEntity<String> request = new HttpEntity<String>(user.toString(), headers);
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + this.port + "/gateway/services/transfers/transfer", request, String.class);
		JSONObject json = new JSONObject(response.getBody());

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(400));//Expected to be this response code
		assertThat(json.getString("statusCode")).isEqualTo("CL2200");//Expected to be this error
		*/
	}	


}