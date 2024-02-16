package aplicaciones;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.javabean.AgendaContactos;
import modelo.javabean.Contacto;

public class AppGestinAgenda {

    // Variables estáticas para la agenda y el Scanner
    private static AgendaContactos adao;
    private static Scanner leer;

    // Bloque estático para inicializar las variables estáticas
    static {
        adao = new AgendaContactos();
        leer = new Scanner(System.in);
    }

    // Método principal
    public static void main(String[] args) {
        // Llama a varios métodos de prueba
        procAltaContacto();
        procBuscarUno();
        procBuscarTelefono();
        procBuscarEmail();
        procBuscarPorTresPrimeros();
        procCambiarDatos();
        procContactosPorEmpresa();
        procEliminarContacto();
    }

    // Método para dar de alta un nuevo contacto
    public static void procAltaContacto() {
        System.out.println("Ingrese datos del contacto:");
        Contacto contacto = new Contacto();
        contacto.setNombre(leer.next());
        contacto.setApellidos(leer.next());
        contacto.setEmail(leer.next());
        contacto.setEmpresa(leer.next());
        contacto.setTelefono(leer.next());
        if (adao.altaContacto(contacto)) {
            System.out.println("Alta realizada con éxito.");
        } else {
            System.out.println("Problemas al dar de alta al contacto.");
        }
    }

    // Método para eliminar un contacto
    public static void procEliminarContacto() {
        System.out.println("Ingrese el nombre del contacto a eliminar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            if (adao.eliminarContacto(contacto)) {
                System.out.println("Contacto eliminado con éxito.");
            } else {
                System.out.println("Problemas al eliminar el contacto.");
            }
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar un contacto por nombre
    public static void procBuscarUno() {
        System.out.println("Ingrese el nombre del contacto a buscar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar un contacto por teléfono
    public static void procBuscarTelefono() {
        System.out.println("Ingrese el número de teléfono a buscar:");
        String telefono = leer.next();
        Contacto contacto = adao.buscarTelefono(telefono);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar un contacto por email
    public static void procBuscarEmail() {
        System.out.println("Ingrese el email a buscar:");
        String email = leer.next();
        Contacto contacto = adao.buscarEmail(email);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar contactos por los tres primeros caracteres del nombre
    public static void procBuscarPorTresPrimeros() {
        System.out.println("Ingrese los tres primeros caracteres del nombre a buscar:");
        String tresPrimeros = leer.next();
        ArrayList<Contacto> resultados = adao.buscarContactosPorTresPrimeros(tresPrimeros);
        if (!resultados.isEmpty()) {
            System.out.println("Contactos encontrados: " + resultados);
        } else {
            System.out.println("Ningún contacto encontrado.");
        }
    }

    // Método para cambiar datos de un contacto
    public static void procCambiarDatos() {
        System.out.println("Ingrese el nombre del contacto a modificar:");
        String nombre = leer.next();
        Contacto contacto = adao.buscarUno(nombre);
        if (contacto != null) {
            System.out.println("Ingrese los nuevos datos del contacto:");
            contacto.setNombre(leer.next());
            contacto.setApellidos(leer.next());
            contacto.setEmail(leer.next());
            contacto.setEmpresa(leer.next());
            contacto.setTelefono(leer.next());
            if (adao.cambiarDatos(contacto)) {
                System.out.println("Datos cambiados con éxito.");
            } else {
                System.out.println("Problemas al cambiar los datos del contacto.");
            }
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar contactos por empresa
    public static void procContactosPorEmpresa() {
        System.out.println("Ingrese el nombre de la empresa para buscar contactos:");
        String empresa = leer.next();
        ArrayList<Contacto> resultados = adao.contactosPorEmpresa(empresa);
        if (!resultados.isEmpty()) {
            System.out.println("Contactos de la empresa " + empresa + ": " + resultados);
        } else {
            System.out.println("Ningún contacto encontrado para la empresa " + empresa + ".");
        }
    }
}