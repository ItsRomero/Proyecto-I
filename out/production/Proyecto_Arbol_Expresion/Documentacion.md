
## Descripción General
El presente sistema implementa un **árbol de expresiones** en Java, capaz de:

- Convertir una expresión **infija** a **postfija**.
- Construir un **árbol binario de expresión**.
- Mostrar los recorridos del árbol:
  - Inorden
  - Preorden
  - Postorden
- Evaluar la expresión matemática ingresada.
- Visualizar gráficamente el árbol mediante una interfaz en **Swing**.

## Estructura del Proyecto

El sistema está compuesto por dos clases principales:

### Clase `Nodo`
Representa cada elemento del árbol.

**Atributos:**
- `String valor`: Valor del nodo (operador o variable).
- `Nodo izquierda`: Referencia al hijo izquierdo.
- `Nodo derecha`: Referencia al hijo derecho.


### Clase `ArbolExpresion`
Contiene la lógica principal del sistema.

**Funciones principales:**

- `esOperador(char c)`  
  Verifica si un carácter es un operador matemático.

- `prioridad(char c)`  
  Define la precedencia de operadores:
  - `+ -` → prioridad 1  
  - `* /` → prioridad 2  
  - `^` → prioridad 3  

- `infijaAPostfija(String expr)`  
  Convierte una expresión infija a postfija utilizando una pila.

- `construir(String post)`  
  Construye el árbol de expresión a partir de la notación postfija.

- Recorridos del árbol:
  - `inorden(Nodo r)`
  - `preorden(Nodo r)`
  - `postorden(Nodo r)`

- `evaluar(String post, Map valores)`  
  Evalúa la expresión mostrando el uso de la pila paso a paso.


### lase `DibujoArbol`
Permite visualizar el árbol de manera gráfica.

**Características:**
- Utiliza `JFrame` y `Graphics`.
- Dibuja nodos y conexiones de forma recursiva.
- Representa la estructura jerárquica del árbol.


## Funcionamiento del Sistema


1. El usuario ingresa una expresión matemática en formato infijo.  
   Ejemplo: (a+b)*c

2. El sistema:
- Valida la expresión.
- La convierte a postfija.
- Construye el árbol.

3. Se muestran los recorridos:
- Inorden
- Preorden
- Postorden

4. El usuario ingresa valores para las variables.

5. El sistema evalúa la expresión mostrando el proceso en pila.

6. Se abre una ventana gráfica con el árbol.


## Ejemplo de Ejecución

**Entrada:**

(a+b)*c

**Salida:**
Postfija: ab+c*

- Inorden: a + b * c
- Preorden: * + a b c
- Postorden: a b + c *

Simulacion de pila:
- Push 2 -> [2]
- Push 3 -> [2, 3]
- Operacion 2 + 3 = 5 -> [5]
- Push 4 -> [5, 4]
- Operacion 5 * 4 = 20 -> [20]

Resultado: 20


## Algoritmos Utilizados

- **Pila (Stack):**
  - Conversión de expresiones.
  - Evaluación matemática.

- **Recursividad:**
  - Recorridos del árbol.
  - Dibujo del árbol.

- **Árbol Binario:**
  - Representación estructurada de expresiones matemáticas.


## Interfaz Gráfica

La clase `DibujoArbol`:
- Dibuja cada nodo como texto.
- Une nodos mediante líneas.
- Distribuye el árbol usando coordenadas (x, y).


## Validaciones

- La expresión solo permite:

letras, números, operadores (+ - * / ^) y paréntesis

- Se evita el ingreso de caracteres inválidos.


## Limitaciones

- No soporta números de más de un dígito (ej: 12, 100).
- No maneja errores como división entre cero.
- El dibujo puede desordenarse en árboles muy grandes.


## Conclusión

El sistema demuestra la aplicación de estructuras de datos como **pilas y árboles binarios**, integrando además conceptos de **recursividad y visualización gráfica**, permitiendo comprender de manera práctica el procesamiento de expresiones matemáticas.

