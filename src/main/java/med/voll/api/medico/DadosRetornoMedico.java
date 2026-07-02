package med.voll.api.medico;

public record DadosRetornoMedico(Long id, String nome,  String email, String crm, Especialidade especialidade) {

	
	public DadosRetornoMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
