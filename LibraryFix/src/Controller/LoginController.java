package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.DBHandler;


public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton login;

    @FXML
    private JFXCheckBox remember_me;

    @FXML
    private ImageView progress;

    @FXML
    private JFXButton forgotpassword;
    
    @FXML
    private Label incorrect;
	
	private DBHandler handler;
	private PreparedStatement pst;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		progress.setVisible(false);
		incorrect.setVisible(false);
		username.setStyle("-fx-text-inner-color: #ffffff");
		password.setStyle("-fx-text-inner-color: #ffffff");
		
		handler=new DBHandler();
	}

	@FXML
	public void loginAction(ActionEvent e) throws IOException
	{
		//Loading
		progress.setVisible(true);
		PauseTransition pt=new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev -> {
			
		});
		pt.play();
		
		//Retrive Data
		String s1="SELECT * from accounts where Username=? and Password=?";
		Connection connection=handler.getConnection();
		try 
		{
			pst=connection.prepareStatement(s1);
		
			pst.setString(1, username.getText());
			pst.setString(2, password.getText());
			ResultSet rs= pst.executeQuery();
			
			int count=0;
			
			while(rs.next())
			{
				count=count+1;
			}
			if(count==1)
			{
				login.getScene().getWindow().hide();

				Stage Home=new Stage();

				Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
				Scene scene = new Scene(root);
				Home.setScene(scene);
				Home.show();
				Home.setResizable(false);
				Home.setTitle("Home");
			}
			else
			{
				progress.setVisible(false);
				incorrect.setVisible(true);
				incorrect.setText("Username or password is incorrect");
				
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}	
	public void signAction(ActionEvent e1) throws IOException
	{
		signup.getScene().getWindow().hide();

		Stage Signup=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Signup.fxml"));
		Scene scene = new Scene(root);
		Signup.setScene(scene);
		Signup.show();
		Signup.setResizable(false);
		Signup.setTitle("SignUp");
	}
	public void forgotpasswordAction(ActionEvent e2) throws IOException
	{
		forgotpassword.getScene().getWindow().hide();

		Stage Forgotpassword=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Forgotpassword.fxml"));
		Scene scene = new Scene(root);
		Forgotpassword.setScene(scene);
		Forgotpassword.show();
		Forgotpassword.setResizable(false);
		Forgotpassword.setTitle("Forgot Password");
	}
}


