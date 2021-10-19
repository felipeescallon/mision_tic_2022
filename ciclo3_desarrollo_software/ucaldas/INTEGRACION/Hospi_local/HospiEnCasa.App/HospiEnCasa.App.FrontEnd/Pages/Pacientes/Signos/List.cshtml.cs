using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace HospiEnCasa.App.FrontEnd.Pages.Pacientes.Signos
{
    public class ListModel : PageModel
    {
        private readonly IRepositorioPaciente repositorioPacientes;
        [BindProperty]
        public Paciente Paciente { get; set; }


        public IEnumerable<SignoVital> SignosPaciente { get; set; }

        public ListModel()
        {
            this.repositorioPacientes = new RepositorioPaciente(new HospiEnCasa.App.Persistencia.AppContext());
        }
        public void OnGet(int? pacienteId)
        {

            if (pacienteId.HasValue)
            {
                Paciente = repositorioPacientes.GetPaciente(pacienteId.Value);
            }

            if (Paciente == null)
            {
                RedirectToPage("./NotFound");
            }
            else
            {
                SignosPaciente = repositorioPacientes.GetSignosPaciente(pacienteId.Value);
            }

        }
    }
}
