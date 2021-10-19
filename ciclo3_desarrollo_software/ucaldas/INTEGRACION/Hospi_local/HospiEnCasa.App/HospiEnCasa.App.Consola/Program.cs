using System;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;
using System.Collections.Generic;

namespace HospiEnCasa.App.Consola
{
    class Program
    {

        private static IRepositorioPaciente _repoPaciente = new RepositorioPaciente(new Persistencia.AppContext());
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World EF!------------");
            ListarSignosPaciente(5);
            //ListarPacientesCorazon();
            //ListarPacientesFiltro();   
            //ListarPacientesMasculinos();
            //AddSignosPaciente(2);
            //AddPacienteConSignos();             
            //AddPaciente();
            //BuscarPaciente(2);
            //AsignarMedico();

        }

        private static void AddPaciente()
        {
            var paciente = new Paciente
            {
                Nombre = "Rodolfo",
                Apellidos = "Francis",
                NumeroTelefono = "31111645",
                Genero = Genero.Masculino,
                Direccion = "Calle 44 No 767-4",
                Longitud = 5.07062F,
                Latitud = -75.52290F,
                Ciudad = "Bogota",
                FechaNacimiento = new DateTime(1990, 04, 12)
            };
            _repoPaciente.AddPaciente(paciente);

        }


        private static void AddPacienteConSignos()
        {
            var paciente = new Paciente
            {
                Nombre = "Carmenza",
                Apellidos = "Zuluaga",
                NumeroTelefono = "5001646",
                Genero = Genero.Femenino,
                Direccion = "Calle 908 No Xy-40",
                Longitud = 5.07062F,
                Latitud = -75.52290F,
                Ciudad = "Pereira",
                FechaNacimiento = new DateTime(1984, 04, 12),
                SignosVitales = new List<SignoVital> {
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=36,Signo=TipoSigno.TemperaturaCorporal},
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=95,Signo=TipoSigno.SaturacionOxigeno},
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=90,Signo=TipoSigno.FrecuenciaCardica}

                }
            };
            _repoPaciente.AddPaciente(paciente);

        }

        private static void AddSignosPaciente(int idPaciente)
        {
            var paciente = _repoPaciente.GetPaciente(idPaciente);
            if (paciente != null)
            {
                if (paciente.SignosVitales != null)
                {
                    paciente.SignosVitales.Add(new SignoVital { FechaHora = new DateTime(2021, 07, 10, 10, 50, 0), Valor = 86, Signo = TipoSigno.FrecuenciaCardica });
                }
                else
                {
                    paciente.SignosVitales = new List<SignoVital> {
                        new SignoVital{FechaHora= new DateTime(2021,07,10,10,50,0),Valor=86,Signo=TipoSigno.FrecuenciaCardica}
                    };
                }
                _repoPaciente.UpdatePaciente(paciente);
            }
        }


        private static void BuscarPaciente(int idPaciente)
        {
            var paciente = _repoPaciente.GetPaciente(idPaciente);
            Console.WriteLine(paciente.Nombre + " " + paciente.Apellidos);
        }

        private static void AsignarMedico()
        {
            var medico = _repoPaciente.AsignarMedico(1, 2);
            Console.WriteLine(medico.Nombre + " " + medico.Apellidos);
        }


        private static void ListarPacientesMasculinos()
        {
            var pacientesM = _repoPaciente.GetPacientesMasculinos();
            foreach (Paciente p in pacientesM)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }

        private static void ListarPacientesFiltro()
        {
            var pacientesM = _repoPaciente.GetPacientesPorFiltro("Y");
            foreach (Paciente p in pacientesM)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }
        private static void ListarPacientesCorazon()
        {
            var pacientesH = _repoPaciente.GetPacientesCorazon();
            foreach (Paciente p in pacientesH)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }

        private static void ListarSignosPaciente(int idPaciente)
        {
            var signos = _repoPaciente.GetSignosPaciente(idPaciente);
            if (signos != null)
            {
                foreach (SignoVital s in signos)
                {
                    Console.WriteLine(s.Valor);
                }
            }
            else
            {
                Console.WriteLine("No registra signos");
            }


        }


    }
}
