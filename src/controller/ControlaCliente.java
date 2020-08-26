/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author evand
 */
public class ControlaCliente {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> listarTodos() {
        return this.clientes;
    }

    public void salvar(Cliente c) {
        this.clientes.add(c);
    }

    public void remover(Cliente c) {
        this.clientes.remove(c);
    }

    public ArrayList<Cliente> listarPorNome(String criteria) {
        ArrayList<Cliente> retorno = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().contains(criteria)) {
                retorno.add(cliente);
            }
        }
        return retorno;
    }

    public void salvarArquivo() {
        //BufferedWriter bufferedWriter;
        String arquivo = "";
        try {
            arquivo = "src/clientes.txt";
            FileWriter fileWriter = new FileWriter(arquivo); //para não sobrescrever cada vez, passe um parametro true (append ~> true)
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cliente cliente : this.clientes) {
                bufferedWriter.write("Nome: "+cliente.getNome()+" Idade: "+cliente.getIdade()+" "
                        + "CPF: "+cliente.getCpf()+"\n");//escreve uma linha
            }
            bufferedWriter.close();           
        } catch (IOException e) {
            System.err.println("Não foi possível gravar em: " + arquivo);
        }

    }

    public void lerArquivo() {

    }

}
