namespace upc.edm
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Usuario")]
    public partial class Usuario
    {
        public Usuario()
        {
           
        }

        [Key]
        public int Codigo { get; set; }

        public string Alias { get; set; }

        public string Password { get; set; }

        public int Estado { get; set; }

        
    }
}
