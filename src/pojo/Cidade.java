package pojo;

public class Cidade {
    private int id_cidade;
    private String nome_cidade;
    private int id_estado;
    
    public int getId_cidade() {
        return id_cidade;
    }
    
    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
    
    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nomeCidade) {
        this.nome_cidade = nomeCidade;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int idEstado) {
        this.id_estado = id_estado;
    }
}