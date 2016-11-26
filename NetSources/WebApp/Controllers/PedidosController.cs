using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.ClienteService;
using WebApp.PedidoService;
using WebApp.ProductoService;

namespace WebApp.Controllers
{
    public class PedidosController : Controller
    {
        private PedidoServiceClient ClPedido = new PedidoServiceClient();
        private ClienteWSClient ClCliente = new ClienteWSClient();
        private ProductoWSClient ClProducto = new ProductoWSClient();

        // GET: Pedidos
        public ActionResult Index()
        {
            var ResultCliente = ClPedido.Listar();
            return View(ResultCliente);
        }

        public ActionResult Create()
        {
            ViewBag.CodigoCliente = new SelectList(ClCliente.ListaCliente().Records.Select(e => new {
                Text = (e.TipoCliente == 1 ? e.Nombres + " " + e.Apellidos : e.RazonSocial),
                Value = e.Codigo
            }), "Value", "Text");

           
            return View();
        }

        [HttpPost]
        public ActionResult Create(Pedido form)
        {
            form.Fecha = DateTime.Now;
            
            ClPedido.Registrar(form);

           

            return RedirectToAction("Index");
        }

        public ActionResult Detalle(int Id)
        {
            return View(ClPedido.Obtener(Id));
        }

        public ActionResult ProductoList()
        {
            return Json( ClProducto.ListaProducto().ToList() , JsonRequestBehavior.AllowGet) ;
        }
    }
}