package Dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.Cidade;

public class CidadeDao {
    public final String SQL_INCLUIR = "INSERT INTO CIDADE VALUES (?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE CIDADE SET NOME_CIDADE = ?, ID_ESTADO = ?, WHERE ID_CIDADE = ?";
    public final String SQL_EXCLUIR = "DELETE FROM CIDADE WHERE ID_CIDADE = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM CIDADE WHERE ID_CIDADE = ?";
    public static final String SQL_PESQUISAR = "SELECT ID_CIDADE, NOME_CIDADE, SIGLA_ESTADO FROM CIDADE JOIN ESTADO ON CIDADE.ID_ESTADO = ESTADO.ID_ESTADO ORDER BY NOME_CIDADE";
    
    public boolean incluir(Cidade cidade) {
        try {
            cidade.setId_cidade(Conexao.getGenerator("G_CIDADE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cidade.getId_cidade());
            ps.setString(2, cidade.getNome_cidade());
            ps.setInt(3, cidade.getId_estado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a Cidade.");
            return false;
        }
    }
    
    public boolean alterar(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, cidade.getNome_cidade());
            ps.setInt(2, cidade.getId_estado());
            ps.setInt(3, cidade.getId_cidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a Cidade.");
            return false;
        }
    }
    public boolean excluir(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cidade.getId_cidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a Cidade.");
            return false;
        }
    }
    public boolean consultar(Cidade cidade) {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cidade.getId_cidade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cidade.setNome_cidade(rs.getString("NOME_CIDADE"));
                cidade.setId_estado(rs.getInt("ID_ESTADO"));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar a Cidade.");
            return false;
        }
    }
}
