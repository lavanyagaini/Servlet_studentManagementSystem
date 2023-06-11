package studentmanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.StrudentDao;
import studentmanagementsystem.dto.Student;

public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String email=req.getParameter("studentEmail");
String password=req.getParameter("studentPassword");

StrudentDao dao=new StrudentDao();
Student student=dao.loginStudent(email, password);
if(student!=null) {
	if(student.getPassword().equals(password)) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Pwd correct login success");
		
		
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Pwd incorrect");
		
	}
	
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("there is no student");
	}
}
}
