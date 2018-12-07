package br.ufc.petti.certificadosflisol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.petti.certificadosflisol.model.Participante;
import br.ufc.petti.certificadosflisol.service.ParticipanteService;

@Controller
@RequestMapping(path="/participantes/")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;

	@RequestMapping(path="add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("participante", new Participante());
		return mv;
	}
	
	@RequestMapping(path="/salvar")
	public String salvarParticipante(Participante participante) {
		if(participante != null)
			participanteService.save(participante);
		return "redirect:/";
	}
}
