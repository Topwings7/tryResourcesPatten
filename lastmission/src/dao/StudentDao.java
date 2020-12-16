package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import conn.Conn;
import dto.StudentDto;

public class StudentDao {
	private static StudentDao instance = new StudentDao();
	private  StudentDao() {}
	public static StudentDao getInstance() {
		return instance;
	}
	public ArrayList<StudentDto> selectStudentList(){
		ArrayList<StudentDto> stList = new ArrayList<StudentDto>();
		String sql = "select id, name, age, address, phone, birth_date, grade from student";
		try (Connection conn = Conn.getConn();
			 PreparedStatement pst = conn.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				int 	  id 	 	 = rs.getInt("id");
				String 	  name    	 = rs.getString("name");
				int 	  age     	 = rs.getInt("age");
				String    address 	 = rs.getString("address");
				String    phone   	 = rs.getString("phone");
				LocalDate birth_date = rs.getDate("birth_date").toLocalDate();
				int		  grade      = rs.getInt("grade");
				StudentDto stDto = new  StudentDto(id, name, age, address, phone, birth_date, grade);
				stList.add(stDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}
}
