package br.com.fiap.rickandmorty.json;

import br.com.fiap.rickandmorty.model.Personagem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorJson {

    public void gravarJson(Personagem personagem) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("src/main/java/br/com/fiap/rickandmorty/personagem.json")) {
            gson.toJson(personagem, writer);
            System.out.println("Arquivo Json escrito com sucesso!");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo" + e.getMessage());
        }
    }
}
