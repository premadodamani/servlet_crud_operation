package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDAO;
import Dto.Student;

@WebServlet("/fetchall")
public class StudentFetch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.fetchall();
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<h1>Student details</h1>");
		
		printWriter.print("<table border='1'>");
		
		printWriter.print("<tr>");
		printWriter.print("<th>ID</th>");
		printWriter.print("<th>NAME</th>");
		printWriter.print("<th>PHONE NO</th>");
		printWriter.print("<th>EMAIL</th>");
		printWriter.print("<th>DATE OF BIRTH</th>");
		printWriter.print("<th>GENDER</th>");
		printWriter.print("<th>COUNTRY</th>");
		printWriter.print("<th>ADDRESS</th>");
		printWriter.print("<th>AGE</th>");
		printWriter.print("<th>HOBBIES</th>");
		printWriter.print("</tr>");
		
		for(Student student:list){
			printWriter.print("<tr>");
			printWriter.print("<td>"+student.getId()+"</td>");
			printWriter.print("<td>"+student.getName()+"</td>");
			printWriter.print("<td>"+student.getPhone()+"</td>");
			printWriter.print("<td>"+student.getEmail()+"</td>");
			printWriter.print("<td>"+student.getDob()+"</td>");
			printWriter.print("<td>"+student.getGender()+"</td>");
			printWriter.print("<td>"+student.getCountry()+"</td>");
			printWriter.print("<td>"+student.getAddress()+"</td>");
			printWriter.print("<td>"+student.getAge()+"</td>");
			printWriter.print("<td>"+Arrays.toString(student.getHobbies())+"</td>");
			printWriter.print("</tr>");
		}
		printWriter.print("</table>");
		
	}
}
