package model2.mvcboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 게시물 불러오기
        MVCBoardDAO dao = new MVCBoardDAO();
        String idx = request.getParameter("idx");
        
        String cookieName = "viewed_" + idx;
        boolean alreadyViewed = false;
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    alreadyViewed = true;
                    break;
                }
            }
        }
		if (!alreadyViewed) {
			dao.updateVisitCount(idx);
			Cookie viewCookie = new Cookie(cookieName, "true");
			viewCookie.setMaxAge(60 * 60 * 24 * 1);  // 1일간 유지
			viewCookie.setPath(request.getContextPath());
			response.addCookie(viewCookie);
			System.out.println("조회수 증가 & 쿠키 저장: " + cookieName);
		} else {
			System.out.println("이미 본 글, 조회수 미증가: " + cookieName);
		}
        
        MVCBoardDTO dto = dao.selectView(idx);
        dao.close();

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
        
        //첨부파일 확장자 추출 및 이미지 타입 확인
         String ext = null, fileName = dto.getSfile();
         if(fileName!=null) {
         	ext = fileName.substring(fileName.lastIndexOf(".")+1);
         }
         String[] mimeStr = {"png","jpg","gif"};
         List<String> mimeList = Arrays.asList(mimeStr);
         boolean isImage = false;
         if(mimeList.contains(ext)) {
         	isImage = true;
         }
        
        
        // 게시물(dto) 저장 후 뷰로 포워드
        request.setAttribute("dto", dto);
        request.setAttribute("isImage", isImage);
        request.getRequestDispatcher("/14MVCBoard/View.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
