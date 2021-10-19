namespace HospiEnCasa.App.Dominio
{
    /// <summary>Class <c>Enfermera</c>
    /// Modela una Persona del personal de enfermería del equipo medico de apoyo 
    /// </summary>   
    public class Enfermera : Persona
    {
        /// Numero único de la tarjeta profesional   
        public string TarjetaProfesional { get; set; }
        /// Cantidad de horas laborales a la semana 
        public int HorasLaborales { get; set; }
    }
}