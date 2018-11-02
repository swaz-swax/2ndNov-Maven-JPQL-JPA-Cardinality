package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		Student student=em.find(Student.class, 1);
		System.out.println(student.getStudentId()+ " , "+ student.getName());
		Address address=student.getAddress();
		System.out.println(address.getCity());
		System.out.println("----------------------------------------------------");

		Address address1=em.find(Address.class, 1);
		System.out.println(address1.getCity()+" , "+address1.getState());
		Student s=address.getStudent();
		System.out.println(s.getStudentId()+" , "+s.getName());
	}

}
