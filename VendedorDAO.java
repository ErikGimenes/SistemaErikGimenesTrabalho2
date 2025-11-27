/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EgVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 08111349114
 */
public class VendedorDAO extends GenericDAO<EgVendedor> {

    public VendedorDAO() {
        super(EgVendedor.class);
    }



    public EgVendedor buscarPorCodigo(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgVendedor.class);
        criteria.add(Restrictions.eq("idVendedor", codigo) );
        EgVendedor vendedor = (EgVendedor) criteria.uniqueResult();
        session.getTransaction().commit();
        return vendedor;
    }

    public List<EgVendedor> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgVendedor.class);
        List<EgVendedor> vendedores = criteria.list();
        session.getTransaction().commit();
        return vendedores;
    }


}
