using System;
using System.Collections.Generic;
using System.Linq;
using HospiEnCasa.App.Dominio;
using Microsoft.EntityFrameworkCore;

namespace HospiEnCasa.App.Persistencia
{

    public class RepositorioPaciente : IRepositorioPaciente
    {
        /// <summary>
        /// Referencia al contexto de Paciente
        /// </summary>
        private readonly AppContext _appContext;
        /// <summary>
        /// Metodo Constructor Utiiza 
        /// Inyeccion de dependencias para indicar el contexto a utilizar
        /// </summary>
        /// <param name="appContext"></param>//
        public RepositorioPaciente(AppContext appContext)
        {
            _appContext = appContext;
        }


        public Paciente AddPaciente(Paciente paciente)
        {
            var pacienteAdicionado = _appContext.Pacientes.Add(paciente);
            _appContext.SaveChanges();
            return pacienteAdicionado.Entity;

        }

        public void DeletePaciente(int idPaciente)
        {
            var pacienteEncontrado = _appContext.Pacientes.FirstOrDefault(p => p.Id == idPaciente);
            if (pacienteEncontrado == null)
                return;
            _appContext.Pacientes.Remove(pacienteEncontrado);
            _appContext.SaveChanges();
        }

       public IEnumerable<Paciente> GetAllPacientes()
        {
            return GetAllPacientes_();
        }
        public IEnumerable<Paciente> GetPacientesPorFiltro(string filtro)
        {
            var pacientes = GetAllPacientes(); // Obtiene todos los saludos
            if (pacientes != null)  //Si se tienen saludos
            {
                if (!String.IsNullOrEmpty(filtro)) // Si el filtro tiene algun valor
                {
                    pacientes = pacientes.Where(s => s.Nombre.Contains(filtro));
                }

            }
            return pacientes;

        }

        public IEnumerable<Paciente> GetAllPacientes_()
        {
            return _appContext.Pacientes;
        }

        public Paciente GetPaciente(int idPaciente)
        {
            return _appContext.Pacientes.FirstOrDefault(p => p.Id == idPaciente);
        }

        public Paciente UpdatePaciente(Paciente paciente)
        {
            var pacienteEncontrado = _appContext.Pacientes.FirstOrDefault(p => p.Id == paciente.Id);
            if (pacienteEncontrado != null)
            {
                pacienteEncontrado.Nombre = paciente.Nombre;
                pacienteEncontrado.Apellidos = paciente.Apellidos;
                pacienteEncontrado.NumeroTelefono = paciente.NumeroTelefono;
                pacienteEncontrado.Genero = paciente.Genero;
                pacienteEncontrado.Direccion = paciente.Direccion;
                pacienteEncontrado.Latitud = paciente.Latitud;
                pacienteEncontrado.Longitud = paciente.Longitud;
                pacienteEncontrado.Ciudad = paciente.Ciudad;
                pacienteEncontrado.FechaNacimiento = paciente.FechaNacimiento;
                pacienteEncontrado.Familiar = paciente.Familiar;
                pacienteEncontrado.Enfermera = paciente.Enfermera;
                pacienteEncontrado.Medico = paciente.Medico;
                pacienteEncontrado.Historia = paciente.Historia;

                _appContext.SaveChanges();


            }
            return pacienteEncontrado;
        }

        public Medico AsignarMedico(int idPaciente, int idMedico)
        {
            var pacienteEncontrado = _appContext.Pacientes.FirstOrDefault(p => p.Id == idPaciente);
            if (pacienteEncontrado != null)
            {
                var medicoEncontrado = _appContext.Medicos.FirstOrDefault(m => m.Id == idMedico);
                if (medicoEncontrado != null)
                {
                    pacienteEncontrado.Medico = medicoEncontrado;
                    _appContext.SaveChanges();
                }
                return medicoEncontrado;
            }
            return null;
        }

        public IEnumerable<Paciente> GetPacientesMasculinos()
        {

            return _appContext.Pacientes.Where(p => p.Genero == Genero.Masculino).ToList();        }

        IEnumerable<Paciente> IRepositorioPaciente.GetPacientesCorazon()
        {

            return _appContext.Pacientes
                                   .Where(p => p.SignosVitales.Any(s => TipoSigno.FrecuenciaCardica == s.Signo && s.Valor >= 90))
                                   .ToList();
        }

        IEnumerable<SignoVital> IRepositorioPaciente.GetSignosPaciente(int idPaciente)
        {
            var paciente = _appContext.Pacientes.Where(s => s.Id==idPaciente)
                                               .Include(s=>s.SignosVitales)
                                               .FirstOrDefault();

            return paciente.SignosVitales;
        }
    }
}