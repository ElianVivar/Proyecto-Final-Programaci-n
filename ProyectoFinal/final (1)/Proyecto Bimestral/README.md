# CafeGest

Aplicación de escritorio para la gestión básica de una cafetería. Permite iniciar sesión según el rol del usuario, administrar el catálogo de productos, crear y facturar pedidos, y consultar las ventas realizadas durante la sesión actual.

El proyecto está desarrollado en **Java** con **Swing**. Las pantallas principales están estructuradas con el patrón de formularios de NetBeans (`.java` + `.form`). No usa dependencias externas ni un servidor de base de datos.

## Contenido

- [Características](#características)
- [Tecnologías y requisitos](#tecnologías-y-requisitos)
- [Ejecución](#ejecución)
- [Credenciales iniciales](#credenciales-iniciales)
- [Uso de la aplicación](#uso-de-la-aplicación)
- [Reglas de negocio](#reglas-de-negocio)
- [Persistencia de datos](#persistencia-de-datos)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Diseño y clases principales](#diseño-y-clases-principales)
- [Flujo de un pedido](#flujo-de-un-pedido)
- [Formularios de NetBeans](#formularios-de-netbeans)
- [Limitaciones actuales](#limitaciones-actuales)

## Características

- Autenticación con usuarios de tipo **Administrador** y **Barista**.
- Menú principal condicionado por el rol de la sesión.
- Administración del catálogo: registrar, modificar, eliminar y consultar productos.
- Productos de dos tipos: bebidas y alimentos.
- Personalización de bebidas por tamaño y tipo de leche.
- Opción de calentado para alimentos.
- Registro de cliente y documento (cédula o RUC) antes de facturar.
- Cálculo de subtotales, total del pedido e IVA del 15 % en la factura.
- Generación de una factura visual en pantalla.
- Historial de pedidos confirmados, con detalle por producto e ingresos acumulados.
- Persistencia del catálogo de productos en un archivo CSV.

## Tecnologías y requisitos

| Recurso | Uso |
| --- | --- |
| Java JDK 8 o superior | Compilación y ejecución. Se usan lambdas, `LocalDateTime` y Swing. |
| Java Swing | Interfaz gráfica de escritorio. |
| NetBeans (opcional) | Edición visual de los formularios `.form`. |
| CSV local | Almacenamiento de usuarios y productos. |

No se requiere Maven, Gradle, una conexión de red ni bibliotecas adicionales.

## Ejecución

> Importante: ejecute los comandos desde la carpeta `Proyecto Bimestral`. La aplicación busca `database/usuarios.csv` y `database/productos.csv` en el directorio de trabajo actual.

### Desde consola

```powershell
cd "Proyecto Bimestral"
javac -d out src\*.java
java -cp out Main
```

En sistemas macOS o Linux, puede usar:

```bash
cd "Proyecto Bimestral"
javac -d out src/*.java
java -cp out Main
```

Al iniciar, `Main` programa la apertura de `LoginForm` en el hilo de eventos de Swing.

### Desde un IDE

1. Abra la carpeta `Proyecto Bimestral` como proyecto Java.
2. Marque `src` como carpeta de código fuente si el IDE no lo detecta automáticamente.
3. Configure `Main` como clase principal o ejecute `src/Main.java`.
4. Mantenga `database` al mismo nivel que `src` y ejecute con `Proyecto Bimestral` como directorio de trabajo.

Para editar de forma visual los formularios, abra los pares `.java` y `.form` desde NetBeans. Los archivos `.form` describen la estructura de las ventanas, mientras que el método `initComponents()` contiene el código de interfaz generado.

## Credenciales iniciales

Las credenciales se leen de `database/usuarios.csv`. En el estado actual del proyecto son:

| Rol | Usuario | Contraseña | Acceso principal |
| --- | --- | --- | --- |
| Administrador | `admin` | `admin123` | Administrar productos |
| Barista | `barista` | `barista123` | Crear pedidos y facturar |

Las contraseñas se guardan en texto plano porque este es un proyecto académico/local. No debe utilizarse este enfoque en un sistema de producción.

## Uso de la aplicación

### 1. Inicio de sesión

En la pantalla inicial ingrese un usuario y su contraseña. Si las credenciales son válidas, el sistema abre el menú de sesión. Si no lo son, muestra un mensaje de acceso denegado.

El menú presenta opciones diferentes según el tipo de usuario, pero ambos roles pueden consultar el historial de pedidos y cerrar sesión.

### 2. Administrador: catálogo de productos

El administrador puede abrir **Administrar productos** y trabajar con la tabla del catálogo.

- **Registrar:** escriba ID, nombre, precio base y el tipo de producto; luego pulse `Registrar`.
- **Modificar:** seleccione una fila de la tabla. Sus valores se cargan en el formulario; cambie el nombre o precio y pulse `Modificar`.
- **Eliminar:** seleccione un producto y pulse `Eliminar`.
- **Limpiar:** borra el contenido del formulario para iniciar otro registro.

El ID no puede repetirse. Además, `Producto` no permite precios negativos. Las modificaciones del catálogo se guardan inmediatamente en `database/productos.csv`.

### 3. Barista: creación de pedidos

El barista abre **Crear pedido / Facturar**. La pantalla inicia un pedido nuevo con un identificador como `P0001` y estado `Pendiente`.

1. Ingrese el nombre del cliente.
2. Seleccione el tipo de documento (`Cedula` o `RUC`) e ingrese su número.
3. Elija un producto y la cantidad (de 1 a 99).
4. Si es una bebida, seleccione tamaño y tipo de leche. Si es un alimento, puede indicar si debe calentarse.
5. Pulse `Agregar al pedido`; el detalle aparece en la tabla y el total se actualiza.
6. Repita los pasos anteriores para agregar más productos.
7. Pulse `Confirmar y facturar` para validar el pedido, confirmarlo y mostrar la factura.

El botón `Nuevo pedido` descarta el pedido en edición y crea otro. El botón `Ver historial` abre la consulta sin cerrar el formulario del barista.

### 4. Historial de pedidos

La pantalla **Historial de pedidos** muestra una tabla con número de pedido, fecha, cliente, documento, estado y total. Al seleccionar una fila, la tabla inferior presenta sus productos, cantidades, precios unitarios y subtotales.

El resumen inferior muestra la cantidad de ventas registradas y el total de ingresos. `Actualizar` vuelve a cargar las tablas a partir del historial en memoria.

## Reglas de negocio

### Precios

El precio final se calcula a partir del precio base del producto:

| Tipo | Regla |
| --- | --- |
| Bebida pequeña con leche entera | Conserva el precio base. |
| Bebida mediana | Suma `$0.50`. |
| Bebida grande | Suma `$1.00`. |
| Leche de almendra o deslactosada | Suma `$0.75`, adicional al tamaño. |
| Alimento calentado | Suma `$0.30`. |
| Detalle de pedido | `precio final × cantidad`. |
| Pedido | Suma de sus detalles. |
| Factura | Muestra subtotal, IVA del 15 % y total con IVA. |

El total almacenado en `Pedido` corresponde a la suma de los detalles. El IVA se calcula y se muestra únicamente para la factura visual; no se agrega al total registrado en el historial.

### Validaciones al facturar

Para confirmar un pedido, el sistema exige:

- Tener al menos un producto agregado.
- Ingresar el nombre del cliente.
- Usar solo dígitos en el documento.
- Una cédula de exactamente 10 dígitos o un RUC de exactamente 13 dígitos.

Después de confirmar, el pedido recibe estado `Confirmado`, registra la fecha/hora actual y se agrega al historial. El botón de facturación se deshabilita para impedir confirmar el mismo pedido dos veces.

## Persistencia de datos

Los datos se gestionan desde `BaseDatosCafe`, un singleton cargado una vez durante la ejecución.

| Archivo | Contenido | Comportamiento |
| --- | --- | --- |
| `database/usuarios.csv` | Rol, ID, nombre y contraseña. | Se lee al arrancar; la aplicación no modifica este archivo. |
| `database/productos.csv` | Tipo, ID, nombre, precio base y atributos de producto. | Se lee al arrancar y se reescribe después de registrar, modificar o eliminar un producto. |

Si alguno de estos archivos no existe, `BaseDatosCafe` crea el directorio `database` y genera datos de ejemplo. Los pedidos y el historial de ventas **no se guardan en archivos**: se conservan solo mientras la aplicación sigue abierta.

### Formato de `productos.csv`

```text
tipo,id,nombre,precioBase,tamano,tipoLeche,requiereCalentado
BEBIDA,B001,Capuccino,2.50,grande,almendra,false
ALIMENTO,A001,Croissant,1.75,,,true
```

Evite usar comas dentro de nombres o valores, pues el lector actual separa las columnas directamente por comas y no implementa comillas CSV.

## Estructura del proyecto

```text
Proyecto Bimestral/
├── database/
│   ├── productos.csv             # Catálogo persistente
│   └── usuarios.csv              # Usuarios iniciales
├── src/
│   ├── Main.java                 # Punto de entrada
│   ├── LoginForm.java/.form      # Inicio de sesión
│   ├── MenuSesionForm.java       # Menú posterior al acceso
│   ├── AdminForm.java/.form      # Gestión del catálogo
│   ├── BaristaForm.java/.form    # Toma de pedido y factura
│   ├── HistorialPedidosForm.java/.form
│   ├── BaseDatosCafe.java        # Datos locales, catálogo e historial
│   ├── Usuario.java              # Clase base de usuarios
│   ├── Administrador.java
│   ├── Barista.java
│   ├── Producto.java             # Clase base de productos
│   ├── Bebida.java
│   ├── Alimento.java
│   ├── Pedido.java
│   ├── DetallePedido.java
│   ├── HistorialVentas.java
│   └── MenuCafe.java             # API de menú con restricción por rol
└── README.md
```

La carpeta `out/` se crea al compilar y contiene archivos `.class`; no es código fuente.

## Diseño y clases principales

### Modelo de usuarios

`Usuario` es una clase abstracta con ID, nombre, contraseña y el método abstracto `obtenerRol()`.

- `Administrador` devuelve el rol **Administrador**.
- `Barista` devuelve el rol **Barista**.

`BaseDatosCafe.autenticar(...)` recorre los usuarios cargados desde CSV y devuelve el objeto del rol correspondiente solo si el ID y la contraseña coinciden.

### Modelo de productos

`Producto` es una clase abstracta que concentra ID, nombre, precio base y el contrato `calcularPrecioFinal()`.

- `Bebida` añade `tamano` y `tipoLeche` para calcular recargos.
- `Alimento` añade `requiereCalentado` para aplicar su recargo si corresponde.

Durante la toma de pedido, `BaristaForm` crea una copia personalizada del producto seleccionado. Esto permite que la bebida o alimento de un detalle conserve las opciones elegidas en ese momento.

### Pedidos, detalles e historial

- `DetallePedido` asocia un producto, una cantidad y un subtotal calculado.
- `Pedido` conserva sus detalles, datos de cliente, total, estado y fecha de confirmación.
- `HistorialVentas` almacena pedidos confirmados y calcula número de ventas e ingresos.
- `BaseDatosCafe` genera IDs correlativos de pedido y sirve de puente entre la interfaz y estos objetos.

### Interfaz

| Clase | Responsabilidad |
| --- | --- |
| `LoginForm` | Autentica al usuario y abre el menú. |
| `MenuSesionForm` | Muestra las opciones permitidas por el rol. |
| `AdminForm` | Mantiene el catálogo de productos. |
| `BaristaForm` | Registra clientes, personaliza productos, arma pedidos y muestra factura. |
| `HistorialPedidosForm` | Consulta pedidos confirmados y sus detalles. |

`MenuCafe` ofrece operaciones de catálogo que validan explícitamente que el usuario sea administrador. Actualmente las pantallas utilizan directamente `BaseDatosCafe` para administrar los productos; la clase queda disponible como una capa de dominio alternativa.

## Flujo de un pedido

```text
Inicio de sesión (Barista)
          │
          ▼
BaseDatosCafe.crearPedido() → Pedido P0001 (Pendiente)
          │
          ▼
Seleccionar producto + personalización + cantidad
          │
          ▼
DetallePedido → Pedido.agregarDetalle() → recalcular total
          │
          ▼
Validar cliente y documento
          │
          ▼
Pedido.confirmar() → Confirmado + fecha/hora
          │
          ▼
BaseDatosCafe.registrarVenta() → HistorialVentas
          │
          ├──► Mostrar factura (subtotal + IVA + total)
          └──► Consultar HistorialPedidosForm
```

## Formularios de NetBeans

Los siguientes formularios disponen de su archivo de diseño:

| Formulario | Archivo de diseño |
| --- | --- |
| Inicio de sesión | `src/LoginForm.form` |
| Administrador | `src/AdminForm.form` |
| Barista | `src/BaristaForm.form` |
| Historial de pedidos | `src/HistorialPedidosForm.form` |

Al modificar el diseño desde NetBeans, evite editar manualmente el bloque delimitado por `//GEN-BEGIN:initComponents` y `//GEN-END:initComponents`, ya que el diseñador puede regenerarlo. La lógica de eventos y las reglas de negocio se mantienen fuera de ese bloque.

## Diagrama UML

El diagrama de clases completo está disponible en [docs/diagrama-clases.puml](docs/diagrama-clases.puml). Está escrito en [PlantUML](https://plantuml.com/), por lo que puede abrirse en un visor o extensión compatible para exportarlo como PNG, SVG o PDF.

## Limitaciones actuales

- El historial se pierde al cerrar la aplicación.
- Los IDs de pedido vuelven a iniciar desde `P0001` en cada ejecución.
- Los campos de personalización del administrador no se guardan al registrar una bebida o alimento; se crean con valores predeterminados. La personalización completa se realiza desde la pantalla del barista.
- La validación de cédula y RUC verifica longitud y caracteres, pero no el dígito verificador oficial.
- El archivo CSV no soporta campos con comas ni mecanismos de concurrencia.
- Las credenciales se almacenan sin cifrado, por lo que el proyecto no está preparado para uso productivo.

## Posibles mejoras

- Persistir pedidos e historial en CSV o una base de datos.
- Guardar los datos de factura, incluido el IVA, como parte de cada venta.
- Implementar validación ecuatoriana completa de cédula y RUC.
- Agregar edición de tamaño, leche y calentado en el módulo administrativo.
- Añadir pruebas unitarias para cálculos y validaciones.
- Incorporar hash de contraseñas y gestión de usuarios.

---

Proyecto académico de gestión de cafetería desarrollado con Java Swing.
