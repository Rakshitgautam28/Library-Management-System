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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IssuebookController implements Initializable {

    @FXML
    private JFXTextField bookid;

    @FXML
    private JFXTextField bookname;

    @FXML
    private JFXTextField publisher;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField pages;

    @FXML
    private JFXTextField studentid;

    @FXML
    private JFXTextField studentname;

    @FXML
    private JFXTextField phoneno;

    @FXML
    private JFXTextField course;

    @FXML
    private JFXTextField semester;

    @FXML
    private DatePicker issuedate;

    @FXML
    private JFXButton searchone;

    @FXML
    private JFXButton searchtwo;

    @FXML
    private JFXButton issue;

    @FXML
    private JFXButton back;
   
    @FXML
    private Label issued;
    
    
    private DBHandler handler;
    private PreparedStatement pst;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		issued.setVisible(false);
		bookid.setStyle("-fx-text-inner-color: #ffffff");
		studentid.setStyle("-fx-text-inner-color: #ffffff");
		bookname.setStyle("-fx-text-inner-color: #ffffff");
		studentname.setStyle("-fx-text-inner-color: #ffffff");
		publisher.setStyle("-fx-text-inner-color: #ffffff");
		phoneno.setStyle("-fx-text-inner-color: #ffffff");
		price.setStyle("-fx-text-inner-color: #ffffff");
		course.setStyle("-fx-text-inner-color: #ffffff");
		pages.setStyle("-fx-text-inner-color: #ffffff");
		semester.setStyle("-fx-text-inner-color: #ffffff");
		handler=new DBHandler();
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
	
	 @FXML
	    void searchoneAction(ActionEvent event) {

	    	String s1="SELECT * from books where ID=?";
			Connection connection=handler.getConnection();
			try 
			{
				pst=connection.prepareStatement(s1);
			
				pst.setString(1, bookid.getText());
				ResultSet rs= pst.executeQuery();
			
				int count=0;
			
				while(rs.next())
				{
					count=count+1;
					if(count==1)
					{
						bookname.setText(rs.getString(2));
						publisher.setText(rs.getString(3));
						price.setText(rs.getString(4));
						pages.setText(rs.getString(5));
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
	 
	 @FXML
	    void searchtwoAction(ActionEvent event) {
	    	
	    	String s2="SELECT * from students where ID=?";
			Connection connection=handler.getConnection();
			try 
			{
				pst=connection.prepareStatement(s2);
			
				pst.setString(1, studentid.getText());
				ResultSet rs= pst.executeQuery();
			
				int count=0;
			
				while(rs.next())
				{
					count=count+1;
					if(count==1)
					{
						studentname.setText(rs.getString(2));
						phoneno.setText(rs.getString(3));
						course.setText(rs.getString(4));
						semester.setText(rs.getString(5));
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
@FXML	 
 void issuebookAction(ActionEvent event) {
		 
		 String insert="INSERT INTO issue(BID,BName,Publisher,Price,Pages,SID,SName,Phoneno,Course,Semester,Dateofissue) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			Connection connection=handler.getConnection();
			
			try {
				
				pst=connection.prepareStatement(insert);
				pst.setString(1, bookid.getText());
				pst.setString(2, bookname.getText());
				pst.setString(3, publisher.getText());
				pst.setString(4, price.getText());
				pst.setString(5, pages.getText());
				pst.setString(6, studentid.getText());
				pst.setString(7, studentname.getText());
				pst.setString(8, phoneno.getText());
				pst.setString(9, course.getText());
				pst.setString(10, semester.getText());
				pst.setString(11, (issuedate.getEditor()).getText());
				pst.executeUpdate();
				issued.setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	 }
	 


}
