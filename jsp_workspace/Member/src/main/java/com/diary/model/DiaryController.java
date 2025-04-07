package com.diary.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diary.util.JSFunction;

@WebServlet("/register.do")
public class DiaryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public DiaryController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String weather = request.getParameter("weather");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        DiaryVO diary = new DiaryVO();
        diary.setWeather(weather);
        diary.setTitle(title);
        diary.setContent(content);
        
        DiaryDAO dao = new DiaryDAO();
        int result = dao.insertDiary(diary);
        
        if(result > 0) {
        	JSFunction.alertLocation(response, "일기 등록 성공!","/register.jsp");
        } else {
        	JSFunction.alertLocation(response, "일기 등록 실패!","/register.jsp");
        }
    }
}
