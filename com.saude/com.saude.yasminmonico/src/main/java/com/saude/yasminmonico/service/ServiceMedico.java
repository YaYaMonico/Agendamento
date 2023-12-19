package com.saude.yasminmonico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.yasminmonico.models.Medico;
import com.saude.yasminmonico.models.Paciente;
import com.saude.yasminmonico.repository.RepositoryMedico;
import com.saude.yasminmonico.repository.RepositoryPaciente;


@Service
public class ServiceMedico {

	@Autowired
	private RepositoryMedico repositoryMedico;
	
	public void salvarMedico(Medico medico) {
		repositoryMedico.save(medico);
	}
	
	public List<Medico> listarAll(){
		return repositoryMedico.findAll();
	}

	public Optional<Medico> getMedico(int id){
		return repositoryMedico.findById(id);
	}
	
	public void excluirMedico(Medico medico) {
		repositoryMedico.delete(medico);
	}
}
