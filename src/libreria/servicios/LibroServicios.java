package libreria.servicios;

import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author jigcau89
 */
public class LibroServicios {

    private final LibroDAO DAO;

    public LibroServicios() {
        this.DAO = new LibroDAO();
    }

    public Libro crearLibro() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
        
            System.out.print("Ingrese título del libro: ");
            String titulo = leer.next();
            System.out.print("Ingrese año de publicación: ");
            Integer anio = leer.nextInt();
            System.out.print("Ingrese cantidad de ejemplares: ");
            Integer ejemplares = leer.nextInt();
            System.out.print("Ingrese autor: ");
            String autor = leer.next();
            System.out.print("Ingrese editorial: ");
            String editorial = leer.next();
            Libro libro = new Libro(titulo, anio, ejemplares, autor, editorial);
//            libro.setTitulo(titulo);
//            libro.setAnio(anio);
//            libro.setEjemplares(ejemplares);
//            libro.setAutor(autor);
//            libro.setEditorial(editorial);
            DAO.guardar(libro);
            return libro;
            
            
        } catch (Exception e) {
              System.out.println(e.getMessage());
            return null;
        }
        
        
    }
    public void modificarLibro(){
        
    }
    public void eliminarLibro(){
        
    }
    
}
