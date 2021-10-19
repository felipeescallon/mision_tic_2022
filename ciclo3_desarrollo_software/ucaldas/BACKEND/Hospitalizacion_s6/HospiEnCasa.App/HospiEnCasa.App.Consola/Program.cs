using System;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;
using System.Collections.Generic;//PARA EL MANEJO DE LISTAS (SEMANA 6)

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
            
            //Console.WriteLine("Buscando paciente actualizado...");
            //BuscarPaciente(3);
            //AsignarMedico();

            //RETOMANDO PARA LA SEMANA 6: se debe ir deshabilitando lo que se va haciendo porque son pruebas
            
            /*
            AddPaciente();
            Console.WriteLine("¡Paciente añadido!");            
            
            AddPacienteConSignos(); //solo es una prueba de que se envia info desde la consola y se guarda en la base de datos
            Console.WriteLine("¡Se ha registrado un paciente con signos!");            

            AddSignosPaciente(5); //el 5 ya existia en mi BD: solo es una prueba de que se envia info desde la consola y se guarda en la base de datos
            Console.WriteLine("¡Se ha agregado signos a un paciente!");            
            
            AddSignosPaciente(2); //el 2 no existia porque ya lo había borrado en mi BD: solo es una prueba de que se  envia info desde la consola y se guarda en la base de datos
            //como la id es autoincremental, entonces no se pone en la posición 2 sino en la última actual + 1 
            Console.WriteLine("¡Se ha agregado signos a un paciente!"); 

            ListarTodosLosPacientes();
            Console.WriteLine("¡Se han listado todos los pacientes!");                       

            ListarPacientesMasculinos();
            Console.WriteLine("¡Se han listado todos los pacientes MASCULINOS!");   
            
            ListarPacientesFemeninos();
            Console.WriteLine("¡Se han listado todos los pacientes FEMENINOS!");   
            
            ListarPacientesCorazon();
            Console.WriteLine("¡Se han listado todos los pacientes con riesgo del corazón por baja frecuencia cardiaca!");   
            
            ListarPacientesRiesgoCovid();
            Console.WriteLine("¡Se han listado todos los pacientes con riesgo de Covid por baja saturación de oxigeno!");   

            //AsignarMedico();//HACE PARTE DE LA SOLUCIÓN DE LOS TALLERES
            //Console.WriteLine("Medico (Persona 8) ha sido asignado al Paciente (Persona 1)");
            */

            //PRUEBAS EN CLASE (6-oct-2021):
            
            //ListarTodosLosPacientes();
            //Console.WriteLine("¡Se han listado todos los pacientes!");

            //AddPacienteConSignos(); //solo es una prueba de que se envia info desde la consola y se guarda en la base de datos
            //Console.WriteLine("¡Se ha registrado un paciente con signos!"); 

            ListarPacientesMasculinos();
            Console.WriteLine("¡Se han listado todos los pacientes MASCULINOS!");   
            
            ListarPacientesFemeninos();
            Console.WriteLine("¡Se han listado todos los pacientes FEMENINOS!");   


        }
        //CRUD
        private static void AddPaciente()
        //private static Paciente AddPaciente()
        {
            var paciente = new Paciente
            {
                
                //Nombre = "Nicolay",
                //Apellidos = "Perez",
                //Nombre = "Nicolay2",
                //Apellidos = "Perez2",
                //Nombre = "Nicolay3",
                //Apellidos = "Perez3",                
                //NumeroTelefono = "3001645",
                //Genero = Genero.Masculino,
                //Direccion = "Calle 4 No 7-4",
                //Longitud = 5.07062F,
                //Latitud = -75.52290F,
                //Ciudad = "Manizales",
                //FechaNacimiento = new DateTime(1990, 04, 12)
                
                //Nuevo paciente (semana 6):
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
      
        //private static void GetAllPacientes()
        //{
          //var pacientes = _repoPaciente.GetAllPacientes();          
          //for (int i=0;i<5;i++){
          //paciente: Pacientes){
          //    Console.WriteLine(pacientes[i].Nombre+" "+pacientes[i].Apellidos);         
          //Console.WriteLine(pacientes);   //PENDIENTE COMO HACER PARA MOSTRARLOS COMO UNA LISTA      
          //}

                    
         //SIN RETORNO          
           
          

        /*ESTO VA PARA LAS SIGUIENTES SEMANAS
        private static void AsignarMedico()
        {
            var medico = _repoPaciente.AsignarMedico(1,2);
            Console.WriteLine(medico.Nombre+" "+medico.Apellidos);
        }

        */
        //CONTINÚA DESDE LA SEMANA 3 QUE YA FUNCIONABA, Y SE RETOMA EN LA SEMANA 6:
        private static void ListarTodosLosPacientes()
        {
            var pacientes = _repoPaciente.GetAllPacientes();
            foreach (Paciente p in pacientes)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }
        
        
        private static void AddPacienteConSignos()
        {
            var paciente = new Paciente
            {
                //Nombre = "Carmenza",
                //Apellidos = "Zuluaga",
                //Nombre = "Carmenza3",
                //Apellidos = "Zuluaga3",
                Nombre = "Carmenza4",
                Apellidos = "Zuluaga4",
                NumeroTelefono = "5001646",
                //Genero = Genero.Femenino,//Enumerable de la posición 1 (inicia en 0)
                Genero = Genero.Bisexual,//Enumerable de la posición 2 (inicia en 0)
                Direccion = "Calle 908 No Xy-40",
                Longitud = 5.07062F,
                Latitud = -75.52290F,
                Ciudad = "Pereira",
                FechaNacimiento = new DateTime(1984, 04, 12),
                SignosVitales = new List<SignoVital> {
                    /*DE UNA VEZ LE PONGO LOS 5 DISTINTOS TIPOS DE SIGNO VITAL: los enumerables empiezan en 0
                    0: TensionArterial,
                    1: FrecuenciaCardica,
                    2: FrecuenciaRespiratoria,
                    3: SaturacionOxigeno,
                    4: TemperaturaCorporal
                    */
                    //REF:https://es.hesperian.org/hhg/Where_Women_Have_No_Doctor:C%C3%B3mo_medir_la_temperatura,_el_pulso,_la_respiraci%C3%B3n_y_la_presi%C3%B3n_de_la_sangre                    
                    new SignoVital{FechaHora= new DateTime(2021,10,12,19,43,55),Valor=120,Signo=TipoSigno.TensionArterial},//por facilidad solo se considera la sistolica       
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=90,Signo=TipoSigno.FrecuenciaCardica},
                    new SignoVital{FechaHora= new DateTime(2021,10,12,19,48,37),Valor=15,Signo=TipoSigno.FrecuenciaRespiratoria},//Es normal para un adulto tener de 12 a 20 respiraciones completas por minuto (una respiración completa consiste en tomar y soltar aire una vez).
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=88,Signo=TipoSigno.SaturacionOxigeno},
                    new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=35,Signo=TipoSigno.TemperaturaCorporal},

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
                    //paciente.SignosVitales.Add(new SignoVital { FechaHora = new DateTime(2021, 07, 10, 10, 50, 0), Valor = 86, Signo = TipoSigno.FrecuenciaCardica });
                    /*DE UNA VEZ LE PONGO LOS 5 DISTINTOS TIPOS DE SIGNO VITAL: los enumerables empiezan en 0
                    0: TensionArterial,
                    1: FrecuenciaCardica,
                    2: FrecuenciaRespiratoria,
                    3: SaturacionOxigeno,
                    4: TemperaturaCorporal
                    */
                    //REF:https://es.hesperian.org/hhg/Where_Women_Have_No_Doctor:C%C3%B3mo_medir_la_temperatura,_el_pulso,_la_respiraci%C3%B3n_y_la_presi%C3%B3n_de_la_sangre                    
                    //AQUI SE BVA AGREGANDO CADA SIGNO VITAL A LA LISTA 
                    paciente.SignosVitales.Add(new SignoVital{FechaHora= new DateTime(2021,10,12,19,43,55),Valor=130,Signo=TipoSigno.TensionArterial});//por facilidad solo se considera la sistolica       
                    paciente.SignosVitales.Add(new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=86,Signo=TipoSigno.FrecuenciaCardica});
                    paciente.SignosVitales.Add(new SignoVital{FechaHora= new DateTime(2021,10,12,19,43,55),Valor=11,Signo=TipoSigno.FrecuenciaRespiratoria});//Es normal para un adulto tener de 12 a 20 respiraciones completas por minuto (una respiración completa consiste en tomar y soltar aire una vez).
                    paciente.SignosVitales.Add(new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=95,Signo=TipoSigno.SaturacionOxigeno});
                    paciente.SignosVitales.Add(new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=41,Signo=TipoSigno.TemperaturaCorporal});
                }
                else //CAMBIO 86 POR 87 PARA VER SI ENTRA ACÁ CUANDO INGRESO SIGNOS DE UN PACIENTE QUE YA TENÍA COMO NICOLAY 5
                //En general cambio los valores para poder evidenciar mejor
                {
                    paciente.SignosVitales = new List<SignoVital> {//aquí se pasa de una vez toda la lista de los signos vitales
                        //new SignoVital{FechaHora= new DateTime(2021,07,10,10,50,0),Valor=87,Signo=TipoSigno.FrecuenciaCardica}
                        new SignoVital{FechaHora= new DateTime(2021,10,12,19,43,55),Valor=110,Signo=TipoSigno.TensionArterial},//por facilidad solo se considera la sistolica       
                        new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=87,Signo=TipoSigno.FrecuenciaCardica},
                        new SignoVital{FechaHora= new DateTime(2021,10,12,19,43,55),Valor=25,Signo=TipoSigno.FrecuenciaRespiratoria},//Es normal para un adulto tener de 12 a 20 respiraciones completas por minuto (una respiración completa consiste en tomar y soltar aire una vez).
                        new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=79,Signo=TipoSigno.SaturacionOxigeno},
                        new SignoVital{FechaHora= new DateTime(2021,09,12,18,50,0),Valor=37,Signo=TipoSigno.TemperaturaCorporal},
                    };
                }
                //_repoPaciente.UpdatePaciente(paciente);//ORIGINAL DEL ING OSCAR
                _repoPaciente.UpdatePaciente(paciente, idPaciente);//MODIFICADA POR MI PARA QUE FUNCIONARA
                
            }
            //ESTA PRUEBA LA PUSE YO EN CASO DE QUE SI NO HAY PACIENTE (NO HAY ID), ENTONCES QUE CREE UNO PACIENTE CON SIGNOS:
            else
            {
                AddPacienteConSignos();//reuso la función así se duplique la info de Carmenza (solo es una prueba)
            }
        }

        private static void AsignarMedico()
        {
            var medico = _repoPaciente.AsignarMedico(1, 8);//Medico (Persona 8: Rodolfo) ha sido asignado al Paciente (Persona 1: Nicolay)
            Console.WriteLine(medico.Nombre + " " + medico.Apellidos);
        }

        private static void ListarPacientesMasculinos()
        {
            var pacientesM = _repoPaciente.GetPacientesMasculinos();//M:Masculino
            foreach (Paciente p in pacientesM)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }
        //ESTE SE LO AGREGUÉ YO PARA SEGUIR CON LAS PRUEBAS:
        private static void ListarPacientesFemeninos()
        {
            var pacientesF = _repoPaciente.GetPacientesFemeninos();//F:Femenino
            foreach (Paciente p in pacientesF)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }


        private static void ListarPacientesCorazon()
        {
            var pacientesH = _repoPaciente.GetPacientesCorazon();//H:Heart
            foreach (Paciente p in pacientesH)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }
        
        //ESTE FUE AGREGADO POR MI (por saturación de oxigeno): 
        //https://cuidateplus.marca.com/bienestar/2020/05/27/oximetro-coronavirus-necesitas-173506.html

        private static void ListarPacientesRiesgoCovid()
        {
            var pacientesRC = _repoPaciente.GetPacientesRiesgoCovid();//RC:RiesgoCovid
            foreach (Paciente p in pacientesRC)
            {
                Console.WriteLine(p.Nombre + " " + p.Apellidos);
            }

        }
/*
TAREA EN CLASE/CASA: BACKEND
1. Hacer un filtro para niveles de temperatura anormales (hipotermia vs fiebre):
Info sobre la temperatura corporal: https://www.elsevier.es/es-revista-offarm-4-articulo-trastornos-temperatura-corporal-13108301    
2. Hacer un filtro para niveles de tensión (presión) arterial normales (sin/con tener en cuenta la edad)    
Info sobre la presión arterial: https://www.grupopacc.es/blog/valores-normales-de-tension-arterial-segun-tu-edad/
*/
    }
}
