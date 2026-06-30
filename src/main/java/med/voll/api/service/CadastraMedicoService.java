package med.voll.api.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import med.voll.api.medico.DadosCadastroMedico;

@Service
public class CadastraMedicoService {
	
	private EntityManager manager;
	
	public void cadastraMedico(DadosCadastroMedico medico) {
		
		System.out.println("Medico cadastrado");
	}
}
