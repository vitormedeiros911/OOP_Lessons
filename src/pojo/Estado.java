package pojo;

public class Estado {
    private int id_estado;
    private String nome_estado;
    private String uf_estado;
    
    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int idEstado) {
        this.id_estado = idEstado;
    }

    public String getNomeEstado() {
        return nome_estado;
    }

    public void setNome_estado(String nomeEstado) {
        this.nome_estado = nomeEstado;
    }

    public String getUf_estado() {
        return uf_estado;
    }

    public void setUf_estado(String siglaEstado) {
        this.uf_estado = siglaEstado;
    }
}
