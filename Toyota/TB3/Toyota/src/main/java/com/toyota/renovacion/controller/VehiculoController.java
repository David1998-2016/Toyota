package com.toyota.renovacion.controller;

import java.text.ParseException;
import java.util.Map;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyota.renovacion.model.Vehiculo;
import com.toyota.renovacion.service.IDuenoService;
import com.toyota.renovacion.service.IVehiculoService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	@Autowired
	private IDuenoService dService;
	
	@Autowired
	private IVehiculoService vService;
	
	@RequestMapping("/")
	public String irVehiculo(Map<String, Object> model) {
		model.put("listaVehiculos", vService.listar());
		return "listVehiculos";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		model.addAttribute("listaDuenos", dService.listar());
		return "vehiculo";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Vehiculo objVehiculo, 
			BindingResult binRes, Model model ) throws ParseException 
	{
		if (binRes.hasErrors()) {
			model.addAttribute("listaDuenos", dService.listar());
			return "vehiculo";
		}
		else {
			boolean flag = vService.insertar(objVehiculo);
			if (flag) {
				return "redirect:/vehiculo/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/vehiculo/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Vehiculo objVehiculo, 
			BindingResult binRes, Model model, RedirectAttributes objRedir ) 
					throws ParseException {
		if (binRes.hasErrors()) {
			return "redirect:/vehiculo/listar";
		}
		else {
			boolean flag = vService.modificar(objVehiculo);
			if (flag) {
				objRedir.addFlashAttribute("mensaje", "se actualizo correctamente");
				return "redirect:/vehiculo/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/vehiculo/listar";
			}			
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar (@PathVariable int id, Model model, 
			RedirectAttributes objRedir) 
	{
		
		Optional<Vehiculo> objVehiculo = vService.listarId(id);
						
		if (objVehiculo == null) {
			objRedir.addFlashAttribute("mensaje", "ocurrio un error");
			return "redirect:/vehiculo/listar";
		}
		else {
			
						
			model.addAttribute("listaDuenos", dService.listar());
			if (objVehiculo.isPresent())
				objVehiculo.ifPresent(o -> model.addAttribute("vehiculo", o));			

			return "vehiculo";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		if (id!=null && id>0) {
			vService.eliminar(id);
			model.put("listaVehiculos", vService.listar());
		}
		return "listVehiculos";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaVehiculos", vService.listar());
		return "listVehiculos";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Vehiculo vehiculo) throws ParseException {
		vService.listarId(vehiculo.getIdVehiculo());
		return "listVehiculos";		
	}

}
