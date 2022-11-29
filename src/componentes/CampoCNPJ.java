package componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class CampoCNPJ extends JFormattedTextField implements Componente {

  private String nome;
  private boolean obrigatorio;

  public CampoCNPJ(String nome, boolean obrigatorio) {
    try {
      this.nome = nome;
      this.obrigatorio = obrigatorio;
      adicionaFocusListener();
      MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
      mf.setPlaceholderCharacter('_');
      mf.install(this);
    } catch (Exception e) {
      e.printStackTrace();
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

  public void adicionaFocusListener() {
    Border bordaPadrao = getBorder();
    Color corPadrao = getBackground();
    addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent fe) {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setBackground(new Color(240, 240, 240));
      }

      @Override
      public void focusLost(FocusEvent fe) {
        setBorder(bordaPadrao);
        setBackground(corPadrao);
      }
    });
  }

  @Override
  public String getValor() {
    return getText();
  }

  @Override
  public boolean isVazio() {
    return getValor().equals("__.___.___/____-__");
  }

  @Override
  public boolean isValido() {
    return getValor().replace(".", "").replace("-", "")
        .replace("/", "").replace("_", "").length() == 11;
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
