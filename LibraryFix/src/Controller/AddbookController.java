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

public class AddbookController implements Initializable {

    @FXML
    private JFXTextField bookid;

    @FXML
    private JFXTextField bookname;

    @FXML
    private JFXButton add;

    @FXML
    private JFXTextField pages;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField publisher;

    @FXML
    private JFXButton back;
    
    @FXML
    private Label added;

    private DBHandler handler;
    private PreparedStatement pst;

    
    @FXML
    void addAction(ActionEvent event) {

    	String insert="INSERT INTO books(ID,Name,Publisher,Price,Pages) VALUES(?,?,?,?,?)";
		Connection connection=handler.getConnection();
		
		try {
			
			pst=connection.prepareStatement(insert);
			pst.setString(1, bookid.getText());
			pst.setString(2, bookname.getText());
			pst.setString(3, publisher.getText());
			pst.setString(4, price.getText());
			pst.setString(5, pages.getText());
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
		bookid.setStyle("-fx-text-inner-color: #ffffff");
		bookname.setStyle("-fx-text-inner-color: #ffffff");
		publisher.setStyle("-fx-text-inner-color: #ffffff");
		price.setStyle("-fx-text-inner-color: #ffffff");
		pages.setStyle("-fx-text-inner-color: #ffffff");
		handler=new DBHandler();
		
		// TODO Auto-generated method stub
		
	}

}
