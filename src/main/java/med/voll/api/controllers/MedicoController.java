package med.voll.api.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizaMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosRetornoMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	
	@PostMapping
	@Transactional
	public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){
		repository.save(new Medico(dados));
		
	}

	@GetMapping
	public Page<DadosRetornoMedico> listarMedicos(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosRetornoMedico::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizaMedico(@RequestBody @Valid DadosAtualizaMedico dadosAtualizados) {
		var medico = repository.getReferenceById(dadosAtualizados.id());
		medico.atualizarMedico(dadosAtualizados);
		
	}
	
}