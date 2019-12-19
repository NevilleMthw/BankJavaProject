public class Loan {
    private final double interestRate= 0.03;                   //Interest rate is final.
    private double  monthlyInstall,YearlyPayment;               //Variables for the payment.
    public double getYearlyPayment(double loan, int year) {              //Method for implementing the calculation of Yearly payment.
          monthlyInstall=loan/12;
          YearlyPayment = (monthlyInstall+((monthlyInstall) * (interestRate) ));
          return YearlyPayment;
    }

  public double getTotalPayment(double loan, int year) {                //Method for calculating the Total Payment.
        double totalPayment = (monthlyInstall+((monthlyInstall) * (interestRate) )) * year * 12;
        return totalPayment;
    }
}
