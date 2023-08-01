//package com.helloworldgroup.helloworld.sercurityconfig;
//
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Bean
//    public UserDetailsManager authenticateUsers() {
//
//        UserDetails user = User.withUsername("devs").
//                password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password")).build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.setAuthoritiesByUsernameQuery("select user_name,user_pwd,user_enabled from user where user_name=?");
//        users.setUsersByUsernameQuery("select user_name,user_role from user where user_name=?");
//        users.createUser(user);
//        return users;
//    }
//
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/home").permitAll()
//                .requestMatchers("/welcome").authenticated()
//                .requestMatchers("/admin").hasAuthority("ADMIN")
//                .requestMatchers("/emp").hasAuthority("EMPLOYEE")
//                .requestMatchers("/mgr").hasAuthority("MANAGER")
//                .anyRequest().authenticated()
//
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/welcome",true)
//
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/accessDenied")
//        ;
//        return http.build();
//    }
//}
