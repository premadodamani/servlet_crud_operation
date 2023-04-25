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

@WebServlet("/fetchMob")
public class StudentFetchMobile extends HttpServlet {
@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	long phone=Long.parseLong(req.getParameter("phone"));
	
	StudentDAO dao=new StudentDAO();
	PrintWriter printWriter=resp.getWriter();
	List<Student> list=dao.fetchByMob(phone);
	if(list.isEmpty())
	{
		printWriter.print("<h1>Data not found check mobile number<h/1>");
	}else{
		
//	PrintWriter printWriter=resp.getWriter();
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
	
	for(Student student1:list){
		printWriter.print("<tr>");
		printWriter.print("<td>"+student1.getId()+"</td>");
		printWriter.print("<td>"+student1.getName()+"</td>");
		printWriter.print("<td>"+student1.getPhone()+"</td>");
		printWriter.print("<td>"+student1.getEmail()+"</td>");
		printWriter.print("<td>"+student1.getDob()+"</td>");
		printWriter.print("<td>"+student1.getGender()+"</td>");
		printWriter.print("<td>"+student1.getCountry()+"</td>");
		printWriter.print("<td>"+student1.getAddress()+"</td>");
		printWriter.print("<td>"+student1.getAge()+"</td>");
		printWriter.print("<td>"+Arrays.toString(student1.getHobbies())+"</td>");
		printWriter.print("</tr>");
	
	printWriter.print("</table>");
	
}
}
}
}
