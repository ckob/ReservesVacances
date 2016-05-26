package KochCarles;

import org.joda.time.DateTime;

public class Main {

    public static void main(String[] args) {
        Agency agency = new Agency();

        ReservationPeriod rp1 = new ReservationPeriod(new DateTime().minusDays(10), new DateTime().minusDays(5), 50., true);
        ReservationPeriod rp2 = new ReservationPeriod(new DateTime().plusDays(2), new DateTime().plusDays(50), 55., true);
        ReservationPeriod rp3 = new ReservationPeriod(new DateTime().plusDays(2), new DateTime().plusDays(50), 80., true);
        ReservationPeriod rp4 = new ReservationPeriod(new DateTime().plusDays(60), new DateTime().plusDays(90), 90., true);
        Accommodation a1 = new BeachAppartment(15, (short)5, true, rp1, rp2);
        Accommodation a2 = new BeachAppartment(15, (short)5, true, rp3, rp4);
        agency.addBookables(a1, a2);
        System.out.println(a1.book(new DateTime().plusDays(5), new DateTime().plusDays(10)));
        System.out.println(a1);
        System.out.println(a2);
    }
}
