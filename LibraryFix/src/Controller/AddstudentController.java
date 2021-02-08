package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class AddstudentController implements Initializable{

    @FXML
    private JFXTextField studentid;

    @FXML
    private JFXTextField studentname;

    @FXML
    private JFXButton add;

    @FXML
    private JFXTextField semester;

    @FXML
    private JFXTextField course;

    @FXML
    private JFXTextField phoneno;

    @FXML
    private JFXButton back;
    
    @FXML
    private Label added;
    
    private DBHandler handler;
    private PreparedStatement pst;

    @FXML
    void addAction(ActionEvent event) {

    	String insert="INSERT INTO students(ID,Name,Phoneno,Course,Semester) VALUES(?,?,?,?,?)";
		Connection connection=handler.getConnection();
		
		try {
			
			pst=connection.prepareStatement(insert);
			pst.setString(1, studentid.getText());
			pst.setString(2, studentname.getText());
			pst.setString(3, phoneno.getText());
			pst.setString(4, course.getText());
			pst.setString(5, semester.getText());
			pst.executeUpdate();
			added.setVisible(true);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
    	
    	back.getScene().getWindow().hide();

		Stage Home=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
		Scene scene = new Scene(root);
		Home.setScene(scene);
		Home.show();
		Home.setResizable(false);
		Home.setTitle("Home");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		added.setVisible(false);
		studentid.setStyle("-fx-text-inner-color: #ffffff");
		studentname.setStyle("-fx-text-inner-color: #ffffff");
		phoneno.setStyle("-fx-text-inner-color: #ffffff");
		course.setStyle("-fx-text-inner-color: #ffffff");
		semester.setStyle("-fx-text-inner-color: #ffffff");
		handler=new DBHandler();
		
	}

}
