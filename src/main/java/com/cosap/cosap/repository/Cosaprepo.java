package com.cosap.cosap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cosap.cosap.model.Employee_pojo;

@Repository
public interface Cosaprepo extends CrudRepository<Employee_pojo, String>{

}
