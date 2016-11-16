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
            var ResultCliente = ClCliente.ListaCliente();

            return View(ResultCliente.Records);
        }

        public ActionResult Create()
        {
            ViewBag.TipoCliente = new SelectList(new[] {
                new { Text = "PERSONA NATURAL", Value = 1 },
                new { Text = "PERSONA JURÍDICA", Value = 2 },
            }, "Value", "Text");


            return View();
        }

        [HttpPost]
        public ActionResult Create(ClienteContract form)
        {
            int result = ClCliente.GuardarCliente(form);

            if (result == 1)
            {
                return RedirectToAction("Index");
            }

            return RedirectToAction("Create");

        }

        public ActionResult Edit(int id)
        {
            var ResultCliente = ClCliente.ObtenerCliente(id);

            ViewBag.TipoCliente = new SelectList(new[] {
                new { Text = "PERSONA NATURAL", Value = 1 },
                new { Text = "PERSONA JURÍDICA", Value = 2 },
            }, "Value", "Text");

            return View(ResultCliente);
        }

        [HttpPost]
        public ActionResult Edit(int id, ClienteContract form)
        {
            int result = ClCliente.ModificarCliente(form);

            if (result == 1)
            {
                return RedirectToAction("Index");
            }

            return RedirectToAction("Edit");

        }

    }
}