package KochCarles;/*
 * ReservationPeriod.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 *
 * This class is useful to express for each period
 * 
 *  if the accommodation is available or not
 *
 */

import org.joda.time.DateTime;

public class ReservationPeriod {

	// start and end of a reservations
	DateTime start,end;
	Double price;
	Boolean available;

	public ReservationPeriod(DateTime start,DateTime end,Double price,Boolean available) {
		this.start=start;
		this.end=end;
		this.price=price;
		this.available=available;
	}

	/**
	 * @return the start
	 */
	public DateTime getStart() {
		return start;
	}

	/**
	 * @return the end
	 */
	public DateTime getEnd() {
		return end;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @return if available
	 */
	public Boolean getAvailable() {
		return available;
	}

	@Override
	public String toString() {
		return "ReservationPeriod{" +
				"start=" + start +
				", end=" + end +
				", price=" + price +
				", available=" + available +
				'}';
	}
}
