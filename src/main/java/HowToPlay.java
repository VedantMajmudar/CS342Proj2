import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HowToPlay {

public static void PlayPrompt() {
		
		Stage RuleWindow = new Stage();
		RuleWindow.initModality(Modality.APPLICATION_MODAL);
		RuleWindow.setTitle("How to Play / Prompt");
		RuleWindow.setMinWidth(250);
		
		Label RulesData = new Label();
		RulesData.setText(">>>>>>> HOW TO PLAY <<<<<<<<< ");
	
		VBox layout = new VBox(10);
		layout.getChildren().addAll(RulesData);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout);
		RuleWindow.setScene(scene);
		RuleWindow.showAndWait();
	}
	
	
	
}
