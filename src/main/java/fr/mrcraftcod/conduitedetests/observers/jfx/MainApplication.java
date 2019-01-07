package fr.mrcraftcod.conduitedetests.observers.jfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public class MainApplication extends Application{
	private Stage stage;
	private ViewController controller;
	private NumberTable numberTable;
	
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
		
		numberTable = new NumberTable(null);
		
		NumberField<Integer> numberInput = new NumberField<>();
		
		Button buttonPush = new Button("Push");
		buttonPush.setOnAction(evt -> {
			if(Objects.nonNull(controller)){
				controller.push(numberInput.getInt());
			}
		});
		
		Button buttonPop = new Button("Pop");
		buttonPop.setOnAction(evt -> {
			if(Objects.nonNull(controller)){
				controller.pop();
			}
		});
		
		Button buttonClear = new Button("Clear");
		buttonClear.setOnAction(evt -> {
			if(Objects.nonNull(controller)){
				controller.clear();
			}
		});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(numberInput, buttonPush, buttonPop, buttonClear);
		
		return root;
	}
	
	public void attachController(ViewController controller){
		this.controller = controller;
		this.numberTable.setItems(controller.getList());
	}
	
	public Stage getStage(){
		return stage;
	}
}
