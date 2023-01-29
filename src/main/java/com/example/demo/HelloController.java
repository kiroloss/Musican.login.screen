package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private AnchorPane cancelbutton;

    @FXML
    private Button loginbutton;

    @FXML
    private TextField username;

    @FXML
    private PasswordField passwordPasswordfield;


    @FXML
    private Label loginmessagelabel;

    public void loginbuttononaction(ActionEvent actionEvent){
        if(username.getText().isBlank()==false && passwordPasswordfield.getText().isBlank()==false){
            loginmessagelabel.setText("You Try To Login !");
            validateLogin();
        }else {
            loginmessagelabel.setText("Please Enter The Username and Password");
        }
    }

    public void cancelbuttonaction(ActionEvent actionEvent){
        Stage stage =(Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        //this is simply the new instance of our DatabaseConnection
        DataBaseConnection connectNow= new DataBaseConnection();
        //calling the method which i created in databaseconnection class
        Connection connectDb =connectNow.getconnection();

        String verfiylogin="select count(1) from useraccounts where UserName='"+username.getText() +"'and Password='"+passwordPasswordfield.getText() +"'";

        try{

            Statement statement=connectDb.createStatement();
            ResultSet queryresult=statement.executeQuery(verfiylogin);

            while (queryresult.next()){
                if(queryresult.getInt(1)==1){
                    loginmessagelabel.setText("welcome");
                }else {
                    loginmessagelabel.setText("Invalid login try aagain");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}