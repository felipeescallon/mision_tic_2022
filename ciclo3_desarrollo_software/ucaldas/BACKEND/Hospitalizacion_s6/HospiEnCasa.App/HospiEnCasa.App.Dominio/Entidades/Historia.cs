
using System.Collections.Generic;

namespace HospiEnCasa.App.Dominio
{
    /// <summary>Class <c>Historia</c>
    /// Modela la Historia clínica relacionada cpon el cuidado en casa del Paciente
    /// </summary>   
    public class Historia 
    {
        // Identificador único de la Historia
        public int Id { get; set; }
        /// Descripcion detallada del diagnostico del Paciente 
        public string Diagnostico  { get; set; }
         /// Descripción de la casa y habitación del Paciente  
        public string Entorno { get; set; }
        /// Referencia la lista de sugerencias registradas en la Historia del Paciente
        public List<SugerenciaCuidado> Sugerencias { get; set; }
    }
}