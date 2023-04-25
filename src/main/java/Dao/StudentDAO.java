package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Student;

public class StudentDAO {
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transation=manager.getTransaction();

public void insert(Student student)
{
	transation.begin();
	manager.persist(student);
	transation.commit();
}

public List<Student> fetchall()
{
	return manager.createQuery("select x from Student x").getResultList();
}
public Student fetchById(int id)
{
	return manager.find(Student.class,id);
}
public List<Student> fetchByMob(long phone)
{
return manager.createQuery("select x from Student x where phone=?100").setParameter(100, phone).getResultList();	
}
}



