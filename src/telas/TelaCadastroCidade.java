package telas;

import componentes.CampoTexto;
import componentes.CampoComboBox;
        
public class TelaCadastroCidade extends TelaCadastro {
    private CampoTexto jtfNome = new CampoTexto ("Nome", 20, true);
    private CampoComboBox jtfEstado = new CampoComboBox("Estado", new Object[][] { { 1, "PR" }, { 2, "MS" } },
      true);
    public TelaCadastroCidade() {
        super ("Cadastro de Cidade");
        adicionaComponente (jtfNome, 1, 2, 1, 1, true);
        adicionaComponente(jtfEstado, 5, 2, 1, 1, true);
      
        habilitaCampos(false);
    pack();
    setSize(600, 375);
    setVisible(true);
    }
}