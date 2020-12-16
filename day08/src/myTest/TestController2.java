package myTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//상속을받아서 만든다
public class TestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestController2() {
		System.out.println("서블릿 생성자 실행");
	}
	
	
	//서비스 메서드는 모든 get이나 post두가지 다 받는 메서드
/*	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 실행");

		req.getRequestDispatcher("/my2.jsp").forward(req, resp);
	}*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두겟 메서드 호출");
		String name = req.getParameter("name");
		
		//데이타를 만든다(모델)을 만든다
		
		//뷰페이지로 데이타를 전달하기 위해 request에 담음
		req.setAttribute("greeting", "안녕하세요");
		req.setAttribute("name", name);
		req.getRequestDispatcher("/my2.jsp").forward(req, resp);
	}
}
