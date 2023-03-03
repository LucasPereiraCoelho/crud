package br.com.consultorio.entidades;

public class Endereco {
    
    private long id;
    private String cep;
    private String logradouro;
    private int numero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereços{" + " Id = " + id + ", CEP = " + cep + ", Logradouro = " + logradouro + ", Número = " + numero + '}';
    }
    
    
    
}
