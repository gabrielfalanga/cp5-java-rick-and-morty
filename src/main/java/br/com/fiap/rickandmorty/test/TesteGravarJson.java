package br.com.fiap.rickandmorty.test;

import br.com.fiap.rickandmorty.json.ManipuladorJson;
import br.com.fiap.rickandmorty.model.Personagem;
import br.com.fiap.rickandmorty.service.RickAndMortyService;

import java.util.Scanner;


public class TesteGravarJson {
    // Gabriel Martins Falanga     RM: 555061
    // Guilherme Romanholi Santos  RM: 557462

    public static void main(String[] args) {
        RickAndMortyService service = new RickAndMortyService();
        ManipuladorJson manipuladorJson = new ManipuladorJson();
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o id do personagem -> ");
        int id_personagem = leitor.nextInt();

        Personagem personagem = service.buscarPersonagemPorId(id_personagem);
        System.out.println("\n" + personagem);

        manipuladorJson.gravarJson(personagem);
    }
}
