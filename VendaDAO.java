/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EgVenda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 08111349114
 */
public class VendaDAO extends GenericDAO<EgVenda> {

    public VendaDAO() {
        super(EgVenda.class);
    }




    public EgVenda buscarPorCodigo(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgVenda.class);
        criteria.add(Restrictions.eq("idVenda", codigo) );
        EgVenda venda = (EgVenda) criteria.uniqueResult();
        session.getTransaction().commit();
        return venda;
    }

    public List<EgVenda> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgVenda.class);
        List<EgVenda> vendas = criteria.list();
        session.getTransaction().commit();
        return vendas;
    }


}
