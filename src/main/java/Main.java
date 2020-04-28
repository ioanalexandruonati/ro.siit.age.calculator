import model.AgeCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

   private static Object PeriodType;

   public static void main (String[] args) throws ParseException {

      String birthday = "21/9/1992";

      SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

      Date birthDate = sdf.parse(birthday);

      AgeCalculator ageCalculator = new AgeCalculator();

      System.out.println(ageCalculator.calculateAge(birthDate).toString());

      int totalDays = ageCalculator.calculateAge(birthDate).getDays() + ageCalculator.calculateAge(birthDate).getMonths() * 31 + ageCalculator.calculateAge(birthDate).getYears() * 365;
      System.out.println(totalDays);
   }
}
