package com.actorep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}