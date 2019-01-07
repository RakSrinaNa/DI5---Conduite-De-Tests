package fr.mrcraftcod.conduitedetests.observers.jfx;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.Observer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public class MainApplication extends Application implements Observer{
	private Stage stage;
	
	public void start(Stage stage){
		this.stage = stage;
		Scene scene = buildScene(stage);
		stage.setTitle(this.getFrameTitle());
		stage.setScene(scene);
		stage.sizeToScene();
		if(getIcon() != null){
			setIcon(getIcon());
		}
		stage.show();
	}
	
	public Scene buildScene(Stage stage){
		return new Scene(createContent(stage));
	}
	
	public String getFrameTitle(){
		return "Pile";
	}
	
	public Image getIcon(){
		return null;
	}
	
	private void setIcon(Image icon){
		this.stage.getIcons().clear();
		this.stage.getIcons().add(icon);
	}
	
	public Parent createContent(Stage stage){
		HBox root = new HBox();
		return root;
	}
	
	@Override
	public void update(Observable o, Object obj){
	
	}
	
	public Stage getStage(){
		return stage;
	}
}
