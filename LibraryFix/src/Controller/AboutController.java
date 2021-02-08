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

public class AboutController implements Initializable{

    @FXML
    private JFXButton back;

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
		// TODO Auto-generated method stub
		
	}

}