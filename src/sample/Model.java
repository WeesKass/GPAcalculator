package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Model {

    private ArrayList<Integer> listOfCredits = new ArrayList<>();
    private ArrayList<String> listOfGrades = new ArrayList<>();

    int numberOfRows = 3;
    private double currGpa = 0.0;



    public void calculateGPA()
    {
        double numberSemesterHours = 0.0;
        double totalCoursePoints = 0.0;
        double gradeScaled=0.0;
        int courseHours ;
        String grade;

        for(int i = 0; i < numberOfRows; i++)
        {
            courseHours = listOfCredits.get(i);
            numberSemesterHours += courseHours;
            grade = listOfGrades.get(i);

            switch (grade){
                case("A+"):
                    gradeScaled = 4.0;break;

                case("A"):
                    gradeScaled = 4.0;break;

                case("A-"):
                    gradeScaled = 3.7;break;

                case("B+"):
                    gradeScaled = 3.3;break;

                case("B"):
                    gradeScaled = 3.0;break;

                case("B-"):
                    gradeScaled = 2.7;break;

                case("C+"):
                    gradeScaled = 2.3;break;

                case("C"):
                    gradeScaled = 2.0;break;

                case("C-"):
                    gradeScaled = 1.7;break;

                case("D+"):
                    gradeScaled = 1.3;break;

                case("D"):
                    gradeScaled = 1.0;break;

                case("D-"):
                    gradeScaled = 0.7;break;

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
            if(!(listOfCredits.get(i).getText().equals("")) && !(listOfCredits.get(i).getText() == null))
            {
                this.listOfCredits.add(Integer.parseInt(listOfCredits.get(i).getText()));
            }
        }
    }

    public void setCurrGPA(double currGpa) {
        this.currGpa = currGpa;
        return;
    }

    public double getCurrGpa() {
        return currGpa;
    }

    public int getNumOfRows(){
        return numberOfRows;
    }
    public void setNumOfRows(int numberOfRows){
        this.numberOfRows = numberOfRows;
    }
}