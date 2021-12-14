//PROGRAMACIÓN FUNCIONAL CON JAVASCRIPT (nodejs "nativo/puro")
console.log("Hola mundo desde NodeJS");
//para esta prueba de una sola linea puede que no lleve ; al final de console.log("")

//IMPORTANDO PAQUETES Y OTROS ARCHIVOS + GUARDANDO EN CONSTANTES:
const express = require('express');//importando express y guardando en una constante llamada express
const mongoose = require('mongoose');//importando mongoose y guardando en una constante llamada mongoose
const TareaSquema = require("./modelos/Tarea.js");//importando el esquema de Tarea.js y guardando en una constante llamada TareaSquema

const app = express();//instanciando express y guardando en una constante llamada app

const router = express.Router();//definiendo las rutas como una puerta para que el usuario externo consulte nuestras funcionalidades
app.use(express.urlencoded({extended: true}));//para que se use la codificación de la url de express y que sea extendida
app.use(express.json());//para que se permita ingresar info en formato json

//Conexión a la base de datos (ActividadesBD: dicha BD tiene una colección llamada Tareas)
mongoose.connect("mongodb+srv://prog_web:ProgWebMintic2022@clusterprogweb.irmh1.mongodb.net/ActividadesBD?retryWrites=true&w=majority");//cadena de conexión (se debe poner el password y el nombre de la base de datos)

//Operaciones CRUD: se muestran como ejemplo las operaciones de creación (CREATE-app.post()) y lectura(READ-app.get()). 
//CONSULTA PRÁCTICA en equipos: terminar de hacer las otras operaciones del CRUD pendientes (update/delete)
//modelo cliente(request)-servidor(response): el servidor recibe la req del cliente y le responde al mismo cliente con res
router.get('/', (req, res) => {//al principio el navegador arrojaba Error pero con esto lo solucionamos porque ya apuntamos a la raíz ('/') del servidor
    res.send("El inicio de mi API");//respuesta del servidor cuando haya una petición del cliente (localhost:3000)
})//no va ; porque es una función

router.get('/tarea', (req, res) => {//es para pedir(READ) info desde el lado del cliente viniendo del servidor
    TareaSquema.find(function(err,datos){//esa función es un callback
        if(err){
            console.log("Error leyendo las tareas");  
        }else{
            res.send(datos);
        }        
    })//no va ; porque es una función    
});

router.post('/tarea', (req, res) => {//es para poner(CREATE) info desde el lado del cliente hacia el servidor
    let nuevaTarea = new TareaSquema({//se define un objeto dentro del constructor de TareaSquema
        //estos son los parámetros
        //obtengo el body (para eso era el url encoded y el json usando express)
        idTarea: req.body.id,
        nombreTarea: req.body.nombre,
        detalleTarea: req.body.detalle//no es necesario la , aquí porque esta finalizando el bloque de código         
    });//la anterior sería la información que llega para construir una nueva tarea

    //a través de mongoose: permitir que el esquema nuevaTarea guarde la información...
    //...y que precisamente la función pasada es la que se va a ejecuar luego de que se guarde la info
    nuevaTarea.save(function(err,datos){//esa función es un callback
        if(err){
            console.log(err);//muestra info en caso de error  
        }
        //si no entra a error es porque se guardó la info, y para eso desde el servidor se le informa al cliente que la operación fue exitosa
        res.send("Tarea almacenada correctamente.")//no es necesario el ; aquí porque esta finalizando el bloque de código        
    })//no va ; porque es una función
});

app.use(router);//para agregarle las rutas creadas a nuestra app
//con la linea 4 y la siguiente linea se puede incializar un servidor web escuchando por el puerto 3000 y pasandole una funcion anónima (lambda/"flecha") de javascript

app.listen(3000, () => {
    console.log("Servidor corriendo en el puerto 3000")//esta función solo muestra este mensaje
    //En un browser digitamos localhost:3000 y sale el mensaje Cannot GET / 
    //Con lo anterior se demuestra que si funciona aunque todavía no hay una ruta para la raíz del servidor
});