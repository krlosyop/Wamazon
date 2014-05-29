
package ws.productoNegocio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.productoNegocio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BusquedaResponse_QNAME = new QName("http://negocio/", "busquedaResponse");
    private final static QName _Busqueda_QNAME = new QName("http://negocio/", "busqueda");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.productoNegocio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Busqueda }
     * 
     */
    public Busqueda createBusqueda() {
        return new Busqueda();
    }

    /**
     * Create an instance of {@link BusquedaResponse }
     * 
     */
    public BusquedaResponse createBusquedaResponse() {
        return new BusquedaResponse();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio/", name = "busquedaResponse")
    public JAXBElement<BusquedaResponse> createBusquedaResponse(BusquedaResponse value) {
        return new JAXBElement<BusquedaResponse>(_BusquedaResponse_QNAME, BusquedaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Busqueda }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio/", name = "busqueda")
    public JAXBElement<Busqueda> createBusqueda(Busqueda value) {
        return new JAXBElement<Busqueda>(_Busqueda_QNAME, Busqueda.class, null, value);
    }

}
