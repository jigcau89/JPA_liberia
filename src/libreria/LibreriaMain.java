package libreria;

import libreria.servicios.AutorServicios;
/**
 * 
 * @author jigcau89
 */
public class LibreriaMain {

    public static void main(String[] args) {
        AutorServicios as = new AutorServicios();
        try {
            //    AutorServicios.crearAutor();
            //AutorServicios.modificarAutor();
            // AutorServicios.eliminarAutor();
            //as.busquedaAutorPorNombre();
           // as.modificarAlta();
            //as.modificarAutor();
          // as.eliminarAutor();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
