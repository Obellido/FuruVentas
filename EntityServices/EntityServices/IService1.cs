using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace EntityServices
{
    [ServiceContract]
    public interface IClienteWS
    {

        [OperationContract]
        ClienteContract ObtenerCliente(int codigo);

        
    }
    
}
