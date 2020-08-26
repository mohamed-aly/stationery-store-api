package stationery.store.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceSeverConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {// @formatter:off
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

        .and().authorizeRequests()
            .antMatchers(HttpMethod.GET,"**/user/all").access("#oauth2.hasScope('read')")
            .antMatchers(HttpMethod.POST,"**/signUp").access("#oauth2.hasScope('write')")
            .antMatchers(HttpMethod.DELETE,"**/user/delete/*").access("#oauth2.hasScope('write')");
    } // @formatter:on

}
