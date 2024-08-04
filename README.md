# Generador de Escalas y Acordes Musicales

## Descripción

El programa **Generador de Escalas y Acordes Musicales** es una aplicación en Java que permite al usuario generar escalas musicales a partir de una nota inicial y ver los acordes correspondientes en el círculo de quintas. El programa utiliza la teoría musical para calcular la secuencia de notas en una escala y los acordes relacionados.

## Estructura del Programa

El programa consta de tres clases principales:

- **`Nota`**: Representa una nota musical con un número y un nombre.
- **`Escala`**: Representa una escala musical que contiene una lista de notas, una progresión de intervalos y un nombre.
- **`Main`**: Contiene la lógica principal para generar escalas y acordes a partir de la nota inicial proporcionada por el usuario.

## Funcionalidades

- **Generación de Escalas**: Calcula la escala musical basada en una nota inicial y una progresión de intervalos.
- **Generación de Acordes del Círculo de Quintas**: Calcula los acordes basados en el círculo de quintas a partir de la nota inicial proporcionada.

## Uso

1. Al ejecutar el programa, se te pedirá que ingreses una nota inicial para la escala.
2. El programa generará la escala mayor a partir de la nota inicial usando una progresión fija de intervalos.
3. También generará los acordes correspondientes basados en el círculo de quintas.

## Ejemplo de Ejecución

```plaintext
=================================================== <[Entrada]> ==================================================
¿De qué nota quieres la escala?: LA#
=================================================== <[Escala]> ===================================================
LA# DO RE RE# FA SOL LA LA# 
=================================================== <[Circulo]> ===================================================
LA# RE# FA DOm SOLm 
==================================================================================================================