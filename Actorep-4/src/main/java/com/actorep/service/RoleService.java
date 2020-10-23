package com.actorep.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.RoleRepository;
import com.actorep.model.Role;

@Service
@Transactional
public class RoleService implements IActorepServiceRole {
	
	@Autowired
	private RoleRepository roleRepository;
	
	// CRUD Role
	
	@Override
	public Collection<Role> listRoles() {
		return roleRepository.findAll();
	}
	
	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	
	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
	}
	
	@Override
	public Role getRole(int id) {
		return roleRepository.findById(id).get();
	}

}
