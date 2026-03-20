import java.util.*;

class Nodo {
    String valor;
    Nodo izquierda, derecha;

    Nodo(String v) {
        valor = v;
        izquierda = derecha = null;
    }
}

public class ArbolExpresion {

    static boolean esOperador(char c) {
        return "+-*/^".indexOf(c) != -1;
    }

    static int prioridad(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return 0;
    }

    // Convertir a postfija
    static String infijaAPostfija(String expr) {
        String res = "";
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    res += pila.pop();
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && prioridad(c) <= prioridad(pila.peek())) {
                    res += pila.pop();
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) res += pila.pop();

        return res;
    }

    // Construir árbol
    static Nodo construir(String post) {
        Stack<Nodo> pila = new Stack<>();

        for (int i = 0; i < post.length(); i++) {
            char c = post.charAt(i);

            if (!esOperador(c)) {
                pila.push(new Nodo(c + ""));
            } else {
                Nodo der = pila.pop();
                Nodo izq = pila.pop();
                Nodo n = new Nodo(c + "");
                n.izquierda = izq;
                n.derecha = der;
                pila.push(n);
            }
        }

        return pila.pop();
    }

    // Mostrar recorridos
    static void inorden(Nodo r) {
        if (r != null) {
            inorden(r.izquierda);
            System.out.print(r.valor + " ");
            inorden(r.derecha);
        }
    }

    static void preorden(Nodo r) {
        if (r != null) {
            System.out.print(r.valor + " ");
            preorden(r.izquierda);
            preorden(r.derecha);
        }
    }

    static void postorden(Nodo r) {
        if (r != null) {
            postorden(r.izquierda);
            postorden(r.derecha);
            System.out.print(r.valor + " ");
        }
    }

    // Evaluar mostrando la pila paso a paso
    static double evaluar(String post, Map<Character, Double> valores) {
        Stack<Double> pila = new Stack<>();

        System.out.println("\n--- Simulacion de pila ---");

        for (int i = 0; i < post.length(); i++) {
            char c = post.charAt(i);

            if (Character.isLetter(c)) {
                double val = valores.get(c);
                pila.push(val);
                System.out.println("Push " + val + " -> " + pila);
            } else {
                double b = pila.pop();
                double a = pila.pop();
                double r = 0;

                if (c == '+') r = a + b;
                if (c == '-') r = a - b;
                if (c == '*') r = a * b;
                if (c == '/') r = a / b;
                if (c == '^') r = Math.pow(a, b);

                pila.push(r);
                System.out.println("Operacion " + a + " " + c + " " + b + " = " + r + " -> " + pila);
            }
        }

        return pila.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese expresion:");
        String expr = sc.nextLine().replace(" ", "");

        if (!expr.matches("[a-zA-Z0-9+\\-*/^()]+")) {
            System.out.println("Expresion invalida");
            return;
        }

        String post = infijaAPostfija(expr);
        Nodo raiz = construir(post);

        System.out.println("\nPostfija: " + post);

        System.out.print("Inorden: "); inorden(raiz);
        System.out.print("\nPreorden: "); preorden(raiz);
        System.out.print("\nPostorden: "); postorden(raiz);

        Set<Character> vars = new HashSet<>();
        for (char c : expr.toCharArray()) {
            if (Character.isLetter(c)) vars.add(c);
        }

        Map<Character, Double> valores = new HashMap<>();

        for (char v : vars) {
            System.out.print("\nValor para " + v + ": ");
            valores.put(v, sc.nextDouble());
        }

        double res = evaluar(post, valores);

        System.out.println("\nResultado: " + res);

        new DibujoArbol(raiz);
    }
}
