/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EgVenda;

/**
 *
 * @author 08111349114
 */
public class Eg_ControllerVenda extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EgVenda venda = (EgVenda) lista.get(rowIndex);
        if (columnIndex == 0) {
            return venda.getIdVenda(); // Código
        }
        if (columnIndex == 1) {
            return venda.getValorTotal(); // Valor total
        }
        if (columnIndex == 2) {
            return venda.getDataVenda(); // Data da venda
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Valor Total";
        }
        if (column == 2) {
            return "Data da Venda";
        }
        return "";
    }

}
