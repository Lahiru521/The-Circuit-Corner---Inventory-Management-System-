package com.example.login;

import org.junit.jupiter.api.Test;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {
    @Test
    void enterAnIntegerValue(){
        Validations int_validation = new Validations();
        TextField textField =new TextField();
        Label label = new Label();

        textField.setText("100");
        int result = Integer.parseInt(String.valueOf(int_validation.int_validation(textField,label)));

        assertEquals(150,result,"Expected Value was Succeed");

    }


}