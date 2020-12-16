package myTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 WebServlet(주소)
//해당되는 주소로 요청이 오면 서블릿을 실행시킴
//최초 요청시에는 서블릿 객체가 생성된다.
//그 후에는 이미 만들어진 객체를 이용한다.
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestController() {
    	System.out.println("TestController 서블릿 객체 생성");
    }
    //겟방식으로 요청이 왔을 시 실행할 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 실행");
		PrintWriter out = response.getWriter();
		out.print("<h1>hello word!!</h1>");
	}
	//포스트방식으로 요청이 왔을 시 실행할 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 실행");
	}

}
