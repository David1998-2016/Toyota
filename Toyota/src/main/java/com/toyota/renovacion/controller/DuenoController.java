package com.toyota.renovacion.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.toyota.renovacion.model.Dueno;
import com.toyota.renovacion.service.IDuenoService;

@Controller
@RequestMapping("/dueno")
public class DuenoController {
	
	@Autowired
	private IDuenoService rService;
	
	@RequestMapping("/bienvenido")
	public String irDuenoBienvenido() {
		return "bienvenido";		
	}
	
	@RequestMapping("/")
	public String irRace(Map<String, Object> model) {
		model.put("listaDuenos", rService.listar());
		return "listDueno";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("dueno", new Dueno());
		return "dueno";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Dueno objDueno, 
			BindingResult binRes, Model model ) throws ParseException 
	{
		if (binRes.hasErrors()) {
			return "race";
		}
		else {
			boolean flag = rService.insertar(objDueno);
			if (flag) {
				return "redirect:/dueno/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/dueno/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Dueno objDueno, 
			BindingResult binRes, Model model, RedirectAttributes objRedir ) 
					throws ParseException {
		if (binRes.hasErrors()) {
			return "redirect:/race/listar";
		}
		else {
			boolean flag = rService.modificar(objDueno);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "se actualizo correctamente");
				return "redirect:/dueno/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/dueno/irRegistrar";
			}			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Dueno> objDueno= rService.listarId(id);
		if (objDueno == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/dueno/listar";
		}
		else {
			model.addAttribute("dueno", objDueno);
			return "dueno";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaDuenos", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se puede eliminar un dueno asignado");
			model.put("listaDuenos", rService.listar());
		}
		return "listDueno";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDuenos", rService.listar());
		return "listDueno";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Dueno dueno) throws ParseException {
		rService.listarId(dueno.getIdDueno());
		return "listDueno";		
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Dueno dueno) throws ParseException {
		List<Dueno> listaDuenos;
		dueno.setLastnameDueno(dueno.getLastnameDueno());
		listaDuenos = rService.buscarNombre(dueno.getLastnameDueno());
		
		if (listaDuenos.isEmpty()) {
			model.put("mensaje", "No se encontro");						
		}
		model.put("listaDuenos", listaDuenos);
		return "buscarDueno";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("dueno", new Dueno());
		return "buscarDueno";
	}
		
}



