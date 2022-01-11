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
import com.cosap.cosap.model.Register_pojo;
import com.cosap.cosap.model.Vaccine_pojo;
import com.cosap.cosap.service.CosapService;
import com.cosap.cosap.service.RegisterService;
import com.cosap.cosap.service.VaccineService;

//This is controller file
@RestController
@RequestMapping("api/v1")
public class Controller {

	
	@Autowired
	CosapService cosapservice;
	
	@Autowired
	VaccineService vaccineservice;
	
	@Autowired
	RegisterService registerservice;
	
	
	

	// This is for GetMapping annotation
	@GetMapping("employee")
	public ResponseEntity<List<Employee_pojo>> getAllemp() {
		System.out.println("Fetching all Employess");
		List<Employee_pojo> employes = cosapservice.getAllemp();
		return new ResponseEntity<List<Employee_pojo>>(employes, HttpStatus.OK);
	}

	//api/v1/employee/I516845
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee_pojo> getempbyid(@PathVariable String id) {
		System.out.println("Fetching Employess with INumber = " + id);
		Employee_pojo emp = cosapservice.get_emp(id);
		return new ResponseEntity<Employee_pojo>(emp, HttpStatus.OK);
	}

	//api/v1/empDetails?id=I516845
	@GetMapping("empDetails")
	public ResponseEntity<Employee_pojo> getempbyparam(@RequestParam String id) {
		System.out.println("Fetching employees with INumber = " + id);
		Employee_pojo emp = cosapservice.get_emp(id);
		return new ResponseEntity<Employee_pojo>(emp, HttpStatus.OK);
	}

	@PostMapping("employee")
	public ResponseEntity<String> addemp(@RequestBody Employee_pojo emp) {
		System.out.println("Adding a new employee " + emp.getiNumber());
		cosapservice.addemp(emp);
		return new ResponseEntity<String>("Adding Employee", HttpStatus.CREATED);
	}
	
	@PostMapping("employee/all")
	public ResponseEntity<String> addallemp(@RequestBody List<Employee_pojo> emp) {
		cosapservice.addallemp(emp);;
		return new ResponseEntity<String>("Adding Employee", HttpStatus.CREATED);
	}
	

	@DeleteMapping("employee/{id}")
	public ResponseEntity<String> deleteemp(@PathVariable String id) {
		System.out.println("Deleteing employee with INumber" + id);
		cosapservice.deleteemp(id);
		return new ResponseEntity<String>("Deleting Employee", HttpStatus.NO_CONTENT);
	}

	@PutMapping("employee/{id}")
	public ResponseEntity<String> updateemp(@PathVariable String id, @RequestBody Employee_pojo scholar) {
		System.out.println("Updating employee with INumber " + id + ". New Name = " + cosapservice.get_emp(id));
		return new ResponseEntity<String>("Updating Employee", HttpStatus.OK);
	}
	
	
	
	//Start of vaccine Apis
	
	//api/v1/vaccine
	@GetMapping("vaccine")
	public ResponseEntity<List<Vaccine_pojo>> getallvaccine() {
		System.out.println("Fetching all vaccine");
		List<Vaccine_pojo> vaccine = vaccineservice.getAllVaccine();
		return new ResponseEntity<List<Vaccine_pojo>>(vaccine, HttpStatus.OK);
	}

	//api/v1/vaccine/25052021
	@GetMapping("vaccine/{id}")
	public ResponseEntity<Vaccine_pojo> getvaccinebyid(@PathVariable String id) {
		System.out.println("Fetching Vaccines with Date = " + id);
		Vaccine_pojo vaccine = vaccineservice.getVaccinebyid(id);
		return new ResponseEntity<Vaccine_pojo>(vaccine, HttpStatus.OK);
	}
	
	
	//api/v1/vaccine
	@PostMapping("vaccine")
	public ResponseEntity<String> addvaccine(@RequestBody Vaccine_pojo vaccine) {
		vaccineservice.addvaccine(vaccine);
		return new ResponseEntity<String>("Adding Vaccines", HttpStatus.CREATED);
	}
	
	
	//api/v1/vaccine/all
	@PostMapping("vaccine/all")
	public ResponseEntity<String> addallvaccine(@RequestBody List<Vaccine_pojo> vaccine) {
		vaccineservice.addallvaccine(vaccine);
		return new ResponseEntity<String>("Adding Vaccines", HttpStatus.CREATED);
	}
	
	
	//api/v1/vaccine/date
	@DeleteMapping("vaccine/{id}")
	public ResponseEntity<String> deletevaccine(@PathVariable String id) {
		System.out.println("Deleteing Vaccine with Date" + id);
		vaccineservice.deletevaccine(id);
		return new ResponseEntity<String>("Deleting Vaccine", HttpStatus.NO_CONTENT);
	}
	
	
	//api/v1/vaccine/date
	@PutMapping("vaccine/{id}")
	public ResponseEntity<String> updatevaccine(@PathVariable String id, @RequestBody Vaccine_pojo vaccine) {
		System.out.println("Updating Vaccine" + id + ". New Name = " + vaccineservice.getVaccinebyid(id));
		return new ResponseEntity<String>("Updating Vaccine", HttpStatus.OK);
	}
	
	//Star of register apis
	
	
	
	//api/v1/register
		@GetMapping("register")
		public ResponseEntity<List<Register_pojo>> getallregister() {
			System.out.println("Fetching all registrations");
			List<Register_pojo> reg = registerservice.getAllRegister();
			return new ResponseEntity<List<Register_pojo>>(reg, HttpStatus.OK);
		}

		//api/v1/register/i516845
		@GetMapping("register/{id}")
		public ResponseEntity<Register_pojo> getregisterbyinumber(@PathVariable String id) {
			System.out.println("Fetching Register with Inumbers = " + id);
			Register_pojo reg = registerservice.getRegisterbyid(id);
			return new ResponseEntity<Register_pojo>(reg, HttpStatus.OK);
		}
		
		
		//api/v1/register
		@PostMapping("register")
		public ResponseEntity<String> addregister(@RequestBody Register_pojo reg) {
			System.out.println("Adding a new Vaccine " + reg.getDate());
			registerservice.addregister(reg);
			return new ResponseEntity<String>("Adding Register", HttpStatus.CREATED);
		}
	
	
	
}
