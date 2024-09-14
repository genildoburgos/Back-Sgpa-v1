package br.edu.ufape.poo.sgpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.facade.Facade;

/*@RestController
@RequestMapping("/api/v1")
public class MembroController {
	
	@Autowired
	private Facade facade;
	
	@GetMapping("/Membro")
	public List<Membro> listarMembros() {
		return facade.listarMembros();
	}
	
	@PostMapping("/Membro")

}*/
