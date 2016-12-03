package sigf.beans;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sigf.beans.Cliente;
import sigf.beans.Guiaremision;
import sigf.beans.Miscelaneos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:26:12")
@StaticMetamodel(Comprobantepago.class)
public class Comprobantepago_ { 

    public static volatile SingularAttribute<Comprobantepago, Date> fechahora;
    public static volatile SingularAttribute<Comprobantepago, Cliente> codcliente;
    public static volatile SingularAttribute<Comprobantepago, String> estado;
    public static volatile SingularAttribute<Comprobantepago, BigDecimal> importepagado;
    public static volatile SingularAttribute<Comprobantepago, Miscelaneos> codtipodocumento;
    public static volatile SingularAttribute<Comprobantepago, String> nrocomprobante;
    public static volatile SingularAttribute<Comprobantepago, Miscelaneos> codmoneda;
    public static volatile SingularAttribute<Comprobantepago, BigDecimal> importetotal;
    public static volatile SingularAttribute<Comprobantepago, BigDecimal> importeporpagar;
    public static volatile SingularAttribute<Comprobantepago, Date> fechavencimiento;
    public static volatile SingularAttribute<Comprobantepago, Guiaremision> guiaremision;
    public static volatile SingularAttribute<Comprobantepago, Miscelaneos> codtipopago;

}