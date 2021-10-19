namespace HospiEnCasa.App.Dominio
{
    /// <summary>Class <c>FamiliarDesignado</c>
    /// Modela al familiar asignado para cuidar al paciente
    /// </summary>   
    public class FamiliarDesignado : Persona
    {

        public string Parentesco { get; set; }
        // Dirección de correo electrónico del FamiliarDesignado
        public string Correo { get; set; }
    }
}
