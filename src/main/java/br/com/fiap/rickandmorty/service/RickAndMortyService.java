package br.com.fiap.rickandmorty.service;

import br.com.fiap.rickandmorty.model.Personagem;

import java.net.http.HttpClient;

public class RickAndMortyService {

    public Personagem buscarPersonagemPorId(int id) {
        Personagem personagem = new Personagem();
        personagem.setId(id);

        try {
            String uri = "https://rickandmortyapi.com/api/character/" + id;
            HttpClient client = HttpClient.newHttpClient();
            HttpClient
        }
    }
}
