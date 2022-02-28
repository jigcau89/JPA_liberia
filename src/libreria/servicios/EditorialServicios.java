
package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialServicios {
 //Creamos un EntityManager
    private static final EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public static void crearEditorial(){
        try {
            //Creamos un objeto Autor y le asignamos un nombre
            Editorial editorial = new Editorial();
            
            System.out.println("Ingrese nombre de la Editorial");
            editorial.setNombre(leer.next());
            
             editorial.setAlta(Boolean.TRUE);
            System.out.println("Se ingreso exitosamento la Editorial " + editorial.getNombre());

            //Iniciamos una transacción con el método getTransaction().begin();  para luego poder persistir.
            em.getTransaction().begin();
            //Persistimos el objeto. preservar la informacion de un objeto de forma permanente
            em.persist(editorial);
            //Terminamos la transacción con el método commit. Commit en programación
            //significa confirmar un conjunto de cambios, en este caso persistir el objeto
            em.getTransaction().commit();
            
        } catch (Exception e) {
        }
    }
}
