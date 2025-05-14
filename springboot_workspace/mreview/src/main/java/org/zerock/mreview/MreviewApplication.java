package org.zerock.mreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //날짜 자동입력시 필요
// @EntityScan(basePackages = {
// 	"org.zerock.club.*",	
// 	"org.zerock.mreview.*"
// })
// @ComponentScan(basePackages = {
// 	"org.zerock.club.*",	
// 	"org.zerock.mreview.*"
// })
public class MreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MreviewApplication.class, args);
	}

}
