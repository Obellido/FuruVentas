namespace upc.edm
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Pedido")]
    public partial class Pedido
    {
        public Pedido()
        {
            Detalle = new HashSet<DetallePedido>();
        }

        [Key]
        public int Id { get; set; }

        public int ClienteId { get; set; }

        public DateTime Fecha { get; set; }

        public double SubTotal { get; set; }

        public double IGV { get; set; }

        public double Total { get; set; }

        public int UsuarioId { get; set; }

        [ForeignKey("ClienteId")]
        public virtual Clientes Clientes { get; set; }
        
        [ForeignKey("UsuarioId")]
        public virtual Usuario Usuario { get; set; }

        public virtual ICollection<DetallePedido> Detalle { get; set; }
    }
}
