package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.generation.models.Elefante;
import com.generation.repositories.ElefanteRepository;

@Service
public class ElefanteService {
	@Autowired
	ElefanteRepository elefanteRepository;
	
public void saveElefante(@Valid Elefante elefante) {
		
		elefanteRepository.save(elefante);
	}
	public List<Elefante> findAll() {
		// TODO Auto-generated method stub
		return elefanteRepository.findAll();
	}
	public Elefante buscarId(Long id) {

		return elefanteRepository.findById(id).get();
	}
}
