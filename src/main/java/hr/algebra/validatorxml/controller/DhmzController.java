package hr.algebra.validatorxml.controller;

import hr.algebra.validatorxml.service.TemperatureService;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class DhmzController {

    TemperatureService temperatureService = new TemperatureService();

    @GetMapping("/dhmz")
    public String startDhzm() throws XmlRpcException {
        WebServer server = new WebServer(8000);
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();

        phm.addHandler("TemperatureService", TemperatureService.class);
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        return "dhmz";
    }

    @PostMapping("/dhmz")
    public String getTempFromGrad(@RequestParam("city") String city, Model model) {
        if (temperatureService.getTemperature(city).equals("City not found")) {
            model.addAttribute("AdditionMessage", "City not found");
        } else {
            model.addAttribute("AdditionMessage", "The temperature of the city of " + city + " is: ");
            model.addAttribute("Temperature", temperatureService.getTemperature(city) + "°C");
        }
        return "dhmz";
    }
}
