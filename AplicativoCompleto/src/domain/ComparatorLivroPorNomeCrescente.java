/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Comparator;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class ComparatorLivroPorNomeCrescente implements Comparator<Livro> {
    public int compare(Livro livro1, Livro livro2) {
        return livro1.getNome().compareTo(livro2.getNome());
    }
}
