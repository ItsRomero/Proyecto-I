import javax.swing.*;
import java.awt.*;

public class DibujoArbol extends JFrame {

    Nodo raiz;

    public DibujoArbol(Nodo r) {
        raiz = r;
        setTitle("Arbol");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        dibujar(g, raiz, 300, 100, 100);
    }

    void dibujar(Graphics g, Nodo n, int x, int y, int espacio) {
        if (n != null) {
            g.drawString(n.valor, x, y);

            if (n.izquierda != null) {
                g.drawLine(x, y, x - espacio, y + 50);
                dibujar(g, n.izquierda, x - espacio, y + 50, espacio / 2);
            }

            if (n.derecha != null) {
                g.drawLine(x, y, x + espacio, y + 50);
                dibujar(g, n.derecha, x + espacio, y + 50, espacio / 2);
            }
        }
    }
}
