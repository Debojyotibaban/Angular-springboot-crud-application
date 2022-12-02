package com.pcsglobal.main.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.pcsglobal.datajpa.model.Itemployee;
//import com.pcsglobal.datajpa.model.Itemployee;
import com.pcsglobal.main.exception.ItempNotFoundException;
import com.pcsglobal.main.model.Employee;
import com.pcsglobal.main.repository.EmployeeRepository;

@Service
@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerRest {
	
	@Autowired(required=false)
	
	private EmployeeRepository employeeRepository; // employeeRepository is an object created by springboot automatically
	
	
	  // get all the records of employees
	  
	 @GetMapping("/employees") //the url 
	 public List<Employee>getAllEmployees(){
	  System.out.println("get all the employees......"); 
	  return employeeRepository.findAll(); 
	 }
	 
	
	
	
	// Create  one employee rest api into database
	  @PostMapping("/createemployees") // createemployees is the rest api
		public ResponseEntity<Map<String , Boolean>> createemployee(@RequestBody Employee employees){	
	    Employee createdItemployee=employeeRepository.save(employees);
	    Map<String ,Boolean> response= new HashMap<>();
	    response.put("IT employee record created ." ,Boolean.TRUE);
	    ResponseEntity.ok(createdItemployee); // 200 for success
		return ResponseEntity.ok(response);
	  }

		
	
	
	  //get one particular employee record by id
	
	  @GetMapping(path="employees/{userid}")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable("userid" ) int userid) // @path variable is used  to find the employee aid through postman and with the function of findbyid 
		
		{
			Employee employee= employeeRepository.findById(userid).orElseThrow(() -> new ItempNotFoundException());
			System.out.println(" Get the employee record by userid...");
			return ResponseEntity.ok(employee);
		}
	  
	  
	  
	  
	  //update the employee record 
	  
	  
	  @PutMapping("updateemployees/{userid}")
		public ResponseEntity <Map<String , Boolean>> updateEmployee(@PathVariable("userid" ) int userid , @RequestBody Employee employeeDetails)// response is response body and request body is a object body
		{
		Employee employee= employeeRepository.findById(userid).orElseThrow(() -> new ItempNotFoundException());
		
		employee.setName(employeeDetails.getName()); //itemp details is the object body and got the aname from postman and send it to the itemp entity 
		employee.setTitle(employeeDetails.getTitle());
		employee.setBody(employeeDetails.getBody());
		
		Employee updatedItemployee=employeeRepository.save(employee); 
		Map<String ,Boolean> response= new HashMap<>();  //put  response in the database
		response.put("IT employee record updated..with userid :" +userid +" -> updated ",Boolean.TRUE);  // put the  entire response
		 ResponseEntity.ok(updatedItemployee);  // building the response entity
		 return ResponseEntity.ok(response); // return the response entity.
		}
	  
	  
	  //Delete the employee from the database
	  
	  @DeleteMapping("delemployees/{userid}") // this the path that type in the postman
		public ResponseEntity <Map<String , Boolean>> deleteEmployee(@PathVariable("userid" ) int userid )// response is response body 
		{
		Employee employee= employeeRepository.findById(userid).orElseThrow(() -> new ItempNotFoundException());
		employeeRepository.delete(employee);
		Map<String ,Boolean> response= new HashMap<>();
		response.put("IT employee record deleted..with userid :" +userid +" -> deleted ",Boolean.TRUE);// put the  entire response
		System.out.println(" Delete the employee record....");
	    return ResponseEntity.ok(response);// return or printing  the response entity.
		}
	  
	  
	  
	  
	  
	  
	  
	  
}
