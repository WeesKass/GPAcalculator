package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;




public class Controller implements Initializable {

	@FXML
	private MenuItem reset;
	@FXML
	private MenuItem edit;
	@FXML
	private MenuItem about;
	@FXML
	private MenuItem exit;

	@FXML
	private GridPane inputGrid;

	@FXML
	private TextField nameInput0;
	@FXML
	private TextField creditsInput0;
	@FXML
	private ComboBox<String> gradeInput0;
	@FXML
	private Button removeButton0;

	@FXML
	private TextField nameInput1;
	@FXML
	private TextField creditsInput1;
	@FXML
	private ComboBox<String> gradeInput1;
	@FXML
	private Button removeButton1;

	@FXML
	private TextField nameInput2;
	@FXML
	private TextField creditsInput2;
	@FXML
	private ComboBox<String> gradeInput2;
	@FXML
	private Button removeButton2;

	@FXML
	private Circle colorIdentifier;
	@FXML
	private Text gpaOutput;

	@FXML
	private Button calcButton;
	@FXML
	private Button addButton;


	private final int MAX_ROWS_OF_COURSE = 12;
	final Tooltip removeTooltip = new Tooltip("Remove this course");


	
	private final Model model = new Model();
	private TextField courseName;
	private TextField creditsInput;
	private Text gradeName;
	private ComboBox<String> gradeInput;
	private Button removeButton;
	private ArrayList<TextField> listOfCredits = new ArrayList<>();
	private ArrayList<ComboBox<String>> listOfGrades = new ArrayList<>();
	private ArrayList<TextField> listOfCourseNames = new ArrayList<>();



	@FXML
	private void calculateGPA(ActionEvent e) {
		if(model.getNumOfRows() == 0) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("ERROR: NO FIELD(S) FOUND.");
		alert.setContentText("Please make sure you have at least one course row  before pressing Calculate button.");
		alert.showAndWait();
		return;
	}

		model.setCredits(listOfCredits);
		model.setGradeList(listOfGrades);
		model.calculateGPA();

		gpaOutput.setText(model.getCurrGpa() + "");
		colorIdentifier.setVisible(true);

		if (model.getCurrGpa() > 3.5){
			colorIdentifier.setFill(Color.rgb(0, 128, 0));
		}else if(model.getCurrGpa() > 2.5){
			colorIdentifier.setFill(Color.rgb(70, 130, 180));
		}else  if(model.getCurrGpa() > 1.5){
			colorIdentifier.setFill(Color.rgb(255, 215, 0));
		}else {
			colorIdentifier.setFill(Color.rgb(178, 34, 34));
		}
		reset.setDisable(false);
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
		listOfCourseNames.add(creditsInput);
		courseName.fontProperty().setValue(new Font(13));
		courseName.setId("nameInput" + model.getNumOfRows());

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
		removeButton.setTooltip(removeTooltip);

		removeButton.setOnAction(event -> { removeRow(event); });

		inputGrid.add(courseName, 0, model.getNumOfRows());
		inputGrid.add(creditsInput, 1, model.getNumOfRows());
		inputGrid.add(gradeName, 2, model.getNumOfRows());
		inputGrid.add(gradeInput, 3, model.getNumOfRows());
		inputGrid.add(removeButton, 4, model.getNumOfRows());

		model.setNumOfRows(model.getNumOfRows()+1);
		reset.setDisable(false);

	}


	@FXML
	private void removeRow(ActionEvent event) {
		int row = inputGrid.getRowIndex((Node) event.getSource());
		ArrayList<Node> deleteNodes = new ArrayList<>(5);

		nodeDeleter(row,deleteNodes);
		model.setNumOfRows(model.getNumOfRows()-1);

		listOfGrades.remove(row);
		model.setGradeList(listOfGrades);
		listOfCredits.remove(row);

		for(int i = 0; i < listOfCredits.size(); i++) {
			listOfCredits.get(i).getText();
		}
		model.setCredits(listOfCredits);

    }


	@FXML
	void exit(ActionEvent event) {
		Platform.exit();

	}
	@FXML
	void resetAction(ActionEvent event) {

		for(int i = model.getNumOfRows(); i > 2; i--) {
			int row = i;
			ArrayList<Node> deleteNodes = new ArrayList<>(5);
			nodeDeleter(row,deleteNodes);
		}

		for(int j = model.getNumOfRows()-1; j > 3; j--) {
			listOfCredits.remove(listOfCredits.get(j));
			listOfGrades.remove(listOfGrades.get(j));
			listOfCourseNames.remove(listOfCourseNames.get(j));
		}model.setNumOfRows(3);


		for(int k = 0; k < model.getNumOfRows(); k++) {
			listOfCredits.get(k).clear();
			listOfGrades.get(k).valueProperty().set(null);
			listOfCourseNames.get(k).clear();

		}model.resetData();
		gpaOutput.setText("");
		reset.setDisable(true);
		colorIdentifier.setVisible(false);
	}

	@FXML
	void aboutAction(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/sample/About.fxml"));
			Stage aboutWindow = new Stage();
			aboutWindow.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(root, 343, 486);
			aboutWindow.setScene(scene);
			aboutWindow.setTitle("About My Project");
			aboutWindow.showAndWait();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	@FXML
	void editAction(ActionEvent event) {

	}

	public void nodeDeleter(int row, ArrayList deleteNodes){
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
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		reset.setDisable(true);


		listOfCredits.add(creditsInput0);
		gradeInput0.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput0);
		listOfCourseNames.add(nameInput0);

		listOfCredits.add(creditsInput1);
		gradeInput1.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput1);
		listOfCourseNames.add(nameInput1);

		listOfCredits.add(creditsInput2);
		gradeInput2.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F");
		listOfGrades.add(gradeInput2);
		listOfCourseNames.add(nameInput2);
	}
}