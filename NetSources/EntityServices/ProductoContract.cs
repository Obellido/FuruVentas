using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Web;

namespace EntityServices
{
    [ServiceContract]
    public class ProductoContract
    {
        [DataMember]
        public int Codigo { get; set; }

        [DataMember]
        public string Descripcion { get; set; }

        [DataMember]
        public int Cantidad { get; set; }

        [DataMember]
        public decimal PVenta { get; set; }

        [DataMember]
        public decimal PCompra { get; set; }

        [DataMember]
        public decimal Medida { get; set; }

        [DataMember]
        public string Proveedor { get; set; }

        [DataMember]
        public DateTime FechaCompra { get; set; }


    }
}