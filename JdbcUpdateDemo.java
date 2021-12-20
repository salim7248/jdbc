package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wings","root","S@lim1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
Statement st = null;
try {
	st = con.createStatement();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
PreparedStatement ps = null;
try {
	ps = con.prepareStatement("insert into student(id,name,city)values(18,'alim','kolhapur')");
	ps.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


//ps.executeQuery();

ResultSet rs=st.executeQuery("select * from student");
while(rs.next()) {
	System.out.println("id "+rs.getInt(1)+" name "+rs.getString(2)+" city "+rs.getString(3));
}

st.close();
con.close();


	}

}
