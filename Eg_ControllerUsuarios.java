/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EgUsuarios;

/**
 *
 * @author 08111349114
 */
public class Eg_ControllerUsuarios extends AbstractTableModel{

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
        EgUsuarios jjm_Usuario = (EgUsuarios) lista.get(rowIndex);
        if (columnIndex == 0){
            return jjm_Usuario.getIdUsuario();
        }
        if (columnIndex == 1){
            return jjm_Usuario.getNomeCompleto();
        }
        if (columnIndex == 2){
            return jjm_Usuario.getCpf();
        }
        if (columnIndex == 3){
            return jjm_Usuario.getDataNascimento();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Cpf";
        if (column == 3) return "Data Nascimento";
        return "";
    }
    
}
