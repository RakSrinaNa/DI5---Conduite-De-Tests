package fr.mrcraftcod.conduitedetests.jfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public class NumberTable extends TableView<Integer>{
	/**
	 * Constructor.
	 */
	public NumberTable(ObservableList<Integer> data){
		super();
		
		int colCount = 1;
		int padding = 2;
		
		TableColumn<Integer, Number> columnID = new TableColumn<>("Number");
		columnID.setCellValueFactory(value -> new SimpleIntegerProperty(value.getValue()));
		columnID.prefWidthProperty().bind(widthProperty().subtract(padding).divide(colCount));
		
		//noinspection unchecked
		getColumns().addAll(columnID);
		
		this.setItems(data);
	}
}
