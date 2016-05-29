package KochCarles;/*
 * ReservationPeriod.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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

    public ReservationPeriod(String start, String end, Double price, Boolean available) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        this.start=formatter.parseDateTime(start);
        this.end=formatter.parseDateTime(end);
        this.price=price;
        this.available=available;
    }

	/**
	 * @return the start
	 */
	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start=start;
	}

	/**
	 * @return the end
	 */
	public DateTime getEnd() {
		return end;
	}

    public void setEnd(DateTime end) {
        this.end = end;
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
