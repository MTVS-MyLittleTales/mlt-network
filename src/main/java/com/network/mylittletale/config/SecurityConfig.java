package com.network.mylittletale.config;

import com.network.mylittletale.member.model.service.AuthenticationService;
import com.network.mylittletale.member.model.service.CustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    public SecurityConfig(AuthenticationService authenticationService, CustomLoginSuccessHandler customLoginSuccessHandler) {
        this.authenticationService = authenticationService;
        this.customLoginSuccessHandler = customLoginSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/js/**", "/static/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                    .authorizeRequests()
                    .mvcMatchers( "/tale/**").hasAnyAuthority("ROLE_MEMBER", "ROLE_ADMIN")
                    .mvcMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                    .mvcMatchers("/**", "/member/**").permitAll();
//                .and()
//                    .csrf().disable();

        http
                    .formLogin()
                    .loginPage("/member/login")
                    .successHandler(customLoginSuccessHandler)
                    .failureUrl("/member/loginfail")
                    .usernameParameter("memberId")
                    .passwordParameter("memberPwd")
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/");

    }

}
