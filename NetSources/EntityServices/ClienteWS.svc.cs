using AutoMapper;
using EDM;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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

        public int EliminarCliente(int codigo)
        {
            var result = db.Clientes.Where(e => e.Codigo == codigo).FirstOrDefault();

            if (result == null)
            {
                return 2;
            }
            else
            {
                db.Clientes.Remove(result);

                if (db.SaveChanges() > 0)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            
        }

        public int GuardarCliente(ClienteContract cliente)
        {
            Mapper.Initialize(cfg => cfg.CreateMap<ClienteContract,Cliente>());
            Cliente cl = Mapper.Map<Cliente>(cliente);

            db.Clientes.Add(cl);

            if (db.SaveChanges() > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public ClientePagedContract ListaPagCliente(int pagina)
        {
            if (pagina == 0) pagina++;
            List<ClienteContract> ls = new List<ClienteContract>();
            Mapper.Initialize(cfg => cfg.CreateMap<Cliente, ClienteContract>());

            var Query = db.Clientes;

            var TotalRecords = Query.Count();

            Query.OrderBy(e=> e.Codigo).Take(20).Skip((pagina - 1) * 20).ToList().ForEach(e=> {
                ls.Add(Mapper.Map<ClienteContract>(e));
            });

            return new ClientePagedContract {
                 TotalRecords = TotalRecords,
                 Records = ls
            };
        }

        public int ModificarCliente(ClienteContract cliente)
        {
            if (cliente.Codigo != 0)
            {
                Mapper.Initialize(cfg => cfg.CreateMap<ClienteContract, Cliente>());
                Cliente cl = Mapper.Map<Cliente>(cliente); 
                db.Entry(cl).State = EntityState.Modified;

                if (db.SaveChanges() > 0)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }

            }
            return 2;
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
