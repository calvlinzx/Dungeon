package unsw.dungeon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {

    @FXML
    private Pane moving;
    @FXML
    private GridPane squares;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;
    @FXML
    private Button back2home;

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);
        dungeon.setEnemyObserver();
    }
    
    @FXML
	void goBack2home(ActionEvent event) throws IOException {
		go2homeScene("Homepafe.json");
	}

    private void go2homeScene(String string) throws IOException {
    	Stage primaryStage = (Stage) back2home.getScene().getWindow();
    	HomepageController hc = new HomepageController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        loader.setController(hc);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
	}

    
	@FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");

       // Add the ground first so it is below all other entities
       // for (int x = 0; x < dungeon.getWidth(); x++) {
       //     for (int y = 0; y < dungeon.getHeight(); y++) {
       //         squares.add(new ImageView(ground), x, y);
       //     }
       // }
        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);
    }
	
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	        	if(! node.getId().equals("player"))
	        		return node;
	        }
	    }
	    return null;
	}
	
	private void doThings2node(int x, int y) {
		Node node = getNodeFromGridPane(squares, x, y);
		if(node != null) {
			if(node.getId().equals("sword") || node.getId().equals("treasure") || node.getId().equals("key") ||
			   node.getId().equals("invincibility")) {
				squares.getChildren().remove(node);
				if(node.getId().equals("invincibility")) {
					player.useInvincibility();
				}
			}
			if(node.getId().equals("enemy") && player.battleEnemy()) {
				squares.getChildren().remove(node);
			}
		}
	}
	
	public void playerActs() {
		player.pickUp();
	}
	
    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
        case UP:
        	if(dungeon.canGoThere(player.getX(), player.getY()-1)) {
        		player.moveUp();
        		playerActs();
        		doThings2node(player.getX(), player.getY());
        	}
        	break;
        case DOWN:
        	if(dungeon.canGoThere(player.getX(), player.getY()+1)) {
        		player.moveDown();
        		playerActs();
        		doThings2node(player.getX(), player.getY());
        	}
        	break;
        case LEFT:
        	if(dungeon.canGoThere(player.getX()-1, player.getY())) {
        		player.moveLeft();
        		playerActs();
        		doThings2node(player.getX(), player.getY());
        	}
            break;
        case RIGHT:
        	if(dungeon.canGoThere(player.getX()+1, player.getY())){
        		player.moveRight();
        		playerActs();
        		doThings2node(player.getX(), player.getY());
        	}
            break;
        default:
            break;
        }
    }

}

