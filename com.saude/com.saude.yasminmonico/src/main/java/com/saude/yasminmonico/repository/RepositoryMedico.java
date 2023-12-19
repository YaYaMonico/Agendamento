package com.saude.yasminmonico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.yasminmonico.models.Medico;

@Repository
public interface RepositoryMedico extends JpaRepository<Medico, Integer>{

}
