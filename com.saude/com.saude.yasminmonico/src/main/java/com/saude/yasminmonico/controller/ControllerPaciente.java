package com.saude.yasminmonico.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.yasminmonico.models.Paciente;
import com.saude.yasminmonico.service.ServicePaciente;

@Controller
@RequestMapping("/pacientes")
public class ControllerPaciente {
	@Autowired
	private ServicePaciente servicePaciente;
	@GetMapping(value = "")
	public String listarAll(Model model) {
		model.addAttribute("pacientes", servicePaciente.listarAll());
		return "/pacientes/pacientes";
	}

	@GetMapping(value = "/novopaciente")
	public String novopaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "/pacientes/novopaciente";
	}

	@PostMapping(value = "/salvar")
	public String salvar(@ModelAttribute Paciente paciente) {
		servicePaciente.salvarPaciente(paciente);
		return "redirect:/pacientes";
	}

	@GetMapping(value = "/excluir/{codigo}")
	public String excluirpaciente(@PathVariable("codigo") int codigo) {
		Optional<Paciente> paciente = servicePaciente.getPaciente(codigo);
		if (paciente.isPresent()) {
			servicePaciente.excluirPaciente(paciente.get());
		}
		return "redirect:/pacientes";
	}

	@GetMapping(value = "/editar/{codigo}")
	public String editarpaciente(@PathVariable("codigo") int codigo, Model model) {
		Optional<Paciente> paciente = servicePaciente.getPaciente(codigo);
		model.addAttribute("paciente", paciente.get());
		return "/pacientes/novopaciente";
	}
}
