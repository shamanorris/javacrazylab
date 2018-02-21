package test.jaxb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

public class TestObject {
	public static void main(String[] args) {
		
		DataEsecuzione dataEsecuzione = new DataEsecuzione();
		  dataEsecuzione.setTime(Long.toString(GregorianCalendar.getInstance().getTimeInMillis()));
		  dataEsecuzione.setTimezone("");
		
		List<Proprieta> proprieta = new ArrayList<Proprieta>();
		  
		Contesto contesto = new Contesto();
		  contesto.setGuid(java.util.UUID.randomUUID().toString());
		  contesto.setAbi("3000");
		  contesto.setMatricola("U821711");
		  contesto.setCodRichiedente("NORM");
		  contesto.setDataEsecuzione(dataEsecuzione);
		  contesto.setPuntoOperativo("962");

		for (int i = 0; i < 26; i++){
			Proprieta proprietaSingolo = new Proprieta();
			proprietaSingolo.setNome(Integer.toString(i));
			proprietaSingolo.setValore(Integer.toString(i));
			proprietaSingolo.setTipo(Integer.toString(i));
			proprieta.add(proprietaSingolo);
		}		
		
		Documento documento = new Documento();
		   documento.setCodDocumento("randomvalue");
		   List<Proprieta> proprieta2 = new ArrayList<Proprieta>();
		   proprieta2.add(new Proprieta("descrizione", "281", "String"));
		   proprieta2.add(new Proprieta("flagprincipale", "abc", "String"));
		   proprieta2.add(new Proprieta("tipoDocumento", "Principale", "String"));
		   documento.setProprieta(proprieta2);
		   documento.setAutore("abbb");
		   documento.setType("pdf");
		   documento.setUrl("www.url.com");
		List<Documento> documenti = new ArrayList<Documento>();
		documenti.add(documento);
		
		  NormativaRequest request = new NormativaRequest();
		  request.setContesto(contesto);
		  request.setProprieta(proprieta);
		  request.setDocumento(documenti);
		  try {
			  
	        JAXBContext jc = JAXBContext.newInstance(Customer.class);
	        
	        String xmlText =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><customer><firstName>Jane</firstName><lastName>Doe</lastName><phoneNumbers><number>555-1111</number><type>work</type></phoneNumbers><phoneNumbers><number>555-2222</number><type>home</type></phoneNumbers></customer>"; 
	        InputStream stream = new ByteArrayInputStream(xmlText.getBytes("UTF-8"));
	        StreamSource xml = new StreamSource(stream);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        JAXBElement<Customer> je1 = unmarshaller.unmarshal(xml, Customer.class);
	        Customer customer = je1.getValue();
	 
	        JAXBElement<Customer> je2 = new JAXBElement<Customer>(new QName("customer"), Customer.class, customer);
	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(je2, System.out);
			/*
			File file = new File("E:\\test.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(NormativaRequest.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(request, file);
			jaxbMarshaller.marshal(request, System.out);
*/
		      } catch (JAXBException e) {
			e.printStackTrace();
		      } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
