package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.Estado;

public class EstadoDao {
    public final String SQL_INCLUIR = "INSERT INTO ESTADO VALUES (?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ESTADO SET NOME_ESTADO = ?, SIGLA_ESTADO = ?, WHERE ID_ESTADO = ?";
    public final String SQL_EXCLUIR = "DELETE FROM ESTADO WHERE ID_ESTADO = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ESTADO WHERE ID_ESTADO = ?";
    public final static String SQL_PESQUISAR = "SELECT * FROM ESTADO ORDER BY NOME_ESTADO";
    public final static String SQL_COMBOBOX = "SELECT ID_ESTADO, NOME_ESTADO || '-' || SIGLA_ESTADO FROM ESTADO ORDER BY NOME_ESTADO";
    
    public boolean incluir(Estado estado) {
        try {
            estado.setId_estado(Conexao.getGenerator("G_ESTADO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, estado.getId_estado());
            ps.setString(2, estado.getNome_estado());
            ps.setString(3, estado.getUf_estado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o Estado.");
            return false;
        }
    }
    
    public boolean alterar(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, estado.getNomeEstado());
            ps.setString(2, estado.getUf_estado());
            ps.setInt(3, estado.getId_estado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Estado.");
            return false;
        }
    }
    
    public boolean excluir(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, estado.getId_estado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Estado.");
            return false;
        }
    }
    
    public boolean consultar(Estado estado) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, estado.getId_estado());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado.setNome_estado(rs.getString("NOME_ESTADO"));
                estado.setUf_estado(rs.getString("SIGLA_ESTADO"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Estado.");
            return false;
        }
    }
}
