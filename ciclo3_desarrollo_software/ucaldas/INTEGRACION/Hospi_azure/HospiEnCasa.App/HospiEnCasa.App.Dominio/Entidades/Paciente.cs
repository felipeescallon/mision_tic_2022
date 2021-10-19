using System;
namespace HospiEnCasa.App.Dominio
{
    /// <summary>Class <c>Paciente</c>
    /// Modela un Paciente que esta en atencion hospitalaria
    /// </summary>   
    public class Paciente : Persona
    {
        public string Direccion { get; set; }
        /// Coordenada de la dirección del Paciente
        public float Latitud { get; set; }
        /// Coordenada de la dirección del Paciente
        public float Longitud { get; set; }
        // Ciudad de residencia del Paciente
        public string Ciudad { get; set; }
        public DateTime FechaNacimiento { get; set; }
        /// Relacion entre Paciente y su FamiliarDesignado para cuidarlo
        public FamiliarDesignado Familiar { get; set; }
        /// Relacion entre Paciente y la  Enfermera asignada
        public Enfermera Enfermera { get; set; }
        /// Relacion entre Paciente y el Medico que lo atiende
        public Medico Medico { get; set; }
        /// Relacion entre Paciente y su Historia clínica
        public Historia Historia { get; set; }
        /// <summary>
        ///  Referencia a la lista de signos vitales de un Paciente 
        /// </summary>
        /// <value></value>
        public System.Collections.Generic.List<SignoVital> SignosVitales { get; set; }
    }
}
