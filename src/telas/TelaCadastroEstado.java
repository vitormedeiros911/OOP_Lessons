package telas;

import componentes.CampoTexto;

public class TelaCadastroEstado extends TelaCadastro {
    private CampoTexto jtfNome = new CampoTexto ("Nome", 20, true);
    private CampoTexto jtfUf = new CampoTexto ("sigla", 2, true);

public TelaCadastroEstado() {
    super ("Cadastro de Estado");
    adicionaComponente (jtfNome, 1, 2, 1, 1, true);
    adicionaComponente (jtfUf, 2, 2, 1, 1, true);
    
    habilitaCampos(false);
    pack();
    setSize(600, 375);
    setVisible(true);
}
}
