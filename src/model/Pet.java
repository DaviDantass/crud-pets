package model;

public class Pet {
    private Long id;
    private String nome;
    private String tipo;

    public Pet(){}
    public Pet(Long id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Pet id: " + id + " Nome: " + nome + " Tipo: " + tipo;
    }
}
