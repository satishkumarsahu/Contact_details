
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

//create a table model to display the contact images in the jtable
public class MyModel extends AbstractTableModel {
    
    private String[] columns;
    private Object[] [] rows;
    
    public MyModel(){}
    
    public MyModel(Object[] [] data,String[] columnsName){
        
      this.columns=columnsName;
      this.rows=data;
    }
    //index of the image coloum is 8
    public Class getColumnClass(int col){
        if(col==8){return Icon.class;}
        else{
            return getValueAt(0,col).getClass();
                    }
    }

    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return this.rows[i][i1];
        
    }
    
    @Override
    public String getColumnName(int col){
        
      return this.columns[col];
        
    }
    
    
}
