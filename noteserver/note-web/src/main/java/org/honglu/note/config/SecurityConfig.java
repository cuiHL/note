package org.honglu.note.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("honglu")
//                .password("123456")
//                .roles("admin");
//    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("honglu").password("123456").roles("admin").build());
//        return manager;
//    }

    @Autowired
    DataSource dataSource;


    @Override
    @Bean
    protected  UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        if (!manager.userExists("honglu")) {
            manager.createUser(User.withUsername("honglu").password("123456").roles("admin").build());
        }
        return manager;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**", "/favicon.ico");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((req, resp, authentication) -> {
                    System.out.println(req.getSession().getId());
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write(req.getSession().getId() + ":" + authentication.getName());
                    printWriter.flush();
                    printWriter.close();
                })
                .failureHandler((req, resp, exception) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write(exception.getMessage());
                    printWriter.flush();
                    printWriter.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, resp, authenticn) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write("注销登陆成功");
                    printWriter.flush();
                    printWriter.close();
                })
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, authException) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("尚未登录，请先登录");
                    out.flush();
                    out.close();
                });

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    //注册自定义的UsernamePasswordAuthenticationFilter
    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter filter = new LoginFilter();
        filter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
            System.out.println(req.getSession().getId());
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(req.getSession().getId() + ":" + authentication.getName());
            printWriter.flush();
            printWriter.close();
        });
        filter.setAuthenticationFailureHandler((req, resp, exception) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(exception.getMessage());
            printWriter.flush();
            printWriter.close();});

        filter.setFilterProcessesUrl("/login");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
            try {
                filter.setAuthenticationManager(authenticationManagerBean());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return filter;
    }

    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}
