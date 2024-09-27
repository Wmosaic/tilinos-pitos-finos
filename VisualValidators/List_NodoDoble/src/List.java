public class List <T> {
    private NodoD<T> head;
    private NodoD<T> tail;
    private int count;

    ///** Método para agregar un nuevo Dato "String" a la lista*/
    //public void add(String name) {
    //    add(new Nodo(name));
    //}

//------------------------------------Add---------------------------------------//
//------------------------------------------------------------------------------//

    /** Método para agregar un nuevo Dato al inicio de la list */
    public void addFirst(T entry) {
        if (entry != null) {
            addFirst(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void addFirst(NodoD<T> entry) {
        if (head == null && tail == null) {
            //El Nodo se agrega al inicio y final de la lista
            head = tail = entry;
        } else {
            //El nuevo Nodo se agrega al inicio de la lista
            entry.next = head;
            if (head != null) {
                head.previous = entry;
            }
            head = entry;
            if (tail == null) {
                tail = entry;
            }
        }
        count++;
    }

    /** Método para agregar un nuevo Dato al final de la lista */
    public void addLast(T entry) {
        if (entry != null) {
            addLast(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void addLast(NodoD<T> entry) {
        //Si el Inicio y Final de la lista son Vacías (Null)
        if (head == null && tail == null) {
            //El Nodo se agrega al inicio y final de la lista
            head = tail = entry;
        } else {
            //El nuevo Nodo se agrega al final de la lista
            tail.next = entry;
            entry.previous = tail;
            tail = entry;
        }
        count++;
    }

    /** Método para agregar un nuevo Dato en cualquier lugar de la lista */
    public void addX(T entry, int position) {
        if (entry != null) {
            addX(new NodoD<>(entry), position);
        }
    }

    /** Método para insertar un nuevo Nodo a la lista */
    private void addX(NodoD<T> entry, int position) {
        NodoD<T> anterior = null;
        NodoD<T> actual = head;

        if (position < 0 || position > size()) {
            return;
        }

        // a) Si la lista está vacía
        if (head == null && tail == null) {
            head = tail = entry;
        } else if (position == 0) {
            // b) Si se quiere insertar al inicio
            addFirst(entry);
        } else {
            // c) Inserción en cualquier otra posición
            for (int i = 0; i < position; i++) {
                anterior = actual;
                actual = actual.next;
            }
            entry.next = actual;
            anterior.next = entry;
            entry.previous = anterior;

            if (actual != null) {
                actual.previous = entry;
            }
            // Sí se inserta en la última posición, actualizar tail
            if (entry.next == null) {
                tail = entry;
            }
        }
        count++; // Incrementar el tamaño de la lista
    }


    /** Método para agregar un nuevo Dato a la cola de la lista */
    public void push(T entry) {
        if (entry != null) {
            push(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void push(NodoD<T> entry) {
        //Si el Inicio y Final de la lista son Vacías (Null)
        if (head == null && tail == null) {
            //El Nodo se agrega al inicio y final de la lista
            head = tail = entry;
        } else {
            //El nuevo Nodo se agrega al final de la lista
            tail.next = entry;
            entry.previous = tail;
            tail = entry;
        }
        count++;
    }


    public void insertDirect(NodoD<T> entry) {

    }
    // a) Remover elemento de la lista
    // b) El primer nodo solamente agregarlo add
    // c) El siguiente elemento posicionar en la posición correcta alfabéticamente
    //      c.1 ) Si es Menor que el primero usar addHead
    //      c.2 ) Si es mayor al final usar add
    //      c.3 ) Si es en un intermedio usar insert

    // *) usar charAt.(0) para comparar


//-----------------------------------Remove-------------------------------------//
//------------------------------------------------------------------------------//

    /** Método para eliminar el primer elemento de la lista */
    public NodoD<T> removeFirst() {
        NodoD<T> eliminado = null;
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
            head.previous = null;
            eliminado.next = null;  //Desconectar el nodo borrado de la lista
            count--;
        }
        return eliminado;           // Devolver el Nodo borrado
    }

    /** Método para eliminar el último Nodo de la lista */
    public NodoD<T> removeLast() {
        NodoD<T> eliminado = null;
        if (head != null) {
            eliminado = tail;
            tail = tail.previous;
            tail.next = null;
            eliminado.previous = null;
            count--;
        }
        return eliminado;
    }

    /** Método para eliminar un Nodo en específico de la lista */
    public NodoD<T> removeX(int index) {
        NodoD<T> actual = head;
        NodoD<T> anterior = null;
        NodoD<T> eliminado;

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
            } else {
                head.previous = null;
            }
        } else {
            // c) Se recorre la lista hasta llegar al nodo con el índice deseado
            for (int i = 0; i < index; i++) {
                anterior = actual;
                actual = actual.next;
            }
            eliminado = actual;

            if (actual != null) {
                anterior.next = actual.next; // Se reconecta el nodo con el que le sigue
                // Eliminando el que queda entre medio
                actual.previous = anterior;
            } else {
                anterior.next = actual;
            }

            // Si el nodo eliminado es el último, actualizar tail
            if (actual == tail) {
                tail = anterior;
            }
        }
        eliminado.next = null;
        count--;
        return eliminado;
    }

    /** Método para eliminar el último Nodo de la lista */
    public NodoD<T> pop() {
        NodoD<T> eliminado = null;
        if (head != null) {
            eliminado = tail;
            if (tail.previous == null){
                head = tail = null;
            }else{
                tail = tail.previous;
                tail.next = null;
            }
            eliminado.previous = null;
            count--;
        }
        return eliminado;
    }


    public NodoD<T> penultimo(){
        NodoD<T> eliminado = null;
        if (size() > 1) {
            NodoD<T> actual = pop();
            eliminado = pop();
            push(actual);
            count--;
        }
        return eliminado;
    }

    public NodoD<T> antepenultimo(){
        NodoD<T> eliminado = null;
        if (size() > 2) {
            NodoD<T> actual = pop();
            NodoD<T> anterior = pop();
            eliminado = pop();
            push(anterior);
            push(actual);
            count--;
        }
        return eliminado;
    }

    public NodoD<T> fondo(){
        int size = this.size() - 1;
        NodoD<T>[] almacenado = new NodoD[size()-1];
        NodoD<T> eliminado = null;
        if (head != null) {
            //supongamos que la lista tiene 6 elementos;
            for (int i = 0; i < size; i++) {
                almacenado[i] = pop();
            }
            eliminado = pop();
            for (int i = 0; i < size; i++) {
                push(almacenado[size-i-1]);
            }
        }
        return eliminado;
    }



    /** Método para buscar un Nodo en específico de la lista*/
    public NodoD<T> search(int position) {
        NodoD<T> index;
        if (position < 0){
            return null;
        }
        index = head;
        for (int i = 0; i < position && index != null ; i++) {
            index = index.next;
        }
        return index;
    }

    public NodoD<T> peek(){
        NodoD<T> eliminado = null;
        if (head != null) {
            eliminado=pop();
            addLast(eliminado);
        }
        return eliminado;
    }

    /** Método para regresar el tamaño de la lista*/
    public int size(){
        return count;
    }

    @Override
    public String  toString(){
        String salida = "";
        NodoD<T> index = head;
        while (index != null) {
            salida += index + "\n";
            index = index.next;
        }

        return salida.toString();
    }

    public String  toStringR(){
        String salida = "";
        NodoD<T> index = tail;
        while (index != null) {
            salida += index + "\n";
            index = index.previous;
        }

        return salida.toString();
    }

}
