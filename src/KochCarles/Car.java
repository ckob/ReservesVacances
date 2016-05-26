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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Car implements Bookable {
    double MIN_COST_DAY=15;
    int id;

	ArrayList<ReservationPeriod> reservationPeriods;
	public Car(ReservationPeriod... rps) {
		reservationPeriods = new ArrayList<>();
        addReservationsPeriods(rps);
        id=Accommodation.lastID++;
	}

	private boolean addReservationPeriod(ReservationPeriod r) {
		return reservationPeriods.add(r);
	}

    private void addReservationsPeriods(ReservationPeriod... rps) {
        for (ReservationPeriod rp : rps) {
            if (rp.price<MIN_COST_DAY) {
                System.err.println("El preu per dia no arriba al mínim així que s'ha actualitzat a "+MIN_COST_DAY);
                rp.price = MIN_COST_DAY;
            }
            addReservationPeriod(rp);
        }
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
                rp.available =false;
                return new Period(start, end).getDays()*rp.price;
            }
        }
        return null;
    }

    public Double book(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return book(formatter.parseDateTime(start), formatter.parseDateTime(end));
    }

    @Override
    public String toString() {
        String rPs="";
        for (ReservationPeriod reservationPeriod : reservationPeriods) {
            rPs+=reservationPeriod.toString()+"\n";
        }
        return "Car{" +
                ", id=" + id +
                ", \nreservationPeriods{\n" + (rPs.isEmpty()?"No hi ha ningun periode de reserva disponible":rPs)+"}"+
                ", MIN_COST_DAY=" + MIN_COST_DAY;

    }
}
