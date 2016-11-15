﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EDM
{
    [Table("Productos")]
    public class Producto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Codigo { get; set; }
        
        public string Descripcion { get; set; }
        public int Cantidad { get; set; }
        public decimal PVenta { get; set; }
        public decimal PCompra { get; set; }
        public decimal Medida { get; set; }
        public string Proveedor { get; set; }
        public DateTime FechaCompra { get; set; }
    }
}
