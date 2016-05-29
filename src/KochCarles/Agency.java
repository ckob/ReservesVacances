package KochCarles;/*
 * Agency.java        1.0 May, 2016
 *
 * Copyright 2016 @author Carles Koch <ckbusquets@gmail.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
import java.util.ArrayList;

public class Agency {

	ArrayList<Bookable> bookableItems=new ArrayList<Bookable>();
	static int lastID;
	public Agency() {
		lastID=1;
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
            s+=bookableItem.toString()+"\n";
        }
        return "Agencia:\n"+(s!=""?s:"Res a l'agencia");
    }
}
