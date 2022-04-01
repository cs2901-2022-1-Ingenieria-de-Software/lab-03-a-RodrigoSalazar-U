# LAB 03 A

Contexto:

Se esta desarrollando una aplicacion que calcule el total con impuestos para generar un reporte para gerencia y revisar el presupuesto.

Para ello se reciben ordenes por cada pais con la cantidad de Widgets a pedir.

# Ejercicio 1: Refactorizar(Hacer que el codigo sea testeable)

Revisar las clases ManageDemand, Tax y Order si consideran que se puede refactorizar el codigo.

Un tip es si su codigo responde: 
- Es testeable ? 
- Encuentro un code smell ?
- Podria aplicar SOLID ? 

Recordar: para correr la app mvn exec:java

# Ejercicio 2: Agregar Pruebas Unitarias ( JUnits )

Agregar todos los tests de los casos que consideren necesarios.

Un tip:
- Consideren primero los happy path o caminos de codigo que si o si deberian ser testeados para asegurarnos que la aplicacion funcione.
- Cubrir Edge Cases(Excepciones, Casos atipicos como cadena vacia, valores invalidos)

Recordar: para correr tests mvn verifyç

=======================================================================================================

GIT:

git clone <repo>
git status
git pull origin <branch>
git add .
git commit -m “<commit message>”
git push origin <branch>

MAVEN:

mvn clean // borra toda la carpeta target
mvn compile // compila archivos java
mvn install // genera el jar(empaquetado)
mvn clean install // genera el jar
mvn verify // corre solo los tests(junit)

CORRER:

mvn exec:java -Dexec.mainClass=“com.lab.Main”
o
mvn exec:java

Librerias Java Utiles:

java.util.Arrays;
java.util.Collections;


