package com.example.zadanie_7_1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public ComboBox comboBoxQuestion;
    public TextField textFieldQuestion;
    public RadioButton rbA;
    public RadioButton rbB;
    public RadioButton rbC;
    public ToggleGroup toggleGroup;
    public Label results;
    public CheckBox cbA;
    public CheckBox cbB;
    public CheckBox cbC;
    public Button exitButton;
    public Label textFieldLabel;
    public Label comboBoxLabel;
    public Label checkBoxLabel;
    public Label radioBtnLabel;

    public void closeApp(ActionEvent actionEvent){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void checkTest(ActionEvent actionEvent){
    RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();

    boolean isCorrectTextQ = textFieldQuestion.getText().equals("2026");
    boolean isCorrectRadioBtnQ = rb != null && rb.getText().equals("A - onAction=\"#checkTest\"");
    boolean isCorrectCheckBoxQ = cbA.isSelected() && !cbB.isSelected() && cbC.isSelected();
    boolean isCorrectComboBoxQ = comboBoxQuestion.getValue() != null && comboBoxQuestion.getValue().toString().equals("HBox");

    if(isCorrectTextQ){
        textFieldLabel.setStyle("-fx-text-fill:green; -fx-font-size: 16px; -fx-font-weight:bold");
        textFieldLabel.setText("Correct answer! ✓");
    } else {
        textFieldLabel.setStyle("-fx-text-fill:red; -fx-font-size: 16px; -fx-font-weight:bold");
        textFieldLabel.setText("Incorrect answer! ⨯");
    }

    if(isCorrectComboBoxQ){
        comboBoxLabel.setStyle("-fx-text-fill:green; -fx-font-size: 16px; -fx-font-weight:bold");
        comboBoxLabel.setText("Correct answer! ✓");
    } else {
        comboBoxLabel.setStyle("-fx-text-fill:red; -fx-font-size: 16px; -fx-font-weight:bold");
        comboBoxLabel.setText("Incorrect answer! ⨯");
    }

    if(isCorrectCheckBoxQ){
        checkBoxLabel.setStyle("-fx-text-fill:green; -fx-font-size: 16px; -fx-font-weight:bold");
        checkBoxLabel.setText("Correct answer! ✓");
    } else {
        checkBoxLabel.setStyle("-fx-text-fill:red; -fx-font-size: 16px; -fx-font-weight:bold");
        checkBoxLabel.setText("Incorrect answer! ⨯");
    }

    if(isCorrectRadioBtnQ){
        radioBtnLabel.setStyle("-fx-text-fill:green; -fx-font-size: 16px; -fx-font-weight:bold");
        radioBtnLabel.setText("Correct answer! ✓");
    } else {
        radioBtnLabel.setStyle("-fx-text-fill:red; -fx-font-size: 16px; -fx-font-weight:bold");
        radioBtnLabel.setText("Incorrect answer! ⨯");
    }

    boolean isPassed = isCorrectTextQ && isCorrectRadioBtnQ && isCorrectCheckBoxQ && isCorrectComboBoxQ;

    if(isPassed){
        results.setStyle("-fx-text-fill:green; -fx-font-size: 24px;");
        results.setText("Test passed");
    } else {
        results.setStyle("-fx-text-fill:red; -fx-font-size: 24px;");
        results.setText("Test failed");
    }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxQuestion.getItems().addAll("HBox", "VBox", "StackPane");

        toggleGroup = new ToggleGroup();
        rbA.setToggleGroup(toggleGroup);
        rbB.setToggleGroup(toggleGroup);
        rbC.setToggleGroup(toggleGroup);
    }

}
