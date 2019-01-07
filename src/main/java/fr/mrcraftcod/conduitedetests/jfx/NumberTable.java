package fr.mrcraftcod.conduitedetests.jfx;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
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
		skinProperty().addListener((obs, oldSkin, newSkin) -> {
			final TableHeaderRow header = (TableHeaderRow) lookup("TableHeaderRow");
			header.reorderingProperty().addListener((o, oldVal, newVal) -> header.setReordering(false));
		});
		
		this.setItems(data);
	}
}
