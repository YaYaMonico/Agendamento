package com.saude.yasminmonico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.yasminmonico.models.Consulta;
import com.saude.yasminmonico.repository.RepositoryConsulta;

@Service
public class ServiceConsulta {

	@Autowired
	private RepositoryConsulta repositoryConsulta;
	
	public void salvarConsulta(Consulta consulta) {
		repositoryConsulta.save(consulta);
	}
	
	public List<Consulta> listarAll(){
		return repositoryConsulta.findAll();
	}

	public Optional<Consulta> getConsulta(int id){
		return repositoryConsulta.findById(id);
	}
	
	public void excluirConsulta(Consulta consulta) {
		repositoryConsulta.delete(consulta);
	}
}