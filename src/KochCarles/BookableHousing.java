package KochCarles;/*
 * BookableHousing.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

/** 
 * 
 * Interface to manage items of type housing that can be booked
 * 
 */
public interface BookableHousing extends Bookable {
	/**
	 * 
	 * cleaning costs are paid once per period
	 * 
	 * @return	the amount
	 */
	
	double getCleaningCosts();
	
	/**
	 * 
	 * the number of maximum allowed people
	 * 
	 * @return	the number of people
	 */
	short getMaxAllowedPeople();
	
	/**
	 * 
	 * @return if dogs, cats, etc are allowed 
	 */
	boolean petsAllowed();

}
