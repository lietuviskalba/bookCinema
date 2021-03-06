package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/feedback" ,"/home").permitAll()
               // .antMatchers("/", "/cinema").permitAll()
                .antMatchers("/", "/register").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/client").hasRole("USER")
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("client").password("password").roles("CLIENT")
                .and()
                .withUser("admin").password("password").roles("ADMIN");

    }



}

