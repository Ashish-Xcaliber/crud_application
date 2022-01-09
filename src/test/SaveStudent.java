package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveStudent {
	
	JdbcCon jdbcObj = new JdbcCon();
	

	public void storeStudentDetail(int STUDENT_NO,String STUDENT_NAME,String STUDENT_DOB,String STUDENT_DOJ) throws SQLException {
		Connection con = jdbcObj.getConnection();
		PreparedStatement stmtt = null;
		try {
			stmtt = con.prepareStatement("insert into student values(?,?,?,?)");
			stmtt.setInt(1,STUDENT_NO);
			stmtt.setString(2, STUDENT_NAME);
			stmtt.setString(3, STUDENT_DOB);
			stmtt.setString(4, STUDENT_DOJ);
			stmtt.executeUpdate();
			
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmtt.close();
		}

	}
	public void updateStudentDetail(int STUDENT_NO,String STUDENT_NAME,String STUDENT_DOB,String STUDENT_DOJ) throws SQLException {
		Connection con = jdbcObj.getConnection();
		PreparedStatement stmtt = null;
		try {
			stmtt = con.prepareStatement("update student set STUDENT_NAME=?,STUDENT_DOB=?,STUDENT_DOJ=? where STUDENT_NO=?" );
			
			stmtt.setString(1, STUDENT_NAME);
			stmtt.setString(2, STUDENT_DOB);
			stmtt.setString(3, STUDENT_DOJ);
			stmtt.setInt(4,STUDENT_NO);
			stmtt.executeUpdate();
			
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmtt.close();
		}

	}
	public void deleteStudent(int STUDENT_NO) throws SQLException {
		Connection con = jdbcObj.getConnection();
		PreparedStatement stmtt = null;
		try {
			stmtt = con.prepareStatement("delete from student where STUDENT_NO=?" );
			stmtt.setInt(1,STUDENT_NO);
			stmtt.executeUpdate();	
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmtt.close();
		}
	}
	public void searchStudent(int STUDENT_NO) throws SQLException {
		Connection con = jdbcObj.getConnection();
		ResultSet rSet;
		try {
			Statement stmt = con.createStatement();
			String query = ("select * from student where STUDENT_NO="+STUDENT_NO+"" );
			rSet = stmt.executeQuery(query);
			while(rSet.next())
			{
				System.out.println("Student No   :"+rSet.getString("STUDENT_NO"));
				System.out.println("Student Name :"+rSet.getString("STUDENT_NAME"));
				System.out.println("Student DOB  :"+rSet.getString("STUDENT_DOB"));
				System.out.println("Student DOJ  :"+rSet.getString("STUDENT_DOJ"));
				System.out.println("");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	public void displayStudent() throws SQLException {
		Connection con = jdbcObj.getConnection();
		ResultSet rSet;
		try {
			Statement stmt = con.createStatement();
			String query = ("select * from student");
			rSet = stmt.executeQuery(query);
			while(rSet.next())
			{
				System.out.println("Student No   :"+rSet.getString("STUDENT_NO"));
				System.out.println("Student Name :"+rSet.getString("STUDENT_NAME"));
				System.out.println("Student DOB  :"+rSet.getString("STUDENT_DOB"));
				System.out.println("Student DOJ  :"+rSet.getString("STUDENT_DOJ"));
				System.out.println("");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
