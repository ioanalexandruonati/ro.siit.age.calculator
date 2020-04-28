package servlet;

import model.AgeCalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/calculate")
public class AgeCalculatorServlet extends HttpServlet {

   @Override
   public void init () throws ServletException {
      super.init();
   }

   @Override
   protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/view/index.jsp").forward(request, response);

   }

   @Override
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {

      String birthDay = request.getParameter("BirthDate");

      SimpleDateFormat sdf = new SimpleDateFormat(birthDay);

      try {
         Date birthDate = sdf.parse(birthDay);

         AgeCalculator ageCalculator = new AgeCalculator();


         int totalDays = ageCalculator.calculateAge(birthDate).getDays() + ageCalculator.calculateAge(birthDate).getMonths() * 31 + ageCalculator.calculateAge(birthDate).getYears() * 365;

         String result = String.valueOf(totalDays);

         request.getSession().setAttribute("result", result);

         response.sendRedirect("result");

      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}