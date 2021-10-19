
using System;
using System.Collections.Generic;
using System.Linq;
using HospiEnCasa.App.Dominio;

namespace HospiEnCasa.App.Persistencia
{
    public interface IRepositorioPaciente
    {
        IEnumerable<Paciente> GetAllPacientes();
        Paciente AddPaciente(Paciente paciente);
        //Paciente UpdatePaciente(Paciente paciente);//original del Ing. Oscar
        Paciente UpdatePaciente(Paciente paciente, int idPaciente_original);//modificada por mi para que funcionara
        void DeletePaciente(int idPaciente);    
        Paciente GetPaciente(int idPaciente);
        Medico AsignarMedico(int idPaciente, int idMedico);

        //COMPLEMENTANDO DE LA SEMANA 6:
        IEnumerable<Paciente> GetPacientesMasculinos();
        IEnumerable<Paciente> GetPacientesFemeninos();//ESTE FUE AGREGADO POR MI
        IEnumerable<Paciente> GetPacientesCorazon();
        IEnumerable<Paciente> GetPacientesRiesgoCovid();//ESTE FUE AGREGADO POR MI (por saturación de oxigeno): 
                                                        //https://cuidateplus.marca.com/bienestar/2020/05/27/oximetro-coronavirus-necesitas-173506.html

/*
TAREA EN CLASE/CASA: BACKEND
1. Hacer un filtro para niveles de temperatura anormales (hipotermia vs fiebre):
Info sobre la temperatura corporal: https://www.elsevier.es/es-revista-offarm-4-articulo-trastornos-temperatura-corporal-13108301    
2. Hacer un filtro para niveles de tensión (presión) arterial normales (sin/con tener en cuenta la edad)    
Info sobre la presión arterial: https://www.grupopacc.es/blog/valores-normales-de-tension-arterial-segun-tu-edad/
*/


    }


}