package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.PhotoRepository;
import com.actorep.model.Photo;

@Service
@Transactional
public class PhotoService implements IActorepServicePhoto {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Collection<Photo> listPhotos() {
		return photoRepository.findAll();
	}

	@Override
	public void savePhoto(Photo photo) {
		photoRepository.save(photo);
	}

	@Override
	public void deletePhoto(int id) {
		photoRepository.deleteById(id);		
	}

	@Override
	public Photo getPhoto(int id) {
		return photoRepository.findById(id).get();
	}

}
