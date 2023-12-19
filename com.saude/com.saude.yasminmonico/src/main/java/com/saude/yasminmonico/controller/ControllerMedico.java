package com.saude.yasminmonico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.yasminmonico.models.Medico;
import com.saude.yasminmonico.service.ServiceEspecialidade;
import com.saude.yasminmonico.service.ServiceMedico;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/medicos")
public class ControllerMedico {
	
	@Autowired
	private ServiceMedico serviceMedico;
	
	@Autowired
	private ServiceEspecialidade serviceEspecialidade;

	@GetMapping(value = "")
	public String listarAll(Model model) {
		model.addAttribute("medicos", serviceMedico.listarAll());
		return "/medicos/medicos";
	}

	@GetMapping(value = "/novomedico")
	public String novomedico(Model model) {
		model.addAttribute("especialidades", serviceEspecialidade.listarAll());
		model.addAttribute("medico", new Medico());
		return "/medicos/novomedico";
	}

	@PostMapping(value = "/salvar")
	public String salvar(@ModelAttribute Medico medico) {
		serviceMedico.salvarMedico(medico);
		return "redirect:/medicos";
	}

	@GetMapping(value = "/excluir/{codigo}")
	public String excluirmedico(@PathVariable("codigo") int codigo) {
		Optional<Medico> medico = serviceMedico.getMedico(codigo);
		if (medico.isPresent()) {
			serviceMedico.excluirMedico(medico.get());
		}
		return "redirect:/medicos";
	}

	@GetMapping(value = "/editar/{codigo}")
	public String editarmedico(@PathVariable("codigo") int codigo, Model model) {
		Optional<Medico> medico = serviceMedico.getMedico(codigo);
		model.addAttribute("especialidades", serviceEspecialidade.listarAll());
		model.addAttribute("medico", medico.get());
		return "/medicos/novomedico";
	}

}
