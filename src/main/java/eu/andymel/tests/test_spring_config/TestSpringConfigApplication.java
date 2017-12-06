package eu.andymel.tests.test_spring_config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestSpringConfigApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestSpringConfigApplication.class, args);
		
	}

	@PostConstruct
	public void init() {
		OAuthProviderConfig l = linkedin();
		Map<String, OAuthProviderConfig> map = providers();

		System.out.println("here");

	}

	@Bean
	@ConfigurationProperties("oauth.linkedIn")
	public OAuthProviderConfig linkedin(){
		return new OAuthProviderConfig();
	}
	
	@Bean
	@ConfigurationProperties("oauth")
	public Map<String, OAuthProviderConfig> providers(){
		return new HashMap<>();
	}
	
	
}
