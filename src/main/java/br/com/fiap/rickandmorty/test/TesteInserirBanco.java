package br.com.fiap.rickandmorty.test;

import br.com.fiap.rickandmorty.dao.PersonagemDao;
import br.com.fiap.rickandmorty.model.Personagem;
import br.com.fiap.rickandmorty.service.RickAndMortyService;

import java.util.Scanner;

public class TesteInserirBanco {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        RickAndMortyService api = new RickAndMortyService();
        PersonagemDao dao = new PersonagemDao();
        Personagem personagem;

        System.out.print("Digite o ID do personagem para buscar na API e inserir no banco:\n-> ");
        var id_per = leitor.nextInt();

        personagem = api.buscarPersonagemPorId(id_per);

        System.out.println(personagem);

        dao.insertPersonagem(personagem);
        System.out.println("Inserido com sucesso.");
    }
}
