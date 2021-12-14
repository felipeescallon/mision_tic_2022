const mongoose = require('mongoose');

const TareaShema = new mongoose.Schema({
    idTarea: Number,
    nombreTarea: String,
    detalleTarea: String
});

module.exports = mongoose.model('tarea',TareaShema,'Tareas');