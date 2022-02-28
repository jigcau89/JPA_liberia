package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;
/**
 * 
 * @author jigcau89
 */
public class AutorDAO extends DAO<Autor>{

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Autor objeto) {
        super.eliminar(objeto); //To change body of generated methods, choose Tools | Templates.
    }


//    public void eliminar(String nombre) {
//        Autor autor = buscarPorNombre(nombre);
//        super.eliminar(autor);
//    }

    public List<Autor> listarTodos() {
        conectar();
        List<Autor> autor = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autor;
    }

    public Autor buscarPorNombre(String nombre) {
        try {
            conectar();
        Autor autor  = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre", Autor.class)
                .setParameter("nombre", nombre).getSingleResult(); //getResulList();
        desconectar();
        return autor;
            
        } catch (Exception e) {
            throw e;
        }
            
    }
    
     public Autor buscarPorId(Integer id) throws Exception {
        conectar();
        Autor autor  = em.find(Autor.class, id);
        desconectar();
        return autor;
     }

//    public Autor buscarPorId(Integer id) {
//        conectar();
//        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a, IN(a.id) i WHERE i.id LIKE :id")
//                .setParameter("id", id).getSingleResult();
//        desconectar();
//        return autor;
//    }

    /**
     * Revisar esta pagina para aprender mas de los JOIN en JPQL
     * https://www.baeldung.com/jpa-join-types
     */
//    public List<Autor> buscarPorPaisYProvincia(String pais, String provincia) {
//        conectar();
//        //Opcion 1 sin JOIN
//        //        List<Persona> personas = em.createQuery("SELECT p FROM Persona p WHERE p.direccion.pais LIKE :pais AND p.direccion.provincia LIKE :provincia ")
//        //                .setParameter("pais", pais).setParameter("provincia", provincia).getResultList();
//        //Opcion 2 con JOIN
//        List<Autor> personas = em.createQuery("SELECT p FROM Persona p JOIN p.direccion d WHERE d.pais LIKE :pais AND d.provincia LIKE :provincia ")
//                .setParameter("pais", pais).setParameter("provincia", provincia).getResultList();
//        desconectar();
//        return personas;
//    }
}
