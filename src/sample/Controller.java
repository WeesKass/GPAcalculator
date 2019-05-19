package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
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
	private Button resetButton;
	@FXML
	private Circle colorIdentifier;




	private final int MAX_ROWS_OF_COURSE = 12;

	
	private final Model model = new Model();
	private TextField courseName;
	private TextField creditsInput;
	private Text gradeName;
	private ComboBox<String> gradeInput;
	private Button removeButton;
	private ArrayList<TextField> listOfCredits = new ArrayList<>();
	private ArrayList<ComboBox<String>> listOfGrades = new ArrayList<>();



	@FXML
	private void calculateGPA(ActionEvent e) {

		model.setCredits(listOfCredits);
		model.setGradeList(listOfGrades);
		model.calculateGPA();

		gpaOutput.setText(model.getCurrGpa() + "");

		if (model.getCurrGpa() > 3.5){
			colorIdentifier.setFill(Color.rgb(0, 128, 0));
		}else if(model.getCurrGpa() > 2.5){
			colorIdentifier.setFill(Color.rgb(70, 130, 180));
		}else  if(model.getCurrGpa() > 1.5){
			colorIdentifier.setFill(Color.rgb(255, 215, 0));
		}else {
			colorIdentifier.setFill(Color.rgb(178, 34, 34));
		}

	}

	@FXML
	private void addRow(ActionEvent e) {

		if (model.getNumOfRows() > MAX_ROWS_OF_COURSE){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR: NO SPACE LEFT ON STAGE.");
			alert.setContentText(String.format("Sorry, It is possible to add only %s courses.", MAX_ROWS_OF_COURSE));
			alert.showAndWait();
			return;
		}

		courseName = new TextField();
		courseName.setPromptText("Ex: English");
		courseName.fontProperty().setValue(new Font(13));
		courseName.setId("text" + model.getNumOfRows());

		creditsInput = new TextField();
		creditsInput.setPromptText("Ex: 3");
		listOfCredits.add(creditsInput);
		creditsInput.setId("creditsInput" + model.getNumOfRows());

		gradeName = new Text("");
		gradeName.fontProperty().setValue(new Font(15));
		gradeName.setId("text" + model.getNumOfRows() + "" + model.getNumOfRows());

		gradeInput = new ComboBox<String>();
		gradeInput.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput);
		gradeInput.setId("gradeInput" + model.getNumOfRows());

		removeButton = new Button("-");
		removeButton.fontProperty().setValue(new Font(15));
		removeButton.setId("removeButton" + model.getNumOfRows());

		removeButton.setOnAction(event -> { removeRow(event); });

		inputGrid.add(courseName, 0, model.getNumOfRows());
		inputGrid.add(creditsInput, 1, model.getNumOfRows());
		inputGrid.add(gradeName, 2, model.getNumOfRows());
		inputGrid.add(gradeInput, 3, model.getNumOfRows());
		inputGrid.add(removeButton, 4, model.getNumOfRows());

		model.setNumOfRows(model.getNumOfRows()+1);

	}




	@FXML
	private void removeRow(ActionEvent event) {
		int row = inputGrid.getRowIndex((Node) event.getSource());
		ArrayList<Node> deleteNodes = new ArrayList<>(5);

		for (Node child : inputGrid.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(child);

			int r = rowIndex == null ? 0 : rowIndex;

			if (r > row) {
				GridPane.setRowIndex(child, r-1);
			} else if (r == row) {
				deleteNodes.add(child);
				child.setManaged(false);
			}
		}

		inputGrid.getChildren().removeAll(deleteNodes);
		model.setNumOfRows(model.getNumOfRows()-1);

		listOfGrades.remove(row);
		model.setGradeList(listOfGrades);
		listOfCredits.remove(row);
		for(int i = 0; i < listOfCredits.size(); i++)
		{
			System.out.println(listOfCredits.get(i).getText());
		}
		model.setCredits(listOfCredits);

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		listOfCredits.add(creditsInput0);
		gradeInput0.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput0);

		listOfCredits.add(creditsInput1);
		gradeInput1.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput1);

		listOfCredits.add(creditsInput2);
		gradeInput2.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput2);
	}


}