console.log("Hola mundo")

const express = require('express');
const mongoose = require('mongoose');
const PersonaSchema = require("./modelos/Persona.js");

const app = express();
const router = express.Router();
app.use(express.urlencoded({extended: true}));
app.use(express.json());

//Conexión a base de datos
mongoose.connect("mongodb+srv://prog_web:ProgWebMintic2022@clusterprogweb.z35rm.mongodb.net/OfertaLaboral?retryWrites=true&w=majority");

//Operaciones CRUD
router.get('/', (req, res) =>{
    res.send("El inicio de mi API");
})

router.get('/persona', (req, res) => {
    PersonaSchema.find(function(err,datos){
        if(err){
            console.log("Error leyendo las personas");
        }else{
            res.send(datos);
        }
    })
});

router.post('/persona',(req, res) => {
    let nuevaPersona = new PersonaSchema({
        idPersona: req.body.id, //la segunda parte puede ser diferente pues es del front
        tipoDocumento: req.body.tipoDocumento,
        documento: req.body.documento,
        nombres: req.body.nombres,
        apellidos: req.body.apellidos,
        direccion: req.body.direccion,
        correo: req.body.correo,
        fijo: req.body.fijo,
        celular: req.body.celular,
        sitioWeb: req.body.sitioWeb,
        descripcion: req.body.descripcion
    });

    nuevaPersona.save(function(err,datos){
        if(err){
            console.log(err);
        }
        res.send("Persona almacenada correctamente.")
    })
});

app.use(router); 
app.listen(3000,() =>{
    console.log("Servidor corriendo en el puerto 3000")
});
