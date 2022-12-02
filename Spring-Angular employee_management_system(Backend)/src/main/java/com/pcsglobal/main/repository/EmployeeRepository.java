package com.pcsglobal.main.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pcsglobal.main.model.Employee;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee ,Integer> {
	
	

}
