package br.com.fiap.rickandmorty.test;

import br.com.fiap.rickandmorty.dao.PersonagemDao;
import br.com.fiap.rickandmorty.model.Personagem;

import java.util.Scanner;

public class TesteBuscarPorId {
    public static void main(String[] args) {
        PersonagemDao dao = new PersonagemDao();
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o ID para buscar no banco de dados:\n-> ");
        int id_per = leitor.nextInt();

        Personagem personagem = dao.buscarPorId(id_per);
        System.out.println(personagem);
    }
}
