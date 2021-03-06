package com.generation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.generation.models.Elefante;
import com.generation.services.ElefanteService;

@Controller
@RequestMapping("/elefante")
public class ElefanteController {
	
	@Autowired
	ElefanteService elefanteService;
	
	// Pasamos un objeto vacio
		@RequestMapping("")
		public String auto(@ModelAttribute("elefante") Elefante elefante) {
			return "elefante.jsp";
		}
		@PostMapping("/guardar")
		public String guardarElefante(@ModelAttribute("elefante") Elefante elefante, BindingResult resultado, Model model) {
			// capturamos si existe un ingreso de error en los datos
			if (resultado.hasErrors()) {
				model.addAttribute("msgError", "Debe realizar el ingreso de datos");
				return "elefante.jsp";
			} else {
				// capturamos el objeto auto con atributos llenos
				System.out.println(elefante.toString());

				// enviar el objeto al service
				elefanteService.saveElefante(elefante);
				// obtener una lista de autos
				List<Elefante> listaElefantes = elefanteService.findAll();
				// pasamos la lista de elefantes al jsp
				model.addAttribute("elefantesCapturados", listaElefantes);
				return "mostrarElefantes.jsp";// pagina a desplegar

			}

		}
		
		// mostrar el listado de autos
		@RequestMapping("/mostrar")
		public String mostrar(Model model) {
			// obtener una lista de elefantes
			List<Elefante> listaElefantes = elefanteService.findAll();
			// pasamos la lista de elefantes al jsp
			model.addAttribute("elefantesCapturados", listaElefantes);
			return "mostrarElefantes.jsp";
		}
		
		@RequestMapping("/editar/{id}")//editar para despliegue de todos los elefantes
		public String editar(@PathVariable("id") Long id, Model model) {
			System.out.println("el id es:" + id);
			Elefante elefante = elefanteService.buscarId(id);
			model.addAttribute("elefante", elefante);
			return "editarElefante.jsp";//redireccionar a otra url
		}
		
		//localhost:9080/elefante/actualizar/{id} -> actualizar para la persistencia en BD
		@PostMapping("editar/actualizar/{id}")
		public String actualizarElefante(@PathVariable("id") Long id ,@Valid @ModelAttribute("elefante") Elefante elefante, BindingResult resultado, Model model) {
			System.out.println("EL id a actualizar es:" + id);
			// capturamos si existe un ingreso de error en los datos
			
			if (resultado.hasErrors()) {
				model.addAttribute("msgError", "Debe realizar el ingreso de datos");
				return "editarElefante.jsp";
			} else {
				// capturamos el objeto auto con atributos llenos
				System.out.println(elefante.toString());

				// enviar el objeto al service
				elefanteService.saveElefante(elefante);
				// obtener una lista de autos
				List<Elefante> listaElefantes= elefanteService.findAll();
				// pasamos la lista de autos al jsp
				model.addAttribute("elefantesCapturados", listaElefantes);
				return "mostrarElefantes.jsp";// pagina a desplegar

			}

		}
}
