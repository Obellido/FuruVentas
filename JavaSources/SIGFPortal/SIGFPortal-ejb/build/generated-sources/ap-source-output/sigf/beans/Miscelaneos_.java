package sigf.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sigf.beans.Comprobantepago;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T17:26:12")
@StaticMetamodel(Miscelaneos.class)
public class Miscelaneos_ { 

    public static volatile SingularAttribute<Miscelaneos, String> descelemento;
    public static volatile SingularAttribute<Miscelaneos, String> estado;
    public static volatile SingularAttribute<Miscelaneos, String> codproceso;
    public static volatile CollectionAttribute<Miscelaneos, Comprobantepago> comprobantepagoCollection1;
    public static volatile CollectionAttribute<Miscelaneos, Comprobantepago> comprobantepagoCollection2;
    public static volatile CollectionAttribute<Miscelaneos, Comprobantepago> comprobantepagoCollection;
    public static volatile SingularAttribute<Miscelaneos, String> codelemento;

}