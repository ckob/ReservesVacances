package KochCarles;/*
 * Agency.java        1.0 May 26, 2016
 *
 * Copyright 2016 @author Ramón Bruballa <rbruballa@escoladeltreball.org> <rbruballa@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
import java.util.ArrayList;

public class Agency {

	ArrayList<Bookable> bookableItems=new ArrayList<Bookable>();
	
	public Agency() {
	}
	public boolean addBookable (Bookable b) {
		return bookableItems.add(b);
	}
	public boolean addBookables (Bookable...bs) {
		for (Bookable b : bs) {
			if (!addBookable(b))  {
                System.err.println("S'ha produit un error al afegir un bookable a l'agencia.");
                return false;
            }
		}
		return true;
	}

    @Override
    public String toString() {
        String s="";
        for (Bookable bookableItem : bookableItems) {
            s+=bookableItem.toString();
        }
        return "Agencia:\n"+(s!=""?s:"Res a l'agencia");
    }
}
