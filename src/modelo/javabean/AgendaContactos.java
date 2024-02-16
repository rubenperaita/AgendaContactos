package modelo.javabean;

import java.util.ArrayList;

// Clase que implementa la interfaz GestioAgenda para la gestión de una agenda de contactos
public class AgendaContactos implements GestioAgenda {

    // Atributos de la clase
    private String nombreAgenda;
    private ArrayList<Contacto> contactos;

    // Constructor de la clase
    public AgendaContactos() {
        // Inicialización de la agenda con un nombre predeterminado
        nombreAgenda = "Mi Agenda";
        // Inicialización de la lista de contactos
        contactos = new ArrayList<>();
        // Carga de datos iniciales en la agenda
        cargarDatos();
    }

    // Método privado para cargar datos iniciales en la agenda
    private void cargarDatos() {
        // Ejemplos de contactos predefinidos
        contactos.add(new Contacto("Ruben", "Peraita", "663478475", "ruben@ifp.es", "ifp"));
        contactos.add(new Contacto("Tomas", "Escudero", "663485458", "tomas@ifp.es", "ifp"));
        contactos.add(new Contacto("Joking", "Mel", "679083875", "joking@ifp.es", "ifp"));
        contactos.add(new Contacto("Sofia Camila", "Samano", "642923854", "@ifp.es", "ifp"));
    }

    // Implementación del método de la interfaz para dar de alta un nuevo contacto
    @Override
    public boolean altaContacto(Contacto contacto) {
        // Verifica si el contacto ya existe en la lista
        if (!contactos.contains(contacto)) {
            // Si no existe, lo agrega y retorna true
            contactos.add(contacto);
            return true;
        }
        // Si ya existe, retorna false
        return false;
    }

    // Implementación del método de la interfaz para eliminar un contacto
    @Override
    public boolean eliminarContacto(Contacto contacto) {
        // Intenta eliminar el contacto de la lista y retorna true si tuvo éxito
        return contactos.remove(contacto);
    }

    // Implementación del método de la interfaz para buscar un contacto por nombre
    @Override
    public Contacto buscarUno(String nombre) {
        // Crea un contacto temporal con el nombre proporcionado
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        // Busca la posición del contacto en la lista
        int pos = contactos.indexOf(contacto);
        // Si no se encuentra, retorna null; de lo contrario, retorna el contacto
        return (pos == -1) ? null : contactos.get(pos);
    }

    // Implementación del método de la interfaz para buscar un contacto por teléfono
    @Override
    public Contacto buscarTelefono(String telefono) {
        // Itera sobre los contactos y devuelve el primero con el número de teléfono proporcionado
        for (Contacto ele : contactos) {
            if (telefono.equals(ele.getTelefono())) {
                return ele;
            }
        }
        // Si no se encuentra, retorna null
        return null;
    }

    // Implementación del método de la interfaz para buscar un contacto por email
    @Override
    public Contacto buscarEmail(String email) {
        // Itera sobre los contactos y devuelve el primero con el email proporcionado
        for (Contacto ele : contactos) {
            if (email.equals(ele.getEmail())) {
                return ele;
            }
        }
        // Si no se encuentra, retorna null
        return null;
    }

    // Implementación del método de la interfaz para buscar contactos por los tres primeros caracteres del nombre
    @Override
    public ArrayList<Contacto> buscarContactosPorTresPrimeros(String nombre) {
        // Lista para almacenar los resultados de la búsqueda
        ArrayList<Contacto> resultados = new ArrayList<>();
        // Itera sobre los contactos y agrega aquellos cuyos tres primeros caracteres del nombre coinciden
        for (Contacto ele : contactos) {
            if (ele.getNombre().startsWith(nombre.substring(0, Math.min(nombre.length(), 3)))) {
                resultados.add(ele);
            }
        }
        // Retorna la lista de resultados
        return resultados;
    }

    // Implementación del método de la interfaz para cambiar datos de un contacto existente
    @Override
    public boolean cambiarDatos(Contacto contacto) {
        // Busca la posición del contacto en la lista
        int index = contactos.indexOf(contacto);
        // Si se encuentra, reemplaza el contacto y retorna true; de lo contrario, retorna false
        if (index != -1) {
            contactos.set(index, contacto);
            return true;
        }
        return false;
    }

    // Implementación del método de la interfaz para buscar contactos asociados a una empresa específica
    @Override
    public ArrayList<Contacto> contactosPorEmpresa(String empresa) {
        // Lista para almacenar los resultados de la búsqueda
        ArrayList<Contacto> resultados = new ArrayList<>();
        // Itera sobre los contactos y agrega aquellos que pertenecen a la empresa proporcionada
        for (Contacto ele : contactos) {
            if (empresa.equals(ele.getEmpresa())) {
                resultados.add(ele);
            }
        }
        // Retorna la lista de resultados
        return resultados;
    }
}