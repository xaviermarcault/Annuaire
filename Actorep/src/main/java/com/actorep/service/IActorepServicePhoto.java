package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Photo;;

public interface IActorepServicePhoto {

	public Collection<Photo> listPhotos();

	public void savePhoto(Photo photo);

	public void deletePhoto(int id);

	public Photo getPhoto(int id);
	
}
