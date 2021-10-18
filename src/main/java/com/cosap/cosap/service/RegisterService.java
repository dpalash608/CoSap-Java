package com.cosap.cosap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosap.cosap.model.Register_pojo;
import com.cosap.cosap.model.Vaccine_pojo;
import com.cosap.cosap.repository.Registerrepo;

@Service
public class RegisterService {
	
	@Autowired
	Registerrepo registerrepo;
	
	public List<Register_pojo> getAllRegister() {
		List<Register_pojo> reglist = new ArrayList<>();
		for (Register_pojo reg : registerrepo.findAll()) {
			reglist.add(reg);
		}
		return reglist;
	}

	public Register_pojo getRegisterbyid(String inumber) {
		Optional<Register_pojo> reg = registerrepo.findById(inumber);
		if (reg.isPresent()) {
			System.out.println(reg.get().getDate());
			System.out.println(reg.get().getAgegrp());
			return reg.get();
		}
		return null;
	}

	public void addregister(Register_pojo vaccine) {
		registerrepo.save(vaccine);
	}

}
