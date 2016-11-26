package sigf.beans;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sigf.beans.Comprobantepago;
import sigf.beans.ComprobantepagoDetallePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-26T13:45:45")
@StaticMetamodel(ComprobantepagoDetalle.class)
public class ComprobantepagoDetalle_ { 

    public static volatile SingularAttribute<ComprobantepagoDetalle, String> unidad;
    public static volatile SingularAttribute<ComprobantepagoDetalle, BigDecimal> impuesto;
    public static volatile SingularAttribute<ComprobantepagoDetalle, BigDecimal> preciobase;
    public static volatile SingularAttribute<ComprobantepagoDetalle, BigDecimal> descuento;
    public static volatile SingularAttribute<ComprobantepagoDetalle, String> codprod;
    public static volatile SingularAttribute<ComprobantepagoDetalle, Integer> cantidad;
    public static volatile SingularAttribute<ComprobantepagoDetalle, ComprobantepagoDetallePK> tbComprobantepagoDetallePK;
    public static volatile SingularAttribute<ComprobantepagoDetalle, BigDecimal> precioneto;
    public static volatile SingularAttribute<ComprobantepagoDetalle, Comprobantepago> tbComprobantepago;

}