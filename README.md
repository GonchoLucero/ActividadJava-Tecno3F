# ActividadJava-Tecno3F

 - Sistema para administrar al personal de la Policia de Tres de Febrero

// REQUERIMIENTOS
---------------------------------------
 - Clase Policia:
 - Nombre
 - Apellido
 - Legajo
 - Escuadron
 - Arma Asignada

---------------------------------------
- Clase Escuadron:
- Nombre del escuadron
- Comisaria a la que pertenecen
- Grupo de Policias
- Armas que poseen

---------------------------------------
- Clase Arma:
- Municiones
- Alcance en metros
- Marca
- Calibre
- Estado ("Nueva", "En Mantenimiento", "En Uso")

---------------------------------------
- Dos variantes de armas: armas cortas y largas

---------------------------------------
- Clase ArmaCorta:
- Hereda los atributos de clase Arma
- SiesAutomatica

---------------------------------------
- Clase ArmaLarga:
- Hereda los atributos de clase Arma
- tieneSelloRENAR
- descripcionUso
- Nivel

---------------------------------------
- El sistema debe contar con las siguientes funcionalidades:

- De cualquier arma se debe poder saber si está en condiciones para poder
  ser usada por un policía en un enfrentamiento. Para que pueda estar en
  condiciones debe estar en estado “EN USO” y ser un calibre >=9.

- En el caso de las armas largas debe ser posible compararlas. Un arma
  larga es mayor a otra si tiene mayor nivel.

- Es importante contar con alguna funcionalidad en las armas cortas para
  saber si se las puede disparar a más de 200m.

- De cualquier escuadrón se debe poder saber la cantidad de integrantes,
  armas que poseen , a que policía corresponde cada una y cuantas están en
  condiciones para ser usadas.
