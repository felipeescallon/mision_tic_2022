using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;
using Microsoft.AspNetCore.Authorization;

namespace HospiEnCasa.App.FrontEnd.Pages
{

    [Authorize]
    public class ListModel : PageModel
    {
        private readonly IRepositorioPaciente repositorioPacientes;

        public IEnumerable<Paciente> Pacientes {get;set;}   
       

        public ListModel()
       {
            this.repositorioPacientes=new RepositorioPaciente(new HospiEnCasa.App.Persistencia.AppContext());
       }
       
        public void OnGet(string filtroBusqueda)
        {
            Pacientes = repositorioPacientes.GetAllPacientes();
          
        }
    }
}
