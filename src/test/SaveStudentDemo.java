package test;

import java.sql.SQLException;
import java.util.Scanner;

public class SaveStudentDemo {
	public static void main(String[] args) throws SQLException {
		try (Scanner s = new Scanner(System.in)) {
			try (Scanner s1 = new Scanner(System.in)) {
				SaveStudent std = new SaveStudent();
				int ch;
				System.out.println("1.INSERT");
				System.out.println("2.UPDATE");
				System.out.println("3.DELETE");
				System.out.println("4.SEARCH");
				System.out.println("5.DISPLAY");
				do {
					//System.out.println("1.INSERT");
					//System.out.println("2.UPDATE");
					//System.out.println("3.DELETE");
					//System.out.println("4.SEARCH");
					//System.out.println("5.DISPLAY");
					System.out.println("Enter The Choice :");
					ch=s.nextInt();
					
					switch(ch) {
					case 1:
						System.out.print("Enter The student no :");
						int student_no=s.nextInt();
						
						System.out.print("Enter The student name :");
						String student_name=s1.nextLine();
						
						System.out.print("Enter The student dob(yyyy-mm-dd):");
						String student_dob=s1.nextLine();
						
						System.out.print("Enter The student doj(yyyy-mm-dd):");
						String student_doj=s1.nextLine();
						std.storeStudentDetail(student_no, student_name, student_dob, student_doj);
						std.displayStudent();
						break;
						
					case 2: 
						System.out.print("Enter The student no to update :");
						int stud_no=s.nextInt();
						
						System.out.print("Enter The student name :");
						String stud_name=s1.nextLine();
						
						System.out.print("Enter The student dob(yyyy-mm-dd):");
						String stud_dob=s1.nextLine();
						
						System.out.print("Enter The student doj(yyyy-mm-dd):");
						String stud_doj=s1.nextLine();
						std.updateStudentDetail(stud_no,stud_name,stud_dob,stud_doj);
						std.displayStudent();
						break;
					case 3:
						System.out.print("Enter The student no to delete :");
						int stdu_no=s.nextInt();
						std.deleteStudent(stdu_no);
						break;
					case 4:
						System.out.println("Enter Student No to Search :");
						int stdno = s.nextInt();
						std.searchStudent(stdno);
						break;
					case 5:
						std.displayStudent();
						
					}
				}while(ch!=0);
			}
		}
	}
}
