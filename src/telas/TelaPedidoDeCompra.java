package telas;

import componentes.CampoTexto;

public class TelaPedidoDeCompra extends TelaCadastro {
  private CampoTexto jtfCodigo = new CampoTexto("Código", 10, true);
  private CampoTexto jtfNome = new CampoTexto("Produto", 10, false);
  private CampoTexto jtfPreco = new CampoTexto("Preço", 10, false);
  private CampoTexto jtfDesconto = new CampoTexto("Desconto", 10, false);
  private CampoTexto jtfQtd = new CampoTexto("Quantidade", 10, true);
  private CampoTexto jtfTotal = new CampoTexto("Total", 10, false);
  private CampoTexto jtfTotalLiquido = new CampoTexto("Total Líquido", 10, false);

  public TelaPedidoDeCompra() {
    super("Pedido de Compra");

    jtfPreco.setEnabled(false);
    jtfNome.setEnabled(false);
    jtfTotal.setEnabled(false);
    jtfTotalLiquido.setEnabled(false);

    adicionaComponente(jtfCodigo, 1, 2, 1, 1, true);
    adicionaComponente(jtfNome, 1, 4, 1, 3, false);
    adicionaComponente(jtfQtd, 3, 4, 1, 1, true);
    adicionaComponente(jtfDesconto, 3, 2, 1, 1, true);
    adicionaComponente(jtfPreco, 4, 2, 1, 1, false);
    adicionaComponente(jtfTotal, 4, 4, 1, 1, false);
    adicionaComponente(jtfTotalLiquido, 5, 2, 1, 1, false);
    habilitaCampos(false);
    pack();
    setSize(600, 375);
    setVisible(true);
  }
}
