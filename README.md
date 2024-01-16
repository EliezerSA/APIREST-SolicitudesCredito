PROYECTO APIREST SOLICTUDES DE CREDITO

Bajar el Zip de proyecto en la pestaña > Code
Descomprimir o clonar el repositorio con el enlace de la misma pestaña

abrir en IDE de preferencia, sea Intellij o Visual Studio Code

El proyecto es modular, pro tanto, cada modulo se debe de correr de manera independiente o e pueden ejecutar al mismo tiempo
en el archivo con el metodo Main: Pro ejemplo "MsvcSolicitudesAplicattion" que se encuentran contenidos dentro del workspace de
cada modulo

Dentro de resources > application.properties > se ubica el puerto donde escuchara cada modulo de microservicio

Abrir POSTMAN, o un Navegador Web compatible > Google Chrome o Firefox
Ejecutar los metodos en el siguiente orden, GET > Consulta de registros, POST > Crear un registro nuevo, PUT > Editar o actualizar de acuerdo a ID y DELETE > Eliminar registro

Se incluyen clases para la comnunicacion entre microservicios a traves de servidor Feign > Ejemplo: FinancieraSolicitud, FinancieraCliente

Conclusion: Solo Asignacion de Solcitudes, Clientes a Financiera
![image](https://github.com/EliezerSA/APIREST-SolicitudesCredito/assets/40576280/cc01e0e0-c18c-43f4-aa23-edb90f21a328)

Nota: Falta relacion Creditos con Status para los siguientes 2 contratos
Nota: Falta implementacion de Docker con SpringCloud, si me lo permiten subir los cambios posteriormente, ya que solo lleggue a la alta de solicitudes.
Diagrama se incluye en un enlace externo

