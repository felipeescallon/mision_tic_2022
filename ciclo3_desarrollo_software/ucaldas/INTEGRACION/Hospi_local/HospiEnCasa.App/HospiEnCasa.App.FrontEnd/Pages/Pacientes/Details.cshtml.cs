using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;

namespace HospiEnCasa.App.FrontEnd.Pages.Pacientes
{
    public class DetailsModel : PageModel
    {
        private readonly IRepositorioPaciente repositorioPacientes;
        public Paciente Paciente { get; set; }

        public DetailsModel()
        {
            this.repositorioPacientes=new RepositorioPaciente(new HospiEnCasa.App.Persistencia.AppContext());
        }

        public IActionResult OnGet(int pacienteId)
        {
            Paciente = repositorioPacientes.GetPaciente(pacienteId);
            if(Paciente==null)
            {
                return RedirectToPage("./NotFound");
            }
            else
            return Page();
        }
    }
}
