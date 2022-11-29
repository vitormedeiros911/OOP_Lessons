package telas;

import componentes.CampoCNPJ;
import componentes.CampoEmail;
import componentes.CampoTexto;

public class TelaCadastroFornecedor extends TelaCadastro {
  private CampoTexto jtfNome = new CampoTexto("Nome", 20, true);
  private CampoTexto jtfTelefone = new CampoTexto("Telefone", 10, true);
  private CampoTexto jtfCidade = new CampoTexto("Cidade", 20, true);
  private CampoCNPJ jtfCNPJ = new CampoCNPJ("CNPJ", true);
  private CampoEmail jtfEmail = new CampoEmail("E-mail", 10, true);

  public TelaCadastroFornecedor() {
    super("Cadastro de Fornecedor");
    adicionaComponente(jtfNome, 1, 2, 1, 1, true);
    adicionaComponente(jtfTelefone, 2, 2, 1, 1, true);
    adicionaComponente(jtfCidade, 3, 2, 1, 1, true);
    adicionaComponente(jtfCNPJ, 4, 2, 1, 1, true);
    adicionaComponente(jtfEmail, 5, 2, 1, 1, true);
    habilitaCampos(false);
    pack();
    setSize(600, 400);
    setVisible(true);
  }
}
