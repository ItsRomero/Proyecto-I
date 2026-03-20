Árbol de Expresiones en Java

📌 Descripción

Este proyecto implementa un sistema en Java que permite trabajar con expresiones matemáticas utilizando estructuras de datos como pilas (Stack) y árboles binarios.

El sistema recibe una expresión en formato infijo y realiza:

- Conversión a notación postfija  
- Construcción de árbol de expresión  
- Recorridos del árbol  
- Evaluación paso a paso  
- Visualización gráfica del árbol  

---

🚀 Funcionalidades

- Conversión de expresión infija a postfija  
- Construcción de árbol binario de expresión  
- Recorridos:
  - Inorden  
  - Preorden  
  - Postorden  
- Evaluación de la expresión con simulación de pila  
- Interfaz gráfica con Swing  

---

🧠 Conceptos aplicados

- Pilas (Stack)  
- Árboles binarios  
- Recursividad  
- Notación infija y postfija  
- Swing (JFrame, Graphics)  

---

🖥️ Ejemplo de uso

Entrada:
```bash
a+b
Valores:
a = 2
b = 3
Salida:
Postfija: ab+

Inorden: a + b  
Preorden: + a b  
Postorden: a b +  

--- Simulacion de pila ---
Push 2 -> [2]
Push 3 -> [2, 3]
Operacion 2 + 3 = 5 -> [5]

Resultado: 5
⚙️ Cómo ejecutar

Clonar repositorio:
git clone https://github.com/ItsRomero/Proyecto-I.git
Abrir en un IDE:
NetBeans
IntelliJ
Eclipse
Ejecutar: ArbolExpresion.java

🧪 Expresiones de prueba
a+b
(a+b)*c
a+b*(c-d)
(a+b)*(c-d)+e
a+b^c*(d-e)
🌳 Visualización

El sistema muestra el árbol en una ventana gráfica usando Swing.

⚠️ Validaciones
Solo se permiten:
Letras
Números
Operadores: + - * / ^
Paréntesis

❗ Limitaciones
No soporta números de más de un dígito
No maneja división entre cero
Dibujo básico del árbol

📁 Estructura
ArbolExpresion.java
DibujoArbol.java
README.md

👥 Integrantes
Oliver Fernando Romero Esquite


📚 Curso
Programación III

🏫 Universidad
Universidad Mariano Gálvez de Guatemala

📌 Estado
Proyecto finalizado
