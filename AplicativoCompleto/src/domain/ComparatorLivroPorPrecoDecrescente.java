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
public class ComparatorLivroPorPrecoDecrescente implements Comparator<Livro> {
    public int compare(Livro livro1, Livro livro2) {
        return (-1) * Double.compare(livro1.getPreco(), livro2.getPreco());
    }

}
