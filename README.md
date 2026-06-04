# Programación II — Portfolio Java

Colección de ejercicios y pequeños proyectos realizados en Java para mostrar fundamentos de programación orientada a objetos, estructuras de datos, entrada/salida y manejo básico de archivos.

## Proyectos incluidos

Todos los proyectos incluidos en este repositorio fueron revisados, compilados y ejecutados correctamente con `OpenJDK 21`. También se aplicaron correcciones mínimas en tres proyectos incluidos para evitar resultados incorrectos o fallos de ejecución.

| Proyecto | Descripción breve | Ejecución |
|---|---|---|
| Aprender | Primer programa de prueba: salida por consola. | `java -cp out Main` |
| Cambio-de-temperatura | Conversión básica entre Fahrenheit y Celsius. | `java -cp out Main` |
| Caracteres | Operaciones básicas con caracteres y códigos numéricos. | `java -cp out Main` |
| Coches | Clase `Coche`, objetos, atributos y método `toString`. | `java -cp out Main` |
| Cono | Cálculo de área y volumen de un cono con datos fijos. | `java -cp out Main` |
| Cono2 | Cálculo de área y volumen de un cono con entrada por teclado. | `java -cp out Main` |
| EjemploConjuntoEnteros | Implementación de un conjunto de enteros con unión e intersección. | `java -cp out Main` |
| Flota-Coches | Modelo de vehículos, repostajes y consumo medio. | `java -cp out Main` |
| GestionFlotaDeCoches | Gestión de una flota de coches con menú y archivos. | `java -cp out Main` |
| Gestion_Bolsa2.0 | Gestión de una cartera de inversión con cuenta bancaria, operaciones, activos y generación de informes. | `java -cp out Main` |
| Polinomios | Operaciones básicas con polinomios. | `java -cp out Main` |
| Prueba-de-subarchivos | Ejemplo de clases auxiliares y enum. | `java -cp out Main` |
| Rectangulo | Cálculo de área y perímetro de un rectángulo. | `java -cp out Main` |

## Cómo compilar un proyecto

Entra en la carpeta del proyecto y ejecuta:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

También puedes abrir cada carpeta como proyecto Java en IntelliJ IDEA.

## Proyectos excluidos tras la revisión

Estos proyectos se quitaron del ZIP final porque no estaban listos para presentarse en GitHub:

| Proyecto eliminado | Motivo |
|---|---|
| Ejercicio_Clase | Error de sintaxis en `trabajador.java`: constructor incompleto. |
| PreciosWeb | Error de sintaxis en `Main.java`: línea incompleta con `new Scanner(Syst)`. |
| Simulacro de informatica | No contiene carpeta `src` ni archivos `.java` ejecutables. |
| Test | Errores de sintaxis en `Main.java`, por ejemplo `falso.` y una concatenación incompleta. |

## Notas

Se han eliminado archivos de configuración local de IntelliJ (`.idea`, `.iml`) y carpetas de compilación (`out`) para dejar el repositorio más limpio.

Correcciones mínimas aplicadas:

- `Cambio-de-temperatura`: fórmula de conversión Celsius → Fahrenheit corregida.
- `Coches`: asignación del año de fabricación en el constructor corregida.
- `Gestion_Bolsa2.0`: uso de un único `Scanner` para evitar fallos de lectura en el menú interactivo.
