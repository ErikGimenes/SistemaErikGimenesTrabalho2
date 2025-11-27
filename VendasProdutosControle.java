package eg_view;

import bean.EgVendaProdutos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendasProdutosControle extends AbstractTableModel {

    private List<EgVendaProdutos> lista = new ArrayList<EgVendaProdutos>();

    public void addBean(EgVendaProdutos egVendaProdutos) {
        lista.add(egVendaProdutos);
        fireTableDataChanged();
    }

    public void removeBean(int index) {
        lista.remove(index);
        fireTableDataChanged();
    }

    public EgVendaProdutos getBean(int index) {
        return lista.get(index);
    }

    public void setList(List<EgVendaProdutos> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public void updateBean(int index, EgVendaProdutos egVendaProdutos) {
        lista.set(index, egVendaProdutos);
        fireTableDataChanged();
    }

    public List<EgVendaProdutos> getList() {
        return lista;
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
        EgVendaProdutos egVendaProdutos = lista.get(rowIndex);
        if (columnIndex == 0) {
            return egVendaProdutos.getEgProdutos().getNome();
        } else if (columnIndex == 1) {
            return egVendaProdutos.getQuantidade();
        } else if (columnIndex == 2) {
            return egVendaProdutos.getValorUnitario();
        } else if (columnIndex == 3) {
            return egVendaProdutos.getQuantidade() * egVendaProdutos.getValorUnitario(); // Calcula o total
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Produto";
        } else if (column == 1) {
            return "Quantidade";
        } else if (column == 2) {
            return "Valor Unitário";
        } else if (column == 3) {
            return "Total";
        }
        return null;
    }
}

