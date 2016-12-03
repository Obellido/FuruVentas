using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Web;
using System.Web.Mvc;
using upc.edm;

namespace upc.webapp.Controllers
{
    public class AccesoController : Controller
    {
        // GET: Acceso
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(string user, string pass)
        {
            var client = new RestClient("http://localhost:8889/api");
            var request = new RestRequest("Usuarios/{name}", Method.GET);
            request.AddUrlSegment("name", user);
            request.AddParameter("pass", pass);

            var response2 = client.Execute<Usuario>(request);

            if (response2.Data != null)
            {
                
           var claims = new List<Claim>
           {
               new Claim(ClaimTypes.Name, user),
               new Claim(ClaimTypes.NameIdentifier,user)
           };

           var identity = new ClaimsIdentity(claims, "ApplicationCookie", ClaimTypes.Name, ClaimTypes.Role);
           var owinContext = Request.GetOwinContext();
           owinContext.Authentication.SignIn(identity);

                return RedirectToAction("Index", "Home");
            }

            return RedirectToAction("Login",new { error = "Contraseña incorrecta" });    

           
        }

        public ActionResult Logout()
        {
            Request.GetOwinContext().Authentication.SignOut();
            return RedirectToAction("Login");
        }
    }
}