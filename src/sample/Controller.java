package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;
import java.util.ArrayList;


public class Controller implements Initializable
{
	@FXML
	private GridPane inputGrid;
	@FXML
	private Text text0;
	@FXML
	private TextField creditsInput0;
	@FXML
	private Text text00;
	@FXML
	private ComboBox<String> gradeInput0;
	@FXML
	private Button removeButton0;
	@FXML
	private Text text1;
	@FXML
	private TextField creditsInput1;
	@FXML
	private Text text11;
	@FXML
	private ComboBox<String> gradeInput1;
	@FXML
	private Button removeButton1;
	@FXML
	private Text text2;
	@FXML
	private TextField creditsInput2;
	@FXML
	private Text text22;
	@FXML
	private ComboBox<String> gradeInput2;
	@FXML
	private Button removeButton2;
	@FXML
	private Text gpaOutput;
	@FXML
	private Button calcButton;
	@FXML
	private Button addButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button newButton;

	
	private final Model model = new Model();
	private Text creditsName;
	private TextField creditsInput;
	private Text gradeName;
	private ComboBox<String> gradeInput;
	private Button removeButton;
	private ArrayList<TextField> listOfCredits = new ArrayList<TextField>();
	private ArrayList<ComboBox<String>> listOfGrades = new ArrayList<ComboBox<String>>();

	

	@FXML
	private void calculateGPA(ActionEvent e) {
		
	}


	@FXML
	private void addRow(ActionEvent e) {

	}


	@FXML
	private void saveSemester(ActionEvent e) {

	}
	


	@FXML
	private void newSemester(ActionEvent e) {

	}


	@FXML
	private void removeRow(ActionEvent event) {

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}



	
}