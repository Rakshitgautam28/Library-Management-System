package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ForgotpasswordController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXButton login;

    @FXML
    private JFXTextField answer;

    @FXML
    private Label question;

    @FXML
    private Label password;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton retrieve;

    private DBHandler handler;
    private PreparedStatement pst;
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		username.setStyle("-fx-text-inner-color: #ffffff");
		password.setStyle("-fx-text-inner-color: #ffffff");
		question.setStyle("-fx-text-inner-color: #ffffff");
		answer.setStyle("-fx-text-inner-color: #ffffff");
		handler=new DBHandler();
	}

	@FXML
	public void loginAction(ActionEvent e1) throws IOException
	{
		login.getScene().getWindow().hide();

		Stage Login=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
		Scene scene = new Scene(root);
		Login.setScene(scene);
		Login.show();
		Login.setResizable(false);
		Login.setTitle("Login");
	}
    
	public void searchAction(ActionEvent e2) throws IOException
	{
		String s1="SELECT * from accounts where Username=?";
		Connection connection=handler.getConnection();
		try 
		{
			pst=connection.prepareStatement(s1);
		
			pst.setString(1, username.getText());
			ResultSet rs= pst.executeQuery();
		
			int count=0;
		
			while(rs.next())
			{
				count=count+1;
				if(count==1)
				{
					question.setText("Question : "+rs.getString(5));
				}
				else
				{
					System.out.println("Username and password are not correct");
				}
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}	
	public void retriveAction(ActionEvent e3) throws IOException
	{
		String s1="SELECT * from accounts where Username=?";
		Connection connection=handler.getConnection();
		try 
		{
			pst=connection.prepareStatement(s1);
		
			pst.setString(1, username.getText());
			ResultSet rs= pst.executeQuery();
		
			int count=0;
		
			while(rs.next())
			{
				count=count+1;
				if(count==1)
				{
					password.setText("Password : "+rs.getString(3));
				}
				else
				{
					System.out.println("Username and password are not correct");
				}
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	} 
}