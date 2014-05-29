
package sesion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sesion package. 
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

    private final static QName _GetLoginResponse_QNAME = new QName("http://sesion/", "getLoginResponse");
    private final static QName _GetLogin_QNAME = new QName("http://sesion/", "getLogin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLogin }
     * 
     */
    public GetLogin createGetLogin() {
        return new GetLogin();
    }

    /**
     * Create an instance of {@link GetLoginResponse }
     * 
     */
    public GetLoginResponse createGetLoginResponse() {
        return new GetLoginResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion/", name = "getLoginResponse")
    public JAXBElement<GetLoginResponse> createGetLoginResponse(GetLoginResponse value) {
        return new JAXBElement<GetLoginResponse>(_GetLoginResponse_QNAME, GetLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sesion/", name = "getLogin")
    public JAXBElement<GetLogin> createGetLogin(GetLogin value) {
        return new JAXBElement<GetLogin>(_GetLogin_QNAME, GetLogin.class, null, value);
    }

}
