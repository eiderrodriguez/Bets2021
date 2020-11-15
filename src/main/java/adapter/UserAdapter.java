package adapter;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.Apustua;
import domain.PertsonaErregistratua;

public class UserAdapter extends AbstractTableModel{
	private String[] columnNames = {"Event","Question","Event Date", "Bet(€)"};
	private Vector<Apustua> myBets;

	public UserAdapter(PertsonaErregistratua p){
		myBets = p.getApustuak();
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	public int getRowCount() {
		int size;
		if (myBets == null) {
			size = 0;
		}
		else {
			size = myBets.size();
		}
		return size;
	}
	public Object getValueAt(int row, int col) {
		Object temp = null;
		if (col == 0) {
			temp = myBets.get(row).getKuota().getGaldera().getEvent();
		}
		else if (col == 1) {
			temp = myBets.get(row).getKuota().getGaldera();
		}
		else if (col == 2) {
			temp = myBets.get(row).getApustuData();
		}
		else if (col == 3) {
			temp = myBets.get(row).getZenbatDiru();
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
}
