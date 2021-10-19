using System;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;

namespace HospiEnCasa.App.Consola
{
    class Program
    {
        
        private static IRepositorioPaciente _repoPaciente= new RepositorioPaciente(new Persistencia.AppContext());
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World EF!");
            //AddPaciente();
            //Console.WriteLine("Buscando primer paciente...");
            //BuscarPaciente(1);
            //Console.WriteLine("Ya había un paciente Nicolay Perez, ahora agregaré Nicolay2 Perez2 y los demás datos iguales solo para probar que borrar paciente funciona...");
            //AddPaciente();
            //Console.WriteLine("Buscando segundo paciente...");
            //BuscarPaciente(3);
            //Console.WriteLine("Borrando segundo paciente...");
            //DeletePaciente(2);
            //Paciente paciente_original = BuscarPaciente(1);
            //Paciente paciente_actualizado = UpdatePaciente(paciente_original); //estoy poniendo la info de Nicolay Perez de id1 en id2
            //Paciente paciente_actualizado = UpdatePaciente(AddPaciente()); //estoy poniendo la info de Nicolay Perez de id1 en id2
            //UpdatePaciente(5); //estoy actualizando Nicolay5 Perez5 de la id5 que tenía Nicolay3 Perez3
            GetAllPacientes();            
            //Console.WriteLine("Buscando paciente actualizado...");
            //BuscarPaciente(3);


            //AsignarMedico();
        }

        private static void AddPaciente()
        //private static Paciente AddPaciente()
        {
            var paciente = new Paciente
            {
                
                //Nombre = "Nicolay",
                //Apellidos = "Perez",
                //Nombre = "Nicolay2",
                //Apellidos = "Perez2",
                Nombre = "Nicolay3",
                Apellidos = "Perez3",                
                NumeroTelefono = "3001645",
                Genero = Genero.Masculino,
                Direccion = "Calle 4 No 7-4",
                Longitud = 5.07062F,
                Latitud = -75.52290F,
                Ciudad = "Manizales",
                FechaNacimiento = new DateTime(1990, 04, 12)
            };
            _repoPaciente.AddPaciente(paciente);
            //return paciente;
          
        }
      

        
    
        private static void BuscarPaciente(int idPaciente)
        {
            var paciente = _repoPaciente.GetPaciente(idPaciente);
            //Console.WriteLine(paciente.Nombre+" "+paciente.Apellidos);
            string datos_paciente = "\nNombre:"+paciente.Nombre+"\nApellidos:"+paciente.Apellidos+"\nNumero de Telefono:"+paciente.NumeroTelefono+"\nGenero:"+paciente.Genero+"\nDireccion:"+paciente.Direccion+"\nUbicacion (Longitud;Latitud):("+paciente.Longitud+";"+paciente.Latitud+")"+"\nCiudad:"+paciente.Ciudad+"\nFecha de Nacimiento:"+paciente.FechaNacimiento;
            Console.WriteLine(datos_paciente);          
         //SIN RETORNO       
        }

        

        /*
        private static Paciente BuscarPaciente(int idPaciente)
        {
            var paciente = _repoPaciente.GetPaciente(idPaciente);
            //Console.WriteLine(paciente.Nombre+" "+paciente.Apellidos);
            string datos_paciente = "\nNombre:"+paciente.Nombre+"\nApellidos:"+paciente.Apellidos+"\nNumero de Telefono:"+paciente.NumeroTelefono+"\nGenero:"+paciente.Genero+"\nDireccion:"+paciente.Direccion+"\nUbicacion (Longitud;Latitud):("+paciente.Longitud+";"+paciente.Latitud+")"+"\nCiudad:"+paciente.Ciudad+"\nFecha de Nacimiento:"+paciente.FechaNacimiento;
            Console.WriteLine(datos_paciente);          
            return paciente;//CON RETORNO  
        }
        */

      

        private static void DeletePaciente(int idPaciente)
        {            
            _repoPaciente.DeletePaciente(idPaciente);
            Console.WriteLine("Paciente borrado!");           
                
        }
        
       
        //private static Paciente UpdatePaciente(int idPaciente)
        private static void UpdatePaciente(int idPaciente_original)
        {            
            //var paciente_actualizado = _repoPaciente.UpdatePaciente(paciente);
            var paciente_actualizado = new Paciente
            {
                
                //Nombre = "Nicolay",
                //Apellidos = "Perez",
                //Nombre = "Nicolay2",
                //Apellidos = "Perez2",
                Nombre = "Nicolay5",
                Apellidos = "Perez5",                
                NumeroTelefono = "3001645",
                Genero = Genero.Masculino,
                Direccion = "Calle 4 No 7-4",
                Longitud = 5.07062F,
                Latitud = -75.52290F,
                Ciudad = "Manizales",
                FechaNacimiento = new DateTime(1990, 04, 12)
            };
            _repoPaciente.UpdatePaciente(paciente_actualizado, idPaciente_original);
            //var paciente = _repoPaciente.UpdatePaciente(idPaciente);

            Console.WriteLine("Paciente actualizado!");
            //return paciente_actualizado;           
                
        }
          //¡HASTA AQUÍ ME FUNCIONA! (FIN SEMANA 3)
      
        private static void GetAllPacientes()
        {
          var pacientes = _repoPaciente.GetAllPacientes();          
          //for (int i=0;i<5;i++){
          //paciente: Pacientes){
          //    Console.WriteLine(pacientes[i].Nombre+" "+pacientes[i].Apellidos);         
          Console.WriteLine(pacientes);   //PENDIENTE COMO HACER PARA MOSTRARLOS COMO UNA LISTA      
          //}        
            
         //SIN RETORNO  
          
        }

        
            
            

        /*ESTO VA PARA LAS SIGUIENTES SEMANAS
        private static void AsignarMedico()
        {
            var medico = _repoPaciente.AsignarMedico(1,2);
            Console.WriteLine(medico.Nombre+" "+medico.Apellidos);
        }

        */
    }
}
