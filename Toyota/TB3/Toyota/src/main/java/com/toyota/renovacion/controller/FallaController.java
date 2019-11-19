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

import com.toyota.renovacion.model.Falla;
import com.toyota.renovacion.service.IFallaService;

@Controller
@RequestMapping("/falla")
public class FallaController {
	
	@Autowired
	private IFallaService rService;
	
	@RequestMapping("/bienvenido")
	public String irFallaBienvenido() {
		return "bienvenido";		
	}
	
	@RequestMapping("/")
	public String irRace(Map<String, Object> model) {
		model.put("listaFallas", rService.listar());
		return "listFalla";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("falla", new Falla());
		return "falla";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Falla objFalla, 
			BindingResult binRes, Model model ) throws ParseException 
	{
		if (binRes.hasErrors()) {
			return "race";
		}
		else {
			boolean flag = rService.insertar(objFalla);
			if (flag) {
				return "redirect:/falla/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/falla/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Falla objFalla, 
			BindingResult binRes, Model model, RedirectAttributes objRedir ) 
					throws ParseException {
		if (binRes.hasErrors()) {
			return "redirect:/race/listar";
		}
		else {
			boolean flag = rService.modificar(objFalla);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "se actualizo correctamente");
				return "redirect:/falla/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/falla/irRegistrar";
			}			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Falla> objFalla= rService.listarId(id);
		if (objFalla == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/falla/listar";
		}
		else {
			model.addAttribute("falla", objFalla);
			return "Falla";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaFallas", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se puede eliminar una falla asignado");
			model.put("listaFallas", rService.listar());
		}
		return "listFalla";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaFallas", rService.listar());
		return "listFalla";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Falla falla) throws ParseException {
		rService.listarId(falla.getIdFalla());
		return "listFalla";		
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Falla falla) throws ParseException {
		List<Falla> listaFallas;
		falla.setNameFalla(falla.getNameFalla());
		listaFallas = rService.buscarNombre(falla.getNameFalla());
		
		if (listaFallas.isEmpty()) {
			model.put("mensaje", "No se encontro");						
		}
		model.put("listaFallas", listaFallas);
		return "buscarFalla";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("falla", new Falla());
		return "buscarFalla";
	}
		
}



