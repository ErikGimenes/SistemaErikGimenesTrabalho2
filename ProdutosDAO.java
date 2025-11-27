package dao;

import bean.EgProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author 08111349114
 */
public class ProdutosDAO extends GenericDAO<EgProdutos> {

    public ProdutosDAO() {
        super(EgProdutos.class);
    }

    public EgProdutos buscarPorCodigo(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgProdutos.class);
        criteria.add(Restrictions.eq("idProduto", codigo) );
        EgProdutos produto = (EgProdutos) criteria.uniqueResult();
        session.getTransaction().commit();
        return produto;
    }

    public List<EgProdutos> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgProdutos.class);
        List<EgProdutos> produtos = criteria.list();
        session.getTransaction().commit();
        return produtos;
    }
}
