package KochCarles;

import org.joda.time.DateTime;

import java.util.ArrayList;

/*
 * Bookable.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
/**
 * Interface to manage anything that can be booked
 */

public interface Bookable {

	/**
	 * 
	 * getter of available periods
	 * 
	 * @return 	a list of reservation periods and their prices
	 * 
	 */
	
	ArrayList<ReservationPeriod> getAvailablePeriods();
	
	
	/**
	 * 
	 * @param 	start
	 * @param 	end
	 * @return	the total price (in case of housing includes cleaning costs)
	 * 			null if part of the period is not available
	 */
	Double book(DateTime start, DateTime end);

    Double book(String start, String end);

}
