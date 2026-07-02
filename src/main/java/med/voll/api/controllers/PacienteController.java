package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.pacientes.ConsultarDadosPaciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository manager;
	
	
	@PostMapping
	@Transactional
	public void cadastroPaciente(@RequestBody @Valid DadosCadastroPaciente dadosPaciente) {
			manager.save(new Paciente(dadosPaciente));
	}
	
	@GetMapping
	public Page<ConsultarDadosPaciente> consultarDadosPaciente(@PageableDefault (page=0, size = 10,  sort = {"nome"})   Pageable paginacao){
		return manager.findAll(paginacao).map(ConsultarDadosPaciente::new);
	}
}
