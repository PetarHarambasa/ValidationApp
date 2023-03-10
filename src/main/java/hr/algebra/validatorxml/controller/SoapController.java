package hr.algebra.validatorxml.controller;

import hr.algebra.validatorxml.service.SoapService;
import net.sf.saxon.s9api.SaxonApiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import java.io.IOException;

@Controller
public class SoapController {
    private final SoapService soapService = new SoapService();

    private String newGeneratedXmlFile = "output.xml";
    private String rngFilePath = "src/main/java/hr/algebra/validatorxml/validation/XMLCreatureValidation.rng";

    @GetMapping("/soap")
    public String getSoup() {
        return "soapInterface";
    }


    @PostMapping("/soap")
    public String executeQuerySOAP(@RequestParam("soapQuery") String soapQuery, Model model) {
        model.addAttribute("XMLFile","XML File");
        model.addAttribute("RNGValidation","RNG Validation");
        try {
            model.addAttribute("ReturnResponse", soapService.generateXMLFileFromXQuery(soapQuery));
            soapService.validateXmlAgainstRngSchema(newGeneratedXmlFile, rngFilePath);
            model.addAttribute("XMLValidationRNG", "New Xml file validation successful!");
            return "soapInterface";
        } catch (IOException | SAXException | SaxonApiException e) {
            model.addAttribute("XMLValidationRNG", "New Xml file validation failed!" + e);
            return "soapInterface";
        }

    }
}
