using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace EntityServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IProductoWS" in both code and config file together.
    [ServiceContract]
    public interface IProductoWS
    {
        [OperationContract]
        ProductoContract ObtenerProducto(int codigo);

        [OperationContract]
        int GuardarProducto(ProductoContract cliente);

        [OperationContract]
        int ModificarProducto(ProductoContract cliente);

        [OperationContract]
        int EliminarProducto(int codigo);

        [OperationContract]
        List<ProductoContract> ListaPagProducto(int pagina);

    }
}
