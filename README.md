# Programación II — Portfolio Java

![Java](https://img.shields.io/badge/Java-Programaci%C3%B3n%20II-blue)
![Estado](https://img.shields.io/badge/estado-revisado-brightgreen)
![Tipo](https://img.shields.io/badge/tipo-portfolio%20acad%C3%A9mico-lightgrey)

Repositorio académico con proyectos realizados en **Java** durante la asignatura **Programación II**.

El objetivo de este repositorio es presentar las prácticas de forma ordenada, como portfolio técnico para GitHub. Cada proyecto está separado en su propia carpeta y puede revisarse de manera independiente.

## Qué se ha preparado para este portfolio

- Organización de los ejercicios en carpetas independientes.
- README general con índice de proyectos.
- README individual dentro de cada proyecto.
- Limpieza de archivos temporales de IntelliJ, compilados y carpetas `out`.
- Revisión de compilación de los proyectos incluidos.
- Exclusión de ejercicios incompletos o con errores de sintaxis.
- Documentación de los cambios y de la revisión realizada.

## Proyectos incluidos

| Proyecto | Tipo | Nivel aproximado | Resumen |
|---|---|---|---|
| [Aprender](./Aprender/) | Consola básica | Inicial | Primer ejercicio de toma de contacto con Java y la salida por consola. |
| [Cambio de temperatura](./Cambio-de-temperatura/) | Cálculo matemático | Inicial | Conversor sencillo entre grados Fahrenheit y Celsius. |
| [Caracteres](./Caracteres/) | Tipos de datos | Inicial | Ejercicio de manipulación de caracteres y sus códigos numéricos. |
| [Coches](./Coches/) | POO | Intermedio | Ejemplo de creación de una clase `Coche` y uso de objetos desde un programa principal. |
| [Cono](./Cono/) | Cálculo matemático | Inicial | Cálculo de área y volumen de un cono usando valores definidos en el código. |
| [Cono 2](./Cono2/) | Consola interactiva | Inicial / Intermedio | Versión interactiva del cálculo de área y volumen de un cono con entrada por teclado. |
| [Ejemplo conjunto de enteros](./EjemploConjuntoEnteros/) | Estructuras de datos | Intermedio | Implementación de un conjunto de enteros con operaciones como unión e intersección. |
| [Flota de coches](./Flota-Coches/) | POO aplicada | Intermedio | Modelo de vehículos, repostajes y cálculo de consumo medio. |
| [Gestión de flota de coches](./GestionFlotaDeCoches/) | Aplicación de consola | Intermedio / Avanzado | Aplicación de consola para gestionar una flota de coches con menú y archivos de datos. |
| [Gestión Bolsa 2.0](./Gestion_Bolsa2.0/) | Aplicación de consola | Avanzado | Aplicación de consola para gestionar una cartera de inversión, activos, operaciones y cuenta bancaria. |
| [Polinomios](./Polinomios/) | Matemáticas + POO | Intermedio | Representación y operaciones básicas con polinomios. |
| [Prueba de subarchivos](./Prueba-de-subarchivos/) | Organización de código | Intermedio | Ejercicio con varias clases auxiliares y enumeraciones para organizar información académica. |
| [Rectángulo](./Rectangulo/) | Cálculo matemático | Inicial | Cálculo de área y perímetro de un rectángulo. |

## Cómo revisar un proyecto

Entra en la carpeta del proyecto que quieras ver y abre su carpeta `src/`. Cada ejercicio incluye un README propio con:

- objetivo del ejercicio;
- conceptos trabajados;
- archivos principales;
- comando de compilación y ejecución.

## Cómo ejecutar un proyecto concreto

Los proyectos **no están pensados para ejecutarse todos a la vez**. Para probar uno en concreto:

```bash
cd NombreDelProyecto
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

También puedes abrir cada carpeta individualmente desde IntelliJ IDEA.

## Documentación adicional

- [Informe de revisión](./INFORME_REVISION.md)
- [Cambios realizados](./docs/CAMBIOS_REALIZADOS.md)
- [Mapa del repositorio](./docs/MAPA_REPOSITORIO.md)

## Nota

Este repositorio muestra una evolución académica: incluye ejercicios sencillos de iniciación y proyectos más completos con programación orientada a objetos, menús, archivos y varias clases.
