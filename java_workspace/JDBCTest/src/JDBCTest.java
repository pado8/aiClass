import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			// oracle jdbc driver 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kim","bluesky");
			System.out.println("연결완료");
			
			//statement객체생성
			Statement stmt=conn.createStatement();
			//insert
			//stmt.executeUpdate("insert into student2 values('K202001','왕건','국문학과')");
			//update
//			stmt.executeUpdate("update student2 set name='홍길돈' where id='M202001'");
			//delete
//			stmt.executeUpdate("delete from student2 where id='S202003'");
			//select
			ResultSet rs=stmt.executeQuery("select * from student2");
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("dept"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
