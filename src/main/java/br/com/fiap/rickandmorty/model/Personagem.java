package br.com.fiap.rickandmorty.model;

import com.google.gson.annotations.SerializedName;

public class Personagem {
    private int id;

    @SerializedName("name")
    private String nome;

    private String status;

    @SerializedName("gender")
    private String genero;

    @SerializedName("species")
    private String especie;

    private String origem;

    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Status: " + status + "\n" +
                "Gênero: " + genero + "\n" +
                "Espécie: " + especie + "\n" +
                "Origem: " + origem + "\n";
    }
}
