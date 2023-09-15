package com.example.lnflearntestcode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication {

  public static void main(String[] args) {

    CalculationRequest calculationRequest  = new CalculationRequestReader().read();
    long answer = new Calculator().calculate(calculationRequest.getNum1(), calculationRequest.getOperator(), calculationRequest.getNum2());

    System.out.println(answer);
  }
}