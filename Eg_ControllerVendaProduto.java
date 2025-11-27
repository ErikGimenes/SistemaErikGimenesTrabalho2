/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EgVendaProdutos;

/**
 *
 * @author 08111349114
 */
public class Eg_ControllerVendaProduto extends AbstractTableModel {

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        EgVendaProdutos vendaProduto = (EgVendaProdutos) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendaProduto.getIdVendaProduto();
        }
        if (columnIndex == 1) {
            return vendaProduto.getEgProdutos().getNome();
        }
        if (columnIndex == 2) {
            return vendaProduto.getQuantidade();
        }
        if (columnIndex == 3) {
            return vendaProduto.getValorUnitario();
        }
        return "";
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Produto";
        }
        if (column == 2) {
            return "Quantidade";
        }
        if (column == 3) {
            return "Valor Unit.";
        }
        return "";
    }

}
