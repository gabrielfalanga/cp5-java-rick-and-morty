package br.com.fiap.rickandmorty.test;

import br.com.fiap.rickandmorty.dao.PersonagemDao;
import br.com.fiap.rickandmorty.model.Personagem;

import java.util.List;
import java.util.Scanner;

public class TesteBuscarPorStatus {
    public static void main(String[] args) {
        PersonagemDao dao = new PersonagemDao();
        Scanner leitor = new Scanner(System.in);

        String status = "";
        do {
            System.out.println("Escolha um status para buscar os personagens do banco de dados");
            System.out.println("1- Alive");
            System.out.println("2- Dead");
            System.out.println("3- unknown");
            System.out.print("-> ");
            int opcao = leitor.nextInt();
            if (opcao == 1) {
                status = "Alive";
            } else if (opcao == 2) {
                status = "Dead";
            } else if (opcao == 3) {
                status = "unknown";
            }
        } while (status.isEmpty());

        List<Personagem> lista = dao.buscarPorStatus(status);
        lista.forEach(System.out::println);
    }
}
