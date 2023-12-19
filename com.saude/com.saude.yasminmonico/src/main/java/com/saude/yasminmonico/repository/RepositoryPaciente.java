package com.saude.yasminmonico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.yasminmonico.models.Paciente;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Integer>{

}
