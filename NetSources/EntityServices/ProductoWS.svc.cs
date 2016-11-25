using AutoMapper;
using EDM;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EntityServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "ProductoWS" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select ProductoWS.svc or ProductoWS.svc.cs at the Solution Explorer and start debugging.
    public class ProductoWS : IProductoWS
    {
        private FuruContext db = new FuruContext();

        public int EliminarProducto(int codigo)
        {
            var result = db.Productos.Where(e => e.Codigo == codigo).FirstOrDefault();

            if (result == null)
            {
                return 2;
            }
            else
            {
                db.Productos.Remove(result);

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

        public int GuardarProducto(ProductoContract producto)
        {
            Mapper.Initialize(cfg => cfg.CreateMap<ProductoContract, Producto>());
            Producto pr = Mapper.Map<Producto>(producto);

            db.Productos.Add(pr);

            if (db.SaveChanges() > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public List<ProductoContract> ListaProducto()
        {
            List<ProductoContract> ls = new List<ProductoContract>();
            Mapper.Initialize(cfg => cfg.CreateMap<Producto, ProductoContract>());
            db.Productos.OrderBy(e => e.Codigo).ToList().ForEach(e => {
                ls.Add(Mapper.Map<ProductoContract>(e));
            });

            return ls;
        }

        public int ModificarProducto(ProductoContract producto)
        {
            if (producto.Codigo != 0)
            {
                Mapper.Initialize(cfg => cfg.CreateMap<ProductoContract, Producto>());
                Producto pr = Mapper.Map<Producto>(producto);
                db.Entry(pr).State = EntityState.Modified;

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

        public ProductoContract ObtenerProducto(int codigo)
        {
            Producto cl = db.Productos.Find(codigo);

            if (cl == null)
            {
                return null;
            }

            Mapper.Initialize(cfg => cfg.CreateMap<Producto, ProductoContract>());
            return Mapper.Map<ProductoContract>(cl);
        }
    }
}
