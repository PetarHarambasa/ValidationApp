package hr.algebra.validatorxml.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import hr.algebra.validatorxml.model.Creatures;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@Service
public class XmlValidationService {

    public static List<Creatures.Creature> creatureList;

    public void saveEntityXSD(MultipartFile xmlFile) throws IOException, JAXBException, SAXException {
        creatureList = new ArrayList<>();
        File xsdFile = new File("src/main/java/hr/algebra/validatorxml/validation/XMLCreatureValidation.xsd");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsdFile);

        JAXBContext jaxbContext = JAXBContext.newInstance(Creatures.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);
        Creatures entity = (Creatures) unmarshaller.unmarshal(xmlFile.getInputStream());

        System.out.println(entity.getCreature());
        creatureList.addAll(entity.getCreature());

    }

    public void saveEntityRNG(MultipartFile xmlFile) throws IOException, JAXBException, SAXException {
        creatureList = new ArrayList<>();
        JAXBContext jaxbContext = JAXBContext.newInstance(Creatures.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Creatures entity = (Creatures) unmarshaller.unmarshal(xmlFile.getInputStream());

        System.setProperty("javax.xml.validation.SchemaFactory:http://relaxng.org/ns/structure/1.0", "com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory");

        File rngFile = new File("src/main/java/hr/algebra/validatorxml/validation/XMLCreatureValidation.rng");
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
        Schema schema = factory.newSchema(rngFile);
        Validator validator = schema.newValidator();
        validator.validate(new JAXBSource(jaxbContext, entity));

        System.out.println(entity.getCreature());
        creatureList.addAll(entity.getCreature());
    }
}
