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

import com.toyota.renovacion.model.Empleado;
import com.toyota.renovacion.service.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService rService;
	
	@RequestMapping("/bienvenido")
	public String irEmpleadoBienvenido() {
		return "bienvenido";		
	}
	
	@RequestMapping("/")
	public String irRace(Map<String, Object> model) {
		model.put("listaEmpleados", rService.listar());
		return "listEmpleado";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "empleado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Empleado objEmpleado, 
			BindingResult binRes, Model model ) throws ParseException 
	{
		if (binRes.hasErrors()) {
			return "race";
		}
		else {
			boolean flag = rService.insertar(objEmpleado);
			if (flag) {
				return "redirect:/empleado/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/empleado/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Empleado objEmpleado, 
			BindingResult binRes, Model model, RedirectAttributes objRedir ) 
					throws ParseException {
		if (binRes.hasErrors()) {
			return "redirect:/race/listar";
		}
		else {
			boolean flag = rService.modificar(objEmpleado);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "se actualizo correctamente");
				return "redirect:/empleado/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/empleado/irRegistrar";
			}			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Empleado> objEmpleado= rService.listarId(id);
		if (objEmpleado == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/empleado/listar";
		}
		else {
			model.addAttribute("empleado", objEmpleado);
			return "empleado";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaEmpleados", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "No se puede eliminar un empleado asignado");
			model.put("listaEmpleados", rService.listar());
		}
		return "listEmpleado";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEmpleados", rService.listar());
		return "listEmpleado";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Empleado empleado) throws ParseException {
		rService.listarId(empleado.getIdEmpleado());
		return "listEmpleado";		
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Empleado empleado) throws ParseException {
		List<Empleado> listaEmpleados;
		empleado.setLastnameEmpleado(empleado.getLastnameEmpleado());
		listaEmpleados = rService.buscarNombre(empleado.getLastnameEmpleado());
		
		if (listaEmpleados.isEmpty()) {
			model.put("mensaje", "No se encontro");						
		}
		model.put("listaEmpleados", listaEmpleados);
		return "buscarEmpleado";		
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "buscarEmpleado";
	}
		
}



