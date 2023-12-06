package com.jspider.employeemanagementsystem.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspider.employeemanagementsystem.dto.Employee1;

public class EmployeeDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static  void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction!=null) {
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}
	
	public void addEmployee(Employee1 employee) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		closeConnection();
	}
	
	
	public void deleteEmployee(int id) {
		openConnection();
		entityTransaction.begin();
		Employee1 employee = entityManager.find(Employee1.class, id);
		entityManager.remove(employee);
		entityTransaction.commit();
		closeConnection();
		
	}
	
	@SuppressWarnings("unchecked")
	public void getAllEmployee() {
		openConnection();
		entityTransaction.begin();
		Query query = entityManager.createQuery("SELECT employee FROM Employee1 employee");
		List<Employee1> employees =query.getResultList();
			for(Employee1 employee : employees) {
				System.out.println(employee);
				
			}
			entityTransaction.commit();
			closeConnection();
	}
	
	public Employee1 getEmployeeById(int id) {
		openConnection();
		entityTransaction.begin();
		Employee1 employee = entityManager.find(Employee1.class, id);
		System.out.println(employee);
		entityTransaction.commit();
		closeConnection();
		return employee;
		
	}
	
	public void updateEmployee(int id,Scanner scanner) {
		openConnection();
		entityTransaction.begin();
		Employee1 employee = entityManager.find(Employee1.class, id);
		scanner.nextLine();
		System.out.println("Enter the employee name:");
		employee.setName(scanner.nextLine());	
		System.out.println("Enter the employee email:");
		employee.setEmail(scanner.nextLine());	
		System.out.println("Enter the employee salary:");
		employee.setSalary(scanner.nextDouble());	
		entityTransaction.commit();
		closeConnection();
	}
	

}
