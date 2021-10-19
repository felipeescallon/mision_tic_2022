using System.Collections.Generic;
using HolaWeb.App.Dominio;


namespace HolaWeb.App.Persistencia.AppRepositorios
{
    public interface IRepositorioSaludos
    {
         IEnumerable<Saludo> GetAll();

    }
}