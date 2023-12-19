package com.saude.yasminmonico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.yasminmonico.models.Especialidade;
import com.saude.yasminmonico.repository.RepositoryEspecialidade;

@Service
public class ServiceEspecialidade {

	@Autowired
	private RepositoryEspecialidade repositoryEspecialidade;
	
	public void salvarEspecialidade(Especialidade especialidade) {
		repositoryEspecialidade.save(especialidade);
	}
	
	public List<Especialidade> listarAll(){
		return repositoryEspecialidade.findAll();
	}

	public Optional<Especialidade> getEspecialidade(int id){
		return repositoryEspecialidade.findById(id);
	}
	
	public void excluirEspecialidade(Especialidade especialidade) {
		repositoryEspecialidade.delete(especialidade);
	}
}
