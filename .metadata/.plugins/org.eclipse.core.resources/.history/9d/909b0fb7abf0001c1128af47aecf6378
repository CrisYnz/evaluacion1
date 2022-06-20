package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
public class AutoService {
	//Llamar al repository
	@Autowired
	AutoRepository autoRepository;
	public void saveAuto(@Valid Auto auto) {
		
		autoRepository.save(auto);
	}
	public List<Auto> findAll() {
		// TODO Auto-generated method stub
		return autoRepository.findAll();
	}

}
