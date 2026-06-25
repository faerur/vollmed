package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
