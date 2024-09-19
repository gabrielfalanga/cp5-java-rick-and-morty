package br.com.fiap.rickandmorty.service;

import br.com.fiap.rickandmorty.model.Personagem;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RickAndMortyService {

    public Personagem buscarPersonagemPorId(int id) {
        Personagem personagem = new Personagem();
        personagem.setId(id);

        try {
            String uri = "https://rickandmortyapi.com/api/character/" + id;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create(uri))
                                             .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Personagem.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
