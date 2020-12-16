package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//서비스를 이용해서 요청에 따른 모델(데이타)를 생성
		UserService service = new UserService();
		ArrayList<UserDto> userlist =  service.getUserListAll();
		req.setAttribute("userlist", userlist);
		
		req.getRequestDispatcher("/WEB-INF/user/userListView.jsp").forward(req, resp);
		//결과 페이지로 보냄
	}

}
