using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EntityServices
{
    [ServiceContract]
    public interface IPedidoService
    {
        [OperationContract]
        Pedido Obtener(int Codigo);

        [OperationContract]
        int Registrar(Pedido Data);

        [OperationContract]
        List<Pedido> Listar();
    }

    [DataContract]
    public class Pedido {
        [DataMember]
        public int Codigo { get; set; }

        [DataMember]
        public int CodigoCliente { get; set; }

        [DataMember]
        public string NombreCliente { get; set; }

        [DataMember]
        public DateTime Fecha { get; set; }

        [DataMember]
        public double SubTotal { get; set; }

        [DataMember]
        public double IGV { get; set; }

        [DataMember]
        public double Total { get; set; }

        [DataMember]
        public List<DetallePedido> Detalle { get; set; }
    }

    [DataContract]
    public class DetallePedido {
        [DataMember]
        public int CodigoProducto { get; set; }

        [DataMember]
        public string NombreProducto { get; set; }

        [DataMember]
        public int PedidoId { get; set; }

        [DataMember]
        public double PrecioU { get; set; }

        [DataMember]
        public double Cantidad { get; set; }

        [DataMember]
        public double SubTotal { get; set; }
    }
}
