package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.EmployeRepository;
import com.actorep.model.Employe;

@Service
@Transactional
public class EmployeService implements IActorepServiceEmploye {

	@Autowired 
	private EmployeRepository employeRepository;

	// CRUD Employe
	
	@Override
	public Collection<Employe> listEmployes() {
		return employeRepository.findAll();
	}
	
	@Override
	public void deleteEmploye(int id) {
		employeRepository.deleteById(id);
	}
	
	@Override
	public void saveEmploye(Employe employe) {
		employeRepository.save(employe);
	}
	
	@Override
	public Employe getEmploye(int id) {
		return employeRepository.findById(id).get();
	}
	

}
