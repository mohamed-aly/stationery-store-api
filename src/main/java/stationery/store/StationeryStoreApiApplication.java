package stationery.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import stationery.store.config.WebConfig;
import stationery.store.config.security.AuthorizationServerConfiguration;
import stationery.store.config.security.SecurityConfig;

@SpringBootApplication
public class StationeryStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{StationeryStoreApiApplication.class, WebConfig.class, AuthorizationServerConfiguration.class, SecurityConfig.class}, args);
	}



}
