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
public class ComparatorLivroPorCodigoDecrescente implements Comparator<Livro> {
    public int compare(Livro o1, Livro o2) {
        return (-1) * o1.getCodigo().compareTo(o2.getCodigo());
    }

}
