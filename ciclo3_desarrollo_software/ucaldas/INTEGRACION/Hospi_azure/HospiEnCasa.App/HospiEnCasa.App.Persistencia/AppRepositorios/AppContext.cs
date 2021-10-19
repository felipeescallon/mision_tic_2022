using Microsoft.EntityFrameworkCore;
using HospiEnCasa.App.Dominio;

namespace HospiEnCasa.App.Persistencia
{
    public class AppContext : DbContext
    {
        public DbSet<Persona> Personas { get; set; }
        public DbSet<Paciente> Pacientes { get; set; }
        public DbSet<Medico> Medicos { get; set; }
        public DbSet<Enfermera> Enfermeras { get; set; }
        public DbSet<FamiliarDesignado> FamiliaresDesignados { get; set; }
        public DbSet<SignoVital> SignosVitales { get; set; }
        public DbSet<Historia> Historias { get; set; }
        public DbSet<SugerenciaCuidado> SugerenciasCuidado { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder
                .UseSqlServer("Server=tcp:misiontic-2022.database.windows.net,1433;Initial Catalog=HospiEncasatData;Persist Security Info=False;User ID=Login-misiontic;Password=Password-mision-tic;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");//ESTA ES LA MIA EN AZURE
               
               //.UseSqlServer("Server=tcp:misiontic2022.database.windows.net,1433;Initial Catalog=HospiEncasatData;Persist Security Info=False;User ID=admin_01;Password=09122006_Hf;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");//ES LA DEL PROFE OSCAR EN AZURE
               //ES LA MIA local (igual que la tenía localmente el profe Oscar)
               //.UseSqlServer("Data Source = (localdb)\\MSSQLLocalDB; Initial Catalog =HospiEncasatData");
               //ES LA MIA en Azure (siguiendo el modelo del profe Oscar del Lab4 de la sdemana 7)
               
               //.UseSqlServer("Server=tcp:misiontic-2022.database.windows.net,1433;Initial Catalog=HospiEncasatData;Persist Security Info=False;User ID=Login-misiontic;Password=Password-mision-tic;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");//ESTA ES LA MIA EN AZURE
               
               //ESTO FUE COPIADO DESDE AZURE CON EL CAMPO DE CONTRASEÑA SIN LLENAR:
               //Server=tcp:misiontic-2022.database.windows.net,1433;Initial Catalog=HospiEncasatData;Persist Security Info=False;User ID=Login-misiontic;Password={your_password};MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;

            }
        }

    }
}