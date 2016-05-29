package KochCarles;/*
 * BeachAppartment.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class BeachAppartment extends Appartment {

	public BeachAppartment(double cleaningCosts, short maxAllowedPeople, boolean petsAllowed, ReservationPeriod... rps) {
		super(cleaningCosts, maxAllowedPeople, petsAllowed);
        MIN_COST_DAY=20;
        addReservationsPeriods(rps);
	}
}
