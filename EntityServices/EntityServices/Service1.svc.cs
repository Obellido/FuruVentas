using EDM;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;


namespace EntityServices
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código, en svc y en el archivo de configuración.
    // NOTE: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione Service1.svc o Service1.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class ClienteWS : IClienteWS
    {
        private FuruContext db = new FuruContext();

        public ClienteContract ObtenerCliente(int codigo)
        {

            ClienteContract cl =  db.Clientes.Where(e=> e.Codigo == codigo).Select(e => new ClienteContract {
                Apellidos = e.Apellidos,
                Codigo = e.Codigo,
                Direccion = e.Direccion,
                DNI = e.DNI,
                Email = e.Email,
                Nombres = e.Nombres,
                RazonSocial = e.RazonSocial,
                Telefono = e.Telefono,
                TipoCliente = e.TipoCliente 
            }).FirstOrDefault();

            return cl;
            
        }
    }
}
