namespace upc.edm
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class FuruDb : DbContext
    {
        public FuruDb()
            : base("name=FuruDb")
        {
        }

        public virtual DbSet<Clientes> Clientes { get; set; }
        public virtual DbSet<DetallePedido> DetallePedido { get; set; }
        public virtual DbSet<Pedido> Pedido { get; set; }
        public virtual DbSet<Productos> Productos { get; set; }
        public virtual DbSet<Usuario> Usuario { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            
        }
    }
}
