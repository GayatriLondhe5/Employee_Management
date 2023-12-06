package com.jspider.employeemanagementsystem.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Information")

public class Employee1 {
	
	
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="employee_id")
		private int id;
		@Column(nullable = false,name = "employee_name")
		private String name;
		@Column(nullable = false,unique = true,name="employee_email")
		private String email;
		@Column(name = "employee_salary")
		private double salary;

	}


