using System;
using System.ComponentModel.DataAnnotations;

namespace HolaWeb.App.Dominio
{
    public class Saludo
    {
        public int Id {get;set;}
        [Required, StringLength(50)]
        public string EnEspañol {get;set;}
         [Required, StringLength(50)]
        public string EnIngles {get;set;}
         [Required, StringLength(50)]
        public string EnItaliano {get;set;}

    }
}
