using AutoMapper;
using EDM;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EntityServices
{
    public class PedidoService : IPedidoService
    {
        private FuruContext db = new FuruContext();

        private void InitializeMap() {
            Mapper.Initialize(cfg => {
                cfg.CreateMap<EDM.Pedido, Pedido>()
                   .ForMember(d => d.NombreCliente,
                              o => o.MapFrom(src => src.Cliente.TipoCliente == 1 ? src.Cliente.Nombres + " " + src.Cliente.Apellidos : src.Cliente.RazonSocial))
                   .ForMember(d=> d.Codigo, o=> o.MapFrom(s=> s.Id))
                   .ForMember(d=> d.CodigoCliente, o=> o.MapFrom(s=> s.ClienteId))
                   ;

                cfg.CreateMap<EDM.DetallePedido, DetallePedido>()
                   .ForMember(d => d.NombreProducto, o => o.MapFrom(s => s.Producto.Descripcion))
                   .ForMember(d => d.CodigoProducto, o=> o.MapFrom(s=> s.ProductoId))
                   ;

                cfg.CreateMap<DetallePedido, EDM.DetallePedido>()
                    .ForMember(d => d.ProductoId, o => o.MapFrom(s => s.CodigoProducto));

                cfg.CreateMap<Pedido, EDM.Pedido>()
                   .ForMember(d => d.Id, o => o.MapFrom(s => s.Codigo))
                   .ForMember(d=> d.ClienteId,o => o.MapFrom(s=> s.CodigoCliente))
                ;

            });
        }

        public Pedido Obtener(int Codigo)
        {
            InitializeMap();
            var _pedido = db.Pedidos.Find(Codigo);
            var _data = Mapper.Map<Pedido>(_pedido);
            return _data;
        }

        public int Registrar(Pedido Data) {
            InitializeMap();
            var _data = Mapper.Map<EDM.Pedido>(Data);

            db.Pedidos.Add(_data);

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
            var _data = db.Pedidos.Include("Detalle").Include("Cliente").ToList();
            _data.ForEach(e => { _result.Add(Mapper.Map<Pedido>(e)); });
            return _result;
        }
    }
}
