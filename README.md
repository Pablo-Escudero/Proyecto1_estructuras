# Proyecto 1 - Estructuras de Datos

Este proyecto consiste en el desarrollo de un **sistema de gestión para una agencia de modelaje ficticia llamada "No Más Enanos Por Favor"**.  
La aplicación fue desarrollada en **Java** utilizando **Java Swing** para la interfaz gráfica y permite administrar la información principal de la agencia de forma sencilla.

El sistema permite registrar, consultar y gestionar modelos, fotógrafos, eventos y lugares donde se realizan las actividades de la agencia.

---

# Descripción del sistema

La aplicación proporciona una interfaz gráfica organizada en pestañas que facilita la gestión de los diferentes componentes del sistema.

A través del sistema se pueden realizar las siguientes acciones:

### Gestión de Modelos
- Registrar nuevos modelos en la agencia.
- Consultar la información de los modelos registrados.
- Mantener organizada la base de datos de modelos disponibles.

### Gestión de Fotógrafos
- Registrar fotógrafos asociados a la agencia.
- Consultar la información de los fotógrafos disponibles.
- Administrar la relación entre fotógrafos y eventos.

### Gestión de Eventos
- Crear eventos organizados por la agencia.
- Administrar eventos públicos y privados.
- Asociar modelos y fotógrafos a los eventos.

### Gestión de Lugares
- Registrar lugares donde se pueden realizar eventos.
- Consultar los lugares disponibles.
- Mantener un catálogo organizado de locaciones.

---

# Persistencia de datos

La información del sistema se guarda utilizando **archivos de texto**, lo cual permite que los datos permanezcan almacenados incluso después de cerrar el programa.

Los archivos utilizados por el sistema son:

- `modelos.txt`
- `fotografos.txt`
- `eventos.txt`
- `lugares.txt`

Estos archivos se encuentran en la **carpeta raíz del proyecto** y son utilizados automáticamente por el sistema para cargar y guardar la información.

---

# Interfaz gráfica

La interfaz fue desarrollada utilizando **Java Swing** y está organizada en diferentes pestañas que permiten acceder a cada módulo del sistema de forma clara.

La aplicación incluye una imagen de encabezado que se carga desde el archivo:


NoMasEnanosPorfavor.png


Por esta razón es importante ejecutar el programa desde la **raíz del proyecto** para que la imagen pueda cargarse correctamente.

---

# Estructura del proyecto

El proyecto está organizado en diferentes paquetes que separan la lógica del sistema según su responsabilidad.


src
│
├── gui
│ └── VentanaPrincipal.java
│
├── gestion
│ └── Clases encargadas de la lógica de gestión del sistema
│
├── modelos
│ └── Clases relacionadas con los modelos de la agencia
│
├── eventos
│ └── Clases relacionadas con la gestión de eventos
│
└── persistencia
└── Clases encargadas del manejo de archivos


Esta estructura permite mantener el proyecto organizado y facilita su mantenimiento y ampliación.

---

# Requisitos

Para ejecutar este proyecto es necesario contar con:

- **Java JDK 8 o superior**
- Un **IDE de desarrollo para Java** (IntelliJ IDEA, Eclipse, NetBeans)  
  o utilizar la **terminal**

---

# Instrucciones de ejecución

## Opción 1: Ejecutar desde un IDE

1. Abrir el proyecto en el IDE.
2. Ubicar la clase principal del programa:


gui.VentanaPrincipal


3. Ejecutar el método principal:


VentanaPrincipal.main()


Es importante que el **directorio de trabajo sea la raíz del proyecto**, donde se encuentra la imagen:


NoMasEnanosPorfavor.png


para que el encabezado de la aplicación se cargue correctamente.

---

## Opción 2: Ejecutar desde la terminal

Ubicarse en la carpeta raíz del proyecto (por ejemplo `Entrega-1`).

### Compilar el proyecto

```bash
javac -d out src/gui/VentanaPrincipal.java src/gestion/*.java src/modelos/*.java src/eventos/*.java src/persistencia/*.java src/gui/*.java
Ejecutar el programa
java -cp out gui.VentanaPrincipal
Integrantes del grupo

Samuel Tabares

Samuel Buelvas

Pablo Escudero

Isaac Galeano
