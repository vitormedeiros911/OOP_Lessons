package telas;

import componentes.CampoCEP;
import componentes.CampoCPF;
import componentes.CampoComboBox;
import componentes.CampoEmail;
import componentes.CampoTexto;

public class TelaCadastroCliente extends TelaCadastro {
  private CampoTexto jtfNome = new CampoTexto("Nome", 20, true);
  private CampoTexto jtfTelefone = new CampoTexto("Telefone", 10, false);
  private CampoTexto jtfLogradouro = new CampoTexto("Logradouro", 20, true);
  private CampoCEP jtfCep = new CampoCEP("CEP", false);
  /*
   * private CampoComboBox jtfEstado = new CampoComboBox("Estado", new Object[][]
   * { { 1, "PR" }, { 2, "MS" } },
   * false);
   */
  private CampoCPF jtfCpf = new CampoCPF("CPF", false);
  private CampoEmail jtfEmail = new CampoEmail("E-mail", 10, false);
  private CampoTexto jtfBairro = new CampoTexto("Bairro", 10, false);
  private CampoComboBox jtfCidade = new CampoComboBox("Cidade",
      new Object[][] { { 1, "Cidade 1" }, { 2, "Cidade 2" } },
      false);

  public TelaCadastroCliente() {
    super("Cadastro de Cliente");
    adicionaComponente(jtfNome, 1, 2, 1, 1, true);
    adicionaComponente(jtfTelefone, 2, 2, 1, 1, true);
    adicionaComponente(jtfLogradouro, 3, 2, 1, 1, true);
    adicionaComponente(jtfCep, 4, 2, 1, 1, true);
    // adicionaComponente(jtfEstado, 5, 2, 1, 1, true);
    adicionaComponente(jtfCpf, 1, 4, 1, 1, true);
    adicionaComponente(jtfEmail, 2, 4, 1, 1, true);
    adicionaComponente(jtfBairro, 3, 4, 1, 1, true);
    adicionaComponente(jtfCidade, 4, 4, 1, 1, true);

    habilitaCampos(false);
    pack();
    setSize(600, 375);
    setVisible(true);
  }

  @Override
  public boolean incluir() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean alterar() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean excluir() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean consultar() {
    // TODO Auto-generated method stub
    return false;
  }
}
