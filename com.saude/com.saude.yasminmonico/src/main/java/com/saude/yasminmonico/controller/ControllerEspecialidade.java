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

import com.saude.yasminmonico.models.Especialidade;
import com.saude.yasminmonico.service.ServiceEspecialidade;
import com.saude.yasminmonico.service.ServiceMedico;

@Controller
@RequestMapping("/especialidades")
public class ControllerEspecialidade {
	@Autowired
	private ServiceEspecialidade serviceEspecialidade;
	
	@Autowired
	private ServiceMedico serviceMedico;

	@GetMapping(value = "")
	public String listarAll(Model model) {
		model.addAttribute("especialidades", serviceEspecialidade.listarAll());
		return "/especialidades/especialidades";
	}

	@GetMapping(value = "/novaespecialidade")
	public String novoespecialidade(Model model) {
		model.addAttribute("medicos", serviceMedico.listarAll());
		model.addAttribute("especialidade", new Especialidade());
		return "/especialidades/novaespecialidade";
	}

	@PostMapping(value = "/salvar")
	public String salvar(@ModelAttribute Especialidade especialidade) {
		serviceEspecialidade.salvarEspecialidade(especialidade);
		return "redirect:/especialidades";
	}

	@GetMapping(value = "/excluir/{codigo}")
	public String excluirespecialidade(@PathVariable("codigo") int codigo) {
		Optional<Especialidade> especialidade = serviceEspecialidade.getEspecialidade(codigo);
		if (especialidade.isPresent()) {
			serviceEspecialidade.excluirEspecialidade(especialidade.get());
		}
		return "redirect:/especialidades";
	}

	@GetMapping(value = "/editar/{codigo}")
	public String editarespecialidade(@PathVariable("codigo") int codigo, Model model) {
		Optional<Especialidade> especialidade = serviceEspecialidade.getEspecialidade(codigo);
		model.addAttribute("medicos", serviceMedico.listarAll());
		model.addAttribute("especialidade", especialidade.get());
		return "/especialidades/novaespecialidade";
	}
}
