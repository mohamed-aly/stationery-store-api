package stationery.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import stationery.store.config.WebConfig;
import stationery.store.config.security.AuthorizationServerConfiguration;
import stationery.store.config.security.ResourceServerConfiguration;

@SpringBootApplication
public class StationeryStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{StationeryStoreApiApplication.class, WebConfig.class, AuthorizationServerConfiguration.class, ResourceServerConfiguration.class}, args);
	}



}
