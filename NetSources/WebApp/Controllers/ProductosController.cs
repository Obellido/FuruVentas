using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.ProductoService;

namespace WebApp.Controllers
{
    public class ProductosController : Controller
    {
        private ProductoWSClient ClProducto = new ProductoWSClient();

        public ActionResult Index()
        {
            return View(ClProducto.ListaProducto());
        }

        public ActionResult Create()
        {
            return View();
        }
    }
}