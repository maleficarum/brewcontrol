package mx.maleficarum.brewcontrol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import mx.maleficarum.brewcontrol.controller.BatchController;
import mx.maleficarum.brewcommon.entity.Batch;
import mx.maleficarum.brewcommon.entity.utils.BatchStatus;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	void creteBatch() {
		Batch batch = new Batch(null, "name", "style", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, LocalDate.now(), LocalDate.now(), LocalDate.now(), "yeast", BigDecimal.ZERO, "notes", BatchStatus.COMPLETED, LocalDateTime.now(), LocalDateTime.now());
		batch = restTemplate.postForObject("/api/v1/batches/create", batch, Batch.class);
		assertThat(batch.getId()).isNotNull();
	}

	@Test
	void fetchBatches() {
		Batch[] batches = restTemplate.getForObject("/api/v1/batches/list", Batch[].class);
    	List<Batch> batchesList = Arrays.asList(batches);
		assertThat(batchesList.size()).isGreaterThan(0);
	}
}