package dev.vorstu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()

                // antMatchers - задаёт шаблон доступности, основываясь на роли
                // (также можно настроить для общей доступности с использованием permitAll);
                .antMatchers( "/api/login/**").permitAll()
                .antMatchers( "/api/boards/**").permitAll()
                .antMatchers( "/api/columns/**").permitAll()
                .antMatchers( "/api/tasks/**").permitAll()

                // Для роли Admin
                //.antMatchers("/api/**").hasAuthority(Role.ADMIN.name())
                // Для роли Student
                //.antMatchers("/api/students/**").hasAuthority(Role.STUDENT.name())
                // Найти если надо

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                //new AuthenticationEntryPoint() - даёт возможность обработать случаи,
                // когда авторизация не прошла успешно.
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response,
                                         AuthenticationException authException) {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());

                    }
                })
                .and()
                .csrf().disable() //csrf().disable() - блокирует валидацию по токенам авторизации
                .cors().disable(); //cors().disable() - блокирует cors валидацию. В данном случае используем REST.
               // .formLogin();// форма авторизации
        return http.build();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentificator(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select username, p.password as password, enable "
                        + "from users as u "
                        + "inner join passwords as p on u.password_id = p.id "
                        + "where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }



}
