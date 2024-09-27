package br.com.fiap.rickandmorty.test;

import br.com.fiap.rickandmorty.dao.PersonagemDao;
import br.com.fiap.rickandmorty.model.Personagem;

import java.util.List;

public class TesteListarBanco {
    public static void main(String[] args) {
        PersonagemDao dao = new PersonagemDao();
        List<Personagem> lista = dao.listarTodos();
        lista.forEach(System.out::println);
    }
}
