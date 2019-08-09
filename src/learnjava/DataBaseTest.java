package learnjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseTest {
	public static final String DRIVER = "org.gjt.mm.mysql.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/Recursion";
	public static final String NAME = "root";
	public static final String PASSWORD = "root";

	public static void main(String[] args){
		try {
			Class.forName(DRIVER);
			Connection c = DriverManager.getConnection(URL, NAME, PASSWORD);
			String sql = "select departmentname,department.departmentid,"
					+ "COUNT(employees.departmentid) as 'num' "
					+ "from department left join employees"
					+ " on employees.departmentid=department.departmentid "
					+ "GROUP BY department.departmentid";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.getRow());
			while(rs.next())
				System.out.println(rs.getString(0)+"  "+rs.getInt(1)+"    "+rs.getInt(2));
			
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
