package wqs.example.concurrency.labconcurrency;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.antkorwin.xsync.XSync;

import wqs.example.concurrency.labconcurrency.service.PaymentService;

@SpringBootApplication
public class LabconcurrencyApplication {
	
	// https://dzone.com/articles/synchronized-by-the-value-of-the-object-in-java
	
	@Autowired
	PaymentService service;

	public static void main(String[] args) {
		SpringApplication.run(LabconcurrencyApplication.class, args);
	}
	
	@PostConstruct
	public void run() {
		
		service.withDrawMoney(UUID.randomUUID(), 10);
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public XSync<UUID>xsync(){
	    return new XSync<>();
	}
}
