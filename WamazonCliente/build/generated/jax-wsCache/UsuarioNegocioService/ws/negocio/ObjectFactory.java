
package ws.negocio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.negocio package. 
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

    private final static QName _RegistraUsuarioResponse_QNAME = new QName("http://negocio/", "registraUsuarioResponse");
    private final static QName _RegistraUsuario_QNAME = new QName("http://negocio/", "registraUsuario");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.negocio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistraUsuarioResponse }
     * 
     */
    public RegistraUsuarioResponse createRegistraUsuarioResponse() {
        return new RegistraUsuarioResponse();
    }

    /**
     * Create an instance of {@link RegistraUsuario }
     * 
     */
    public RegistraUsuario createRegistraUsuario() {
        return new RegistraUsuario();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio/", name = "registraUsuarioResponse")
    public JAXBElement<RegistraUsuarioResponse> createRegistraUsuarioResponse(RegistraUsuarioResponse value) {
        return new JAXBElement<RegistraUsuarioResponse>(_RegistraUsuarioResponse_QNAME, RegistraUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistraUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio/", name = "registraUsuario")
    public JAXBElement<RegistraUsuario> createRegistraUsuario(RegistraUsuario value) {
        return new JAXBElement<RegistraUsuario>(_RegistraUsuario_QNAME, RegistraUsuario.class, null, value);
    }

}
