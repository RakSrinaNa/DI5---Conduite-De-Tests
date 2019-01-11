package fr.mrcraftcod.conduitedetests.jfx;

import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.reflect.Constructor;
import java.util.Optional;

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
	
	public static void main(String[] args){
		Application.launch(MainApplication.class, args);
	}
	
	public void start(Stage stage){
		try{
			String controllerClass = this.getParameters().getNamed().get("observer");
			Class klass = Class.forName(controllerClass);
			if(!klass.getSuperclass().equals(ViewController.class)){
				System.exit(1);
			}
			
			Class<ViewController> kklass = (Class<ViewController>) klass;
			
			Pile pile = new Pile();
			ViewInputPile viewInputPile = new ViewInputPile(pile);
			
			Constructor<ViewController> constructor = kklass.getConstructor(ViewInputPile.class, Integer.class);
			this.controller = constructor.newInstance(viewInputPile, Optional.ofNullable(this.getParameters().getNamed().get("limit")).map(Integer::parseInt).orElse(2));
			pile.addObserver(this.controller);
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
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
		VBox root = new VBox();
		
		numberTable = new NumberTable(controller.getList());
		
		NumberField<Integer> numberInput = new NumberField<>();
		numberInput.setMaxWidth(Double.MAX_VALUE);
		
		Button buttonPush = new Button("Push");
		buttonPush.setOnAction(evt -> {
			controller.push(numberInput.getInt());
			numberInput.reset();
		});
		numberInput.setOnKeyPressed((event) -> {
			if(event.getCode() == KeyCode.ENTER){
				buttonPush.fire();
			}
		});
		
		Button buttonPop = new Button("Pop");
		buttonPop.setOnAction(evt -> {
			try{
				controller.pop();
			}
			catch(ArrayIndexOutOfBoundsException e){
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error popping");
				alert.setHeaderText("You should be more careful");
				alert.setContentText("You can't pop a list that is empty!");
				alert.showAndWait();
			}
			numberInput.reset();
		});
		
		Button buttonClear = new Button("Clear");
		buttonClear.setOnAction(evt -> {
			controller.clear();
			numberInput.reset();
		});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(numberInput, buttonPush, buttonPop, buttonClear);
		
		VBox.setVgrow(numberTable, Priority.ALWAYS);
		HBox.setHgrow(numberInput, Priority.ALWAYS);
		root.getChildren().addAll(numberTable, buttons);
		return root;
	}
	
	public Stage getStage(){
		return stage;
	}
}
