package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.service.CadastraMedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private CadastraMedicoService servicoMedico;
	
	
	@PostMapping
	public void cadastrarMedico(@RequestBody DadosCadastroMedico dados){
		System.out.println(dados);
		servicoMedico.cadastraMedico(dados);
		
	}
}
