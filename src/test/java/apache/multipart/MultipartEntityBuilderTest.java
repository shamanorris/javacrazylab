package apache.multipart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;

public class MultipartEntityBuilderTest {

	public static void main(String args[]){
		String envAttr = "{\n"+
  "\"NOTIFY\": [" +
    "\"/generic-service/batch/updateStatoFatture/envelope/200/636\"" +
  "],"+
  "\"mittente\": \"null\","+
  "\"tipoBusta\": \"HUI_CONS \""+
				"}";
		String envMeta = "{" +
				  "\"ABI\": \"null\","+
				  "\"CANALE\": \"null\","+
				  "\"TIPO_SUPPORTO\": \"null\","+
				  "\"UO\": \"null\""+
				"}";

		String docMeta = "{"+
				"\"dct-extra::url_notifica_conservato\": \"/generic-service/batch/updateStatoFatture/grafometrica/300/636\","+
				"\"dct-meta::cf_cliente\": \"cf_cliente_123\","+
				"\"dct-meta::cf_soc_emittente\": \"cf_soc_emittente_123\","+
				"\"dct-meta::cod_destinatario\": \"cod_destinatario_123\","+
				"\"dct-meta::codice_univoco_sdi\": \"codice_univoco_sdi_123\","+
				"\"dct-meta::data_documento\": \"12/03/2019\","+
				"\"dct-meta::data_ric_sdi\": \"11/03/2019\","+
				"\"dct-meta::nome_allegato\": \"nome_allegato_123\","+
				"\"dct-meta::nota\": \"nota_123\","+
				"\"dct-meta::num_fattura\": \"123999\","+
				"\"dct-meta::numero_pratica\": \"HUIP00099995432120181201\","+
				"\"dct-meta::piva_cliente\": \"piva_cliente_123\","+
				"\"dct-meta::piva_soc_emittente\": \"piva_soc_emittente_123\","+
				"\"dct-meta::rag_soc_cliente\": \"rag_soc_cliente_123\","+
				"\"dct-meta::rag_soc_emittente\": \"rag_soc_emittente_123\","+
				"\"dct-meta::tipo_documento\": \"tipo_documento_123\","+
				"\"dct::cod_documento\": \"ESTTD03000_000\","+
				"\"dct::natural_key_fields\": \"cod_documento,cf_soc_emittente,num_fattura,data_documento,tipo_documento\""+
				"}";

		String docAttr = "{"+
				  "\"estensione\": \"pdf\","+
				  "\"fileToSend\": \"e:\\fatturazione\\work\\1223\\\","+
				  "\"mimeType\": \"application/pdf\","+
				  "\"nomeDocumento\": \"fattura-123.pdf\""+
				"}";
		
		String tipoBusta = "HUI_CONS";
		String uuid = UUID.randomUUID().toString();;
		String idEnvelope = tipoBusta + "-" + uuid;
		String docFileName = "arquivoX";
		String docPath = "C:\\Users\\boca\\Documents\\Developer\\Projects\\git\\java_crazy_lab\\src\\main\\resources\\Declaracao.pdf";
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addPart( "idEnvelope", new StringBody( idEnvelope, ContentType.DEFAULT_TEXT ) );
		builder.addPart( "tipoBusta", new StringBody( tipoBusta, ContentType.DEFAULT_TEXT ) );
		builder.addPart( "env-attr", new ByteArrayBody( envAttr.getBytes(), "env-attr.json" ) );
		builder.addPart( "env-meta", new ByteArrayBody( envMeta.getBytes(), "env-meta.json" ) );
	
		builder.addPart( "doc-attr-" + docFileName, new ByteArrayBody( docAttr.getBytes(), "doc-attr-"
				+ docFileName + ".json" ) );
		builder.addPart( "doc-meta-" + docFileName, new ByteArrayBody( docMeta.getBytes(), "doc-meta-"
				+ docFileName + ".json" ) );
		
		
		InputStream is = null;
		try {
			is = new FileInputStream(docPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		InputStreamBody inputStreamBody = 	new InputStreamBody(is, ContentType.APPLICATION_OCTET_STREAM, docFileName );
		builder.addPart( "doc-content-" + docFileName, inputStreamBody );	
		
		System.out.println(builder.toString());
	}
}
