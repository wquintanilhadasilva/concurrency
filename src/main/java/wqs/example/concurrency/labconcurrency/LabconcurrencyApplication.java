package wqs.example.concurrency.labconcurrency;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.antkorwin.xsync.XSync;

@SpringBootApplication
public class LabconcurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabconcurrencyApplication.class, args);
	}

	
	@Bean
	public XSync<UUID>xsync(){
	    return new XSync<>();
	}
}
