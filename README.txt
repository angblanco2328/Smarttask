========================================
README - Proyecto SmartTask
========================================

Nombre del proyecto: SmartTask  
Descripción: Aplicación de consola para la gestión de tareas, desarrollada en Java.  
Fecha: Febrero 2026  
Autora: Patricia Salazar Arancibia

----------------------------------------
1. Descripción general
----------------------------------------
SmartTask es una aplicación de consola que permite gestionar tareas de manera simple y estructurada.  
El sistema permite:

- Agregar tareas (normales o urgentes)
- Listar todas las tareas
- Listar tareas completadas
- Marcar tareas como completadas
- Eliminar tareas
- Salir del programa

El proyecto está organizado siguiendo buenas prácticas de programación, con separación clara entre:
- Lógica de negocio
- Modelos
- Aplicación principal
- Pruebas unitarias

----------------------------------------
2. Estructura del proyecto
----------------------------------------

SmartTask/
 ├── src/
 │    ├── cl.smarttask.app/        → Contiene SmartTaskApp.java (aplicación principal)
 │    ├── cl.smarttask.modelo/     → Clases de modelo: Tarea, TareaNormal, TareaUrgente
 │    └── cl.smarttask.negocio/    → Lógica de negocio: GestorTareas
 │
 ├── test/
 │    └── cl.smarttask.test/       → Clase de pruebas unitarias: GestorTareasTest.java
 │
 ├── log_tests.txt                 → Registro de ejecución de pruebas JUnit
 ├── log_ejecucion.txt             → Registro de ejecución real de la aplicación
 ├── .classpath
 ├── .project
 └── .settings/

----------------------------------------
3. Pruebas unitarias (JUnit 5)
----------------------------------------
El proyecto incluye una clase de pruebas unitarias para validar:

- Agregar tareas
- Listar tareas
- Marcar tareas como completadas
- Eliminar tareas
- Manejo de IDs inexistentes
- Listado de tareas completadas

Todas las pruebas fueron ejecutadas exitosamente.  
El detalle se encuentra en el archivo: **log_tests.txt**

----------------------------------------
4. Ejecución de la aplicación
----------------------------------------
Para ejecutar SmartTask:

1. Abrir SmartTaskApp.java
2. Ejecutar como "Java Application"
3. Utilizar el menú interactivo para probar las funcionalidades

El registro de una ejecución real se encuentra en: **log_ejecucion.txt**

----------------------------------------
5. Requisitos
----------------------------------------
- Java 17 o superior
- Eclipse IDE (o cualquier IDE compatible con Java)
- Librería JUnit 5 para ejecutar las pruebas

----------------------------------------
6. Notas finales
----------------------------------------
El proyecto cumple con:
- Organización modular
- Uso de clases abstractas y herencia
- Manejo de listas y objetos
- Pruebas unitarias completas
- Registro de ejecución solicitado

