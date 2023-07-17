package temperature.convertor.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

	@FXML
    public Label welLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField textField;

	@FXML
	public Button convertButton;

	private static final String C_F = "Celsius to Fahrenheit";
	private static final String F_C = "Fahrenheit to Celsius";

	private boolean isC_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		choiceBox.getItems().add(C_F);
		choiceBox.getItems().add(F_C);

		choiceBox.setValue(C_F);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_F))
			{
				isC_F = true;
			}
			else
			{
				isC_F = false;
			}
		});

		convertButton.setOnAction(event ->
				convert());

	}

	private void convert() {
		String input = textField.getText();

		float enteredTemperature = 0.0f;

		try {
			enteredTemperature = Float.parseFloat(input);
		}
		catch(Exception ex)
		{
			warnUser();
			return;
		}
		float newTemperature = 0.0f;
		if(isC_F)
		{
			newTemperature = (enteredTemperature*9/5)+32;
		}
		else
		{
			newTemperature = (enteredTemperature-32)*5/9;
		}

		display(newTemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Entered Invalid Temperature");
		alert.setContentText("Enter a Valid Temperature");
		alert.show();
	}

	private void display(float newTemperature)
	{
		String unit = isC_F? "F" : "C";
		System.out.println("The Temperature is: " +newTemperature+ unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The Temperature is: " +newTemperature+ unit);
		alert.show();
	}
}
