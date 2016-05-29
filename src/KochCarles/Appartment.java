package KochCarles;/*
 * Appartment.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public abstract class Appartment extends Accommodation {
    double MIN_COST_DAY=0;

    public Appartment(double cleaningCosts, short maxAllowedPeople, boolean petsAllowed) {
        super(cleaningCosts, maxAllowedPeople, petsAllowed);
    }

    @Override
    public String toString() {
        return super.toString()+ ", MIN_COST_DAY="+MIN_COST_DAY+"\n";
    }

    @Override
    public void addReservationsPeriods(ReservationPeriod... rps) {
        for (ReservationPeriod rp : rps) {
            if (rp.price<MIN_COST_DAY) {
                System.err.println("El preu per dia no arriba al mínim així que s'ha actualitzat a "+MIN_COST_DAY);
                rp.price = MIN_COST_DAY;
            }
            addReservationPeriod(rp);
        }
    }
}
