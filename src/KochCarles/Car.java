package KochCarles;/*
 * Car.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.ArrayList;

public class Car implements Bookable {

	ArrayList<ReservationPeriod> reservationPeriods;
	public Car(ReservationPeriod... rps) {
		reservationPeriods = new ArrayList<>();
		for (ReservationPeriod rp : rps) {
			addReservationPeriod(rp);
		}
	}

	public boolean addReservationPeriod(ReservationPeriod r) {
		return reservationPeriods.add(r);
	}

    @Override
    public ArrayList<ReservationPeriod> getAvailablePeriods() {
        ArrayList<ReservationPeriod> avaiablePeriods = new ArrayList<>();
        for (ReservationPeriod reservationPeriod : reservationPeriods) {
            if (reservationPeriod.available) avaiablePeriods.add(reservationPeriod);
        }
        return avaiablePeriods;
    }

    @Override
    public Double book(DateTime start, DateTime end) {
        ArrayList<ReservationPeriod> rps = getAvailablePeriods();
        for (ReservationPeriod rp : rps) {
            if (rp.getStart().isBefore(start) && rp.getEnd().isAfter(end)) {
                rp.available = false;
                return new Period(start, end).getDays()*rp.price;
            }
        }
        return null;
    }
}
