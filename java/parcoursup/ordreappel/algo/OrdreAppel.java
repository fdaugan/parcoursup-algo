
/* Copyright 2018, 2018 Hugo Gimbert (hugo.gimbert@enseignementsup.gouv.fr) 

    This file is part of Algorithmes-de-parcoursup.

    Algorithmes-de-parcoursup is free software: you can redistribute it and/or modify
    it under the terms of the Affero GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Algorithmes-de-parcoursup is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    Affero GNU General Public License for more details.

    You should have received a copy of the Affero GNU General Public License
    along with Algorithmes-de-parcoursup.  If not, see <http://www.gnu.org/licenses/>.

 */
package parcoursup.ordreappel.algo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gimbert
 */
public class OrdreAppel {

    /* la liste des voeux, dans l'ordre d'appel */
    public List<VoeuClasse> voeux = new LinkedList<>();

    /* calcule une mesure de la différence entre le classement original et l'ordre d'appel: 
    le nombre d'inversions ramené au nombre maximal d'inversions.
    Le nombre maximal d'inversions est obtenu si le classement est totalement inversé
    (cas hypothétique), auquel cas il y a autant d'inversions que de paires non-ordonnées 
    de candidat c'est-à-dire n * (n - 1) / 2.
     */
    public double coefficientDivergence() {

        if (voeux.size() <= 1) {
            return 0.0f;
        }

        /* calcul du coefficient de divergence */
        int nbInversions = 0;
        for (VoeuClasse voe1 : voeux) {
            for (VoeuClasse voe2 : voeux) {
                if (voe2 == voe1) {
                    break;
                }
                if (voe2.rang > voe1.rang) {
                    nbInversions++;
                }
            }
        }

        return (2.0f * nbInversions)
                / (voeux.size() * (voeux.size() - 1));

    }
}
