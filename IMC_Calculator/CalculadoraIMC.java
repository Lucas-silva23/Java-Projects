import javafx.application.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.geometry.*;

public class CalculadoraIMC extends Application{

	public void start(Stage stage){

		Label label = new Label("Calculadora De IMC");
		Label labelPeso = new Label("Peso: ");
		Label labelAltura = new Label("Altura: ");
		Label resultado = new Label();

		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");

		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em m");

		Button botaoCalcular = new Button("Calcular IMC");
		botaoCalcular.setOnAction(e -> {
			try{

				double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
				double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));

				double imc = peso / (altura * altura);

				resultado.setText(String.format("Seu IMC é: %.2f", imc));

			} catch(Exception err){
				System.out.println("Peso ou altura inválidos");
			}
		});

		VBox layout = new VBox(10, label, labelPeso, campoPeso, labelAltura, campoAltura, botaoCalcular, resultado);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout, 300, 300);
		scene.getStylesheets().add("style-calculadora.css");
		
		stage.setTitle("Calculadora de IMC");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}