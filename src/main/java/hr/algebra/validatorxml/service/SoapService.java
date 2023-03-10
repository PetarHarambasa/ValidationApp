package hr.algebra.validatorxml.service;

import net.sf.saxon.Configuration;
import net.sf.saxon.s9api.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public class SoapService {
    String outputPath = "output.xml";

    public String generateXMLFileFromXQuery(String xquery) throws SaxonApiException {
        Configuration config = new Configuration();
        Processor processor = new Processor(config);
        XQueryCompiler compiler = processor.newXQueryCompiler();
        XQueryExecutable executable = compiler.compile(xquery);
        XQueryEvaluator evaluator = executable.load();
        StringWriter writer = new StringWriter();
        Serializer serializer = processor.newSerializer((writer));
        evaluator.run(serializer);

        try (OutputStream outputStream = new FileOutputStream((outputPath))) {
            serializer.setOutputStream(outputStream);
            evaluator.run(serializer);
        } catch (Exception e) {
            throw new RuntimeException("Error generating XML from XQuery", e);
        } finally {
            // ignore

            return writer.toString();
        }
    }

    public boolean validateXmlAgainstRngSchema(String xmlFilePath, String rngFilePath) throws IOException, SAXException {
        System.setProperty("javax.xml.validation.SchemaFactory:http://relaxng.org/ns/structure/1.0", "com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(rngFilePath));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new File(xmlFilePath)));
        return true;
    }
}
