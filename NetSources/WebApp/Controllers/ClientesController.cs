using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.ClienteService;
using PagedList;

namespace WebApp.Controllers
{
    public class ClientesController : Controller
    {
        private ClienteWSClient ClCliente = new ClienteWSClient();
        
        public ActionResult Index(int page = 1)
        {
            var ResultCliente = ClCliente.ListaPagCliente(page);
            
            return View(ResultCliente.Records);
        }

        public ActionResult Create() {
            return View();
        }

        public ActionResult Edit(int id) {
            var ResultCliente = ClCliente.ObtenerCliente(id);
            return View(ResultCliente);
        }
    }
}