package componentes;

import java.util.regex.Pattern;

public class CampoEmail extends CampoTexto {

  public CampoEmail(String nome, int tamanho, boolean obrigatorio) {
    super(nome, tamanho, obrigatorio);
  }

  @Override
  public boolean isValido() {
    return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(getValor())
        .find();
  }
}
