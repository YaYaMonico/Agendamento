package com.saude.yasminmonico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.yasminmonico.models.Paciente;
import com.saude.yasminmonico.repository.RepositoryPaciente;

@Service
public class ServicePaciente {

	@Autowired
	private RepositoryPaciente repositoryPaciente;
	
	public void salvarPaciente(Paciente paciente) {
		repositoryPaciente.save(paciente);
	}
	
	public List<Paciente> listarAll(){
		return repositoryPaciente.findAll();
	}

	public Optional<Paciente> getPaciente(int id){
		return repositoryPaciente.findById(id);
	}
	
	public void excluirPaciente(Paciente paciente) {
		repositoryPaciente.delete(paciente);
	}
}
