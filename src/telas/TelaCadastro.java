package telas;

import componentes.Componente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class TelaCadastro extends JInternalFrame implements ActionListener {
  protected final int PADRAO = 0;
  protected final int INCLUINDO = 1;
  protected final int ALTERANDO = 2;
  protected final int EXCLUINDO = 3;
  protected final int CONSULTANDO = 4;
  protected int estadoTela = PADRAO;
  private boolean temDadosNaTela = false;
  protected JPanel painelComponentes = new JPanel();
  private JPanel painelBotoes = new JPanel();
  private JButton jbIncluir = new JButton("Incluir");
  private JButton jbAlterar = new JButton("Alterar");
  private JButton jbExcluir = new JButton("Excluir");
  private JButton jbConsultar = new JButton("Consultar");
  private JButton jbConfirmar = new JButton("Confirmar");
  private JButton jbCancelar = new JButton("Cancelar");
  private int qtdeLinhas, qtdeColunas;
  private List<Componente> campos = new ArrayList<>();

  public TelaCadastro(String titulo) {
    super(titulo, true, true, true, true);
    setSize(600, 600);
    getContentPane().add("West", painelComponentes);
    getContentPane().add("South", painelBotoes);

    painelComponentes.setLayout(new GridBagLayout());
    painelBotoes.setLayout(new GridLayout(1, 6));

    painelBotoes.add(jbIncluir);
    painelBotoes.add(jbAlterar);
    painelBotoes.add(jbExcluir);
    painelBotoes.add(jbConsultar);
    painelBotoes.add(jbConfirmar);
    painelBotoes.add(jbCancelar);

    jbIncluir.addActionListener(this);
    jbAlterar.addActionListener(this);
    jbExcluir.addActionListener(this);
    jbConsultar.addActionListener(this);
    jbConfirmar.addActionListener(this);
    jbCancelar.addActionListener(this);

    habilitaBotoes();
  }

  public void adicionaComponente(Componente componente, int linha, int coluna, int linhas, int colunas,
      boolean habilitar) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridy = linha;
    gbc.gridx = coluna;
    gbc.gridheight = linhas;
    gbc.gridwidth = colunas;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(5, 5, 5, 5);
    String textoLabel = "<html><body>" + componente.getNome();

    if (componente.isObrigatorio()) {
      textoLabel = textoLabel + "<font color=red>*</font>";
    }
    textoLabel = textoLabel + ": </body></html>";
    JLabel jl = new JLabel(textoLabel);
    painelComponentes.add(jl, gbc);
    gbc.gridx++;
    painelComponentes.add((JComponent) componente, gbc);

    int l, c;
    l = linha + (linhas - 1);
    c = coluna + (colunas - 1);

    if (qtdeLinhas < l) {
      qtdeLinhas = l;
    }

    if (qtdeColunas < c) {
      qtdeColunas = c;
    }

    if (habilitar)
      campos.add(componente);
  }

  public void habilitaBotoes() {
    jbIncluir.setEnabled(estadoTela == PADRAO);
    jbAlterar.setEnabled(estadoTela == PADRAO && temDadosNaTela);
    jbExcluir.setEnabled(estadoTela == PADRAO && temDadosNaTela);
    jbConsultar.setEnabled(estadoTela == PADRAO);
    jbConfirmar.setEnabled(estadoTela != PADRAO);
    jbCancelar.setEnabled(estadoTela != PADRAO);
  }

  public void habilitaCampos(boolean status) {
    for (Componente campo : campos) {
      ((JComponent) campo).setEnabled(status);
    }

    if (status == true && campos.size() > 0) {
      ((JComponent) campos.get(0)).requestFocus();
    }
  }

  public void limpaCampos() {
    for (Componente campo : campos) {
      campo.limpar();
    }
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == jbIncluir) {
      estadoTela = INCLUINDO;
      limpaCampos();
      habilitaCampos(true);
    } else if (ae.getSource() == jbAlterar) {
      estadoTela = ALTERANDO;
      habilitaCampos(true);
    } else if (ae.getSource() == jbExcluir) {
      estadoTela = EXCLUINDO;
    } else if (ae.getSource() == jbConsultar) {
      estadoTela = CONSULTANDO;
      consultar();
    } else if (ae.getSource() == jbConfirmar) {
      if (validaCampos()) {
        if (estadoTela == INCLUINDO) {
          if (incluir() == true) {
            habilitaCampos(false);
            estadoTela = PADRAO;
            temDadosNaTela = true;
          }
        } else if (estadoTela == ALTERANDO) {
          if (alterar() == true) {
            habilitaCampos(false);
            estadoTela = PADRAO;
            temDadosNaTela = true;
          }
        } else if (estadoTela == EXCLUINDO) {
          if (excluir() == true) {
            habilitaCampos(false);
            limpaCampos();
            estadoTela = PADRAO;
            temDadosNaTela = true;
          }
        }
      }
    } else if (ae.getSource() == jbCancelar) {
      estadoTela = PADRAO;
      habilitaCampos(false);
    }
    habilitaBotoes();
  }

  public boolean validaCampos() {
    String errosObrigatorio = "";
    String errosValido = "";
    for (Componente campo : campos) {
      if (campo.isObrigatorio() && campo.isVazio()) {
        errosObrigatorio += campo.getNome() + "\n";
      } else {
        if (!campo.isValido()) {
          errosValido += campo.getNome() + "\n";
        }
      }
    }

    if (!errosObrigatorio.isEmpty()) {
      errosObrigatorio = "Os campos abaixo são obrigatórios\n"
          + "e não foram preenchidos:\n\n" + errosObrigatorio;
      JOptionPane.showMessageDialog(null, errosObrigatorio);
    }

    if (!errosValido.isEmpty()) {
      errosValido = "Os campos abaixo estão inválidos:\n\n"
          + errosValido;
      JOptionPane.showMessageDialog(null, errosValido);
    }

    if (errosObrigatorio.isEmpty() && errosValido.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public void preencherDados(int pk) {
    estadoTela = PADRAO;
    temDadosNaTela = true;
    habilitaBotoes();
  }

  abstract public boolean incluir();

  abstract public boolean alterar();

  abstract public boolean excluir();

  abstract public boolean consultar();
}
