import java.util.Stack;

public class Pila {
    private static final int MAX_ELEMENTOS = 10; // Límite de elementos en la pila
    private Stack<String> coleccion;

    public Pila() {
        coleccion = new Stack<String>();
    }

    public void push(String dato) throws Exception {
        if (coleccion.size() >= MAX_ELEMENTOS) {
            throw new Exception("Error: la pila está llena, no se pueden agregar más elementos.");
        }
        coleccion.push(dato);
    }

    public String pop() throws Exception {
        if (coleccion.empty()) {
            throw new Exception("Error: la pila está vacía, no se puede extraer ningún elemento.");
        }
        return coleccion.pop();
    }

    public String cima() throws Exception {
        if (coleccion.empty()) {
            throw new Exception("Error: la pila está vacía, no hay elementos en la cima.");
        }
        return coleccion.peek();
    }

    @Override
    public String toString() {
        StringBuilder listado = new StringBuilder();
        for (int i = coleccion.size() - 1; i >= 0; i--) {
            listado.append(coleccion.get(i) + "\n");
        }
        return listado.toString();
    }
}

