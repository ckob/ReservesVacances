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

public class Main {

    public static void main(String[] args) {
        Agency agency = new Agency();
        Appartment a1 = new BeachAppartment(15, (short)5, true,
                new ReservationPeriod("25/10/2016", "04/11/2016", 1000., true),
                new ReservationPeriod("01/05/2016", "30/09/2016", 1500., true)
        );
        Accommodation a2 = new BeachAppartment(15, (short)5, true,
                new ReservationPeriod("25/10/2016", "04/11/2016", 1000., true),
                new ReservationPeriod("01/05/2016", "30/09/2016", 1500., true)
        );
        Bookable a3 = new BeachAppartment(15, (short)5, true,
                new ReservationPeriod("25/10/2016", "04/11/2016", 1000., true),
                new ReservationPeriod("01/05/2016", "30/09/2016", 1500., true)
        );

        System.out.println("Preu reserva="+a1.book("28/10/2016", "02/11/2016"));
        Appartment a4 = new SkiResortAppartment(20, (short)5, true,
                new ReservationPeriod("01/01/2017", "15/01/2017", 10., true), // 10€ per dia, hauria d'actualitzar al minim cost de mountainappartment + minim cost de skiresortappartment
                new ReservationPeriod("01/02/2017", "15/02/2017", 40., true)    // idem ^
        );
        System.out.println("Preu reserva="+a4.book("02/01/2017", "06/01/2017"));
        Car c1 = new Car(
            new ReservationPeriod("01/01/2017", "15/01/2017", 10., true),
            new ReservationPeriod("01/02/2017", "15/02/2017", 50., true)
        );
        System.out.println("Preu reserva="+c1.book("02/01/2017", "06/01/2017"));

        System.out.println("=========================================");
        Car carTests = new Car(
                //new ReservationPeriod("01/01/2017", "15/01/2017", 10., true),
                new ReservationPeriod("01/02/2017", "15/02/2018", 50., true)
        );
        System.out.println(carTests);
        carTests.book("03/02/2017", "08/02/2017");
        carTests.book("03/09/2017", "08/01/2018");
        System.out.println(carTests);

        Villa v1 = new Villa(50, (short)100, true,
                new ReservationPeriod("25/10/2016", "04/11/2016", 1000., true),
                new ReservationPeriod("01/05/2016", "30/09/2016", 1500., true)
        );
        v1.book("27/10/2016", "02/11/2016");

        System.out.println("================ Info Agencia ========================");
        agency.addBookables(a1, a2, a3, a4, c1, v1);
        System.out.println(agency);
    }
}
