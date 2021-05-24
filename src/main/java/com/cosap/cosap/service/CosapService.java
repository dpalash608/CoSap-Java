package com.cosap.cosap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosap.cosap.model.Employee_pojo;
import com.cosap.cosap.repository.Cosaprepo;


@Service
public class CosapService {
	
	
	@Autowired
	Cosaprepo Cosaprepo;

	public List<Employee_pojo> getAllemp() {
		List<Employee_pojo> emplist = new ArrayList<>();
		for (Employee_pojo emp : Cosaprepo.findAll()) {
			emplist.add(emp);
		}
		return emplist;
	}

	public Employee_pojo get_emp(String INumber) {
		Optional<Employee_pojo> employee = Cosaprepo.findById(INumber);
		if (employee.isPresent()) {
			System.out.println(employee.get().getiNumber());
			System.out.println(employee.get().getEmpName());
			return employee.get();
		}
		return null;
	}

	public void addemp(Employee_pojo emp) {
		Cosaprepo.save(emp);
	}

	public void addallemp(List<Employee_pojo> emp) {
		Cosaprepo.saveAll(emp);
	}

	public void deleteemp(String ID) {
	
		Optional<Employee_pojo> employee1 = Cosaprepo.findById(ID);
		if (employee1.isPresent()) {
			Cosaprepo.deleteById(ID);
			System.out.println("Deleted");
		}
	}

	
	
	

}
