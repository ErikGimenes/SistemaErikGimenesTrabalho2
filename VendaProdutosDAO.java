package dao;

import bean.EgVendaProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * DAO para gerenciar produtos de vendas
 * @author Sistema Erik Gimenes
 */
public class VendaProdutosDAO extends GenericDAO<EgVendaProdutos> {

    public VendaProdutosDAO() {
        super(EgVendaProdutos.class);
    }

    public List<EgVendaProdutos> buscarPorVenda(int idVenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgVendaProdutos.class);
        criteria.add(Restrictions.eq("egVenda.idVenda", idVenda));
        List<EgVendaProdutos> vendaProdutos = criteria.list();
        session.getTransaction().commit();
        return vendaProdutos;
    }

    public void deletePorVenda(int idVenda) {
        session.beginTransaction();
        List<EgVendaProdutos> vendaProdutos = buscarPorVenda(idVenda);
        for (EgVendaProdutos vp : vendaProdutos) {
            session.delete(vp);
        }
        session.getTransaction().commit();
    }
}
