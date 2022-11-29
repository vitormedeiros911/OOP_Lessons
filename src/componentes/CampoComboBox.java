package componentes;

import javax.swing.JComboBox;

public class CampoComboBox extends JComboBox implements Componente {
  private String nome;
  private boolean obrigatorio;
  private Object[][] opcoes;

  public CampoComboBox(String nome, Object[][] opcoes, boolean obrigatorio) {
    this.nome = nome;
    this.obrigatorio = obrigatorio;
    this.opcoes = opcoes;
    adicionaOpcoes();
  }

  public void adicionaOpcoes() {
    addItem("Selecione...");
    for (Object[] opcao : opcoes) {
      addItem(opcao[1]);
    }
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public boolean isObrigatorio() {
    return obrigatorio;
  }

  @Override
  public String getValor() {
    if (getSelectedIndex() == 0) {
      return "";
    } else {
      return "" + opcoes[getSelectedIndex() - 1][0];
    }
  }

  @Override
  public boolean isVazio() {
    return getSelectedIndex() <= 0;
  }

  @Override
  public boolean isValido() {
    return true;
  }

  @Override
  public void setValor(Object valor) {
    // TODO Auto-generated method stub

  }

  @Override
  public void limpar() {
    // TODO Auto-generated method stub

  }
}
