using AutoMapper;
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

        public string EliminarCliente(int codigo)
        {
            var result = db.Clientes.Where(e => e.Codigo == codigo).FirstOrDefault();

            if (result == null)
            {
                return "El registro de cliente a eliminar, no existe";
            }
            else
            {
                db.Clientes.Remove(result);

                if (db.SaveChanges() > 0)
                {
                    return "El registro de cliente, fue eliminado";
                }
                else
                {
                    return "Imposible eliminar";
                }
            }
            
        }

        public int GuardarCliente(ClienteContract cliente)
        {
            throw new NotImplementedException();
        }

        public string ModificarCliente(ClienteContract cliente)
        {



            throw new NotImplementedException();
        }

        public ClienteContract ObtenerCliente(int codigo)
        {
            Cliente cl = db.Clientes.Find(codigo);

            if (cl == null)
            {
                return null;
            }

            Mapper.Initialize(cfg => cfg.CreateMap<Cliente, ClienteContract>());
            return Mapper.Map<ClienteContract>(cl);
            
        }

       
    }
}
