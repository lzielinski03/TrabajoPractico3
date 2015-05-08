Trabajo Práctico 3
Unidad 3 – “Diagnóstico y excepciones” & Unidad 4 – “Manejo de archivos”
I.	El diario de Bridget

Se quiere implementar el diario personal de Bridget.
1)	Los requerimientos del diario son:
a.	Permite agregar entradas de información que Bridget quiere anotar, y siempre después de la última entrada.
i.	El comienzo de cada entrada se guardará con un identificador comenzando desde el 1 y antepuesto por un #. Ejemplo: “#1 I like you very much. Just as you are.”
ii.	Las entradas ocuparan solo una línea.
b.	Permite ver todo lo escrito en el diario
c.	Permite borrar una entrada por identificador (#n)
2)	La interfaz con la que Bridget debe interactuar es una consola con los siguientes requerimientos:
a.	Al comenzar debe mostrar el mensaje “Ingresar comando” y esperar que un comando sea insertado
b.	Se reconocen solo 3 comandos:
i.	/add
Cuando se ejecuta este comando, se muestra este mensaje “Ingresar entrada” y espera que escriba una nueva entrada en el diario. Luego vuelve al menú inicial del punto 2.a
ii.	/delete #n
Permite borrar la línea con el identificador #n siendo n un entero. En caso de no existir, muestra el mensaje “Entrada inexistente” y vuelve al menú inicial del punto 2.a. Si existe muestra el mensaje “Entrada borrada” y vuelve al menú del punto 2.a
iii.	/entries
Muestra todas las entradas del diario y vuelve al menú del punto 2.a
Los requerimientos técnicos para este trabajo
1.	La implementación alcanza con dos clases, y no se debe mezclar el código de la clase del modelo con el modelado de interacción con el usuario.
2.	Se debe implementar para una clase el patrón Singleton
3.	No se considera entregado un proyecto con:
a.	Errores o warnings
b.	Funcionalidad incompleta
4.	Para la entrega correcta del proyecto
a.	No se debe adjuntar todo el workspace
b.	Importar el proyecto y enviar en un archivo .rar o .zip

Los proyectos que estén copiados de otro alumno se los considerara reprobados.
