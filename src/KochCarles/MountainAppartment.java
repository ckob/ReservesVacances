package KochCarles;/*
 * MountainAppartment.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class MountainAppartment extends Appartment {

	public MountainAppartment(double cleaningCosts, short maxAllowedPeople, boolean petsAllowed, ReservationPeriod... rps) {
        super(cleaningCosts, maxAllowedPeople, petsAllowed); // 35 el preu preu minim per dia
        MIN_COST_DAY=15;
        addReservationsPeriods(rps);
	}
}
