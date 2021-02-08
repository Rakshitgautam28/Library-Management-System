package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

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

public class SignupController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton female;
    
    @FXML
    private JFXTextField security_question;

    @FXML
    private JFXTextField answer;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton login;

    @FXML
    private ImageView progress;
    
    @FXML
    private Label complete;

    private DBHandler handler;
    private PreparedStatement pst;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		progress.setVisible(false);
		complete.setVisible(false);
		username.setStyle("-fx-text-inner-color: #ffffff");
		password.setStyle("-fx-text-inner-color: #ffffff");
		security_question.setStyle("-fx-text-inner-color: #ffffff");
		answer.setStyle("-fx-text-inner-color: #ffffff");
		handler=new DBHandler();
	}
	
	@FXML
	public void signupAction(ActionEvent e)
	{
		//Loading
		progress.setVisible(true);
		PauseTransition pt=new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev -> {
			
		});
		pt.play();
		
		String insert="INSERT INTO accounts(Username,Password,Gender,SecurityQuestion,Answer) VALUES(?,?,?,?,?)";
		Connection connection=handler.getConnection();
		
		try {
			
			pst=connection.prepareStatement(insert);
			pst.setString(1, username.getText());
			pst.setString(2, password.getText());
			pst.setString(3, getGender());
			pst.setString(4, security_question.getText());
			pst.setString(5, answer.getText());
			pst.executeUpdate();
			progress.setVisible(false);
			complete.setVisible(true);
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
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
	
	public String getGender() 
	{
		String gen="";
		
		if(male.isSelected())
		{
			gen="male";
		}
		else if(female.isSelected())
		{
			gen="female";
		}
		else 
		{
			System.out.println("Please select any one gender");
		}
		return gen;
	}
}
