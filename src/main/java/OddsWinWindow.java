import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OddsWinWindow {
	
public static void Odds() {
		
		Stage OddsWindow = new Stage();
		OddsWindow.initModality(Modality.APPLICATION_MODAL);
		OddsWindow.setTitle("Odds of Winning");
		OddsWindow.setMinWidth(250);
		
		Label OddsData = new Label();
		OddsData.setStyle("-fx-background-color: BLACK");
		OddsData.setTextFill(Color.LIME); 
		OddsData.setText(
				"10 == 1 in 789.16\n" + 
				"9  == 1 in 136.40\n" +
				"8  == 1 in 33.46\n" + 
				"7  == 1 in 11.58\n" + 
				"6  == 1 in 5.68\n" + 
				"5  == 1 in 4.00\n" +
				"4  == 1 in 4.16\n" + 
				"3  == 1 in 6.76\n" + 
				"2  == 1 in 19.13 \n" + 
				"1  == 1 in 124.75 \n" );
				
	

		VBox layout = new VBox(10);
		layout.getChildren().addAll(OddsData);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout, Color.BLACK);
		OddsWindow.setScene(scene);
		OddsWindow.showAndWait();

}
}
