package com.capg.trg.presentation;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.utility.JPAUtil;

public class EmployeeTesterJPQL {

	public static void main(String[] args) 
	{
		EntityManager entityManager=JPAUtil.getEntityManager();
		/*String jpql1="select e from Employee e"; 
		TypedQuery<Employee> typedQuery=entityManager.createQuery(jpql1,Employee.class);
		List<Employee> empList=typedQuery.getResultList();
		showEmployees(empList);*/
		
		//show employee based on job condition
		
		/*String jpql1="select e from Employee e where "
				+ "e.job=:pjob AND e.salary>=:psal";    //pjob and psal are Named parameter
		TypedQuery<Employee> typedQuery=entityManager.createQuery(jpql1,Employee.class)
				.setParameter("pjob","Manager").setParameter("psal", 50000.0);
		//typedQuery.setParameter("ptitle","Manager");
		List<Employee> empList=typedQuery.getResultList();
		showEmployees(empList);*/
		/*Employee employee=typedQuery.getSingleResult();
		System.out.println(employee);
*/
		//ordinal Parameters
		String jpql2="select e from Employee e where e.job=?1 AND e.salary>=?2";    //?1 and ?2 are ordinal parameter
		
		TypedQuery<Employee> typedQuery=entityManager.createQuery(jpql2,Employee.class)
				.setParameter("1","Manager").setParameter("2", 50000.0);
		List<Employee> empList=typedQuery.getResultList();
		showEmployees(empList);
		
		
		/*//Calling native queries with JPA- bypass the orm framework
		Query query=entityManager.createNativeQuery("select * from Employee where job=?",Employee.class);
		query.setParameter(1, "Manager");
		List<Employee> empList1=query.getResultList();
		showEmployees(empList1);
		*/
		
		/*Query query=entityManager.createNamedQuery("q2");
		List<Employee> employeeList=query.getResultList();
		showEmployees(employeeList);*/
	}

	private static void showEmployees(List<Employee> empList) 
	{
		Iterator<Employee> iterator=empList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}

}
