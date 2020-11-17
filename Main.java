package p20200901DB삽입;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	// DB 연결을 위한 base 코드
		
		// 1. JDBC 드라이버를 적재
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 적재 성공");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버를 찾을 수 없습니다.");
			}
			
			System.out.println("첫번째 테스트");
			
//----------------------------------------------------------------------------------	
			
		// 2. DB 연결
			String url	= "";		// oracle DB 접속을 위한 url
			String id 	= "";		// oracle DB 접속을 위한 아이디
			String password = "";		// oracle DB 접속을 위한 패스워드
			Connection con 	= null;
			
			try {
				con = DriverManager.getConnection(url , id, password);
				System.out.println("연결 성공");
			} catch (SQLException e) {
				System.out.println("연결 오류");
			}
			
			System.out.println("두번째 테스트");

//----------------------------------------------------------------------------------
			
		// 3. SQL문장 작성 및 전송
			try {
				Statement stmt = con.createStatement();
				String sql = null;
				
				// DEPARTMENT 테이블을 DEPTNO기준으로 오름차순으로 정렬하여 조회한다.
				//sql = "select * from DEPARTMENT order by DEPTNO";
				
			/* <NOTE>
			 * select문을 할때는 executeQuery 메소드 사용한다.
			 * ResultSet rs = stmt.executeQuery(sql);
			 * insert문을 사용하면 executeUpdate 메소드 사용한다.
			 */
				
			int a = stmt.executeUpdate(sql);
				
			System.out.println("쿼리를 요청하였습니다." + a);
				
			stmt.close();	
			con.close();	
			
			} catch (SQLException e) {
				System.out.println("예외가 발생하였습니다.");
				}

			
	}// end main
	
}// end class WDB
