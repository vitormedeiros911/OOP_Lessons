package componentes;

public interface Componente {
  public String getNome();

  public boolean isObrigatorio();

  public boolean isVazio();

  public String getValor();

  public boolean isValido();
}
