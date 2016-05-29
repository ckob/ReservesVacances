package KochCarles;
/*
 * Car.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

import org.joda.time.DateTime;
import org.joda.time.Days;
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
        id=Agency.lastID++;
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
            if ((rp.getStart().isBefore(start)||rp.getStart().equals(start)) && (rp.getEnd().isAfter(end)||rp.getEnd().equals(end))) {

                if (Days.daysBetween(rp.getStart(), start).getDays()>0) { // Si hi ha un dia o mes
                    // entre el start inicial del ReservationPeriod i el d'ara, creem un nou ReservationPeriod
                    reservationPeriods.add(new ReservationPeriod(rp.getStart(), start.minusDays(1), rp.price, true));
                }
                //System.out.println("days:"+new Period(end, rp.getEnd()).getDays()); <-- No funciona! dona 0 dies!! Lo d'abaix (amb Days) si que funciona correctament
                //System.out.println("days:"+Days.daysBetween(end, rp.getEnd()).getDays());
                if (Days.daysBetween(end, rp.getEnd()).getDays()>0) {
                    reservationPeriods.add(new ReservationPeriod(end.plusDays(1), rp.getEnd(), rp.price, true));
                }
                rp.available =false;
                rp.setStart(start);
                rp.setEnd(end);

                return Days.daysBetween(start, end).getDays()*rp.price;
            }
        }
        System.err.println("Ningun "+this.getClass().getSimpleName()+" disponible para estas fechas.");
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
        return  "id=" + id +
                ", \nreservationPeriods{\n" + (rPs.isEmpty()?"No hi ha ningun periode de reserva disponible":rPs)+"}"+
                ", MIN_COST_DAY=" + MIN_COST_DAY+"\n";
    }
}
