package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication auth) throws IOException, ServletException {
		List<String> roleNames=new ArrayList<>();//권한목록
		
		auth.getAuthorities().forEach(authority->{
			roleNames.add(authority.getAuthority());			
		});
		//로그인 한사람에게 포인트증가 같은 코드를 작성
		
		
		//관리자이면 관리자페이지로 이동
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sample/admin");
			return;
		}
		
		response.sendRedirect("/"); //관리자가 아닌 경우 첫페이지로 이동
		
	}

}
