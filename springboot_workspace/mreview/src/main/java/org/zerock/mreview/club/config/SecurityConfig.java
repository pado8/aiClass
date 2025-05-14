package org.zerock.mreview.club.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {
    //암호화 알고리즘. BCrypt
    @Bean    
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // 현재 depricated됨. 람다식사용으로 바뀜. controller에서 annotation사용해서 처리 추천.
        // http.authorizeHttpRequests()
        //     .requestMatchers("/sample/all").permitAll()
        //     .requestMatchers("/sample/member").hasRole("MEMBER");
        // http.formLogin();
        // http.csrf().disable(); 
        // http.logout();
        // return http.build();

        //html 공격 막기 위한 csrf 비활성화
        http.csrf(AbstractHttpConfigurer::disable)   
        .formLogin((formLogin) ->
                formLogin.loginPage("/login")
                .defaultSuccessUrl("/movie/list", true))
                .logout(logout->logout.logoutUrl("/signout").logoutSuccessUrl("/login"));
        // .oauth2Login(oauth2->oauth2.loginPage("/login").successHandler(clubLoginSuccessHandler()))
        // .exceptionHandling(handler->handler.accessDeniedHandler(customAccessDeniedHandler()))
        // .rememberMe(remember->remember.tokenValiditySeconds(60*60*24*7).userDetailsService(userDetailsService));
        return http.build();
    }

   @Bean
   public InMemoryUserDetailsManager userDetailsService() {
       UserDetails user = User.builder()
               .username("user1")
               .password("$2a$10$54b4w2aKbDkcEr5BLISfiubKcmZo7kVp5B0FqyUZ9SdMp9TXqNgxe")
               .roles("USER")
               .build();
       return new InMemoryUserDetailsManager(user);
   }

}
