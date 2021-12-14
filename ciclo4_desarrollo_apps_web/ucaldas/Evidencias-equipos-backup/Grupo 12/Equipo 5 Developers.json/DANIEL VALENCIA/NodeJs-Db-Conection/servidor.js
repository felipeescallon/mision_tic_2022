//Imports
const express = require('express');
const mongoose = require('mongoose');
//Models
const TareaShema = require('./Models/task.js');


const app = express();
const router = express.Router();
app.use(express.urlencoded({extended: true}));
app.use(express.json());

//Connection Data base
mongoose.connect("mongodb+srv://rot:1@mintic01.k4mvd.mongodb.net/ActividadesDB?retryWrites=true&w=majority");



//CRUD
router.get('/tarea', (req, res) => {
    TareaShema.find(function(err, datos){
        if (err){
            console.log("Error leyendo las tareas")
        }else{
            res.send(datos);
        }
    })
})

router.post('/tarea', (req, res) => {
    const nuevaTarea = new TareaShema({
        idTarea: req.body.id,
        nombreTarea: req.body.nombre,
        detalleTarea: req.body.detalle
    });
    nuevaTarea.save(function(err, datos){
        if (err){
            console.log(err);
        }
        res.send("Tarea iniciada correctamete.")
    })
    
})






app.use(router);
app.listen(3000, () => {
    console.log("Servidor iniciado")
});