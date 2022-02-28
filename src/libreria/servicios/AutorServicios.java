package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;
/**
 * 
 * @author jigcau89
 */
public class AutorServicios {

    private final AutorDAO DAO;

    public AutorServicios() {
        this.DAO = new AutorDAO();
    }

    //Creamos un EntityManager
    //private static final EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Autor crearAutor() {
        try {
            //Creamos un objeto Autor y le asignamos un nombre
            Autor autor = new Autor();
            System.out.println("Ingrese nombre del autor");
            autor.setNombre(leer.next());
            autor.setAlta(Boolean.TRUE);
            System.out.println("Se ingreso exitosamento el Autor " + autor.getNombre());
            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
// public static void crearAutor() {
//        try {
//            //Creamos un objeto Autor y le asignamos un nombre
//            Autor autor = new Autor();
//            System.out.println("Ingrese nombre del autor");
//            autor.setNombre(leer.next());
//            autor.setAlta(Boolean.TRUE);
//            System.out.println("Se ingreso exitosamento el Autor " + autor.getNombre());
//            //Iniciamos una transacción con el método getTransaction().begin();  para luego poder persistir.
//            em.getTransaction().begin();
//            //Persistimos el objeto. preservar la informacion de un objeto de forma permanente
//            em.persist(autor);
//            //Terminamos la transacción con el método commit. Commit en programación
//            //significa confirmar un conjunto de cambios, en este caso persistir el objeto
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            throw e;
//        }
//
//    }

    public Autor modificarAutor() {
        try {
            Autor autor = new Autor();
            System.out.println("Que autor desea modificar,ingrese su ID");
            DAO.buscarPorId(leer.nextInt());
            //le asignamos un nuevo nombre
            System.out.println("Ingrese nuevo nombre: ");
            autor.setNombre(leer.next());
            DAO.editar(autor);

            if (autor != null) {
                System.out.println("Autor " + autor.getNombre() + " modificado correctamente");
            } else {
                System.out.println("Autor no encontrado");
            }
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    public static void modificarAutor() {
//        try {
//            System.out.println("Que autor desea modificar,inngrese su ID");
//            //usamos el metodo find para buscar el autor a editar
//            Autor autor = em.find(Autor.class, leer.nextInt());
//            System.out.println("Autor a modificar: " + autor.getNombre());
//            //le asignamos un nuevo nombre
//            System.out.println("Ingrese nuevo nombre: ");
//            autor.setNombre(leer.next());
//            em.getTransaction().begin();
//            //actualizamos el autor
//            em.merge(autor);  //igual al metodo persist pero, sirve para actualizar una entidad en la base de datos
//            em.getTransaction().commit();
//        } catch (Exception e) {
//        }
//    }
    public Autor eliminarAutor() throws Exception {
        try {

            System.out.println("Ingrese Id del autor a eliminar");
            Integer id = leer.nextInt();
            Autor autor = DAO.buscarPorId(id);
           
            if (id == null) {
                throw new Exception("debe indicar un id valido");
            }
            if (autor.getAlta()) {
                autor.setAlta(Boolean.FALSE);
                System.out.println("el autor ha sido eliminado");

            } else {
                System.out.println("el autor ya esta eliminado");
            }
            
            DAO.editar(autor);//piden que no eliminemos
      //      DAO.eliminar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
//    public static void eliminarAutor() {
//        try {
//            System.out.println("Ingrese Id del autor a eliminar");
//            Autor autor = em.find(Autor.class, leer.nextInt());
//            System.out.println("Autor a eliminar: " + autor.getNombre());
//            autor.setAlta(Boolean.FALSE);
//            em.getTransaction().begin();
//            //borramos el autor
//            em.remove(autor);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//        }
//    }

    public void modificarAlta() {
        try {
//            Autor autor = new Autor();
            System.out.println("Ingrese el id del autor que desea modificar su alta: ");
            Integer id = leer.nextInt();
            if (id == null) {
                throw new Exception("No existe un autor con ese id");
            }
            Autor autor = DAO.buscarPorId(id);

            System.out.println("Poner en alta=true(1) o alta=false (2)");
            int n = 0;
            n = leer.nextInt();

            if (n == 1) {
                autor.setAlta(Boolean.TRUE);
            } else {
                autor.setAlta(Boolean.FALSE);
            }
            DAO.editar(autor);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void busquedaAutorPorNombre() {
        try {
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor a buscar");
            String nombre = leer.next();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");

            }
            autor = DAO.buscarPorNombre(nombre);

            if (autor == null) {
                throw new Exception("No existe ningun autor con ese nombre");
            }
            System.out.println(autor);
            //List<Autor> autores = DAO.listarTodos();
            //autores = (List<Autor>) DAO.buscarPorNombre(nombre); 

//            if (autores.isEmpty()) {
//                System.out.println("Lista de autores vacia");
//            }
//            for (Autor a : autores) {
//                System.out.println(a);
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
