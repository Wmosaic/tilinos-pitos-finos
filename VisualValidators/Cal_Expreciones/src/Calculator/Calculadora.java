package Calculator;
import java.util.Stack;

public class Calculadora {

    Stack<Character> pila = new Stack<>();
    Stack<Character> pila_Operators = new Stack<>();
    Stack<String> pila_Operands = new Stack<>();
    boolean balanceado = true;

    /** Método para comprobar que la expresión aritmética esté correctamente escrita
     * Verifica que todos los paréntesis, corchetes y llaves estén balanceados.*/
    public boolean testing(String cadena) {
        if (cadena.isEmpty()){
            return false;
        }

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            // a) Si es un carácter de apertura, agregarlo a la pila
            if (c == '{' || c == '(' || c == '[') {
                pila.push(c);
            }
            // b) Si es un carácter de cierre, comprobar la pila
            else if (c == '}' || c == ')' || c == ']') {
                if (pila.empty()) {
                    balanceado = false;
                    break;
                }

                // c) Verificar si el carácter de apertura coincide
                char top = pila.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(') || (c == ']' && top != '[')) {
                    balanceado = false;
                    break;
                }
            }
        }

        // d) Verificar si quedaron caracteres sin cerrar
        if (!pila.empty()) {
            balanceado = false;
        }
        return balanceado;
    }

    /** Método para convertir una expresión aritmética de infija en postfija */
    public String posFija(String exp_IF) {
        char[] operators = {'^', '*', '/', '+', '-', '[', '{', '('};
        Stack<Integer> priority_InStack = new Stack<>();
        String auxExpression = "";

        int priority_OutStack = 0;
        String auxNum = "";
        char letra = 'a';

        String exp_POST = "";

        // 1) recorrer la expresión para obtener los caracteres
        for (int i = 0; i < exp_IF.length(); i++) {
            char c = exp_IF.charAt(i);

            // 2) Comprobar si el carácter es un operador o un operando
            boolean opValidator = true;
            for (char operator : operators) {
                // 3) Si el carácter es un operador entonces:
                if (c == operator) {

                    if (!auxNum.isEmpty()) {
                        auxExpression += auxNum + ",";
                        auxNum = "";
                        exp_POST += letra;
                        letra ++;
                    }

                    opValidator = false;
                    // Darle un valor previo de prioridad al operador
                    if (c == '[' || c == '{' || c == '(') {
                        priority_OutStack = 5;
                    }
                    if (c == '^') {
                        priority_OutStack = 4;
                    }
                    if (c == '*' || c == '/') {
                        priority_OutStack = 2;
                    }
                    if (c == '+' || c == '-') {
                        priority_OutStack = 1;
                    }

                    // 3.1) Si la pila esta vaciá, agregar el operador a la pila
                    if (pila_Operators.empty()) {
                        // Agregar el operador a la pila
                        pila_Operators.push(c);
                        priority_InStack.push(priority(c));
                    }
                    // 3.2) Si la pila no esta vaciá:
                    else {
                        // Comprobar el nivel de prioridad del operador
                        if (priority_OutStack > priority_InStack.peek()) {
                            pila_Operators.push(c);
                            priority_InStack.push(priority(c));
                        } else {
                            exp_POST += pila_Operators.pop();
                            pila_Operators.push(c);
                            auxExpression += "&,";

                        }
                    }
                    break;
                }
            }

            // 4) Si es un paréntesis derecho, entonces:
            if (c == ']' || c == '}' || c == ')') {

                // Si quedo algún número en la variable auxiliar, agregarlo
                if (!auxNum.isEmpty()) {
                    auxExpression += auxNum + ",";
                    auxNum = "";
                    exp_POST += letra;
                    letra ++;
                }

                opValidator = false;
                int size = pila_Operators.size();

                for (int j = 0; j < size; j++) {
                    char top = pila_Operators.pop();
                    priority_InStack.pop();

                    if (top == '[' || top == '{' || top == '(') {
                        break;
                    } else {
                        auxExpression += "&,";
                        exp_POST += top;
                    }
                }
            }

            if (opValidator) {
                // Guardar cifra de operando
                auxNum += c;
            }
        }

        // Si quedo algún número en la variable auxiliar, agregarlo
        if (!auxNum.isEmpty())
        {
            auxExpression += auxNum + ",";
            exp_POST += letra;
        }

        // 5) Si quedan elementos en la pila, pasarlos a la expresión postfija.
        while (!pila_Operators.empty() ) {
            auxExpression += "&,";
            exp_POST += pila_Operators.pop();
        }

        String[] cadena = auxExpression.split(",");

        // Invertir los datos operandos para poderlos trabajar
        for (int i = 0; i < cadena.length; i++) {
            pila_Operands.push(cadena[cadena.length - i - 1]);
        }

        return exp_POST;
    }

    /** Método para evaluar la expresión y regresar su resultado. */
    public double assessment(String ex_POST) {
        Stack<Double> numAux = new Stack<>();

        // a) Recorrer la expresión postfija
        for (int i = 0; i < ex_POST.length(); i++) {
            char c = ex_POST.charAt(i);
            String top = pila_Operands.pop();

            // Si el carácter es un operador entonces:
            if (top.equals("&")) {
                double z = 0;

                double b = numAux.pop();
                double a = numAux.pop();

                if (c == '^') {
                    z = power(a, b);
                }
                if (c == '*' || c == '/') {
                    z = switch (c) {
                        case '*' -> multiplication(a, b);
                        case '/' -> division(a, b);
                        default -> z;
                    };
                }
                if (c == '+' || c == '-') {
                    z = switch (c) {
                        case '+' -> addition(a, b);
                        case '-' -> subtraction(a, b);
                        default -> z;
                    };
                }
                numAux.push(z);
            }
            else {
                numAux.push(Double.valueOf(top));
            }
        }
        return numAux.peek();
    }

    /** Método para evaluar la prioridad de un operador. */
    private int priority (char c){
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '[', '{', '(' -> 0;
            default -> -1;
        };
    }


    public double addition (double a, double b) {
        return a + b;
    }

    public double subtraction (double a, double b) {
        return a - b;
    }

    public  double multiplication (double a, double b) {
        return a * b;
    }

    public  double division (double a, double b) {
        return a / b;
    }

    public double power (double a, double b) {
        return Math.pow(a, b);
    }

}
