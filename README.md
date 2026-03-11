# Proyecto 1 - Estructuras de Datos

## Descripción del sistema

Sistema de gestión para la **Agencia de Modelaje "No Más Enanos Por Favor"**. Permite administrar:

- **Modelos**: registro y consulta de modelos.
- **Fotógrafos**: gestión de fotógrafos de la agencia.
- **Eventos**: creación y manejo de eventos (públicos y privados).
- **Lugares**: catálogo de lugares disponibles para eventos.

El sistema cuenta con una interfaz gráfica (Java Swing) organizada en pestañas y guarda la información en archivos de texto (`modelos.txt`, `fotografos.txt`, `eventos.txt`, `lugares.txt`) en la carpeta del proyecto

---

## Instrucciones de ejecución

### Opción 1: Desde un IDE (IntelliJ IDEA, Eclipse, etc.)

1. Abrir el proyecto en el IDE.
2. Ubicar la clase `VentanaPrincipal` en el paquete `gui`.
3. Ejecutar la clase (Run `VentanaPrincipal.main`).

Asegúrate de que el directorio de trabajo sea la raíz del proyecto (donde está el archivo `NoMasEnanosPorfavor.png`), para que la imagen del encabezado se cargue correctamente.

### Opción 2: Desde la terminal

Desde la raíz del proyecto (`Entrega-1`):

```bash
# Compilar
javac -d out src/gui/VentanaPrincipal.java src/gestion/*.java src/modelos/*.java src/eventos/*.java src/persistencia/*.java src/gui/*.java

# Ejecutar (desde la raíz del proyecto)
java -cp out gui.VentanaPrincipal
```

**Requisitos:** Java 8 o superior (JDK instalado).

---

## Integrantes del grupo

- Samuel Tabares  
- Samuel Buelvas  
- Pablo Escudero  
- Isaac Galeano  
