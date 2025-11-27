/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EgClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 08111349114
 */
public class ClientesDAO extends GenericDAO<EgClientes> {

    public ClientesDAO() {
        super(EgClientes.class);
    }



    public EgClientes buscarPorCodigo(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgClientes.class);
        criteria.add(Restrictions.eq("idCliente", codigo) );
        EgClientes cliente = (EgClientes) criteria.uniqueResult();
        session.getTransaction().commit();
        return cliente;
    }

    public List<EgClientes> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgClientes.class);
        List<EgClientes> clientes = criteria.list();
        session.getTransaction().commit();
        return clientes;
    }


}
