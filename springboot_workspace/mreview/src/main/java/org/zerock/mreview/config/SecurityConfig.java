package org.zerock.mreview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.zerock.mreview.security.handler.ClubLoginSuccessHandler;
import org.zerock.mreview.security.handler.CustomAccessDeniedHandler;
import org.zerock.mreview.security.service.ClubUserDetailsService;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true ,prePostEnabled = true)
@Log4j2
public class SecurityConfig {
    @Autowired
    private ClubUserDetailsService userDetailsService; //주입
  
  //암호화알고리즘. BCrypt
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // 현재 depricated됨. 람다식사용으로 바뀜. controller에서 annotation사용해서 처리 추천.
    http.authorizeRequests().requestMatchers("/sample/all").permitAll()
                            .requestMatchers("/sample/member").hasRole("MEMBER");
    
    // http.formLogin();
    // http.csrf().disable();
    // http.logout();

    //html 공격 막기 위한 csrf 비활성화
    http.csrf(AbstractHttpConfigurer::disable)   
    .formLogin((formLogin) ->
            formLogin.loginPage("/login")
            .defaultSuccessUrl("/movie/list", true))                
            .logout(logout->logout.logoutUrl("/signout").logoutSuccessUrl("/login"))
            .oauth2Login(oauth2->oauth2.loginPage("/login").successHandler(clubLoginSuccessHandler()))
            .exceptionHandling(handler->handler.accessDeniedHandler(customAccessDeniedHandler()))
            .rememberMe(remember->remember.tokenValiditySeconds(60*60*24*7).userDetailsService(userDetailsService));
        

    return http.build();
  }

  @Bean
    public ClubLoginSuccessHandler clubLoginSuccessHandler() {
        return new ClubLoginSuccessHandler(passwordEncoder());
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
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
