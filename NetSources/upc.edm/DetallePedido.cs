namespace upc.edm
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("DetallePedido")]
    public partial class DetallePedido
    {
        [Key]
        public int Id { get; set; }

        public int ProductoId { get; set; }

        public int PedidoId { get; set; }

        public double PrecioU { get; set; }

        public double Cantidad { get; set; }

        public double SubTotal { get; set; }

        [ForeignKey("PedidoId")]
        public virtual Pedido Pedido { get; set; }

        [ForeignKey("ProductoId")]
        public virtual Productos Producto { get; set; }
    }
}
