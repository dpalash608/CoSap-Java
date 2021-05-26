package com.cosap.cosap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cosap.cosap.model.Vaccine_pojo;


@Repository
public interface Vaccinerepo extends CrudRepository<Vaccine_pojo, String> {

}
