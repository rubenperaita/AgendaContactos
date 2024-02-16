package modelo.javabean;

import java.util.ArrayList;

// Interfaz para la gestión de la agenda de contactos
public interface GestioAgenda {

    // Método para dar de alta un nuevo contacto
    boolean altaContacto(Contacto contacto);

    // Método para eliminar un contacto existente
    boolean eliminarContacto(Contacto contacto);

    // Método para buscar un contacto por su nombre
    Contacto buscarUno(String nombre);

    // Método para buscar un contacto por su número de teléfono
    Contacto buscarTelefono(String telefono);

    // Método para buscar un contacto por su dirección de email
    Contacto buscarEmail(String email);

    // Método para buscar contactos cuyos tres primeros caracteres del nombre coincidan
    ArrayList<Contacto> buscarContactosPorTresPrimeros(String nombre);

    // Método para cambiar los datos de un contacto existente
    boolean cambiarDatos(Contacto contacto);

    // Método para buscar contactos asociados a una empresa específica
    ArrayList<Contacto> contactosPorEmpresa(String empresa);
}
