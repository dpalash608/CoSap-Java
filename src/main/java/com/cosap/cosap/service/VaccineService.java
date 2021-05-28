package com.cosap.cosap.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosap.cosap.model.Vaccine_pojo;
import com.cosap.cosap.repository.Vaccinerepo;


@Service
public class VaccineService {

	@Autowired
	Vaccinerepo Vaccinerepo;

	public List<Vaccine_pojo> getAllVaccine() {
		List<Vaccine_pojo> vaccinelist = new ArrayList<>();
		for (Vaccine_pojo vaccine : Vaccinerepo.findAll()) {
			vaccinelist.add(vaccine);
		}
		return vaccinelist;
	}

	public Vaccine_pojo getVaccinebyid(String Date) {
		Optional<Vaccine_pojo> vaccine = Vaccinerepo.findById(Date);
		if (vaccine.isPresent()) {
			System.out.println(vaccine.get().getStock());
			return vaccine.get();
		}
		return null;
	}

	public void addvaccine(Vaccine_pojo vaccine) {
		Vaccinerepo.save(vaccine);
	}

	public void addallvaccine(List<Vaccine_pojo> vaccine) {
		Vaccinerepo.saveAll(vaccine);
	}

	public void deletevaccine(String Date) {

		Optional<Vaccine_pojo> vaccine = Vaccinerepo.findById(Date);
		if (vaccine.isPresent()) {
			Vaccinerepo.deleteById(Date);
			System.out.println("Deleted");
		}
	}

}


