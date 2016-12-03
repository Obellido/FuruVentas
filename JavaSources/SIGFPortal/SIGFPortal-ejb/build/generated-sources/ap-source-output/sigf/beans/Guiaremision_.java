package sigf.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sigf.beans.Comprobantepago;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:26:12")
@StaticMetamodel(Guiaremision.class)
public class Guiaremision_ { 

    public static volatile SingularAttribute<Guiaremision, Date> fechahora;
    public static volatile SingularAttribute<Guiaremision, String> nroguia;
    public static volatile SingularAttribute<Guiaremision, Integer> cantidadtotal;
    public static volatile SingularAttribute<Guiaremision, Comprobantepago> nrocomprobante;
    public static volatile SingularAttribute<Guiaremision, String> flgEntregado;

}