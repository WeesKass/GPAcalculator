package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Model {

    private ArrayList<Integer> listOfCredits = new ArrayList<>();
    private ArrayList<String> listOfGrades = new ArrayList<>();


    private double totalCreditPoints = 0.0;
    private double totalGradePoints = 0.0;

    int numberOfRows = 3;




    public void calculateGPA() {

        double numberSemesterHours = 0.0;
        double totalClassPoints = 0.0;
        double gradeScaled=0.0;
        int classHours = 0;
        String grade = "";


    }

    public void setGradeList(ArrayList<ComboBox<String>> listOfGrades) {

    }
    public void setCredits(ArrayList<TextField> listOfCredits) {

    }


    public int getNumOfRows() {
        return numberOfRows;
    }
    public void setNumOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

}