import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.Window;
import java.io.*;


public class GuiBank extends Application {                                           //Gui main class.
    private Stage window;
    private AccountConstruct[] accountdetails = new AccountConstruct[6];                  //Initializing the array.
    private TextField enterloanAmount = new TextField();                           //Initializing the TextField.
    private TextField enterPeriodAmount = new TextField();//Initializing the TextField.
    private TextField yearlyPayment = new TextField();//Initializing the TextField.
    private TextField totalPayment = new TextField();//Initializing the TextField.


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        accountdetails[0] = new AccountConstruct("Paula Richards", "2710", "Head Psychometrist", "Thailand", "Savings Account", 50000.0, "27th October 2000");
        accountdetails[1] = new AccountConstruct("Lee M", "4536", "Lawyer", "China", "Business Account", 50000.0, "15th April 1996");
        accountdetails[2] = new AccountConstruct("Terry Miller", "3786", "Chartered Accountant", "Canada", "Personal Account", 50000.0, "25th August 1991");
        accountdetails[3] = new AccountConstruct("John Q", "2879", "Dentist", "Japan", "Business Account", 50000.0, "4th September 1990");
        accountdetails[4] = new AccountConstruct("Linda Walker", "3589", "Police Officer", "Afghanistan", "Current Account", 50000.0, "1st January 1994");
        final FlowPane startPane = new FlowPane(); //First FlowPane made for login screen.
        final Scene loginScene = new Scene(startPane, 400, 500); //This scene contains the login TextFields and buttons.
        window.setTitle("Tic Tac Banking"); //Window title as "Tic Tac Banking."
        window.setScene(loginScene);
        window.show();
        Text loginTitle = new Text("Tic Tac Banking"); //Tic Tac Banking as the heading of the FlowPane.
        startPane.setMargin(loginTitle, new Insets(65, 1, 1, 120));
        startPane.getChildren().add(loginTitle);
        startPane.getStylesheets().add(GuiBank.class.getResource("BG1.css").toExternalForm());   //CSS used for background image in the login screen.
        loginTitle.setFont(new Font("Cambria", 25));  //Setting font size and type.
        loginTitle.setFill(Color.BLACK);                                       //Font colour for the text.
        startPane.setVgap(10);
        startPane.setHgap(10);
        Text nameEntryText = new Text("Account Name:"); //This shows the account name text besides the entry field.
        nameEntryText.setFont(new Font("Cambria", 20));                         //Sets font and size.
        startPane.setMargin(nameEntryText, new Insets(45, 1, 1, 30));
        startPane.getChildren().add(nameEntryText);
        nameEntryText.setFill(Color.BLUE);                                          //Changes colour of the text.
        TextField accountName = new TextField("");                                     //TextField for entering account name.
        startPane.setMargin(accountName, new Insets(50, 0, 0, 10));
        startPane.getChildren().add(accountName);
        accountName.setPromptText("Input Name here");
        Text text3 = new Text("Access Pin:"); //This shows the text for entry of access pin.
        text3.setFont(new Font("Cambria", 20));
        startPane.setMargin(text3, new Insets(50, 0, 0, 40));
        startPane.getChildren().add(text3);
        text3.setFill(Color.BLUE); //Changes colour of the text.
        PasswordField accessInput = new PasswordField(); //TextField box for access pin.
        accessInput.setPromptText("Input pin here");
        startPane.setMargin(accessInput, new Insets(50, 1, 1, 35));
        startPane.getChildren().add(accessInput);
        Button login = new Button("Login"); //Button made for login.
        startPane.setMargin(login, new Insets(50, 0, 0, 55));
        startPane.getChildren().add(login);
        login.setPrefHeight(40); //Setting login button height.
        login.setPrefWidth(120); //Setting login button width
        login.setDefaultButton(true);
        final FlowPane paulaPane = new FlowPane(); //FlowPane made to show the account details.
        paulaPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        Scene detailsScene1 = new Scene(paulaPane, 800, 600);
        paulaPane.setHgap(10);
        paulaPane.setVgap(10);
        paulaPane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;"); //Scene borders.
        Button paulaWithdraw = new Button("Withdraw");                                                //Creating withdraw button.
        paulaPane.setMargin(paulaWithdraw, new Insets(5, 0, 10, 0));
        paulaPane.getChildren().add(paulaWithdraw);
        final FlowPane withdrawalPaula = new FlowPane();                                    //Withdraw Pane for Paula.
        final Scene paulawithdrawScene = new Scene(withdrawalPaula, 350, 300);
        paulaWithdraw.setOnAction(event -> { //on click withdraw button will lead to the withdrawal scene.
            window.setScene(paulawithdrawScene);
        });

        Text paulawithdrawAmt = new Text("How much would you like to withdraw?");    //Adds text to the scene.
        withdrawalPaula.setMargin(paulawithdrawAmt, new Insets(10, 10, 10, 10));
        withdrawalPaula.getChildren().add(paulawithdrawAmt);
        paulawithdrawAmt.setFill(Color.PURPLE);                                 //Changes colour of the text.
        paulawithdrawAmt.setFont(new Font("Cambria", 17));               //Changes font size and type.
        TextField paulawithdrawalAmt = new TextField();
        withdrawalPaula.setMargin(paulawithdrawalAmt, new Insets(50, 0, 0, 80));
        withdrawalPaula.getChildren().add(paulawithdrawalAmt);
        Button paulawithdrawConfirm = new Button("Withdraw");
        withdrawalPaula.setMargin(paulawithdrawConfirm, new Insets(90, 120, 0, 120));
        withdrawalPaula.getChildren().add(paulawithdrawConfirm);
        paulawithdrawConfirm.setDefaultButton(true);
        TextField paulasetWithdraw = new TextField();
        withdrawalPaula.setMargin(paulasetWithdraw, new Insets(-150, 0, 0, 80));
        withdrawalPaula.getChildren().add(paulasetWithdraw);
        paulasetWithdraw.setEditable(false);      //Function for changing the editable value.
        withdrawalPaula.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        paulasetWithdraw.setVisible(false);             //Function for changing the visible value.
        Button backtowithdrawPaula = new Button("Go Back");
        withdrawalPaula.setMargin(backtowithdrawPaula, new Insets(-25, 10, 10, 10));
        withdrawalPaula.getChildren().add(backtowithdrawPaula);
        backtowithdrawPaula.setDefaultButton(true);
        backtowithdrawPaula.setOnAction(event -> {
            window.setScene(detailsScene1);
        });


        paulawithdrawConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (Double.parseDouble(paulawithdrawalAmt.getText()) > 50000) {
                    showAlert(Alert.AlertType.ERROR, withdrawalPaula.getScene().getWindow(), "Withdrawal Error!", "Exceeded Withdrawal!");
                    return;
                } else {
                    Double newWithdrawalAmt = accountdetails[0].getAccountBalance() - Double.valueOf(paulawithdrawalAmt.getText());
                    paulasetWithdraw.setText(String.valueOf(newWithdrawalAmt));
                    paulasetWithdraw.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        FlowPane depositPaula = new FlowPane();
        Scene pauladepositScene = new Scene(depositPaula, 350, 350);
        Button paulaDeposit = new Button("Deposit");
        paulaPane.setMargin(paulaDeposit, new Insets(5, 10, 10, 5));
        paulaPane.getChildren().add(paulaDeposit);
        paulaDeposit.setOnAction(event -> {
            window.setScene(pauladepositScene);
            window.setTitle("Tic Tac Banking");

        });
        Text pauladepositAmt = new Text("How much would you like to Deposit?");
        depositPaula.setMargin(pauladepositAmt, new Insets(10, 10, 10, 10));
        depositPaula.getChildren().add(pauladepositAmt);
        pauladepositAmt.setFill(Color.PURPLE);
        pauladepositAmt.setFont(new Font("Cambria", 17));             //Changes font size and type.
        TextField pauladepositenterAmt = new TextField();
        depositPaula.setMargin(pauladepositenterAmt, new Insets(50, 0, 0, 80));
        depositPaula.getChildren().add(pauladepositenterAmt);
        Button pauladepositConfirm = new Button("Deposit");
        depositPaula.setMargin(pauladepositConfirm, new Insets(90, 120, 0, 120));
        depositPaula.getChildren().add(pauladepositConfirm);
        pauladepositConfirm.setDefaultButton(true);
        Button backtodepositPaula = new Button("Go Back");
        depositPaula.setMargin(backtodepositPaula, new Insets(-25, 10, 10, 10));
        depositPaula.getChildren().add(backtodepositPaula);
        backtodepositPaula.setDefaultButton(true);
        TextField paulasetDeposit = new TextField();
        depositPaula.setMargin(paulasetDeposit, new Insets(-150, 50, 0, 80));
        depositPaula.getChildren().add(paulasetDeposit);
        paulasetDeposit.setEditable(false);
        depositPaula.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        paulasetDeposit.setVisible(false);
        pauladepositConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (pauladepositenterAmt.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, depositPaula.getScene().getWindow(), "Deposit Error!", "PLEASE ENTER A DEPOSIT AMOUNT!");
                    return;
                } else {
                    Double newDepositAmt = accountdetails[0].getAccountBalance() + Double.valueOf(pauladepositenterAmt.getText());
                    paulasetDeposit.setText(String.valueOf(newDepositAmt));
                    paulasetDeposit.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        backtodepositPaula.setOnAction(event -> {
            window.setScene(detailsScene1);
        });
        final FlowPane paulaloanPane = new FlowPane();
        final Scene paulaLoanScene = new Scene(paulaloanPane, 400, 400);
        paulaloanPane.setVgap(10);
        paulaloanPane.setHgap(10);
        Button paulaLoan = new Button("Loan");
        paulaPane.setMargin(paulaLoan, new Insets(5, 10, 10, 0));
        paulaPane.getChildren().add(paulaLoan);


        paulaLoan.setOnAction(event -> {                             //On click button will lead to the loan scene.
            window.setScene(paulaLoanScene);
            paulaloanPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
            Text loanHead = new Text("Need a Hand?");
            paulaloanPane.setMargin(loanHead,new Insets(50,10,10,130));
            paulaloanPane.getChildren().add(loanHead);
            loanHead.setFont(new Font("Cambria",25));            //Changes font size and type.
            loanHead.setFill(Color.BLUEVIOLET);
            Text loanText = new Text("Enter Loan Amount:");             //Adds text to the pane.
            paulaloanPane.setMargin(loanText, new Insets(10, 10, 0, 10));
            paulaloanPane.getChildren().add(loanText);
            paulaloanPane.setMargin(enterloanAmount, new Insets(5, 30, -10,1 ));
            paulaloanPane.getChildren().add(enterloanAmount);
            Text periodText = new Text("Enter Period:");                    //Adds text to the pane.
            paulaloanPane.setMargin(periodText, new Insets(30, 100, 0, 10));
            paulaloanPane.getChildren().add(periodText);
            paulaloanPane.setMargin(enterPeriodAmount, new Insets(-40, 10, 1, 130));
            paulaloanPane.getChildren().add(enterPeriodAmount);
            Text yearlyText = new Text("Yearly Payment:");                   //Adds text to the pane.
            paulaloanPane.setMargin(yearlyText, new Insets(20, 10, 10, 10));
            paulaloanPane.getChildren().add(yearlyText);
            paulaloanPane.setMargin(yearlyPayment, new Insets(10, 1, 1, 10));
            paulaloanPane.getChildren().add(yearlyPayment);
            Text totalText = new Text("Total Payment:");                     //Adds text to the pane.
            paulaloanPane.setMargin(totalText,new Insets(15,50,10,10));
            paulaloanPane.getChildren().add(totalText);
            paulaloanPane.setMargin(totalPayment, new Insets(-50, 130, 1, 125));
            paulaloanPane.getChildren().add(totalPayment);
            yearlyPayment.setEditable(false);
            totalPayment.setEditable(false);
            Button loanAmount = new Button("Continue");
            paulaloanPane.setMargin(loanAmount, new Insets(1, 1, 1, 100));
            paulaloanPane.getChildren().add(loanAmount);
            loanAmount.setDefaultButton(true);
            loanAmount.setOnAction(event1 -> calculateLoan());              //On click button will calculate loan amount.
            Button backtoloanPaula = new Button("Go Back");
            paulaloanPane.setMargin(backtoloanPaula,new Insets(10,10,10,100));
            paulaloanPane.getChildren().add(backtoloanPaula);
            backtoloanPaula.setDefaultButton(true);
            backtoloanPaula.setOnAction(event1 -> {
                window.setScene(detailsScene1);
            });

        });



        Text paulaName = new Text("Name:- " + accountdetails[0].getAccountHolder());
        paulaPane.setMargin(paulaName, new Insets(20, 800, 0, 0));
        paulaPane.getChildren().add(paulaName);
        paulaName.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text paulaPos = new Text("Position:-" + accountdetails[0].getPosition());
        paulaPane.setMargin(paulaPos, new Insets(-180, 0, 0, 0));
        paulaPane.getChildren().add(paulaPos);
        paulaPos.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text paulaDob = new Text("DOB:-" + accountdetails[0].getDob());
        paulaPane.setMargin(paulaDob, new Insets(-45, 0, 0, -265));
        paulaPane.getChildren().add(paulaDob);
        paulaDob.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text paulaRes = new Text("Residence:-" + accountdetails[0].getResidence());
        paulaPane.setMargin(paulaRes, new Insets(70, 0, 0, -220));
        paulaPane.getChildren().add(paulaRes);
        paulaRes.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text paulaType = new Text("Type Of Account:-" + accountdetails[0].getTypeOfAccount());
        paulaPane.setMargin(paulaType, new Insets(230, 0, 0, -185));
        paulaPane.getChildren().add(paulaType);
        paulaType.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Image paulaProfile = new Image(getClass().getResourceAsStream("Clerissa.jpeg"));
        ImageView paulaImg = new ImageView(paulaProfile);
        paulaImg.setImage(paulaProfile);
        paulaPane.setMargin(paulaImg, new Insets(-460, 0, 0, 570));
        paulaPane.getChildren().add(paulaImg);
        Image paulaCard = new Image(getClass().getResourceAsStream("Paula credit card.jpg"));
        ImageView paulaCredit = new ImageView(paulaCard);
        paulaCredit.setImage(paulaCard);
        paulaPane.setMargin(paulaCredit, new Insets(-50, 0, 0, 350));
        paulaPane.getChildren().add(paulaCredit);


        FlowPane leePane = new FlowPane();
        final FlowPane withdrawalLee = new FlowPane();                                    //Withdraw Pane for Lee.
        final Scene leewithdrawScene = new Scene(withdrawalLee, 350, 300);              //Withdraw scene for Lee.
        leePane.setVgap(10);
        leePane.setHgap(10);
        Scene detailsScene2 = new Scene(leePane, 800, 600);
        leePane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        leePane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: purple;");
        
        Button leeWithdraw = new Button("Withdraw"); //Creating withdraw button.
        leePane.setMargin(leeWithdraw, new Insets(-280, 0, 10, 0));
        leePane.getChildren().add(leeWithdraw);
        leeWithdraw.setOnAction(event -> {                       //on click withdraw button will lead to the withdrawal scene for Lee.
            window.setScene(leewithdrawScene);
        });

        Text leewithdrawAmt = new Text("How much would you like to withdraw?");
        withdrawalLee.setMargin(leewithdrawAmt, new Insets(10, 10, 10, 10));
        withdrawalLee.getChildren().add(leewithdrawAmt);
        leewithdrawAmt.setFill(Color.PURPLE);
        leewithdrawAmt.setFont(new Font("Cambria", 17));
        TextField leewithdrawalAmt = new TextField();
        withdrawalLee.setMargin(leewithdrawalAmt, new Insets(50, 0, 0, 80));
        withdrawalLee.getChildren().add(leewithdrawalAmt);
        Button leewithdrawConfirm = new Button("Withdraw");
        withdrawalLee.setMargin(leewithdrawConfirm, new Insets(90, 120, 0, 120));
        withdrawalLee.getChildren().add(leewithdrawConfirm);
        leewithdrawConfirm.setDefaultButton(true);
        TextField leesetWithdraw = new TextField();
        withdrawalLee.setMargin(leesetWithdraw, new Insets(-150, 0, 0, 80));
        withdrawalLee.getChildren().add(leesetWithdraw);
        leesetWithdraw.setEditable(false);
        withdrawalLee.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        leesetWithdraw.setVisible(false);
        Button backtowithdrawLee = new Button("Go Back");
        withdrawalLee.setMargin(backtowithdrawLee, new Insets(-25, 10, 10, 10));
        withdrawalLee.getChildren().add(backtowithdrawLee);
        backtowithdrawLee.setDefaultButton(true);
        backtowithdrawLee.setOnAction(event -> {
            window.setScene(detailsScene2);
        });


        leewithdrawConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (Double.parseDouble(leewithdrawalAmt.getText()) > 50000) {
                    showAlert(Alert.AlertType.ERROR, withdrawalLee.getScene().getWindow(), "Withdrawal Error!", "Exceeded Withdrawal!");
                    return;
                } else {
                    Double newWithdrawalAmt = accountdetails[1].getAccountBalance() - Double.valueOf(leewithdrawalAmt.getText());
                    leesetWithdraw.setText(String.valueOf(newWithdrawalAmt));
                    leesetWithdraw.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        Button leeDeposit = new Button("Deposit");
        leePane.setMargin(leeDeposit, new Insets(-280, 10, 10, 5));
        leePane.getChildren().add(leeDeposit);
        FlowPane depositLee = new FlowPane();
        Scene leedepositScene = new Scene(depositLee, 350, 350);
        leeDeposit.setOnAction(event -> {
            window.setScene(leedepositScene);
            window.setTitle("Tic Tac Banking");

        });
        Text leedepositAmt = new Text("How much would you like to Deposit?");
        depositLee.setMargin(leedepositAmt, new Insets(10, 10, 10, 10));
        depositLee.getChildren().add(leedepositAmt);
        leedepositAmt.setFill(Color.PURPLE);
        leedepositAmt.setFont(new Font("Cambria", 17));
        TextField leedepositenterAmt = new TextField();
        depositLee.setMargin(leedepositenterAmt, new Insets(50, 0, 0, 80));
        depositLee.getChildren().add(leedepositenterAmt);
        Button leedepositConfirm = new Button("Deposit");
        depositLee.setMargin(leedepositConfirm, new Insets(90, 120, 0, 120));
        depositLee.getChildren().add(leedepositConfirm);
        leedepositConfirm.setDefaultButton(true);
        Button backtodepositLee = new Button("Go Back");
        depositLee.setMargin(backtodepositLee, new Insets(-25, 10, 10, 10));
        depositLee.getChildren().add(backtodepositLee);
        backtodepositLee.setDefaultButton(true);
        TextField leesetDeposit = new TextField();
        depositLee.setMargin(leesetDeposit, new Insets(-150, 50, 0, 80));
        depositLee.getChildren().add(leesetDeposit);
        leesetDeposit.setEditable(false);
        depositLee.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        leesetDeposit.setVisible(false);
        leedepositConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (leedepositenterAmt.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, depositLee.getScene().getWindow(), "Deposit Error!", "PLEASE ENTER A DEPOSIT AMOUNT!");
                    return;
                } else {
                    Double newDepositAmt = accountdetails[0].getAccountBalance() + Double.valueOf(leedepositenterAmt.getText());
                    leesetDeposit.setText(String.valueOf(newDepositAmt));
                    leesetDeposit.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        backtodepositLee.setOnAction(event -> {
            window.setScene(detailsScene2);
        });
        
        

        Button leeLoan = new Button("Loan");
        leePane.setMargin(leeLoan, new Insets(-280, 10, 10, 0));
        leePane.getChildren().add(leeLoan);
        final FlowPane leeloanPane = new FlowPane();
        final Scene leeLoanScene = new Scene(leeloanPane, 400, 400);
        leeloanPane.setVgap(10);
        leeloanPane.setHgap(10);
        leeLoan.setOnAction(event -> {
            window.setScene(leeLoanScene);
            leeloanPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
            Text leeloanHead = new Text("Need a Hand?");
            leeloanPane.setMargin(leeloanHead,new Insets(50,10,10,130));
            leeloanPane.getChildren().add(leeloanHead);
            leeloanHead.setFont(new Font("Cambria",25));
            leeloanHead.setFill(Color.BLUEVIOLET);
            Text leeloanText = new Text("Enter Loan Amount:");
            leeloanPane.setMargin(leeloanText, new Insets(10, 10, 0, 10));
            leeloanPane.getChildren().add(leeloanText);
            leeloanPane.setMargin(enterloanAmount, new Insets(5, 30, -10,1 ));
            leeloanPane.getChildren().add(enterloanAmount);
            Text leeperiodText = new Text("Enter Period:");
            leeloanPane.setMargin(leeperiodText, new Insets(30, 100, 0, 10));
            leeloanPane.getChildren().add(leeperiodText);
            leeloanPane.setMargin(enterPeriodAmount, new Insets(-40, 10, 1, 130));
            leeloanPane.getChildren().add(enterPeriodAmount);
            Text leeyearlyText = new Text("Yearly Payment:");
            leeloanPane.setMargin(leeyearlyText, new Insets(20, 10, 10, 10));
            leeloanPane.getChildren().add(leeyearlyText);
            leeloanPane.setMargin(yearlyPayment, new Insets(10, 1, 1, 10));
            leeloanPane.getChildren().add(yearlyPayment);
            Text leetotalText = new Text("Total Payment:");
            leeloanPane.setMargin(leetotalText,new Insets(15,50,10,10));
            leeloanPane.getChildren().add(leetotalText);
            leeloanPane.setMargin(totalPayment, new Insets(-50, 130, 1, 125));
            leeloanPane.getChildren().add(totalPayment);
            yearlyPayment.setEditable(false);
            totalPayment.setEditable(false);
            Button leeloanAmount = new Button("Continue");
            leeloanPane.setMargin(leeloanAmount, new Insets(1, 1, 1, 100));
            leeloanPane.getChildren().add(leeloanAmount);
            leeloanAmount.setDefaultButton(true);
            leeloanAmount.setOnAction(event1 -> calculateLoan());
            Button backtoloanLee = new Button("Go Back");
            leeloanPane.setMargin(backtoloanLee,new Insets(10,10,10,100));
            leeloanPane.getChildren().add(backtoloanLee);
            backtoloanLee.setDefaultButton(true);
            backtoloanLee.setOnAction(event1 -> {
                window.setScene(detailsScene2);
            });

        });

        Text leeName = new Text("Name:- " + accountdetails[1].getAccountHolder());
        leePane.setMargin(leeName, new Insets(-170, 0, 0, -220));
        leePane.getChildren().add(leeName);
        leeName.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text leePos = new Text("Position:-" + accountdetails[1].getPosition());
        leePane.setMargin(leePos, new Insets(-70, 0, 0, -130));
        leePane.getChildren().add(leePos);
        leePos.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text leeDob = new Text("DOB:-" + accountdetails[1].getDob());
        leePane.setMargin(leeDob, new Insets(50, 0, 0, -158));
        leePane.getChildren().add(leeDob);
        leeDob.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text leeRes = new Text("Residence:-" + accountdetails[1].getResidence());
        leePane.setMargin(leeRes, new Insets(170, 0, 0, -198));
        leePane.getChildren().add(leeRes);
        leeRes.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text leeType = new Text("Type Of Account:-" + accountdetails[1].getTypeOfAccount());
        leePane.setMargin(leeType, new Insets(320, 0, 0, -158));
        leePane.getChildren().add(leeType);
        leeType.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Image leeImg = new Image(getClass().getResourceAsStream("lee.jpg"));
        ImageView lee = new ImageView(leeImg);
        lee.setImage(leeImg);
        leePane.setMargin(lee, new Insets(-420, 0, 0, 570));
        leePane.getChildren().add(lee);
        Image leeCard = new Image(getClass().getResourceAsStream("lee credit card.png"));
        ImageView leeCredit = new ImageView(leeCard);
        leeCredit.setImage(leeCard);
        leePane.setMargin(leeCredit, new Insets(-50, 0, 0, 350));
        leePane.getChildren().add(leeCredit);

        FlowPane terryPane = new FlowPane();
        Scene detailsScene3 = new Scene(terryPane, 800, 600);
        final FlowPane withdrawalTerry = new FlowPane();                                    //Withdraw Pane for Terry.
        final Scene terrywithdrawScene = new Scene(withdrawalTerry, 350, 300);
        terryPane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;"); //Scene borders.
        terryPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        Button terryWithdraw = new Button("Withdraw"); //Creating withdraw button.
        terryPane.setMargin(terryWithdraw, new Insets(-280, 0, 10, 0));
        terryPane.getChildren().add(terryWithdraw);
        terryWithdraw.setOnAction(event -> {                       //on click withdraw button will lead to the withdrawal scene for Lee.
            window.setScene(terrywithdrawScene);
        });

        Text terrywithdrawAmt = new Text("How much would you like to withdraw?");
        withdrawalTerry.setMargin(terrywithdrawAmt, new Insets(10, 10, 10, 10));
        withdrawalTerry.getChildren().add(terrywithdrawAmt);
        terrywithdrawAmt.setFill(Color.PURPLE);
        terrywithdrawAmt.setFont(new Font("Cambria", 17));
        TextField terrywithdrawalAmt = new TextField();
        withdrawalTerry.setMargin(terrywithdrawalAmt, new Insets(50, 0, 0, 80));
        withdrawalTerry.getChildren().add(terrywithdrawalAmt);
        Button terrywithdrawConfirm = new Button("Withdraw");
        withdrawalTerry.setMargin(terrywithdrawConfirm, new Insets(90, 120, 0, 120));
        withdrawalTerry.getChildren().add(terrywithdrawConfirm);
        terrywithdrawConfirm.setDefaultButton(true);
        TextField terrysetWithdraw = new TextField();
        withdrawalTerry.setMargin(terrysetWithdraw, new Insets(-150, 0, 0, 80));
        withdrawalTerry.getChildren().add(terrysetWithdraw);
        terrysetWithdraw.setEditable(false);
        withdrawalTerry.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        terrysetWithdraw.setVisible(false);
        Button backtowithdrawTerry = new Button("Go Back");
        withdrawalTerry.setMargin(backtowithdrawTerry, new Insets(-25, 10, 10, 10));
        withdrawalTerry.getChildren().add(backtowithdrawTerry);
        backtowithdrawTerry.setDefaultButton(true);
        backtowithdrawTerry.setOnAction(event -> {
            window.setScene(detailsScene3);
        });


        terrywithdrawConfirm.setOnAction(new EventHandler<ActionEvent>() {            //Error shown if the withdrawal is more than the actual amount.
            public void handle(ActionEvent event) {
                if (Double.parseDouble(terrywithdrawalAmt.getText()) > 50000) {
                    showAlert(Alert.AlertType.ERROR, withdrawalTerry.getScene().getWindow(), "Withdrawal Error!", "Exceeded Withdrawal!");
                    return;
                } else {
                    Double newWithdrawalAmt = accountdetails[2].getAccountBalance() - Double.valueOf(terrywithdrawalAmt.getText());
                    terrysetWithdraw.setText(String.valueOf(newWithdrawalAmt));
                    terrysetWithdraw.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        Button terryDeposit = new Button("Deposit");                                      //Deposit button for the FlowPane.
        terryPane.setMargin(terryDeposit, new Insets(-280, 10, 10, 5));
        terryPane.getChildren().add(terryDeposit);
        FlowPane depositTerry = new FlowPane();
        Scene terrydepositScene = new Scene(depositTerry, 350, 350);
        terryDeposit.setOnAction(event -> {
            window.setScene(terrydepositScene);
            window.setTitle("Tic Tac Banking");

        });
        Text terrydepositAmt = new Text("How much would you like to Deposit?");
        depositTerry.setMargin(terrydepositAmt, new Insets(10, 10, 10, 10));
        depositTerry.getChildren().add(terrydepositAmt);
        terrydepositAmt.setFill(Color.PURPLE);
        terrydepositAmt.setFont(new Font("Cambria", 17));
        TextField terrydepositenterAmt = new TextField();
        depositTerry.setMargin(terrydepositenterAmt, new Insets(50, 0, 0, 80));
        depositTerry.getChildren().add(terrydepositenterAmt);
        Button terrydepositConfirm = new Button("Deposit");
        depositTerry.setMargin(terrydepositConfirm, new Insets(90, 120, 0, 120));
        depositTerry.getChildren().add(terrydepositConfirm);
        terrydepositConfirm.setDefaultButton(true);
        Button backtodepositTerry = new Button("Go Back");
        depositTerry.setMargin(backtodepositTerry, new Insets(-25, 10, 10, 10));
        depositTerry.getChildren().add(backtodepositTerry);
        backtodepositTerry.setDefaultButton(true);
        TextField terrysetDeposit = new TextField();
        depositTerry.setMargin(terrysetDeposit, new Insets(-150, 50, 0, 80));
        depositTerry.getChildren().add(terrysetDeposit);
        terrysetDeposit.setEditable(false);
        depositTerry.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        terrysetDeposit.setVisible(false);
        terrydepositConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (terrydepositenterAmt.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, depositTerry.getScene().getWindow(), "Deposit Error!", "PLEASE ENTER A DEPOSIT AMOUNT!");
                    return;
                } else {
                    Double newDepositAmt = accountdetails[0].getAccountBalance() + Double.valueOf(terrydepositenterAmt.getText());
                    terrysetDeposit.setText(String.valueOf(newDepositAmt));
                    terrysetDeposit.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        backtodepositTerry.setOnAction(event -> {
            window.setScene(detailsScene3);
        });
        Button terryLoan = new Button("Loan");
        terryPane.setMargin(terryLoan, new Insets(-280, 10, 10, 0));
        terryPane.getChildren().add(terryLoan);
        final FlowPane terryloanPane = new FlowPane();
        final Scene terryloanScene = new Scene(terryloanPane, 400, 400);
        terryloanPane.setVgap(10);
        terryloanPane.setHgap(10);
        terryLoan.setOnAction(event -> {
            window.setScene(terryloanScene);
            terryloanPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
            Text terryloanHead = new Text("Need a Hand?");
            terryloanPane.setMargin(terryloanHead,new Insets(50,10,10,130));
            terryloanPane.getChildren().add(terryloanHead);
            terryloanHead.setFont(new Font("Cambria",25));
            terryloanHead.setFill(Color.BLUEVIOLET);
            Text terryloanText = new Text("Enter Loan Amount:");
            terryloanPane.setMargin(terryloanText, new Insets(10, 10, 0, 10));
            terryloanPane.getChildren().add(terryloanText);
            terryloanPane.setMargin(enterloanAmount, new Insets(5, 30, -10,1 ));
            terryloanPane.getChildren().add(enterloanAmount);
            Text terryperiodText = new Text("Enter Period:");
            terryloanPane.setMargin(terryperiodText, new Insets(30, 100, 0, 10));
            terryloanPane.getChildren().add(terryperiodText);
            terryloanPane.setMargin(enterPeriodAmount, new Insets(-40, 10, 1, 130));
            terryloanPane.getChildren().add(enterPeriodAmount);
            Text terryearlyText = new Text("Yearly Payment:");
            terryloanPane.setMargin(terryearlyText, new Insets(20, 10, 10, 10));
            terryloanPane.getChildren().add(terryearlyText);
            terryloanPane.setMargin(yearlyPayment, new Insets(10, 1, 1, 10));
            terryloanPane.getChildren().add(yearlyPayment);
            Text terrytotalText = new Text("Total Payment:");
            terryloanPane.setMargin(terrytotalText,new Insets(15,50,10,10));
            terryloanPane.getChildren().add(terrytotalText);
            terryloanPane.setMargin(totalPayment, new Insets(-50, 130, 1, 125));
            terryloanPane.getChildren().add(totalPayment);
            yearlyPayment.setEditable(false);
            totalPayment.setEditable(false);
            Button terryloanAmount = new Button("Continue");
            terryloanPane.setMargin(terryloanAmount, new Insets(1, 1, 1, 100));
            terryloanPane.getChildren().add(terryloanAmount);
            terryloanAmount.setDefaultButton(true);
            terryloanAmount.setOnAction(event1 -> calculateLoan());     //On click button will calculate loan amount.
            Button backtoloanTerry = new Button("Go Back");
            terryloanPane.setMargin(backtoloanTerry,new Insets(10,10,10,100));
            terryloanPane.getChildren().add(backtoloanTerry);
            backtoloanTerry.setDefaultButton(true);
            backtoloanTerry.setOnAction(event1 -> {
                window.setScene(detailsScene3);
            });

        });

        Text terryName = new Text("Name:- " + accountdetails[2].getAccountHolder());
        terryPane.setMargin(terryName, new Insets(-170, 0, 0, -190));
        terryPane.getChildren().add(terryName);
        terryName.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text terryPos = new Text("Position:-" + accountdetails[2].getPosition());
        terryPane.setMargin(terryPos, new Insets(-70, 0, 0, -168));
        terryPane.getChildren().add(terryPos);
        terryPos.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text terryDob = new Text("DOB:-" + accountdetails[2].getDob());
        terryPane.setMargin(terryDob, new Insets(50, 0, 0, -275));
        terryPane.getChildren().add(terryDob);
        terryDob.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text terryRes = new Text("Residence:-" + accountdetails[2].getResidence());
        terryPane.setMargin(terryRes, new Insets(170, 0, 0, -200));
        terryPane.getChildren().add(terryRes);
        terryRes.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text terryType = new Text("Type Of Account:-" + accountdetails[2].getTypeOfAccount());
        terryPane.setMargin(terryType, new Insets(320, 0, 0, -158));
        terryPane.getChildren().add(terryType);
        terryType.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Image terryImg = new Image(getClass().getResourceAsStream("terry miller.jpg"));
        ImageView terry = new ImageView(terryImg);
        terry.setImage(terryImg);
        terryPane.setMargin(terry, new Insets(-420, 0, 0, 570));
        terryPane.getChildren().add(terry);
        Image terryCard = new Image(getClass().getResourceAsStream("terry miller card.jpg"));
        ImageView terryCredit = new ImageView(terryCard);
        terryCredit.setImage(terryCard);
        terryPane.setMargin(terryCredit, new Insets(-50, 0, 0, 350));
        terryPane.getChildren().add(terryCredit);

        FlowPane johnPane = new FlowPane();
        Scene detailsScene4 = new Scene(johnPane, 800, 600);
        johnPane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: brown;");
        johnPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        Button johnWithdraw = new Button("Withdraw"); //Creating withdraw button.
        johnPane.setMargin(johnWithdraw, new Insets(-280, 0, 10, 0));
        johnPane.getChildren().add(johnWithdraw);
        final FlowPane withdrawalJohn = new FlowPane();                                    //Withdraw Pane for John
        final Scene johnwithdrawScene = new Scene(withdrawalJohn, 350, 300);
        johnWithdraw.setOnAction(event -> {                       //on click withdraw button will lead to the withdrawal scene for Lee.
            window.setScene(johnwithdrawScene);
        });

        Text johnwithdrawAmt = new Text("How much would you like to withdraw?");
        withdrawalJohn.setMargin(johnwithdrawAmt, new Insets(10, 10, 10, 10));
        withdrawalJohn.getChildren().add(johnwithdrawAmt);
        johnwithdrawAmt.setFill(Color.PURPLE);
        johnwithdrawAmt.setFont(new Font("Cambria", 17));
        TextField johnwithdrawalAmt = new TextField();
        withdrawalJohn.setMargin(johnwithdrawalAmt, new Insets(50, 0, 0, 80));
        withdrawalJohn.getChildren().add(johnwithdrawalAmt);
        Button johnwithdrawConfirm = new Button("Withdraw");
        withdrawalJohn.setMargin(johnwithdrawConfirm, new Insets(90, 120, 0, 120));
        withdrawalJohn.getChildren().add(johnwithdrawConfirm);
        johnwithdrawConfirm.setDefaultButton(true);
        TextField johnsetWithdraw = new TextField();
        withdrawalJohn.setMargin(johnsetWithdraw, new Insets(-150, 0, 0, 80));
        withdrawalJohn.getChildren().add(johnsetWithdraw);
        johnsetWithdraw.setEditable(false);
        withdrawalJohn.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        johnsetWithdraw.setVisible(false);
        Button backtowithdrawJohn = new Button("Go Back");
        withdrawalJohn.setMargin(backtowithdrawJohn, new Insets(-25, 10, 10, 10));
        withdrawalJohn.getChildren().add(backtowithdrawJohn);
        backtowithdrawJohn.setDefaultButton(true);
        backtowithdrawJohn.setOnAction(event -> {
            window.setScene(detailsScene4);
        });


        johnwithdrawConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (Double.parseDouble(johnwithdrawalAmt.getText()) > 50000) {
                    showAlert(Alert.AlertType.ERROR, withdrawalJohn.getScene().getWindow(), "Withdrawal Error!", "Exceeded Withdrawal!");
                    return;
                } else {
                    Double newWithdrawalAmt = accountdetails[3].getAccountBalance() - Double.valueOf(johnwithdrawalAmt.getText());
                    johnsetWithdraw.setText(String.valueOf(newWithdrawalAmt));
                    johnsetWithdraw.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        Button johnDeposit = new Button("Deposit");
        johnPane.setMargin(johnDeposit, new Insets(-280, 10, 10, 5));
        johnPane.getChildren().add(johnDeposit);
        FlowPane depositJohn = new FlowPane();
        Scene johndepositScene = new Scene(depositJohn, 350, 350);
        johnDeposit.setOnAction(event -> {
            window.setScene(johndepositScene);
            window.setTitle("Tic Tac Banking");

        });
        Text johndepositAmt = new Text("How much would you like to Deposit?");
        depositJohn.setMargin(johndepositAmt, new Insets(10, 10, 10, 10));
        depositJohn.getChildren().add(johndepositAmt);
        johndepositAmt.setFill(Color.PURPLE);
        johndepositAmt.setFont(new Font("Cambria", 17));
        TextField johndepositenterAmt = new TextField();
        depositJohn.setMargin(johndepositenterAmt, new Insets(50, 0, 0, 80));
        depositJohn.getChildren().add(johndepositenterAmt);
        Button johndepositConfirm = new Button("Deposit");
        depositJohn.setMargin(johndepositConfirm, new Insets(90, 120, 0, 120));
        depositJohn.getChildren().add(johndepositConfirm);
        johndepositConfirm.setDefaultButton(true);
        Button backtodepositJohn = new Button("Go Back");
        depositJohn.setMargin(backtodepositJohn, new Insets(-25, 10, 10, 10));
        depositJohn.getChildren().add(backtodepositJohn);
        backtodepositJohn.setDefaultButton(true);
        TextField johnsetDeposit = new TextField();
        depositJohn.setMargin(johnsetDeposit, new Insets(-150, 50, 0, 80));
        depositJohn.getChildren().add(johnsetDeposit);
        johnsetDeposit.setEditable(false);
        depositJohn.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        johnsetDeposit.setVisible(false);
        johndepositConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (johndepositenterAmt.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, depositJohn.getScene().getWindow(), "Deposit Error!", "PLEASE ENTER A DEPOSIT AMOUNT!");
                    return;
                } else {
                    Double newDepositAmt = accountdetails[3].getAccountBalance() + Double.valueOf(johndepositenterAmt.getText());
                    johnsetDeposit.setText(String.valueOf(newDepositAmt));
                    johnsetDeposit.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        backtodepositJohn.setOnAction(event -> {
            window.setScene(detailsScene4);
        });
        Button johnLoan = new Button("Loan");
        johnPane.setMargin(johnLoan, new Insets(-280, 10, 10, 0));
        johnPane.getChildren().add(johnLoan);
        final FlowPane johnloanPane = new FlowPane();
        final Scene johnloanScene = new Scene(johnloanPane, 400, 400);
        johnloanPane.setVgap(10);
        johnloanPane.setHgap(10);
        johnLoan.setOnAction(event -> {
            window.setScene(johnloanScene);
            johnloanPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
            Text johnloanHead = new Text("Need a Hand?");
            johnloanPane.setMargin(johnloanHead,new Insets(50,10,10,130));
            johnloanPane.getChildren().add(johnloanHead);
            johnloanHead.setFont(new Font("Cambria",25));
            johnloanHead.setFill(Color.BLUEVIOLET);
            Text johnloanText = new Text("Enter Loan Amount:");
            johnloanPane.setMargin(johnloanText, new Insets(10, 10, 0, 10));
            johnloanPane.getChildren().add(johnloanText);
            johnloanPane.setMargin(enterloanAmount, new Insets(5, 30, -10,1 ));
            johnloanPane.getChildren().add(enterloanAmount);
            Text johnperiodText = new Text("Enter Period:");
            johnloanPane.setMargin(johnperiodText, new Insets(30, 100, 0, 10));
            johnloanPane.getChildren().add(johnperiodText);
            johnloanPane.setMargin(enterPeriodAmount, new Insets(-40, 10, 1, 130));
            johnloanPane.getChildren().add(enterPeriodAmount);
            Text johnyearlyText = new Text("Yearly Payment:");
            johnloanPane.setMargin(johnyearlyText, new Insets(20, 10, 10, 10));
            johnloanPane.getChildren().add(johnyearlyText);
            johnloanPane.setMargin(yearlyPayment, new Insets(10, 1, 1, 10));
            johnloanPane.getChildren().add(yearlyPayment);
            Text johntotalText = new Text("Total Payment:");
            johnloanPane.setMargin(johntotalText,new Insets(15,50,10,10));
            johnloanPane.getChildren().add(johntotalText);
            johnloanPane.setMargin(totalPayment, new Insets(-50, 130, 1, 125));
            johnloanPane.getChildren().add(totalPayment);
            yearlyPayment.setEditable(false);
            totalPayment.setEditable(false);
            Button johnloanAmount = new Button("Continue");
            johnloanPane.setMargin(johnloanAmount, new Insets(1, 1, 1, 100));
            johnloanPane.getChildren().add(johnloanAmount);
            johnloanAmount.setDefaultButton(true);
            johnloanAmount.setOnAction(event1 -> calculateLoan());
            Button backtoloanJohn = new Button("Go Back");
            johnloanPane.setMargin(backtoloanJohn,new Insets(10,10,10,100));
            johnloanPane.getChildren().add(backtoloanJohn);
            backtoloanJohn.setDefaultButton(true);
            backtoloanJohn.setOnAction(event1 -> {
                window.setScene(detailsScene4);
            });

        });


        Text johnName = new Text("Name:- " + accountdetails[3].getAccountHolder());
        johnPane.setMargin(johnName, new Insets(-170, 0, 0, -190));
        johnPane.getChildren().add(johnName);
        johnName.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text johnPos = new Text("Position:-" + accountdetails[3].getPosition());
        johnPane.setMargin(johnPos, new Insets(-70, 0, 0, -125));
        johnPane.getChildren().add(johnPos);
        johnPos.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text johnDob = new Text("DOB:-" + accountdetails[3].getDob());
        johnPane.setMargin(johnDob, new Insets(50, 0, 0, -145));
        johnPane.getChildren().add(johnDob);
        johnDob.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text johnRes = new Text("Residence:-" + accountdetails[3].getResidence());
        johnPane.setMargin(johnRes, new Insets(170, 0, 0, -225));
        johnPane.getChildren().add(johnRes);
        johnRes.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text johnType = new Text("Type Of Account:-" + accountdetails[3].getTypeOfAccount());
        johnPane.setMargin(johnType, new Insets(320, 0, 0, -145));
        johnPane.getChildren().add(johnType);
        johnType.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Image johnImg = new Image(getClass().getResourceAsStream("John.jpg"));
        ImageView john = new ImageView(johnImg);
        john.setImage(johnImg);
        johnPane.setMargin(john, new Insets(-420, 0, 0, 570));
        johnPane.getChildren().add(john);
        Image johnCard = new Image(getClass().getResourceAsStream("john credit card.png"));
        ImageView johnCredit = new ImageView(johnCard);
        johnCredit.setImage(johnCard);
        johnPane.setMargin(johnCredit, new Insets(-50, 0, 0, 350));
        johnPane.getChildren().add(johnCredit);

        FlowPane lindaPane = new FlowPane();
        Scene detailsScene5 = new Scene(lindaPane, 800, 600);
        lindaPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        lindaPane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: red;");
        lindaPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        Button lindaWithdraw = new Button("Withdraw"); //Creating withdraw button.
        lindaPane.setMargin(lindaWithdraw, new Insets(-280, 0, 10, 0));
        lindaPane.getChildren().add(lindaWithdraw);
        
        Button lindaDeposit = new Button("Deposit");
        lindaPane.setMargin(lindaDeposit, new Insets(-280, 10, 10, 5));
        lindaPane.getChildren().add(lindaDeposit);
        FlowPane depositLinda = new FlowPane();
        Scene lindadepositScene = new Scene(depositLinda, 350, 350);
        lindaDeposit.setOnAction(event -> {
            window.setScene(lindadepositScene);
            window.setTitle("Tic Tac Banking");

        });
        Text lindadepositAmt = new Text("How much would you like to Deposit?");
        depositLinda.setMargin(lindadepositAmt, new Insets(10, 10, 10, 10));
        depositLinda.getChildren().add(lindadepositAmt);
        lindadepositAmt.setFill(Color.PURPLE);
        lindadepositAmt.setFont(new Font("Cambria", 17));
        TextField lindadepositenterAmt = new TextField();
        depositLinda.setMargin(lindadepositenterAmt, new Insets(50, 0, 0, 80));
        depositLinda.getChildren().add(lindadepositenterAmt);
        Button lindadepositConfirm = new Button("Deposit");
        depositLinda.setMargin(lindadepositConfirm, new Insets(90, 120, 0, 120));
        depositLinda.getChildren().add(lindadepositConfirm);
        lindadepositConfirm.setDefaultButton(true);
        Button backtodepositLinda = new Button("Go Back");
        depositLinda.setMargin(backtodepositLinda, new Insets(-25, 10, 10, 10));
        depositLinda.getChildren().add(backtodepositLinda);
        backtodepositLinda.setDefaultButton(true);
        TextField lindasetDeposit = new TextField();
        depositLinda.setMargin(lindasetDeposit, new Insets(-150, 50, 0, 80));
        depositLinda.getChildren().add(lindasetDeposit);
        lindasetDeposit.setEditable(false);
        depositLinda.getStylesheets().add(GuiBank.class.getResource("BG.css").toExternalForm());
        lindasetDeposit.setVisible(false);
        lindadepositConfirm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (lindadepositenterAmt.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, depositLinda.getScene().getWindow(), "Deposit Error!", "PLEASE ENTER A DEPOSIT AMOUNT!");
                    return;
                } else {
                    Double newDepositAmt = accountdetails[4].getAccountBalance() + Double.valueOf(lindadepositenterAmt.getText());
                    lindasetDeposit.setText(String.valueOf(newDepositAmt));
                    lindasetDeposit.setVisible(true);
                }

            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        backtodepositLinda.setOnAction(event -> {
            window.setScene(detailsScene4);
        });
        Button lindaLoan = new Button("Loan");                          //Adds Button to the FlowPane.
        lindaPane.setMargin(lindaLoan, new Insets(-280, 10, 10, 0));
        lindaPane.getChildren().add(lindaLoan);
        final FlowPane lindaloanPane = new FlowPane();                        //FlowPane for loan.
        final Scene lindaloanScene = new Scene(lindaloanPane, 400, 400);
        lindaloanPane.setVgap(10);
        lindaloanPane.setHgap(10);
        lindaLoan.setOnAction(event -> {
            window.setScene(lindaloanScene);


        });
        lindaloanPane.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        Text lindaloanHead = new Text("Need a Hand?");  //Adds text to the Pane.
        lindaloanPane.setMargin(lindaloanHead,new Insets(50,10,10,130));
        lindaloanPane.getChildren().add(lindaloanHead);
        lindaloanHead.setFont(new Font("Cambria",25));
        lindaloanHead.setFill(Color.BLUEVIOLET);
        Text lindaloanText = new Text("Enter Loan Amount:");             //Adds text to the Pane.
        lindaloanPane.setMargin(lindaloanText, new Insets(10, 10, 0, 10));
        lindaloanPane.getChildren().add(lindaloanText);
        lindaloanPane.setMargin(enterloanAmount, new Insets(5, 30, -10,1 ));
        lindaloanPane.getChildren().add(enterloanAmount);
        Text lindaperiodText = new Text("Enter Period:");               //Adds text to the Pane.
        lindaloanPane.setMargin(lindaperiodText, new Insets(30, 100, 0, 10));
        lindaloanPane.getChildren().add(lindaperiodText);
        lindaloanPane.setMargin(enterPeriodAmount, new Insets(-40, 10, 1, 130));
        lindaloanPane.getChildren().add(enterPeriodAmount);
        Text lindayearlyText = new Text("Yearly Payment:");  //Adds text to the Pane.
        lindaloanPane.setMargin(lindayearlyText, new Insets(20, 10, 10, 10));
        lindaloanPane.getChildren().add(lindayearlyText);
        lindaloanPane.setMargin(yearlyPayment, new Insets(10, 1, 1, 10));
        lindaloanPane.getChildren().add(yearlyPayment);
        Text lindatotalText = new Text("Total Payment:");                                       //Adds text to the Pane.
        lindaloanPane.setMargin(lindatotalText,new Insets(15,50,10,10));
        lindaloanPane.getChildren().add(lindatotalText);
        lindaloanPane.setMargin(totalPayment, new Insets(-50, 130, 1, 125));
        lindaloanPane.getChildren().add(totalPayment);
        yearlyPayment.setEditable(false);
        totalPayment.setEditable(false);
        Button lindaloanAmount = new Button("Continue");
        lindaloanPane.setMargin(lindaloanAmount, new Insets(1, 1, 1, 100));
        lindaloanPane.getChildren().add(lindaloanAmount);
        lindaloanAmount.setDefaultButton(true);
        lindaloanAmount.setOnAction(event1 -> calculateLoan());
        Button backtoloanLinda = new Button("Go Back");
        lindaloanPane.setMargin(backtoloanLinda,new Insets(10,10,10,100));
        lindaloanPane.getChildren().add(backtoloanLinda);
        backtoloanLinda.setDefaultButton(true);
        backtoloanLinda.setOnAction(event1 -> {
            window.setScene(detailsScene5);
        });
        Text lindaName = new Text("Name:- " + accountdetails[4].getAccountHolder());
        lindaPane.setMargin(lindaName, new Insets(-170, 0, 0, -190));
        lindaPane.getChildren().add(lindaName);
        lindaName.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text lindaPos = new Text("Position:-" + accountdetails[4].getPosition());
        lindaPane.setMargin(lindaPos, new Insets(-70, 0, 0, -180));
        lindaPane.getChildren().add(lindaPos);
        lindaPos.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text lindaDob = new Text("DOB:-" + accountdetails[4].getDob());
        lindaPane.setMargin(lindaDob, new Insets(50, 0, 0, -200));
        lindaPane.getChildren().add(lindaDob);
        lindaDob.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text lindaRes = new Text("Residence:-" + accountdetails[4].getResidence());
        lindaPane.setMargin(lindaRes, new Insets(170, 0, 0, -195));
        lindaPane.getChildren().add(lindaRes);
        lindaRes.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Text lindaType = new Text("Type Of Account:-" + accountdetails[4].getTypeOfAccount());
        lindaPane.setMargin(lindaType, new Insets(320, 0, 0, -200));
        lindaPane.getChildren().add(lindaType);
        lindaType.setFont(new Font("Cambria", 20));  //Setting font size and type.
        Image lindaImg = new Image(getClass().getResourceAsStream("linda walker.jpg"));
        ImageView linda = new ImageView(lindaImg);
        linda.setImage(lindaImg);
        lindaPane.setMargin(linda, new Insets(-460, 0, 0, 570));
        lindaPane.getChildren().add(linda);
        Image lindaCard = new Image(getClass().getResourceAsStream("linda credit card.png"));
        ImageView lindaCredit = new ImageView(lindaCard);
        lindaCredit.setImage(lindaCard);
        lindaPane.setMargin(lindaCredit, new Insets(-50, 0, 0, 350));
        lindaPane.getChildren().add(lindaCredit);


        Button forgotPass = new Button("Forgot Password");
        startPane.setMargin(forgotPass, new Insets(50, 0, 0, 40));
        startPane.getChildren().add(forgotPass);
        forgotPass.setPrefHeight(40);
        forgotPass.setPrefWidth(120);
        forgotPass.setDefaultButton(true);
        FlowPane fp3 = new FlowPane();
        Scene scene2 = new Scene(fp3, 500, 350);
        fp3.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());  //Background for the forgot password scene.
        forgotPass.setOnAction(event -> {
            window.setScene(scene2);

        });
        fp3.setVgap(10);
        fp3.setHgap(10);
        Text text4 = new Text("Forgot Password? NO PROBLEM!");
        fp3.setMargin(text4, new Insets(60, 0, 0, 70));
        fp3.getChildren().add(text4);
        text4.setFill(Color.RED);
        text4.setFont(new Font("Bookman Old Style", 20));
        Text text5 = new Text("Enter your registered email ID:");
        fp3.setMargin(text5, new Insets(30, 1, 1, 30));
        fp3.getChildren().add(text5);
        text5.setFont(new Font("Cambria", 18));          //Changes font size and type.
        TextField emailField = new TextField();
        fp3.setMargin(emailField, new Insets(40, 1, 1, 30));
        emailField.setPrefWidth(400);
        fp3.getChildren().add(emailField);
        Button enterEmail = new Button("Enter");        //Adds button to the FlowPane.
        fp3.setMargin(enterEmail, new Insets(30, 1, 1, 130));
        enterEmail.setPrefWidth(200);
        enterEmail.setDefaultButton(true);
        fp3.getChildren().add(enterEmail);
        final FlowPane recoveryEmail = new FlowPane();
        final Scene scene3 = new Scene(recoveryEmail, 400, 250);
        recoveryEmail.getStylesheets().add(GuiBank.class.getResource("userbg.css").toExternalForm());
        enterEmail.setOnAction(event -> {
            window.setTitle("Tic Tac Banking");
            window.setScene(scene3);
            window.show();
        });

        enterEmail.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                if (emailField.getText().isEmpty()) {                                                  //No values in the field will show an error.
                    showAlert(Alert.AlertType.ERROR, fp3.getScene().getWindow(), "Email Error!", "You did not enter the registered email.");
                    return;
                } else {

                    enterEmail.setOnAction(e -> {
                        window.setScene(scene3);
                    });
                }
            }

            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();
            }
        });
        recoveryEmail.setHgap(10);
        recoveryEmail.setVgap(10);
        Text text6 = new Text("Recovery email has been sent.");                //Text added to the pane.
        recoveryEmail.setMargin(text6, new Insets(50, 0, 0, 70));
        recoveryEmail.getChildren().add(text6);
        text6.setFont(new Font("Cambria", 18));                   //Changes font size and type.
        Image imgOk = new Image(getClass().getResourceAsStream("ok.png"));   //Adds image to the scene.
        ImageView img3 = new ImageView(imgOk);
        img3.setImage(imgOk);
        recoveryEmail.setMargin(img3, new Insets(30, 0, 0, 130));
        recoveryEmail.getChildren().add(img3);


        login.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    FileReader file = new FileReader("src\\login.txt");                              //To read text file.
                    BufferedReader reader = new BufferedReader(file);
                    String line;

                    if (accountName.getText().isEmpty() || (accessInput.getText().isEmpty())) {      //If no values are present in the TextFields, error message will pop up.
                        showAlert(Alert.AlertType.ERROR, startPane.getScene().getWindow(), "Login Error!", "You did not enter all the required or correct details.");
                        return;
                    }

                    while ((line = reader.readLine()) != null) {                                   //Reads the line.

                        if (line.contains(accountName.getText() + ", " + accessInput.getText())) { //Checks whether the account name and access pin match the values in the file.
                            if (accountdetails[0].accountPin.equals(accessInput.getText())) {
                                login.setOnAction(event1 -> {
                                    window.setScene(detailsScene1);
                                });

                            } else if (accountdetails[1].accountPin.equals(accessInput.getText())) {
                                login.setOnAction(event1 -> {
                                    window.setScene(detailsScene2);
                                });
                            } else if (accountdetails[2].accountPin.equals(accessInput.getText())) {
                                login.setOnAction(event1 -> {
                                    window.setScene(detailsScene3);
                                });
                            } else if (accountdetails[3].accountPin.equals(accessInput.getText())) {
                                login.setOnAction(event1 -> {
                                    window.setScene(detailsScene4);
                                });
                            } else if (accountdetails[4].accountPin.equals(accessInput.getText())) {
                                login.setOnAction(event1 -> {
                                    window.setScene(detailsScene5);
                                });
                            }

                        }
                    }
                } catch (Exception e) { //Outputs the error on the console.
                    System.out.println(e.getMessage());
                }
            }


            public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {       //Method for showing alert.
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.initOwner(owner);
                alert.show();


            }
        });

    }

    public void calculateLoan() {                                         //Method created for calculating and calling the Loan class.
        double loanField = Double.parseDouble(enterloanAmount.getText());
        int year = Integer.parseInt(enterPeriodAmount.getText());
        Loan loan = new Loan();                                          //New Loan object for calling yearlypayment and totalpayment calculation
        yearlyPayment.setText(String.valueOf(loan.getYearlyPayment(loanField, year)));
        totalPayment.setText(String.valueOf(loan.getTotalPayment(loanField, year)));
    }
}
