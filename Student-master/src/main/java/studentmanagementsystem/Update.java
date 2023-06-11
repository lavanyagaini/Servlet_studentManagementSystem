package studentmanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.StrudentDao;
import studentmanagementsystem.dto.Student;

public class Update extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
String name=req.getParameter("studentName");

StrudentDao dao=new StrudentDao();
Student student =dao.updateStudent(id, name);
PrintWriter printWriter=resp.getWriter();
if(student!=null) {
	printWriter.println("Update succesfully");
}else {
	printWriter.println("Student is not present in this ID");
}
}
}
