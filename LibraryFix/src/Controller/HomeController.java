package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private JFXButton addbook;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton addstudent;

    @FXML
    private JFXButton about;

    @FXML
    private JFXButton returnbook;

    @FXML
    private JFXButton issuebook;

    @FXML
    private JFXButton back;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	
	@FXML
    void aboutAction(ActionEvent event) throws IOException {
		about.getScene().getWindow().hide();

		Stage About=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/About.fxml"));
		Scene scene = new Scene(root);
		About.setScene(scene);
		About.show();
		About.setResizable(false);
		About.setTitle("About");
    }
	
	@FXML
	void backAction(ActionEvent event) throws IOException {
		back.getScene().getWindow().hide();

		Stage Login=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
		Scene scene = new Scene(root);
		Login.setScene(scene);
		Login.show();
		Login.setResizable(false);
		Login.setTitle("Login");
		
	}

    @FXML
    void addbookAction(ActionEvent event) throws IOException {
    	addbook.getScene().getWindow().hide();

		Stage Addbook=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Addbook.fxml"));
		Scene scene = new Scene(root);
		Addbook.setScene(scene);
		Addbook.show();
		Addbook.setResizable(false);
		Addbook.setTitle("Add book");
    }

    @FXML
    void addstudentAction(ActionEvent event) throws IOException {
    	addstudent.getScene().getWindow().hide();

		Stage Addstudent=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Addstudent.fxml"));
		Scene scene = new Scene(root);
		Addstudent.setScene(scene);
		Addstudent.show();
		Addstudent.setResizable(false);
		Addstudent.setTitle("Add Student");
    }

    @FXML
    void issuebookAction(ActionEvent event) throws IOException {
    	issuebook.getScene().getWindow().hide();

		Stage Issuebook=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Issuebook.fxml"));
		Scene scene = new Scene(root);
		Issuebook.setScene(scene);
		Issuebook.show();
		Issuebook.setResizable(false);
		Issuebook.setTitle("Issue Book");
    }

    @FXML
    void returnbookAction(ActionEvent event) throws IOException {
    	returnbook.getScene().getWindow().hide();

		Stage Returnbook=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Returnbook.fxml"));
		Scene scene = new Scene(root);
		Returnbook.setScene(scene);
		Returnbook.show();
		Returnbook.setResizable(false);
		Returnbook.setTitle("Return Book");
    }

    @FXML
    void searchAction(ActionEvent event) throws IOException {
    	search.getScene().getWindow().hide();

		Stage search=new Stage();

		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Search.fxml"));
		Scene scene = new Scene(root);
		search.setScene(scene);
		search.show();
		search.setResizable(false);
		search.setTitle("Search");
    }


}
