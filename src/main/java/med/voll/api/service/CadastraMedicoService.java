package med.voll.api.service;

import org.springframework.stereotype.Service;

import med.voll.api.medico.DadosCadastroMedico;

@Service
public class CadastraMedicoService {
	
	
	public void cadastraMedico(DadosCadastroMedico medico) {
		System.out.println("Medico cadastrado");
	}
}
