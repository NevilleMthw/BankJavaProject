public class AccountConstruct {
   private String accountHolder;
   String accountPin;
    private String position;
    private String residence;
    private String typeOfAccount;
    private double accountBalance;
    private String dob;



    public AccountConstruct(String accountHolder, String accountPin, String position, String residence, String typeOfAccount, double accountBalance, String dob) {
        this.accountHolder = accountHolder;
        this.position = position;
        this.accountPin = accountPin;
        this.dob = dob;
        this.residence = residence;
        this.typeOfAccount = typeOfAccount;
        this.accountBalance = accountBalance;


    }


    public String getAccountHolder()
    {

        return accountHolder;
    }
    public String getPosition() {

        return position;
    }

    public String getDob() {

        return dob;
    }
    public String getResidence() {

        return residence;
    }
    public double getAccountBalance() {

        return accountBalance;
    }
    public String getTypeOfAccount() {

        return typeOfAccount;
    }

}