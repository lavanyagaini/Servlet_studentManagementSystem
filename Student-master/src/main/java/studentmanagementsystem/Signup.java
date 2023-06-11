package studentmanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.StrudentDao;
import studentmanagementsystem.dto.Student;

public class Signup extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String name=req.getParameter("studentName");
	String email=req.getParameter("studentEmail");
	String password=req.getParameter("studentPassword");
    
	Student student=new Student();
	student.setName(name);
	student.setEmail(email);
	student.setPassword(password);
	
StrudentDao dao=new StrudentDao();
Student dbStudent=dao.saveStudent(student);
if(dbStudent!=null) {
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
	dispatcher.forward(req, resp);
	
}


}
		

}
