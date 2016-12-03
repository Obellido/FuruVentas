using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using upc.edm;
using upc.webapp.PedidoService;

namespace upc.webapp.Controllers
{
    public class PedidosController : Controller
    {
        private WsPedidoClient ClPedido = new WsPedidoClient();
        private FuruDb db = new FuruDb();

        public ActionResult Index()
        {

            var ResultCliente = ClPedido.Listar();
            return View(ResultCliente);
        }

        public ActionResult Create()
        {
            ViewBag.CodigoCliente = db.Clientes.ToList().Select(e => new SelectListItem
            {
                Text = (e.TipoCliente == 1 ? e.Nombres + " " + e.Apellidos : e.RazonSocial),
                Value = e.Codigo.ToString()
            }).ToList();


            return View();
        }

        [HttpPost]
        public ActionResult Create(ws.Pedido _form)
        {
            _form.Fecha = DateTime.Now;
            ClPedido.Registrar(_form);
            return RedirectToAction("Index");
            
        }
        
        [HttpPost]
        public ActionResult ProductoList()
        {
            return Json(db.Productos.ToList());
        }

        public ActionResult Detalle(int Id)
        {
            return View(ClPedido.Obtener(Id));
        }
    }
}