using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EDM
{
    public class Pedido
    {
        [Key]
        public int Id { get; set; }
        
        public int ClienteId { get; set; }
        public DateTime Fecha { get; set; }

        public double SubTotal { get; set; }
        public double IGV { get; set; }
        public double Total { get; set; }



        [ForeignKey("ClienteId")]
        public virtual Cliente Cliente { get; set; }

        public virtual List<DetallePedido> Detalle { get; set; }

    }


    public class DetallePedido{
        [Key]
        public int Id { get; set; }
        public int ProductoId { get; set; }
        public int PedidoId { get; set; }

        public double PrecioU { get; set; }
        public double Cantidad { get; set; }
        public double SubTotal { get; set; }
        

        [ForeignKey("ProductoId")]
        public virtual Producto Producto { get; set; }

        [ForeignKey("PedidoId")]
        public virtual Pedido Pedido { get; set; }

    }


}
