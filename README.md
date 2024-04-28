# Sistema de Control de Lavadero de Vehículos

## Tecnologia utilizada
- Java
- Eclipse

## Descripción
El Lavadero de Vehículos es un negocio donde se lleva a cabo el lavado de vehículos mediante una línea de lavado automatizada. El sistema de control permite registrar los vehículos que ingresan al lavadero, gestionar los servicios solicitados, generar facturas y realizar el seguimiento de las operaciones diarias.

## Funcionalidades
- Registro de vehículos: Se registra información detallada del vehículo y del cliente, así como la lista de servicios solicitados.
- Asignación de línea de lavado: Los vehículos son asignados a una línea de lavado según su tipo y las características del servicio.
- Emisión de factura: Al finalizar el lavado, se emite una factura que incluye la información del servicio realizado, el cliente y el monto total.
- Seguimiento diario: Se generan listados diarios por cada línea de lavado que contienen las facturas emitidas y el monto total recaudado.

## Requerimientos Específicos
- Excepciones personalizadas: Se lanzan excepciones cuando un vehículo se registra en una línea de lavado incorrecta o si no posee servicios solicitados.
- Constructores y métodos de consulta: Cada clase debe implementar al menos dos constructores y métodos para la modificación y consulta de sus atributos.
- Método toString() y equals(): Se implementan métodos para obtener una representación en cadena del vehículo y para comparar vehículos por su dominio.

## Patrones de diseño:
- Observer/Observable: Aplicado en las clases Lavadero y Línea de Lavado para notificar al lavadero cada vez que se atiende un cliente y se emite una factura.
- Singleton: Aplicado en la clase Lavadero para garantizar una única instancia global del lavadero.

## Programa de Prueba
El programa de prueba incluye la creación del lavadero, una línea de lavado de cada tipo y el método imprimirFacturas() en la clase Lavadero para mostrar un listado con todas las facturas emitidas junto con el monto total recaudado.

## Contribuidor
- Desarrollado por: Martín Arcos
- Contacto: martinarcosvargas2@gmail.com


## Agradecimiento
¡Gracias por elegir nuestro sistema de control de lavadero de vehículos! Estamos comprometidos con brindarle la mejor experiencia en el lavado y mantenimiento de su vehículo.






