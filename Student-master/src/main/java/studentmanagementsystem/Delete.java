package studentmanagementsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.StrudentDao;
import studentmanagementsystem.dto.Student;

public class Delete extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id=Integer.parseInt(req.getParameter("id"));
StrudentDao dao=new  StrudentDao();
Student student=dao.deleteStudent(id);
PrintWriter printWriter=resp.getWriter();
if(student!=null) {
	printWriter.print("student deleted successfully");
}else {
	printWriter.print("student is not present");
}
}
}
