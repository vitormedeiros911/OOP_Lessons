package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {
  public static JDesktopPane jdp = new JDesktopPane();
  private JMenuBar jmb = new JMenuBar();
  private JMenu jmCadastros = new JMenu("Cadastros");
  private JMenu jmMovimentos = new JMenu("Movimentos");

  private JMenuItem jmiCliente = new JMenuItem("Cliente");
  private JMenuItem jmiFornecedor = new JMenuItem("Fornecedor");
  private JMenuItem jmiProduto = new JMenuItem("Produto");
  private JMenuItem jmiPedidoDeCompra = new JMenuItem("Pedido de Compra");

  public TelaSistema(String titulo) {
    setTitle(titulo);

    getContentPane().add(jdp);
    jdp.setBackground(Color.LIGHT_GRAY);

    setJMenuBar(jmb);
    jmb.add(jmCadastros);
    jmb.add(jmMovimentos);

    adicionarItemMenu(jmCadastros, jmiCliente);
    adicionarItemMenu(jmCadastros, jmiFornecedor);
    adicionarItemMenu(jmCadastros, jmiProduto);
    adicionarItemMenu(jmMovimentos, jmiPedidoDeCompra);

    setExtendedState(MAXIMIZED_BOTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void adicionarItemMenu(JMenu menu, JMenuItem itemMenu) {
    menu.add(itemMenu);
    itemMenu.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jmiCliente) {
      TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
      jdp.add(telaCadastroCliente);
    } else if (ae.getSource() == jmiFornecedor) {
      TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor();
      jdp.add(telaCadastroFornecedor);
    } else if (ae.getSource() == jmiProduto) {
      TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
      jdp.add(telaCadastroProduto);
    } else if (ae.getSource() == jmiPedidoDeCompra) {
      TelaPedidoDeCompra telaPedidoDeCompra = new TelaPedidoDeCompra();
      jdp.add(telaPedidoDeCompra);
    }
  }
}
