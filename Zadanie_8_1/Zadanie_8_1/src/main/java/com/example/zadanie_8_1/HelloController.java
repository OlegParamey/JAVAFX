package com.example.zadanie_8_1;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML public ComboBox<String> comboBoxQuestion;
    @FXML public TextField textFieldQuestion;
    @FXML public RadioButton rbA;
    @FXML public RadioButton rbB;
    @FXML public RadioButton rbC;
    @FXML public ToggleGroup toggleGroup;
    @FXML public Label results;
    @FXML public CheckBox cbA;
    @FXML public CheckBox cbB;
    @FXML public CheckBox cbC;
    @FXML public Button exitButton;
    @FXML public Label textFieldLabel;
    @FXML public Label comboBoxLabel;
    @FXML public Label checkBoxLabel;
    @FXML public Label radioBtnLabel;

    private BooleanBinding isPassed;

    public void closeApp(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void checkTest(ActionEvent actionEvent) {
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();

        boolean isCorrectTextQ     = textFieldQuestion.getText().equals("2026");
        boolean isCorrectRadioBtnQ = rb != null
                && rb.getText().equals("A - onAction=\"#checkTest\"");
        boolean isCorrectCheckBoxQ = cbA.isSelected()
                && !cbB.isSelected()
                && cbC.isSelected();
        boolean isCorrectComboBoxQ = comboBoxQuestion.getValue() != null
                && comboBoxQuestion.getValue().equals("HBox");

        showIfQuestionCorrect(isCorrectTextQ,     textFieldLabel);
        showIfQuestionCorrect(isCorrectComboBoxQ, comboBoxLabel);
        showIfQuestionCorrect(isCorrectCheckBoxQ, checkBoxLabel);
        showIfQuestionCorrect(isCorrectRadioBtnQ, radioBtnLabel);

        isPassed = Bindings.createBooleanBinding(
                () -> textFieldQuestion.getText().equals("2026")
                        && toggleGroup.getSelectedToggle() != null
                        && ((RadioButton) toggleGroup.getSelectedToggle())
                        .getText().equals("A - onAction=\"#checkTest\"")
                        && cbA.isSelected() && !cbB.isSelected() && cbC.isSelected()
                        && comboBoxQuestion.getValue() != null
                        && comboBoxQuestion.getValue().equals("HBox"),

                textFieldQuestion.textProperty(),
                toggleGroup.selectedToggleProperty(),
                cbA.selectedProperty(),
                cbB.selectedProperty(),
                cbC.selectedProperty(),
                comboBoxQuestion.valueProperty()
        );

        results.visibleProperty().bind(isPassed);
        results.managedProperty().bind(isPassed);
    }

    private void showIfQuestionCorrect(boolean isCorrect, Label label) {
        if (isCorrect) {
            label.setStyle("-fx-text-fill:green; -fx-font-size:16px; -fx-font-weight:bold");
            label.setText("Correct answer! ✓");
        } else {
            label.setStyle("-fx-text-fill:red; -fx-font-size:16px; -fx-font-weight:bold");
            label.setText("Incorrect answer! ⨯");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxQuestion.getItems().addAll("HBox", "VBox", "StackPane");

        toggleGroup = new ToggleGroup();
        rbA.setToggleGroup(toggleGroup);
        rbB.setToggleGroup(toggleGroup);
        rbC.setToggleGroup(toggleGroup);

        results.setVisible(false);
        results.setManaged(false);

        results.setStyle("-fx-text-fill:green; -fx-font-size:24px; -fx-font-weight:bold");
        results.setText("✓  Test PASSED");
    }
}