package stad;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import stad.Reservation;



public class TableMOdele extends AbstractTableModel{
	
	private List<Reservation>liste=new ArrayList<>();
	private String titres[]= {"nom","email","date","heure"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}  

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch(c)
		{
		case 0:return liste.get(l).getNom();
		case 1:return liste.get(l).getEmail();
		case 2:return liste.get(l).getDate();
		case 3:return liste.get(l).getHeure();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	public void charger(List<Reservation>l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}