package stationery.store.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.security.SecureRandom;


@EnableWebSecurity
@Configuration
public class LssSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    private LoggingFilter loggingFilter;


    public LssSecurityConfig(@Qualifier("lssUserDetailsService") UserDetailsService userDetailsService,
                             LoggingFilter loggingFilter) {
        this.userDetailsService = userDetailsService;
        this.loggingFilter = loggingFilter;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {// @formatter:off
        auth.authenticationProvider(runAsAuthenticationProvider());
        auth.authenticationProvider(daoAuthenticationProvider());
    } // @formatter:on

    @Override
    protected void configure(HttpSecurity http) throws Exception {// @formatter:off
        http
                .addFilterBefore(loggingFilter, AnonymousAuthenticationFilter.class)

                .authorizeRequests()
                .antMatchers("/product/**").authenticated()
//                .antMatchers("/product/**").hasAuthority("user")
                .anyRequest().authenticated()

                .and()
                .formLogin().permitAll()

                .and()
                .logout().permitAll()

                .and()
                .rememberMe()
                .tokenValiditySeconds(7)
                .key("lssAppKey")
                .rememberMeCookieName("rody")


                .and()
                .csrf().disable()
                .httpBasic()
        ;
    } // @formatter:on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Bean
    public AuthenticationProvider runAsAuthenticationProvider(){
        RunAsImplAuthenticationProvider authenticationProvider = new RunAsImplAuthenticationProvider();
        authenticationProvider.setKey("MyRunAsKey");
        return authenticationProvider;
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
