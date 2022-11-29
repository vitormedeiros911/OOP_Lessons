package telas;

import componentes.CampoComboBox;
import componentes.CampoTexto;

public class TelaCadastroProduto extends TelaCadastro {
  private CampoTexto jtfNome = new CampoTexto("Nome", 20, true);
  private CampoTexto jtfPreco = new CampoTexto("Preço", 10, true);
  private CampoTexto jtfPrecoCusto = new CampoTexto("Preço de custo", 10, true);
  private CampoTexto jtfCodigo = new CampoTexto("Código", 10, true);
  private CampoComboBox jtfFornecedor = new CampoComboBox("Fornecedor",
      new Object[][] { { 1, "Zézinho" }, { 2, "João" } },
      true);

  public TelaCadastroProduto() {
    super("Cadastro de Produto");
    adicionaComponente(jtfNome, 1, 2, 1, 3, true);
    adicionaComponente(jtfPreco, 2, 2, 1, 1, true);
    adicionaComponente(jtfPrecoCusto, 3, 2, 1, 1, true);
    adicionaComponente(jtfCodigo, 4, 2, 1, 1, true);
    adicionaComponente(jtfFornecedor, 5, 2, 1, 1, true);
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
