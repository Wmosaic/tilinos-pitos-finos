public class List <T>{
    private Nodo<T> head;
    private Nodo<T> tail;
    private int count;

    ///** Método para agregar un nuevo Dato "String" a la lista*/
    //public void add(String name) {
    //    add(new Nodo(name));
    //}

//------------------------------------------------------------------------------//

    /** Método para agregar un nuevo Dato a la cola de la lista*/
    public void add(T entry) {
        if (entry != null) {
            add(new Nodo<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista*/
    private void add(Nodo<T> entry) {
        //Si el Inicio y Final de la lista son Vacías (Null)
        if (head == null && tail == null) {
            //El Nodo se agrega al inicio y final de la lista
            head = tail = entry;
        } else {
            //El nuevo Nodo se agrega al final de la lista
            tail.next = entry;
            tail = entry;
        }
        count++;
    }

    /** Método para agregar un nuevo Dato a la cabeza de la lista*/
    public void addHead(T entry) {
        if (entry != null) {
            addHead(new Nodo<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista*/
    private void addHead(Nodo<T> entry) {
        if (head == null && tail == null) {
            //El Nodo se agrega al inicio y final de la lista
            head = tail = entry;
        } else {
            //El nuevo Nodo se agrega al inicio de la lista
            entry.next = head;
            head = entry;
        }
        count++;
    }

    /** Método para insertar un nuevo Dato en cualquier lugar de la lista*/
    public void insert(T entry, int position) {
        if (entry != null) {
            insert(new Nodo<>(entry), position);
        }
    }

    /** Método para insertar un nuevo Nodo a la lista*/
    private void insert(Nodo<T> entry, int position) {
        Nodo<T> anterior = head;

        if (position < 0 || position > size()) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites de la lista.");
        }

        // a) Si la lista está vacía
        if (head == null && tail == null) {
            head = tail = entry;
        } else if (position == 0) {
            // b) Si se quiere insertar al inicio
            entry.next = head;
            head = entry;
            if (tail == null) {
                tail = entry;
            }
        } else {
            // c) Inserción en cualquier otra posición
            for (int i = 1; i < position && anterior != null; i++) {
                anterior = anterior.next;
            }
            assert anterior != null;
            entry.next = anterior.next;
            anterior.next = entry;

            if (entry.next == null) {
                tail = entry;  // Si se inserta al final, actualizamos tail
            }
            count++;
        }
    }

    /** Método para eliminar un Nodo de la lista*/
    public Nodo<T> remove() {
        Nodo<T> eliminado = null;
        // a) Si la lista no existe retornar null
        if (size() == 0) {
            return eliminado;
        }
        // b) Si solamente hay un nodo en la lista
        eliminado = head;
        if (size() == 1) {
            // Se elimina el único elemento de la lista
            head = tail = null;
            count = 0;
            return eliminado;
        }
        // c) Si la lista tiene más de un elemento
        if (size() > 1) {
            head = head.next;       // Mover el inicio a la derecha
            eliminado.next = null;  //Desconectar el nodo borrado de la lista
            count --;
        }
        return eliminado;           // Devolver el Nodo borrado
    }

    /** Método para eliminar un Nodo en específico de la lista*/
    public Nodo<T> remove(int index) {
        Nodo<T> actual = head;
        Nodo<T> anterior = null;
        Nodo<T> eliminado;

        // a) Si la lista está vacía o el índice está fuera de rango retornar null
        if (index < 0 || index >= size()) {
            return null;
        }
        // b) Si se quiere eliminar el primer nodo
        if (index == 0) {
            eliminado = head;
            head = head.next;
            // Si se elimina el único nodo, tail debe ser null también
            if (head == null) {
                tail = null;
            }
        } else {
            // c) Se recorre la lista hasta llegar al nodo con el índice deseado
            for (int i = 0; i < index; i++) {
                anterior = actual;
                actual = actual.next;
            }
            eliminado = actual;
            anterior.next = actual.next; // Se desconecta el Nodo y se elimina

            // Si el nodo eliminado es el último, actualizar tail
            if (actual == tail) {
                tail = anterior;
            }
        }
        eliminado.next = null;
        count--;
        return eliminado;
    }

    /** Método para buscar un Nodo en específico de la lista*/
    public Nodo<T> search(int position) {
        Nodo<T> index;
        if (position < 0){
            return null;
        }
        index = head;
        for (int i = 0; i < position && index != null ; i++) {
            index = index.next;
        }
        return index;
    }

//------------------------------------------------------------------------------//

    /** Método para regresar el tamaño de la lista*/
    public int size(){
        return count;
    }

    @Override
    public String  toString(){
        String salida = "";
        Nodo<T> index = this.head;
        while (index != null) {
            salida += index + "\n";
            index = index.next;
        }
        return salida.toString();
    }

}
