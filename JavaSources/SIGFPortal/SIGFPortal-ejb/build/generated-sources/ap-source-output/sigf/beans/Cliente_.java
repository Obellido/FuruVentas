package sigf.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sigf.beans.Comprobantepago;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:26:12")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> ruc;
    public static volatile SingularAttribute<Cliente, String> razonsocial;
    public static volatile CollectionAttribute<Cliente, Comprobantepago> comprobantepagoCollection;

}