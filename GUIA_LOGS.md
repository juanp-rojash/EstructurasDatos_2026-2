# Guía paso a paso para implementar generación de logs en Java con Log4j2 + Lombok

Esta guía explica de forma sencilla cómo implementar logs en un proyecto Java, desde las librerías necesarias hasta la escritura de mensajes de tipo info, warn y error.

## 1. Agregar las librerías en [build.gradle](build.gradle)

En el archivo [build.gradle](build.gradle) se deben incluir las dependencias necesarias para que Log4j2 funcione.

### Dependencias recomendadas

- `org.apache.logging.log4j:log4j-api`
  - Define la API para trabajar con logs.
  - Permite usar clases como `Logger` sin depender de la implementación concreta.

- `org.apache.logging.log4j:log4j-core`
  - Contiene la implementación real de Log4j2.
  - Es la que permite escribir mensajes, usar appenders y leer la configuración XML.

- `com.lmax:disruptor`
  - Mejora el rendimiento cuando se usan logs en aplicaciones con mucha concurrencia.
  - Es recomendable para que la escritura sea más eficiente.

- `org.projectlombok:lombok`
  - Permite usar anotaciones como `@Log4j2`.
  - Evita escribir manualmente el código del logger en cada clase.

### Qué cambiar según el proyecto

- Si el proyecto tiene otro nombre o paquete, debes ajustar el `group` y la clase principal.
- Si la clase principal cambia, actualiza la configuración del plugin `application`.

Ejemplo básico:

```gradle
plugins {
    id 'java'
    id 'application'
}

application {
    mainClass = 'com.example.Main'
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("com.lmax:disruptor:4.0.0")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}
```

---

## 2. Crear la configuración en [src/main/resources/log4j2.xml](src/main/resources/log4j2.xml)

Este archivo define cómo se van a manejar los logs.

### Apartados principales

#### a) `<Configuration>`
- Inicia la configuración de Log4j2.
- `status="warn"` muestra advertencias de la configuración.
- `strict="true"` hace que la configuración sea más estricta.
- `name="Log4j2Config"` asigna un nombre a la configuración.

#### b) `<Properties>`
- Define variables reutilizables dentro del archivo.
- `app_log_root` indica la carpeta donde se guardarán los logs.
- `log_pattern` define el formato del mensaje.
- `log` define el nombre base del archivo de log.

#### c) `<Appenders>`
- Define los destinos de salida de los logs.

##### `Console`
- Muestra los mensajes en la consola.
- Útil para ver los logs mientras se ejecuta la aplicación.

##### `RollingFile`
- Guarda los mensajes en un archivo físico.
- `fileName` define el archivo principal.
- `filePattern` define cómo se llamarán los archivos rotados.
- `append="true"` agrega mensajes al archivo existente.

##### `Policies`
- Determinan cuándo se rota el archivo.
- `TimeBasedTriggeringPolicy` rota por tiempo.
- `SizeBasedTriggeringPolicy` rota cuando el archivo supera cierto tamaño.

##### `DefaultRolloverStrategy`
- Controla cuántos archivos rotados se mantienen.
- En este caso, se guardan hasta 7 archivos.

#### d) `<Loggers>`
- Define qué mensajes se registran y a dónde van.

##### `Root`
- Es el logger general para toda la aplicación.
- `level="info"` significa que se registran mensajes de nivel info o superior.

##### `Logger name="com.example"`
- Es un logger específico para un paquete.
- `level="debug"` permite registrar mensajes desde debug hacia arriba.
- `additivity="false"` evita que los mensajes se dupliquen en el logger raíz.

### Qué cambiar según el nombre del proyecto

- Cambia `Fight` por un nombre más representativo del proyecto, por ejemplo `DragonBall` o `MiProyecto`.
- Cambia `com.example` por el paquete real de tu aplicación.
- Si quieres que los logs se guarden en otra carpeta, cambia `logs` por una ruta distinta.

Ejemplo:

```xml
<Property name="app_log_root">logs</Property>
<Property name="log">DragonBall</Property>
```

Y en el logger:

```xml
<Logger name="com.miempresa.proyecto" level="debug" additivity="false">
```

---

## 3. Habilitar el logger en la clase principal

En la clase principal, normalmente en [src/main/java/com/example/Main.java](src/main/java/com/example/Main.java), se debe importar la anotación de Lombok y usar `@Log4j2`.

### Importación necesaria

```java
import lombok.extern.log4j.Log4j2;
```

### Uso de la anotación

```java
@Log4j2
public class Main {
```

Esto le indica a Lombok que genere automáticamente un objeto `log` listo para usarse.

---

## 4. Escribir mensajes de log

Una vez configurado el logger, puedes registrar mensajes con diferentes niveles.

### `log.info(...)`
- Se usa para registrar eventos normales del sistema.
- Ejemplo: inicio de la aplicación, carga de datos, creación de objetos.

```java
log.info("Iniciando lectura del archivo");
```

### `log.warn(...)`
- Se usa para advertencias.
- Ejemplo: datos incompletos, valores inesperados o situaciones que no detienen la ejecución.

```java
log.warn("Linea del archivo con longitud invalida");
```

### `log.error(...)`
- Se usa cuando ocurre un error importante.
- Ejemplo: archivo no encontrado, excepción al procesar datos.

```java
log.error("Error en la entrada: {}", e.getMessage(), e);
```

---

## 5. Flujo recomendado para implementar logs

1. Agregar dependencias en [build.gradle](build.gradle).
2. Crear o ajustar [src/main/resources/log4j2.xml](src/main/resources/log4j2.xml).
3. Añadir `@Log4j2` en la clase principal o en las clases donde se necesite registrar información.
4. Insertar mensajes con `info`, `warn` y `error` según el tipo de evento.
5. Ejecutar la aplicación y verificar que el archivo se genera en la carpeta configurada.

---

## 6. Recomendaciones adicionales

- Usa `info` para procesos normales.
- Usa `warn` para situaciones anómalas pero no críticas.
- Usa `error` para fallos reales del sistema.
- Mantén el formato del log claro y consistente.
- Si tu proyecto crece, puedes agregar más loggers por paquete para organizar mejor la salida.

---

## 7. Ejemplo completo sencillo

```java
@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("Inicio del programa");

        try {
            log.warn("Ejecutando operación con datos potencialmente incompletos");
        } catch (Exception e) {
            log.error("Ocurrió un error: {}", e.getMessage(), e);
        }
    }
}
```

Con esta estructura, el proyecto podrá generar logs en consola y en archivo de forma ordenada y fácil de mantener.
