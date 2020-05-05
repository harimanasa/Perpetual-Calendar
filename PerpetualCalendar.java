import java.time.*;
import java.time.temporal.*;
public class PerpetualCalendar {
    enum Months {JAN, FEB, MAR, APR, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    static char[] cubeFacesShown;
    static String[] CalendarDaySplit; //The valid input gives this array size of 2.
    public static void main(String... args) {
        String calendarDay = "January 11";
        cubeFacesShown = new char[4];
        CalendarDaySplit = calendarDay.split(" "); /* The first two cubes are reserved for month */
        if(CalendarDaySplit.length==2){
            makeMonths(CalendarDaySplit[0], cubeFacesShown);
            makeDays(CalendarDaySplit[1], cubeFacesShown);
            System.out.println(cubeFacesShown);
        } else{
            System.out.println("Invalid input !");
        }
    }

    private static void makeMonths(String month, char[] cubeFacesShown) {
        try {
            Month monthFace = Month.valueOf(month.toUpperCase());
            int mon = monthFace.get(ChronoField.MONTH_OF_YEAR);
            assert mon <= 12;
            if (mon < 6) {
                cubeFacesShown[0] = (char) (mon+48);
            } else {
                cubeFacesShown[1] = (char) (mon+48);
            }
        }catch(Exception e){
        System.out.println("Illegal Arguement " + month);
        }
    }

    private static void makeDays(String day, char[] cubeFacesShown){
        try {
            int Day = Integer.parseInt(day);
            assert Day <= 31;
            if (Day ==3 || (Day >= 6 && Day <= 8)) {
                cubeFacesShown[3] = (char) (Day+48);
            } else if (Day < 5 || Day == 9) {
                cubeFacesShown[2] = (char) (Day+48);
            } else {
                cubeFacesShown[2]=day.charAt(0);
                cubeFacesShown[3]=day.charAt(1);
            }
        }catch(Exception e){
            System.out.println("Illegal Arguement " + day);
        }
    }
}
