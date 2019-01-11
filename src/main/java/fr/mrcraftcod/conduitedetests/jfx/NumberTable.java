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
		
		TableColumn<Integer, Number> columnNumber = new TableColumn<>("Number");
		columnNumber.setCellValueFactory(value -> new SimpleIntegerProperty(value.getValue()));
		columnNumber.setSortable(false);
		
		//noinspection unchecked
		getColumns().addAll(columnNumber);
		
		this.setItems(data);
	}
}
