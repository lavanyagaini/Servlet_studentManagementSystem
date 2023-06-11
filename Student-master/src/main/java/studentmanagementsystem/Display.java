package studentmanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.StrudentDao;
import studentmanagementsystem.dto.Student;

public class Display extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
StrudentDao dao=new StrudentDao();
Student student=dao.selectStudent(id);
if(student!=null) {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print(student.getId());
	printWriter.print(student.getEmail());
	printWriter.print(student.getPassword());
	printWriter.print(student.getName());
}else {
	RequestDispatcher dispatcher=req.getRequestDispatcher("display.html");
	dispatcher.include(req, resp);
}

}
}
