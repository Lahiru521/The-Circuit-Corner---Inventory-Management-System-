package com.example.login;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Validations { //Define a class name "Validations"
    public int int_validation(TextField textField, Label validationLabel1){ //Method to validate and parse an integer value from a TextField
        int value=0 ; //Initialize the value to 0
        try{
            String value_1 = textField.getText();
            value= Integer.parseInt(value_1); // Try to parse the input text as an Integer
            //System.out.println(value); //Return the value if successful
            return value;
        }catch(NumberFormatException e){
            validationLabel1.setText("You Entered Integer Type is Wrong");
        }
        if (value ==0){
            validationLabel1.setText("You Entered Integer Type is Wrong");
        }
        return value;
    }

    public float float_validation(TextField textField,Label validationLabel1){ //Method to validate and parse a float value from a TextField
        float value =0;//Initialize the value to 0
        try{
            String value_1= textField.getText();
            value = Float.parseFloat(value_1);//Try to parse the input text as a float
            //System.out.println(value);
            return value; //Return the parsed float value if successful
        } catch(Exception e){
            validationLabel1.setText("You Entered Wrong Data to Price Field");
        }
        if (value ==0){ //If parsing fails or the value is still 0 set validationLabel to display an error message
            validationLabel1.setText("You Entered Wrong Data to Price Field");
        }
        return value; //Return the parsed or default value
    }


    public String string_validation(TextField textField,Label validationlabel1) { //Method to validate and parse String value from the TextField
        String value = null; //Initialize the value to null
        try {
            value = textField.getText();
            //Check if the input matches a pattern(alphabet characters) and is not empty
            if (value.matches("[a-aA-Z]+") || !value.isEmpty() || !value.equals("")) {
                return value; // Return the input value if it matches the pattern
            }
        } catch (NumberFormatException e) {
            validationlabel1.setText("You entered A Wrong Category");
        }

        if (value.equals("")) {
            validationlabel1.setText("You entered A Wrong Category");
        }
        return value; //Return the input value or null
    }
    public String naming_validation(TextField textField,Label validationLabel1){ //Method to validate and parse String value from the TextField
       String value =null;
            try{
                value = textField.getText(); //Get the input text from the TextField
                //Checks if the input is not null, not empty and not an empty String
                if (value != null && !value.trim().isEmpty() && !value.equals("0") && !value.equals("")) {
                    return value; //Return the input Value
                }
            }catch(NumberFormatException e){
                validationLabel1.setText("You Entered Wrong Name");
            }
            if (value.equals("")){ //If the value is empty, set the validationLabel to indicate invalid input
                validationLabel1.setText("You Entered Wrong Name");
            }
            return value; // Return the input value or null
        }


    public String date_string_validation(TextField textField,Label validationLabel1){ //Method to validate and retrieve a date string value from a TextField
        String value = null;
            try{
                value = textField.getText(); //Get the input Text from the TextField
                value = value.replace("/"," "); //Replace slashes with spaces to ensure consistent date format
                System.out.println("Date:"+value);
                String [] date = value.split("\\s+"); //Split the date string into an array using spaces as delimiters

                // Check if the date has three parts and each part has the correct length
                if (date.length==3 &&  date[0].length()==2 && date[1].length()==2 && date[2].length()==4) {
                    return value; //Return the input value
                }else{
                    validationLabel1.setText("You entered date type is wrong");
                    return null; //Return null if the format is wrong
                }
            } catch (Exception e){
                validationLabel1.setText("You entered date type is wrong");
            }
            return null; // Return null if there is an date format or exception error

    }

}
