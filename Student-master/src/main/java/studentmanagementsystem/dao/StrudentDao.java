package studentmanagementsystem.dao;

import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import antlr.collections.List;
import studentmanagementsystem.dto.Student;

public class StrudentDao {
	
	
	
public Student saveStudent(Student student) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	System.out.println("saved");
    return student;
}


public Student loginStudent(String email,String password) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	javax.persistence.Query query=entityManager.createQuery("select a from Student a");
	java.util.List<Student> list=query.getResultList();
	boolean value=false;
	for(Student student:list) {
		if(student.getEmail().equals(email)) {
		javax.persistence.Query query1=entityManager.createQuery("select a from Student a where a.email=?2");
		query1.setParameter(2, email);
	     Student dbStudent=(Student) query1.getSingleResult();
	     
	return dbStudent;
		}
		return null;
	
	}
	return null;
}

public Student updateStudent(int id,String name) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		student.setName(name);
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}else {
		return null;
	}
}
public Student deleteStudent(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}
	return null;
}




public Student selectStudent(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Lavanya");
	EntityManager  entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	return student;
	
}
}
