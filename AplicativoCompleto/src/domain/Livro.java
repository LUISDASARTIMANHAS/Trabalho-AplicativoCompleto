/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;


/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Livro implements Serializable {
    private String codigo, nome, genero, editora, datacompra;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

}
