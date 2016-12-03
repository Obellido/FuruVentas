using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;
using System.Web.Http.Description;
using upc.edm;

namespace upc.rest.Controllers
{
    public class UsuariosController : ApiController
    {
        private FuruDb db = new FuruDb();

      
        // GET: api/Usuarios/5
        [ResponseType(typeof(Usuario))]
        [Route("api/Usuarios/{name}")]
        public IHttpActionResult GetUsuario(string name,string pass)
        {
            Usuario usuario = db.Usuario.Where(e=> e.Alias == name && e.Password == pass).FirstOrDefault();
            if (usuario == null)
            {
                return NotFound();
            }

            return Ok(usuario);
        }

        // PUT: api/Usuarios/5
        [ResponseType(typeof(string))]
        [Route("api/Usuarios/{name}")]
        public IHttpActionResult PostUsuario(string name, Usuario usr)
        {
            Usuario usuario = db.Usuario.Where(e => e.Alias == name).FirstOrDefault();
            usuario.Password = usr.Password;

            db.SaveChanges();

            return Ok("Exito" + usr.Password);
        }
        

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool UsuarioExists(int id)
        {
            return db.Usuario.Count(e => e.Codigo == id) > 0;
        }
    }
}