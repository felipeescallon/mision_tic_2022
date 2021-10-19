
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using HospiEnCasa.App.Dominio;

namespace HospiEnCasa.App.Persistencia
{
    public interface IRepositorioPaciente
    {
        IEnumerable<Paciente> GetAllPacientes();
        Paciente AddPaciente(Paciente paciente);
        Paciente UpdatePaciente(Paciente paciente);
        void DeletePaciente(int idPaciente);    
        Paciente GetPaciente(int idPaciente);
        Medico AsignarMedico(int idPaciente, int idMedico); 
        IEnumerable<Paciente>  GetPacientesMasculinos();
        IEnumerable<Paciente> GetPacientesCorazon();
        IEnumerable<Paciente> GetPacientesPorFiltro(string filtro);
        IEnumerable<SignoVital> GetSignosPaciente(int idPaciente);
             
       
    }


}