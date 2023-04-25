package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDAO;
import Dto.Student;

@WebServlet("/fetchid")
public class StudentFetchId extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDAO dao=new StudentDAO();
	Student student=dao.fetchById(id);
	
	PrintWriter printWriter=resp.getWriter();
	
	if(student==null){
		printWriter.print("<h1>Data not found check Id</h1>");
	}else{
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
	
	printWriter.print("</table>");
	
}
}
}

