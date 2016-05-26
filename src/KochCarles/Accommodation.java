package KochCarles;/*
 * Accommodation.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

// allotjament

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Accommodation implements BookableHousing {
    static int lastID=1;
    int id;
	double cleaningCosts;
	short maxAllowedPeople;
	boolean petsAllowed;

	ArrayList <ReservationPeriod> reservationPeriods;

    @Override
    public String toString() {
        String rPs="";
        for (ReservationPeriod reservationPeriod : reservationPeriods) {
            rPs+=reservationPeriod.toString()+"\n";
        }
        return "id=" + id +
                ", cleaningCosts=" + cleaningCosts +
                ", maxAllowedPeople=" + maxAllowedPeople +
                ", petsAllowed=" + petsAllowed +
                ", \nreservationPeriods{\n" + (rPs.isEmpty()?"No hi ha ningun periode de reserva disponible":rPs)+"}";
    }

    public Accommodation(double cleaningCosts, short maxAllowedPeople, boolean petsAllowed) {
		this.id=lastID++;
        this.cleaningCosts=cleaningCosts;
		this.maxAllowedPeople=maxAllowedPeople;
		this.petsAllowed=petsAllowed;
		reservationPeriods = new ArrayList<>();
	}

	@Override
	public ArrayList<ReservationPeriod> getAvailablePeriods() {
        ArrayList<ReservationPeriod> avaiablePeriods = new ArrayList<>();
        for (ReservationPeriod reservationPeriod : reservationPeriods) {
            if (reservationPeriod.available) avaiablePeriods.add(reservationPeriod);
        }
        return avaiablePeriods;
	}
    /**
     *
     * cleaning costs are paid once per period
     *
     * @return	the amount
     */

    public double getCleaningCosts() {
        return cleaningCosts;
    }

    /**
     *
     * the number of maximum allowed people
     *
     * @return	the number of people
     */
    public short getMaxAllowedPeople() {
        return maxAllowedPeople;
    }

    /**
     *
     * @return if dogs, cats, etc are allowed
     */
    public boolean petsAllowed() {
        return petsAllowed;
    }


    public boolean addReservationPeriod(ReservationPeriod r) {
        return reservationPeriods.add(r);
    }

    public void addReservationsPeriods(ReservationPeriod... rps) {
        Collections.addAll(reservationPeriods, rps);
    }

    /**
     *
     * @param 	start
     * @param 	end
     * @return	the total price (in case of housing includes cleaning costs)
     * 			null if part of the period is not available
     */
    @Override
    public Double book(DateTime start, DateTime end) {
        ArrayList<ReservationPeriod> rps = getAvailablePeriods();
        for (ReservationPeriod rp : rps) {
            if (rp.getStart().isBefore(start) && rp.getEnd().isAfter(end)) {
                rp.available = false;
                return new Period(start, end).getDays()*rp.price+cleaningCosts;
            }
        }
        System.err.println("Ningun "+this.getClass().getSimpleName()+" disponible para estas fechas.");
        return null;
    }

    public Double book(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return book(formatter.parseDateTime(start), formatter.parseDateTime(end));
    }
}
