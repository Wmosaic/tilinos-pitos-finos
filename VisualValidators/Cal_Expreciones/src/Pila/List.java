package Pila;
public class List <T> {
    private NodoD<T> head;
    private NodoD<T> tail;
    private int count;

//----------------------------Lista doble enlazada------------------------------//
//------------------------------------Add---------------------------------------//

    /** Método para agregar un nuevo Dato al inicio de la list */
    public void addFirst(T entry) {
        if (entry != null) {
            addFirst(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void addFirst(NodoD<T> entry) {
        if (head == null) {
            // a) Si la lista está vacía, entonces
            // el nuevo nodo será tanto (head) como (tail)
            head = tail = entry;
        } else {
            // b) El nuevo nodo se agrega al inicio
            entry.next = head;
            head.previous = entry;
            head = entry;
        }
        count++;
    }

    /** Método para agregar un nuevo Dato al final de la lista */
    public void add(T entry) {
        if (entry != null) {
            add(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void add(NodoD<T> entry) {
        if (head == null) {
            // a) Si la lista está vacía, entonces
            // el nuevo nodo será tanto (head) como (tail)
            head = tail = entry;
        } else {
            // b) El nuevo Nodo se agrega al final de la lista
            tail.next = entry;
            entry.previous = tail;
            tail = entry;
        }
        count++;
    }

    /** Método para agregar un nuevo Dato en cualquier lugar de la lista */
    public void addX(T entry, int index) {
        if (entry != null) {
            addX(new NodoD<>(entry), index);
        }
    }

    /** Método para insertar un nuevo Nodo a la lista */
    private void addX(NodoD<T> entry, int index) {
        // Si el índice está fuera de rango terminar función
        if (index < 0 || index > size()) {
            return;
        }

        if (index == 0) {
            // a) El nuevo nodo se agrega al inicio (head)
            addFirst(entry);
        } else if (index == size()) {
            // b) El nuevo nodo se agrega al final (tail)
            add(entry);
        } else {
            // c) Inserción en cualquier otra posición
            NodoD<T> actual = head;
            for (int i = 0; i < index; i++) {
                //Se cicla hasta llegar a la posicion deseada
                actual = actual.next;
            }
            //Conectar el nuevo nodo con el índice indicado
            entry.next = actual;
            //Conectar el nuevo nodo con el anterior del índice
            entry.previous = actual.previous;
            //Conectar el nodo anterior del índice con el nuevo
            actual.previous.next = entry;
            //Conectar el nodo índice con el nuevo nodo
            actual.previous = entry;
        }

        count++;
    }

//----------------------------Lista doble enlazada------------------------------//
//-----------------------------------Remove-------------------------------------//

    /** Método para eliminar el primer elemento de la lista */
    public NodoD<T> remove() {
        if (head == null) {
            // Si la lista está vacía, retorna (null)
            return null;
        }
        NodoD<T> eliminado = head;

        if (head == tail) {
            // a) Si la lista solo tiene un elemento, entonces
            // declarar (head) y (tail) como (null)
            head = tail = null;
        } else {
            // b) Sí hay más de un nodo
            // (head) será el nodo siguiente
            head = head.next;
            head.previous = null;
            // Desconectar el nodo eliminado
            eliminado.next = null;
        }
        count--;
        return eliminado;
    }

    /** Método para eliminar el último Nodo de la lista */
    public NodoD<T> removeLast() {
        if (head == null) {
            // Si la lista está vacía, retorna (null)
            return null;
        }
        NodoD<T> eliminado = tail;

        if (tail == head) {
            // a) Si la lista solo tiene un elemento, entonces
            // declarar (head) y (tail) como (null)
            head = tail = null;
        } else {
            // b) Si hay mas de un nodo
            // (tail) sera el nodo anterior
            tail = tail.previous;
            tail.next = null;
            // Desconectar el nodo eliminado
            eliminado.previous = null;
        }
        count--;
        return eliminado;
    }

    /** Método para eliminar un Nodo en específico de la lista */
    public NodoD<T> removeX(int index) {
        // Si el índice está fuera de rango regresar (null)
        if (index < 0 || index >= size()) {
            return null;
        }

        NodoD<T> eliminado = head;

        if (index == 0) {
            // a) El primer nodo se remueve (head)
            return remove();
        } else if (index == size()-1) {
            // b) el ultimo nodo se remueve (tail)
            return removeLast();
        } else {
            // c) remover nodo en cualquier otra posición
            for (int i = 0; i < index; i++) {
                //Se cicla hasta llegar a la posicion deseada
                eliminado = eliminado.next;
            }
            // El nodo anterior al índice se conecta con el posterior al índice
            eliminado.previous.next = eliminado.next;
            // El nodo posterior al índice se conecta con el anterior al índice
            eliminado.next.previous = eliminado.previous;
        }
        count--;
        return eliminado;
    }


//------------------------------------Pilas-------------------------------------//
//------------------------------------------------------------------------------//


    /** Método para agregar un nuevo Dato a la cola de la lista */
    public void push(T entry) {
        if (entry != null) {
            push(new NodoD<>(entry));
        }
    }

    /** Método para agregar un nuevo Nodo a la lista */
    private void push(NodoD<T> entry) {
        if (head == null) {
            head = tail = entry;
        } else {
            tail.next = entry;
            entry.previous = tail;
            tail = entry;
        }
        count++;
    }

    /** Método para eliminar el último Nodo de la lista */
    public NodoD<T> pop() {
        if (head == null) {
            return null;
        }
        NodoD<T> eliminado = tail;

        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            eliminado.previous = null;
        }
        count--;
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
            add(eliminado);
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

        return salida;
    }

    public String  toStringR(){
        String salida = "";
        NodoD<T> index = tail;
        while (index != null) {
            salida += index + "\n";
            index = index.previous;
        }

        return salida;
    }

}
