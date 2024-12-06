/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ComparatorLivroPorCodigoCrescente;
import domain.ComparatorLivroPorCodigoDecrescente;
import domain.ComparatorLivroPorGeneroCrescente;
import domain.ComparatorLivroPorGeneroDecrescente;
import domain.ComparatorLivroPorNomeCrescente;
import domain.ComparatorLivroPorNomeDecrescente;
import domain.Livro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class LivroFileDao {

    public void salvarLivros(Vector<Livro> livros) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream arquivo = new FileOutputStream(LivroFileInformation.getCaminhoArquivo() + LivroFileInformation.getNomeArquivo());

        //Classe responsavel por inserir os objetos
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);

        //Grava o objeto de vetor de livros no arquivo
        objGravar.writeObject(livros);
        objGravar.flush();
        objGravar.close();
        arquivo.flush();
        arquivo.close();
    }

    private boolean estaArquivoVazio() throws FileNotFoundException, IOException {
        //Carrega o arquivo
        String local_arquivo = LivroFileInformation.getCaminhoArquivo() + LivroFileInformation.getNomeArquivo();
        FileInputStream arquivoLeitura = new FileInputStream(local_arquivo);
        boolean estaVazio = (arquivoLeitura.read() == -1);
        arquivoLeitura.close();
        return estaVazio;
    }

    public Vector<Livro> obterLivros() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Carrega o arquivo
        if (estaArquivoVazio()) {
            return new Vector();
        } else {
            //Classe responsavel por recuperar os objetos do arquivo
            String local_arquivo = LivroFileInformation.getCaminhoArquivo() + LivroFileInformation.getNomeArquivo();
            FileInputStream arquivoLeitura = new FileInputStream(local_arquivo);
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            Vector<Livro> vetor = (Vector<Livro>) objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
            return vetor;
        }
    }

   
    public Vector<Livro> obterLivros(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException {
        Vector<Livro> livros = this.obterLivros();
        if (coluna.equals("codigo")){
            if (crescente) Collections.sort(livros, new ComparatorLivroPorCodigoCrescente());
            else Collections.sort(livros, new ComparatorLivroPorCodigoDecrescente());
        }
        else if (coluna.equals("nome")){
            if (crescente) Collections.sort(livros, new ComparatorLivroPorNomeCrescente());
            else Collections.sort(livros, new ComparatorLivroPorNomeDecrescente());
        }
        else if (coluna.equals("genero")){
            if (crescente) Collections.sort(livros, new ComparatorLivroPorGeneroCrescente());
            else Collections.sort(livros, new ComparatorLivroPorGeneroDecrescente());
        }
        else if (coluna.equals("editora")){
            // Exercício - o aluno deve terminar
        }
        else if (coluna.equals("datacompra")){
            // Exercício - o aluno deve terminar
        }
        return livros;
    }
}
