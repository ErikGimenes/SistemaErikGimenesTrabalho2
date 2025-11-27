/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EgVendedor;

/**
 *
 * @author 08111349114
 */
public class Eg_ControllerVendedor extends AbstractTableModel{

    List lista;
    
    public void setList(List lista){
     this. lista = lista;   
    }
    
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EgVendedor vendedor = (EgVendedor) lista.get(rowIndex);
        if (columnIndex == 0){
            return vendedor.getIdVendedor();
        }
        if (columnIndex == 1){
            return vendedor.getNomeCompleto();
        }
        if (columnIndex == 2){
            return vendedor.getEmail();
        }
        if (columnIndex == 3){
            return vendedor.getDataCadastro();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Email";
        if (column == 3) return "Data de Cadastro";
        return "";
    }
    
}
