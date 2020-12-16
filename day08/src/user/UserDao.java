package user;
//디비연동해 쿼리를 날리는 객체

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import db.Conn;

public class UserDao {
	//CRUD하는 메서드를 정의 보통함
	//멤버변수가 없고, 메서드만 있는 아이기 때문에
	//객체를 여러개 만들 필요가 없다
	//따라서 객체가 한번만 만들어지도록 설계
	//이방식을 싱글톤 패턴이라 한다

	//객체는 하나만 먼저 만들어 놓음.
	private static UserDao instance = new UserDao();
	//외부에서 따로 객체를 생성하지 못하도록 막음
	private UserDao() {
	}
	//객체가 필요할 시 이미 만들어진 객체를 반환시켜줌.
	public static UserDao getInstance(){
		return instance;
	}
	//user리스트를 가져오는 메서드
	public ArrayList<UserDto> selectUserList(){
		ArrayList<UserDto> userlist = new ArrayList<UserDto>();
		String sql = "select id, user_id, password, name, phone, address, birth_date, reg_date from user";
		
		try (Connection conn= Conn.getConn();
			 Statement st = conn.createStatement();
			 ResultSet rs = st.executeQuery(sql)){
			
			while(rs.next()) {
				//userDto에 담아 arrayList에 추가함.
				int id = rs.getInt("id");
				String userId = rs.getString("user_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				LocalDate birthDate = rs.getDate("birth_date").toLocalDate();
				LocalDateTime regDate = rs.getTimestamp("reg_date").toLocalDateTime();
				UserDto userDto = new UserDto(id, userId, password, name, phone, address, birthDate, regDate);
				userlist.add(userDto);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userlist;
	}
	//user를 추가하는 메서드
	//user를 수정하는 메서드
	//user를 삭제하는 메서드
}
