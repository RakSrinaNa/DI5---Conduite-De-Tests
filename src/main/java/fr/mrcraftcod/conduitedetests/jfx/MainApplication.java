package fr.mrcraftcod.conduitedetests.jfx;

import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.reflect.Constructor;

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
			this.controller = constructor.newInstance(viewInputPile, 2);
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
		
		Button buttonPush = new Button("Push");
		buttonPush.setOnAction(evt -> {
			controller.push(numberInput.getInt());
			numberInput.reset();
		});
		
		Button buttonPop = new Button("Pop");
		buttonPop.setOnAction(evt -> {
			controller.pop();
			numberInput.reset();
		});
		
		Button buttonClear = new Button("Clear");
		buttonClear.setOnAction(evt -> {
			controller.clear();
			numberInput.reset();
		});
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(numberInput, buttonPush, buttonPop, buttonClear);
		
		root.getChildren().addAll(numberTable, buttons);
		return root;
	}
	
	public Stage getStage(){
		return stage;
	}
}
