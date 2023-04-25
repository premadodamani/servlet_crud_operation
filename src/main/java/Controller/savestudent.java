package Controller;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDAO;
import Dto.Student;

@WebServlet("/savestudent")
public class savestudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
     Date dob=Date.valueOf(req.getParameter("dob"));
		
//	String name=req.getParameter("fn");
//	long phone=Long.parseLong(req.getParameter("ph"));
//	String email=req.getParameter("email");
//	Date dob=Date.valueOf(req.getParameter("dob"));
//	String gender=req.getParameter("gen");
//	String  country=req.getParameter("country");
//	String address=req.getParameter("add");
//	String[] hobbies=req.getParameterValues("hob");
//	
//	int py=LocalDate.now().getYear();
//	int by=dob.toLocalDate().getYear();
//	int age=Period.between(LocalDate.now(),dob.toLocalDate()).getYears();
//	
//	Student student=new Student();
//	student.setAddress(address);
//	student.setCountry(country);
//	student.setName(name);
//	student.setPhone(phone);
//	student.setHobbies(hobbies);
//	student.setDob(dob);
//	student.setEmail(email);
//	student.setGender(gender);
//	student.setAge(py-by);
	
	Student student=new Student();
	student.setAddress(req.getParameter("add"));
	student.setCountry(req.getParameter("drop"));
	student.setName(req.getParameter("first"));
	student.setPhone(Long.parseLong(req.getParameter("ph")));
	student.setHobbies(req.getParameterValues("qual"));
	student.setDob(dob);
//	student.setDob(Date.valueOf(req.getParameter("dob")));
	student.setEmail(req.getParameter("email"));
	student.setGender(req.getParameter("gen"));
	student.setAge(Period.between(dob.toLocalDate(),LocalDate.now()).getYears());
	
    StudentDAO studentDAO=new StudentDAO();
    studentDAO.insert(student);
	resp.getWriter().print("<h1>Data inserted sucessfully</h1>");
	
//	resp.getWriter().print("<h1>"
//			+ "NAME:"+name
//			+ "<br>PHONE NUMBER:"+phone
//			+ "<br>EMAIL:"+email
//			+ "<br>DOB:"+dob
//			+ "<br>GENDER:"+gender
//			+ "<br>COUNTRY:"+country
//			+ "<br>ADDRESS:"+address
//			+ "<br>HOBBIES:"+Arrays.toString(hobbies)
//	        +"</h1>");
//	
	}
}
