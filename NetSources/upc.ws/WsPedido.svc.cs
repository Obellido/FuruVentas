using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using upc.edm;

namespace upc.ws
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "WsPedido" en el código, en svc y en el archivo de configuración a la vez.
    // NOTA: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione WsPedido.svc o WsPedido.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class WsPedido : IWsPedido
    {
        private FuruDb db = new FuruDb();

        private void InitializeMap()
        {
            Mapper.Initialize(cfg => {
                cfg.CreateMap<edm.Pedido, ws.Pedido>()
                   .ForMember(d => d.NombreCliente,
                              o => o.MapFrom(src => src.Clientes.TipoCliente == 1 ? src.Clientes.Nombres + " " + src.Clientes.Apellidos : src.Clientes.RazonSocial))
                   .ForMember(d => d.Codigo, o => o.MapFrom(s => s.Id))
                   .ForMember(d => d.CodigoCliente, o => o.MapFrom(s => s.ClienteId))
                   
                   ;

                cfg.CreateMap<edm.DetallePedido, ws.DetallePedido>()
                   .ForMember(d => d.NombreProducto, o => o.MapFrom(s => s.Producto.Descripcion))
                   .ForMember(d => d.CodigoProducto, o => o.MapFrom(s => s.ProductoId))
                   ;

                cfg.CreateMap<ws.DetallePedido, edm.DetallePedido>()
                    .ForMember(d => d.ProductoId, o => o.MapFrom(s => s.CodigoProducto));

                cfg.CreateMap<ws.Pedido, edm.Pedido>()
                   .ForMember(d => d.Id, o => o.MapFrom(s => s.Codigo))
                   .ForMember(d => d.ClienteId, o => o.MapFrom(s => s.CodigoCliente))
                ;

            });
        }

        public Pedido Obtener(int Codigo)
        {
            InitializeMap();
            var _pedido = db.Pedido.Find(Codigo);
            var _data = Mapper.Map<Pedido>(_pedido);
            return _data;
        }



        public int Registrar(Pedido Data)
        {
            InitializeMap();
            var _data = Mapper.Map<edm.Pedido>(Data);
            _data.UsuarioId = 1;
            db.Pedido.Add(_data);

            if (db.SaveChanges() > 0)
            {
                return 1;
            }
            return 0;
        }

        public List<Pedido> Listar()
        {
            InitializeMap();
            var _result = new List<Pedido>();
            var _data = db.Pedido.Include("Detalle").Include("Clientes").ToList();
            _data.ForEach(e => { _result.Add(Mapper.Map<Pedido>(e)); });
            return _result;
        }
    }
}
