package com.saude.yasminmonico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.yasminmonico.models.Consulta;
import com.saude.yasminmonico.service.ServiceConsulta;
import com.saude.yasminmonico.service.ServiceMedico;
import com.saude.yasminmonico.service.ServicePaciente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping ("/consultas")
public class ControllerConsulta {
	@Autowired
	private ServiceConsulta serviceConsulta;
	
	@Autowired
	private ServiceMedico serviceMedico;
	
	@Autowired
	private ServicePaciente servicePaciente;

	@GetMapping(value = "")
	public String listarAll(Model model) {
		model.addAttribute("consultas", serviceConsulta.listarAll());
		return "/consultas/consultas";
	}

	@GetMapping(value = "/novaconsulta")
	public String novoconsulta(Model model) {
		model.addAttribute("medicos", serviceMedico.listarAll());
		model.addAttribute("pacientes", servicePaciente.listarAll());
		model.addAttribute("consulta", new Consulta());
		return "/consultas/novaconsulta";
	}

	@PostMapping(value = "/salvar")
	public String salvar(@ModelAttribute Consulta consulta) {
		serviceConsulta.salvarConsulta(consulta);
		return "redirect:/consultas";
	}

	@GetMapping(value = "/excluir/{codigo}")
	public String excluirconsulta(@PathVariable("codigo") int codigo) {
		Optional<Consulta> consulta = serviceConsulta.getConsulta(codigo);
		if (consulta.isPresent()) {
			serviceConsulta.excluirConsulta(consulta.get());
		}
		return "redirect:/consultas";
	}

	@GetMapping(value = "/editar/{codigo}")
	public String editarconsulta(@PathVariable("codigo") int codigo, Model model) {
		Optional<Consulta> consulta = serviceConsulta.getConsulta(codigo);
		model.addAttribute("medicos", serviceMedico.listarAll());
		model.addAttribute("pacientes", servicePaciente.listarAll());
		model.addAttribute("consulta", consulta.get());
		return "/consultas/novaconsulta";
	}
}
