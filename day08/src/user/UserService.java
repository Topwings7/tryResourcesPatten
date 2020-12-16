package user;
//user와 관련된 비즈니스 로직을 담는 클래스

import java.util.ArrayList;

public class UserService {
	//유저의 정보를 가져오는 메서드
	public ArrayList<UserDto> getUserListAll(){
		//dao를 이용하여 userlist정보를 가져옴
		UserDao dao = UserDao.getInstance();
		//비즈니스 로직이 있어야하는 부분
		ArrayList<UserDto> userList = dao.selectUserList();
		return userList;
	}
}
