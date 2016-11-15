using EDM;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace EntityServices
{
    [DataContract]
    public class ClienteContract
    {
        [DataMember]
        public int Codigo { get; set; }

        [DataMember]
        public int TipoCliente { get; set; }

        [DataMember]
        public string Nombres { get; set; }

        [DataMember]
        public string Apellidos { get; set; }

        [DataMember]
        public string RazonSocial { get; set; }

        [DataMember]
        public string DNI { get; set; }

        [DataMember]
        public string Direccion { get; set; }

        [DataMember]
        public string Telefono { get; set; }

        [DataMember]
        public string Email { get; set; }
    }
}
