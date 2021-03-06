package stationery.store.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan({"stationery.store.config.security"})
@Order(4)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] PUBLIC_ENDPOINTS = {
            "**/oauth/token",
            "/user/{type}/signUp",
            "/h2-console/**",
            "/product/**",
            "/category/**"
    };

    private final String[] ADMIN_ENDPOINTS = {
            "/user/all",
            "/user/{type}",
            "/delete/{id}"
    };

    private MyUserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder;

    public SecurityConfig(MyUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        super();

        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // global security concerns

    @Bean
    public AuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    // http security concerns

    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers(PUBLIC_ENDPOINTS).permitAll()
                .antMatchers(ADMIN_ENDPOINTS).hasAuthority("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin().permitAll()

                .and()
                .logout().permitAll()

                .and().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                csrf().disable();
    }

}