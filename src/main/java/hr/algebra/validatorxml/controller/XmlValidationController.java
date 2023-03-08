package hr.algebra.validatorxml.controller;

import hr.algebra.validatorxml.model.Creatures;
import hr.algebra.validatorxml.service.XmlValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

import static hr.algebra.validatorxml.service.XmlValidationService.creatureList;


@Controller
public class XmlValidationController {

    private final XmlValidationService xmlValidationService;

    public XmlValidationController(XmlValidationService xmlValidationService) {
        this.xmlValidationService = xmlValidationService;
    }

    @PostMapping("/validateXSD")
    public String saveEntityXSD(@RequestParam("xmlFile") MultipartFile xmlFile, @ModelAttribute Creatures.Creature creature, Model model) {
        try {
            xmlValidationService.saveEntityXSD(xmlFile);
            model.addAttribute("CreatureList", creatureList);
            model.addAttribute("SuccessMassage", "XSD validation successful");
            return "validationPassed";
        } catch (IOException | JAXBException | SAXException e) {
            System.out.println(e.getMessage());
            model.addAttribute("ValidationTypeMassage", "XSD validation failed");
            return "validationFailed";
        }
    }

    @PostMapping("/validateRNG")
    public String saveEntityRNG(@RequestParam("xmlFile") MultipartFile xmlFile, @ModelAttribute Creatures.Creature creature, Model model) {
        try {
            xmlValidationService.saveEntityRNG(xmlFile);
            model.addAttribute("CreatureList", creatureList);
            model.addAttribute("SuccessMassage", "RNG validation successful");
            return "validationPassed";
        } catch (IOException | JAXBException | SAXException e) {
            model.addAttribute("ValidationTypeMassage", "RNG validation failed");
            return "validationFailed";
        }
    }

    @PostMapping("/soap")
    public String executeQuerySOAP(@RequestParam("soapQuery") String inputQuery, Model model) {
        model.addAttribute("ReturnResponse", inputQuery);
        return "soapInterface";
    }
}
