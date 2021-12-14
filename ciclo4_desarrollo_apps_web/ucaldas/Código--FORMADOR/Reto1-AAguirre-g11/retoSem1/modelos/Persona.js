const mongoose = require('mongoose');

let PersonaSchemna = new mongoose.Schema({
    idPersona: Number,
    tipoDocumento: String,
    documento: String,
    nombres: String,
    apellidos: String,
    direccion: String,
    correo: String,
    fijo: String,
    celular: String,
    sitioWeb: String,
    descripcion: String
});

module.exports = mongoose.model('persona', PersonaSchemna, 'Personas');