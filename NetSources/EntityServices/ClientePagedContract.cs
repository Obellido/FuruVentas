using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Web;

namespace EntityServices
{
    [ServiceContract]
    public class ClientePagedContract
    {
        public int TotalRecords { get; set; }
        public List<ClienteContract> Records { get; set; }
    }
}