package KochCarles;/*
 * Villa.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Villa extends Accommodation {

	public Villa(double cleaningCosts, short maxAllowedPeople, boolean petsAllowed, ReservationPeriod... rps) {
		super(cleaningCosts, maxAllowedPeople, petsAllowed);
		for (ReservationPeriod rp : rps) {
			addReservationPeriod(rp);
		}
	}
}
