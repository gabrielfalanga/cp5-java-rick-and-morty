package br.com.fiap.rickandmorty.dao;

import br.com.fiap.rickandmorty.model.Personagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDao {
    private Connection conexao;

    private static void montarPersonagemComResultSet(Personagem personagem, ResultSet rs) {
        try {
            personagem.setId(rs.getInt("id_per"));
            personagem.setNome(rs.getString("nome"));
            personagem.setStatus(rs.getString("status"));
            personagem.setGenero(rs.getString("genero"));
            personagem.setEspecie(rs.getString("especie"));
            personagem.setOrigem(rs.getString("origem"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Personagem> listarTodos() {
        Connection conexao = ConnectionFactory.obterConexao();
        List<Personagem> listaPersonagens = new ArrayList<>();
        PreparedStatement comandoSQL;

        try {
            String sql = "SELECT * FROM personagem";
            comandoSQL = conexao.prepareStatement(sql);
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Personagem personagem = new Personagem();
                montarPersonagemComResultSet(personagem, rs);
                listaPersonagens.add(personagem);
            }
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPersonagens;
    }

    public void insertPersonagem(Personagem personagem) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL;

        try {
            String sql = "INSERT INTO personagem VALUES (?, ?, ?, ?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, personagem.getId());
            comandoSQL.setString(2, personagem.getNome());
            comandoSQL.setString(3, personagem.getStatus());
            comandoSQL.setString(4, personagem.getGenero());
            comandoSQL.setString(5, personagem.getEspecie());
            comandoSQL.setString(6, personagem.getOrigem());

            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Personagem buscarPorId(int id) {
        Connection conexao = ConnectionFactory.obterConexao();
        Personagem personagem = new Personagem();
        PreparedStatement comandoSQL;

        try {
            String sql = "SELECT * FROM personagem WHERE id_per = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs.next()) {
                montarPersonagemComResultSet(personagem, rs);
            } else {
                System.out.println("Nenhum personagem cadastrado com o ID " + id);
            }
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personagem;
    }

    public List<Personagem> buscarPorStatus(String status) {
        Connection conexao = ConnectionFactory.obterConexao();
        List<Personagem> listaPersonagens = new ArrayList<>();
        PreparedStatement comandoSQL;

        try {
            String sql = "SELECT * FROM personagem WHERE status = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, status);

            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Personagem personagem = new Personagem();
                montarPersonagemComResultSet(personagem, rs);
                listaPersonagens.add(personagem);
            }

            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPersonagens;
    }
}
