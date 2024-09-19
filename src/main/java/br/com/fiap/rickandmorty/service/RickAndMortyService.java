package br.com.fiap.rickandmorty.service;

import br.com.fiap.rickandmorty.model.Personagem;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RickAndMortyService {

    /**
     * API Via Cep - https://rickandmortyapi.com/
     * Esta documentação ajudará você a se familiarizar com os recursos da API do Rick and Morty e mostrará como fazer
     * diferentes, consultas para que você possa aproveitar ao máximo.
     *
     * Exemplo de consulta de Personagem:
     *     rickandmortyapi.com/api/character/1
     * Saída
     * URL: https://rickandmortyapi.com/api/character/1
     *
     *     {
     *     "id": 1,
     *     "name": "Rick Sanchez",
     *     "status": "Alive",
     *     "species": "Human",
     *     "type": "",
     *     "gender": "Male",
     *     "origin": {
     *       "name": "Earth (C-137)"
     *          }
     *     }
     * */

    public Personagem buscarPersonagemPorId(int id) {
        Personagem personagem;

        try {
            String uri = "https://rickandmortyapi.com/api/character/" + id;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create(uri))
                                             .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            personagem = new Gson().fromJson(response.body(), Personagem.class);

            // pegando a response como objeto
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            // pegando o valor da chave "name" dentro da chave "origin"
            String nomeOrigem = jsonObject.getAsJsonObject("origin").get("name").getAsString();
            // definindo o atributo origem do personagem
            personagem.setOrigem(nomeOrigem);

            return personagem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
