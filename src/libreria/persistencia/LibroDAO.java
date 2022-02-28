
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;
/**
 * 
 * @author jigcau89
 */

public class LibroDAO extends DAO<Libro>{
@Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public void eliminar(String nombre) {
        Libro libro = buscarPorNombre(nombre);
        super.eliminar(libro);
    }

    public List<Libro> listarTodos() {
        conectar();
        List<Libro> libro = em.createQuery("SELECT li FROM Libro li ")
                .getResultList();
        desconectar();
        return libro;
    }

    public Libro buscarPorNombre(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT li FROM Libro li WHERE li.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;
    }
    
     public Libro buscarPorIsbn(String isbn) throws Exception {
        conectar();
        Libro libro = em.find(Libro.class, isbn);
        desconectar();
        return libro;
     }
     public Libro buscarPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT li FROM Libro li WHERE li.titulo LIKE :titulo")
                .setParameter("nombre", titulo).getSingleResult();
        desconectar();
        return libro;
    }
}
