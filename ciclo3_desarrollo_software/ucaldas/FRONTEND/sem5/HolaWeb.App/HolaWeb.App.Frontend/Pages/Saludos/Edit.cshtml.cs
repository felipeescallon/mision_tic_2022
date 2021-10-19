using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using HolaWeb.App.Dominio;
using HolaWeb.App.Persistencia.AppRepositorios;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace HolaWeb.App.Frontend.Pages
{
    public class EditModel : PageModel
    {
        private readonly IRepositorioSaludos repositorioSaludos;
        [BindProperty]
        public Saludo Saludo { get; set; }

        public EditModel(IRepositorioSaludos repositorioSaludos)
        {
            this.repositorioSaludos = repositorioSaludos;
        }
        public IActionResult OnGet(int? saludoId)
        {
            if (saludoId.HasValue)
            {
                Saludo = repositorioSaludos.GetSaludoPorId(saludoId.Value);
            }
            else
            {
                Saludo = new Saludo();
            }
            if (Saludo == null)
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
            if(Saludo.Id>0)
            {
            Saludo = repositorioSaludos.Update(Saludo);
            }
            else
            {
             repositorioSaludos.Add(Saludo);
            }
            return Page();
        }


    }
}
