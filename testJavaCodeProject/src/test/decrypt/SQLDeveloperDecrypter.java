package test.decrypt;

import java.io.File;
import java.security.GeneralSecurityException;
 
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
 
public class SQLDeveloperDecrypter {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("  Usage 1: " + SQLDeveloperDecrypter.class.getName() + " 0501F83890..... (a single encrypted password)");
            System.err.println("  Usage 2: " + SQLDeveloperDecrypter.class.getName() + " C:\\Users\\...... (the path to the connections.xml file)");
            System.err.println();
            System.err.println("  Pass the password hash code from your connections.xml file. The file might be located at (example)");
            System.err.println("  C:\\Users\\[User]\\AppData\\Roaming\\SQL Developer\\system2.1.1.64.45\\o.jdeveloper.db.connection.11.1.1.2.36.55.30");
 
            System.exit(-1);
        }
 
        if (args[0].startsWith("05")) {
            System.out.println(decryptPassword(args[0]));
        }
        else {
            File file = new File(args[0]);
            if (file.isDirectory())
                file = new File(file, "connections.xml");
 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file.toURI().toString());
 
            // The relevant structure is:
            //
            // <Reference name="connection name">
            //   <RefAddresses>
            //     <StringRefAddr addrType="password">
            //       <Contents>057D3DE2...
 
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//StringRefAddr[@addrType='password']/Contents");
 
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                Element e = (Element) nodes.item(i);
 
                System.out.println("Connection name     : " +
                    ((Element) e.getParentNode().getParentNode().getParentNode()).getAttribute("name")
                );
 
                System.out.println("Password (encrypted): " +
                    e.getTextContent()
                );
 
                System.out.println("Password (decrypted): " +
                    decryptPassword(e.getTextContent())
                );
 
                System.out.println();
            }
        }
    }
 
    // From: http://stackoverflow.com/a/140861
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
 
    // From: http://stackoverflow.com/a/3109774
    public static String decryptPassword(String result) throws GeneralSecurityException {
          return new String(decryptPassword(hexStringToByteArray(result)));
    }
 
    public static byte[] decryptPassword(byte[] result) throws GeneralSecurityException {
        byte constant = result[0];
        if (constant != 5) {
            throw new IllegalArgumentException();
        }
 
        byte[] secretKey = new byte[8];
        System.arraycopy(result, 1, secretKey, 0, 8);
 
        byte[] encryptedPassword = new byte[result.length - 9];
        System.arraycopy(result, 9, encryptedPassword, 0, encryptedPassword.length);
 
        byte[] iv = new byte[8];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = 0;
        }
 
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey, "DES"), new IvParameterSpec(iv));
        return cipher.doFinal(encryptedPassword);
    }
}