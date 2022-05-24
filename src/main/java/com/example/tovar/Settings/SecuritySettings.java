package com.example.tovar.Settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuritySettings extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin2").password(passwordEncoder().encode("admin2")).roles("ADMIN")
                .authorities("TOVARNICHIQARISH,TOVARCHIQARISH,TOVARNIKIRITISH,TOVARNIYANGILASH")
                .and()
                .withUser("admin1").password(passwordEncoder().encode("admin1")).roles("ADMIN")
                .authorities("TOVARNICHIQARISH,TOVARCHIQARISH,TOVARNIKIRITISH,TOVARNIYANGILASH,TOVARNIOCHIRISH");




//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//                .and()
//                .withUser("superuser").password(passwordEncoder().encode("superuser")).roles("SUPERUSER")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS,"/tovar/**").hasAnyAuthority("TOVARNICHIQARISH,TOVARCHIQARISH,TOVARNIKIRITISH,TOVARNIYANGILASH,TOVARNIOCHIRISH")
//                .antMatchers(HttpMethod.DELETE,"/tovar/ochirish/*").hasAuthority("TOVARNIOCHIRISH")
//                .antMatchers(HttpMethod.GET, "/tovar/chiqarish/*").hasAnyRole("ADMIN","SUPERUSER","USER")
//                .antMatchers(HttpMethod.GET,"/tovar/chiqarish/**").hasAnyRole("ADMIN","SUPERUSER")
//                .antMatchers(HttpMethod.POST,"/tovar/kiritish/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/tovar/yangilash/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/tovar/ochirish/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
