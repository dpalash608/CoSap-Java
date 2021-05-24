package com.cosap.cosap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosap.cosap.model.Employee_pojo;
import com.cosap.cosap.service.CosapService;


@RestController
@RequestMapping("api/v1")
public class Controller {

	
	@Autowired
	CosapService cosapservice;

	// This is for GetMapping annotation
	@GetMapping("employee")
	public ResponseEntity<List<Employee_pojo>> getAllScholars() {
		System.out.println("Fetching all scholars");
		List<Employee_pojo> employes = cosapservice.getAllemp();
		return new ResponseEntity<List<Employee_pojo>>(employes, HttpStatus.OK);
	}

	//api/v1/employee/I516845
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee_pojo> getScholarById(@PathVariable String id) {
		System.out.println("Fetching Scholar with INumber = " + id);
		Employee_pojo emp = cosapservice.get_emp(id);
		return new ResponseEntity<Employee_pojo>(emp, HttpStatus.OK);
	}

	//api/v1/empDetails?id=I516845
	@GetMapping("empDetails")
	public ResponseEntity<Employee_pojo> getScholarByParam(@RequestParam String id) {
		System.out.println("Fetching Scholar with INumber = " + id);
		Employee_pojo emp = cosapservice.get_emp(id);
		return new ResponseEntity<Employee_pojo>(emp, HttpStatus.OK);
	}

	@PostMapping("employee")
	public ResponseEntity<String> addScholar(@RequestBody Employee_pojo emp) {
		System.out.println("Adding a new Scholar " + emp.getiNumber());
		cosapservice.addemp(emp);
		return new ResponseEntity<String>("Adding Employee", HttpStatus.CREATED);
	}

	@DeleteMapping("employee/{id}")
	public ResponseEntity<String> deleteScholar(@PathVariable String id) {
		System.out.println("Deleteing Scholar with INumber" + id);
		cosapservice.deleteemp(id);
		return new ResponseEntity<String>("Deleting Employee", HttpStatus.NO_CONTENT);
	}

	@PutMapping("employee/{id}")
	public ResponseEntity<String> updateScholar(@PathVariable String id, @RequestBody Employee_pojo scholar) {
		System.out.println("Updating Scholar with INumber " + id + ". New Name = " + cosapservice.get_emp(id));
		return new ResponseEntity<String>("Updating Employee", HttpStatus.OK);
	}
}
