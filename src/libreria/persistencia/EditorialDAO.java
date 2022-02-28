
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;


public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    public void eliminar(String nombre) throws Exception {
        Editorial editorial = buscarPorNombre(nombre);
        super.eliminar(editorial);
    }

    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editorial = em.createQuery("SELECT e FROM Editorial e ").getResultList();
        desconectar();
        return editorial;
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e  WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return editorial;
    }
    
}
