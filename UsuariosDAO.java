package dao;

import bean.EgUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * @author 08111349114
 */
public class UsuariosDAO extends GenericDAO<EgUsuarios> {

    public UsuariosDAO() {
        super(EgUsuarios.class);
    }

    public EgUsuarios buscarPorCodigo(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgUsuarios.class);
        criteria.add(Restrictions.eq("idUsuario", codigo) );
        EgUsuarios usuario = (EgUsuarios) criteria.uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }

    public List<EgUsuarios> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgUsuarios.class);
        List<EgUsuarios> usuarios = criteria.list();
        session.getTransaction().commit();
        return usuarios;
    }

    public EgUsuarios buscarPorCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(EgUsuarios.class);
        criteria.add(Restrictions.eq("cpf", cpf));
        EgUsuarios usuario = (EgUsuarios) criteria.uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }
}
