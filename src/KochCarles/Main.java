package KochCarles;

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

        System.out.println("Preu reserva:"+a1.book("28/10/2016", "02/11/2016"));
        Appartment a4 = new SkiResortAppartment(20, (short)5, true,
                new ReservationPeriod("01/01/2017", "15/01/2017", 10., true), // 10€ per dia, hauria d'actualitzar al minim cost de mountainappartment + minim cost de skiresortappartment
                new ReservationPeriod("01/02/2017", "15/02/2017", 10., true)
        );
        System.out.println("Preu reserva:"+a4.book("02/01/2017", "06/01/2017"));
        agency.addBookables(a1, a2, a3, a4);
        System.out.println(agency);
    }
}
