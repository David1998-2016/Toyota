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

import com.toyota.renovacion.model.Mantenimiento;
import com.toyota.renovacion.service.IMantenimientoService;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	@Autowired
	private IMantenimientoService rService;
	
	@RequestMapping("/bienvenido")
	public String irMantenimientoBienvenido() {
		return "bienvenido";		
	}
	
	@RequestMapping("/")
	public String irMantenimiento(Map<String, Object> model) {
		model.put("listaMantenimientos", rService.listar());
		return "listMantenimiento";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("mantenimiento", new Mantenimiento());
		return "mantenimiento";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Mantenimiento objMantenimiento, 
			BindingResult binRes, Model model ) throws ParseException 
	{
		if (binRes.hasErrors()) {
			return "mantenimiento";
		}
		else {
			boolean flag = rService.insertar(objMantenimiento);
			if (flag) {
				return "redirect:/mantenimiento/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/mantenimiento/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Mantenimiento objMantenimiento, 
			BindingResult binRes, Model model, RedirectAttributes objRedir ) 
					throws ParseException {
		if (binRes.hasErrors()) {
			return "redirect:/mantenimiento/listar";
		}
		else {
			boolean flag = rService.modificar(objMantenimiento);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "se actualizo correctamente");
				return "redirect:/mantenimiento/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/mantenimiento/irRegistrar";
			}			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Mantenimiento> objMantenimiento= rService.listarId(id);
		if (objMantenimiento == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/mantenimiento/listar";
		}
		else {
			model.addAttribute("mantenimiento", objMantenimiento);
			return "mantenimiento";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaMantenimientos", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se puede eliminar un mantenimiento asignado");
			model.put("listaMantenimientos", rService.listar());
		}
		return "listMantenimiento";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMantenimientos", rService.listar());
		return "listMantenimiento";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Mantenimiento mantenimiento) throws ParseException {
		rService.listarId(mantenimiento.getIdMantenimiento());
		return "listMantenimiento";		
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Mantenimiento mantenimiento) throws ParseException {
		List<Mantenimiento> listaMantenimientos;
		mantenimiento.setNameMantenimiento(mantenimiento.getNameMantenimiento());
		listaMantenimientos = rService.buscarNombre(mantenimiento.getNameMantenimiento());
		
		if (listaMantenimientos.isEmpty()) {
			model.put("mensaje", "No se encontro");						
		}
		model.put("listaMantenimientos", listaMantenimientos);
		return "buscarMantenimiento";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("mantenimiento", new Mantenimiento());
		return "buscarMantenimiento";
	}
}
