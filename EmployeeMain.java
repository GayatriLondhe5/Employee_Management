package com.jspider.employeemanagementsystem.main;

import java.util.Scanner;

import com.jspider.employeemanagementsystem.dao.EmployeeDAO;
import com.jspider.employeemanagementsystem.dto.Employee1;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		Scanner sc = new Scanner(System.in);
		boolean flag= true;
		while(flag) {
			System.out.println("Enter 1 for add employee info. "
					+ "\nEnter 2 to display all employee details."
					+ "\nEnter 3 to display details of emplyee by id."
					+ "\nEnter 4 to update the employee information."
					+ "\nEnter 5 to delete employee."
					+ "\nEnter 6 to exit.");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Employee1 employee = new Employee1();
				sc.nextLine();
				System.out.println("Enter the Emloyee Name.");
				employee.setName(sc.nextLine());
				System.out.println("Enter the Emloyee Email.");
				employee.setEmail(sc.nextLine());
				System.out.println("Enter the Emloyee Salary.");
				employee.setSalary(sc.nextDouble());
				employeeDAO.addEmployee(employee);
				System.out.println("Employee added successfully..");
				break;
			
			case 2:
				employeeDAO.getAllEmployee();
				break;
			
			case 3:
				System.out.println("enter the id.");
				Employee1 employee1 = employeeDAO.getEmployeeById(sc.nextInt());
				if(employee1!=null) {
					System.out.println(employee1);
				}
				else {
					System.out.println("Employee is not found.");
				}
				break;
				
			case 4:
				employeeDAO.getAllEmployee();
				System.out.println("Enter the id.");
				employeeDAO.updateEmployee(sc.nextInt(), sc);
				System.out.println("Employee added succesfully.");
				
				
				break;
		
            case 5:
            	employeeDAO.getAllEmployee();
            	System.out.println("Enter the id.");
            	employeeDAO.deleteEmployee(sc.nextInt());
				
				break;
	
				
            case 6:
				System.out.println("Thank You..!!");
				flag = false;
				break;

			default:
				System.out.println("Enter the valid choice..");
				break;
			}
		}
		sc.close();
		
	}

}
