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
        
        [OperationContract]
        int GuardarCliente(ClienteContract cliente);

        [OperationContract]
        int ModificarCliente(ClienteContract cliente);

        [OperationContract]
        int EliminarCliente(int codigo);

        [OperationContract]
        ClientePagedContract ListaPagCliente(int pagina);
    }
    
}
