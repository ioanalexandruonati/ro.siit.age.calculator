package model;

public class Age {

   private final int days;
   private final int months;
   private final int years;


   public Age (int days, int months, int years) {
      this.days = days;
      this.months = months;
      this.years = years;
   }

   public int getDays () {
      return this.days;
   }

   public int getMonths () {
      return this.months;
   }

   public int getYears () {
      return this.years;
   }

   @Override
   public String toString () {
      return years + " Years, " + months + " Months, " + days + " Days";
   }
}
