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
public class ComparatorFilmePorGeneroCrescente implements Comparator<Livro> {
    public int compare(Livro o1, Livro o2) {
        return o1.getGenero().compareTo(o2.getGenero());
    }

}
