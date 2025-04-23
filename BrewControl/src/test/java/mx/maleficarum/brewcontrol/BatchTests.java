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
import mx.maleficarum.brewcommon.entity.Batch;
import java.util.Arrays;
import java.util.List;

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
	void fetchBatches() {
		Batch[] batches = restTemplate.getForObject("/api/v1/batches/list", Batch[].class);
    	List<Batch> batchesList = Arrays.asList(batches);
	}


}