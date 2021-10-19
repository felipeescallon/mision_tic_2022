using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using HospiEnCasa.App.Dominio;
using HospiEnCasa.App.Persistencia;

namespace HospiEnCasa.App.FrontEnd.Pages
{
    public class EditModel : PageModel
    {
       private readonly IRepositorioPaciente repositorioPacientes;

        [BindProperty]
        public Paciente Paciente  { get; set; } 

        public EditModel()
       {
            this.repositorioPacientes=new RepositorioPaciente(new HospiEnCasa.App.Persistencia.AppContext());
       }
     

        public IActionResult OnGet(int? pacienteId)
        {
            if (pacienteId.HasValue)
            {
                Paciente = repositorioPacientes.GetPaciente(pacienteId.Value);
            }
            else
            {
                Paciente = new Paciente();
            }
            if (Paciente == null)
            {
                return RedirectToPage("./NotFound");
            }
            else
                return Page();

        }

        public IActionResult OnPost()
        {
            if(!ModelState.IsValid)
            {
                return Page();
            }
            if(Paciente.Id>0)
            {
            Paciente = repositorioPacientes.UpdatePaciente(Paciente);
            }
            else
            {
             repositorioPacientes.AddPaciente(Paciente);
            }
            return Page();
        }
    }
}
