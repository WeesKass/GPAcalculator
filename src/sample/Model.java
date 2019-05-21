package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Model {

    //current number of rows
    int numberOfRows = 3;

    private double currentGpa = 0.0;

    //lists containing all of the credits, grades and course names
    private ArrayList<Integer> listOfCredits = new ArrayList<>();
    private ArrayList<String> listOfGrades = new ArrayList<>();
    private ArrayList<String> listOfCourseNames = new ArrayList<>();


    public void calculateGPA() {

        String grade;
        int courseHours ;
        double numberSemesterHours = 0.0;
        double totalCoursePoints = 0.0;
        double gradeScaled=0.0;

        for(int i = 0; i < numberOfRows; i++) {

            courseHours = listOfCredits.get(i);
            numberSemesterHours += courseHours;
            grade = listOfGrades.get(i);

            switch (grade){
                case("A+"):
                    gradeScaled = 4.3;break;

                case("A"):
                    gradeScaled = 4.0;break;

                case("A-"):
                    gradeScaled = 3.7;break;

                case("B+"):
                    gradeScaled = 3.5;break;

                case("B"):
                    gradeScaled = 3.0;break;

                case("B-"):
                    gradeScaled = 2.5;break;

                case("C"):
                    gradeScaled = 2.0;break;

                case("D"):
                    gradeScaled = 1.0;break;

                case("F"):{
                    gradeScaled = 0.0;break; }
            }

            totalCoursePoints += (courseHours*gradeScaled);
        }

        setCurrGPA(Math.round(totalCoursePoints/numberSemesterHours * 100.0) / 100.0);
    }


    public void setGradeList(ArrayList<ComboBox<String>> listOfGrades) {
        this.listOfGrades.clear();

        for(int i = 0; i < listOfGrades.size(); i++) {
            this.listOfGrades.add(listOfGrades.get(i).getValue());
        }
    }


    public void setCredits(ArrayList<TextField> listOfCredits) {
        for (int i = 0; i < listOfCredits.size(); i++) {
            if(!(listOfCredits.get(i).getText().equals("")) && !(listOfCredits.get(i).getText() == null)) {
                this.listOfCredits.add(Integer.parseInt(listOfCredits.get(i).getText()));
            }
        }
    }


    public void setCourseNameList(ArrayList<ComboBox<String>> listOfCourseNames) {
        this.listOfCourseNames.clear();

        for(int i = 0; i < listOfGrades.size(); i++) {
            this.listOfCourseNames.add(listOfCourseNames.get(i).getValue());
        }
    }


    public void setCurrGPA(double currGpa) {
        this.currentGpa = currGpa;
        return;
    }


    public double getCurrentGpa() {
        return currentGpa;
    }


    public int getNumOfRows(){
        return numberOfRows;
    }


    public void setNumOfRows(int numberOfRows){
        this.numberOfRows = numberOfRows;
    }


    public void resetData() {
        listOfCredits.clear();
        listOfGrades.clear();
        return;
    }
}