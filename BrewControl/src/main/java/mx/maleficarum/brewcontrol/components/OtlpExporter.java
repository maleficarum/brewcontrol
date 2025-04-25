package mx.maleficarum.brewcontrol.components;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class OtlpExporter {


    private final Logger log = LoggerFactory.getLogger(getClass());

	@Bean
	OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
        log.info("Sending traces to " + url);
    	return OtlpHttpSpanExporter.builder()
            .setEndpoint(url)
            .build();
    }

}
