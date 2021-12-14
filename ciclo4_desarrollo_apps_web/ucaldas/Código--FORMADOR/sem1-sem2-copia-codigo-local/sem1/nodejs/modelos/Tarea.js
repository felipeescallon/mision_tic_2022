//esquema que permita enviar y leer info desde la base de datos
const mongoose = require('mongoose');//importando mongoose y guardando en una constante llamada mongoose
//construcción del esquema
let TareaSchema = new mongoose.Schema({
    //propiedades del esquema:
    idTarea: Number,
    nombreTarea: String,
    detalleTarea: String
}); //let para variables

//Para exponer lo anterior al exterior:
module.exports = mongoose.model('tarea', TareaSchema, 'Tareas');
//con lo anterior el esquema queda definido que va a ser de utilidad dentro de las operaciones CRUD del servidor.js
//La base de datos se llama ActividadesBD (está en el servidore.js): dicha BD tiene una colección llamada Tareas
