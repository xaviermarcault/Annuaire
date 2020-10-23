package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Role;

public interface IActorepServiceRole {
	
	public Collection<Role> listRoles();
	
	public void saveRole(Role role);		
	
	public void deleteRole(int id);		
	
	public Role getRole(int id);		

}
