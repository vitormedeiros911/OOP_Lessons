package telas;

import bd.Conexao;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaConsulta extends JInternalFrame implements MouseListener {
  private TelaCadastro telaChamadora;
  private DefaultTableModel dtm = new DefaultTableModel();
  private JTable tabela = new JTable(dtm) {
    @Override
    public boolean isCellEditable(int linha, int coluna) {
      return false;
    }
  };
  private JScrollPane jsp = new JScrollPane(tabela);

  public TelaConsulta(TelaCadastro telaChamadora, String titulo, String[] colunas, String sql) {
    super(titulo);
    this.telaChamadora = telaChamadora;
    tabela.getTableHeader().setReorderingAllowed(false);
    insereColunas(colunas);
    insereDados(sql);
    if (dtm.getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "Não existem dados cadastrados.");
      return;
    }
    getContentPane().add(jsp);
    pack();
    setVisible(true);
    TelaSistema.jdp.add(this);
    TelaSistema.jdp.moveToFront(this);
    tabela.addMouseListener(this);
  }

  public void insereColunas(String[] colunas) {
    for (int i = 0; i < colunas.length; i++) {
      dtm.addColumn(colunas[i]);
    }
  }

  public void insereDados(String sql) {
    List<List<String>> dados = Conexao.executaQuery(sql);
    for (int i = 0; i < dados.size(); i++) {
      dtm.addRow(dados.get(i).toArray());
    }
  }

  @Override
  public void mouseClicked(MouseEvent me) {
    if (me.getClickCount() == 2) {
      telaChamadora.preencherDados(Integer.parseInt((String) dtm.getValueAt(tabela.getSelectedRow(), 0)));
      dispose();
      TelaSistema.jdp.remove(this);
    }
  }

  @Override
  public void mousePressed(MouseEvent me) {
  }

  @Override
  public void mouseReleased(MouseEvent me) {
  }

  @Override
  public void mouseEntered(MouseEvent me) {
  }

  @Override
  public void mouseExited(MouseEvent me) {
  }
}
