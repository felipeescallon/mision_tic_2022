using System;
using System.Collections.Generic;
using System.Linq;
using HolaWeb.App.Dominio;

namespace HolaWeb.App.Persistencia.AppRepositorios
{
    public class RepositorioSaludosMemoria : IRepositorioSaludos
    {
        List<Saludo> saludos;

        public RepositorioSaludosMemoria()
        {
            saludos = new List<Saludo>()
            {
                new Saludo{Id=1,EnEspañol="Buenos Dias",EnIngles="Good Morning",EnItaliano="Bungiorno"},
                new Saludo{Id=2,EnEspañol="Buenas Tardes",EnIngles="Good Afternoon",EnItaliano="Buon pomeriggio"},
                new Saludo{Id=3,EnEspañol="Buenas Noches",EnIngles="Good Evening",EnItaliano="Buona notte"}

            };
        }

        public Saludo Add(Saludo nuevoSaludo)
        {
           nuevoSaludo.Id=saludos.Max(r => r.Id) +1; 
           saludos.Add(nuevoSaludo);
           return nuevoSaludo;
        }

        public IEnumerable<Saludo> GetAll()
        {
            return saludos;
        }

        public Saludo GetSaludoPorId(int saludoId)
        {
            return saludos.SingleOrDefault(s => s.Id==saludoId);
        }

        public IEnumerable<Saludo> GetSaludosPorFiltro(string filtro=null) // el parámetro es opcional 
        {
            var saludos = GetAll(); // Obtiene todos los saludos
            if (saludos != null)  //Si se tienen saludos
            {
                if (!String.IsNullOrEmpty(filtro)) // Si el filtro tiene algun valor
                {
                    saludos = saludos.Where(s => s.EnEspañol.Contains(filtro)); 
                    /// <summary>
                    /// Filtra los mensajes que contienen el filtro
                    /// </summary>
                }
            }
            return saludos;
        }

        public Saludo Update(Saludo saludoActualizado)
        {
            var saludo= saludos.SingleOrDefault(r => r.Id==saludoActualizado.Id);
            if (saludo!=null)
            {
                saludo.EnEspañol = saludoActualizado.EnEspañol;
                saludo.EnIngles=saludoActualizado.EnIngles;
                saludo.EnItaliano=saludoActualizado.EnItaliano;
            }
            return saludo;
        }
          
    }
}