package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomepageController {
	@FXML
	private Button level1;
	@FXML
	private Button level2;
	@FXML
	private Button level3;
	@FXML
	private Button level4;
	@FXML
	private Button level5;
	@FXML
	private Button level6;
	@FXML
	private Button level7;
	@FXML
	private Button level8;
	@FXML
	private Button level9;
	@FXML
	private Button level10;

	@FXML
	void go2level1(ActionEvent event) throws IOException {
		go2newScene("maze.json");
	}

	@FXML
	void go2level2(ActionEvent event) throws IOException {
		go2newScene("boulders.json");
	}
	
	@FXML
	void go2level3(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level4(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level5(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level6(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level7(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level8(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level9(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	@FXML
	void go2level10(ActionEvent event) throws IOException {
		go2newScene("advanced.json");
	}
	
	private void go2newScene(String file) throws IOException {
		Stage primaryStage = (Stage) level1.getScene().getWindow();
		DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(file);

		DungeonController controller = dungeonLoader.loadController();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		root.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}