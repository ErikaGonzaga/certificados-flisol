package br.ufc.petti.certificadosflisol.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.petti.certificadosflisol.entity.Participante;
import br.ufc.petti.certificadosflisol.service.ParticipanteService;
import br.ufc.petti.certificadosflisol.util.GenerateImage;
import br.ufc.petti.certificadosflisol.util.SendEmail;

@Controller
@RequestMapping(path="/")
public class MainController {

	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(path="/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(path="/buscarParticipante")
	public String buscarParticipante(String email, Model model, RedirectAttributes redAttrs){
		List<Participante> participantes = participanteService.listByEmail(email);
		if(!participantes.isEmpty()){
			model.addAttribute("participantes", participantes);
			return "lista_participantes";
		}else{
			redAttrs.addFlashAttribute("erro", "Nenhum participantes com o e-mail informado foi localizado.");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(path="/enviarCertificado/{id}")
	public String enviarCertificado(@PathVariable("id") Long id, RedirectAttributes redAttrs){
		Participante participante = participanteService.findById(id);
		if(participante != null){
			
			String pathToModel = MainController.class.getClassLoader().getResource("static/images/modelo.jpg").getPath();
			String pathToOut = MainController.class.getClassLoader().getResource("static/images/generated/").getPath();
			String pathToOutFile = pathToOut + participante.getId() + "_" + participante.getNome().replaceAll(" ", "_") + ".jpg";
			try {
				
				GenerateImage.drawName(participante, pathToModel, pathToOutFile);
				
				SendEmail.sendEmail(participante, pathToOutFile);
				
				redAttrs.addFlashAttribute("ok", "Seu certificado foi enviado!");
				return "redirect:/";
				
			} catch (IOException | EmailException e) {
				e.printStackTrace();
				redAttrs.addFlashAttribute("erro", "Erro interno.");
				return "redirect:/";
			}
			
			
		}else{
			redAttrs.addFlashAttribute("erro", "Participante não encontrado. Erro interno.");
			return "redirect:/";
		}
	}
	
}
