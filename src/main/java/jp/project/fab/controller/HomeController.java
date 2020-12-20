package jp.project.fab.controller;

import jp.project.fab.model.CityModified;
import jp.project.fab.model.Commandes;
import jp.project.fab.model.Meteo;
import jp.project.fab.model.MeteoModified;
import jp.project.fab.service.CommandeService;
import jp.project.fab.service.EmailService;
import jp.project.fab.service.MeteoService;
import jp.project.fab.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    CommandeService sceCde;
    @Autowired
    EmailService mailService;
    @Autowired
    MeteoService meteoService;

    @Value("${uri_base}")
    private String uri;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/home")
    public ModelAndView init(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fabHome");
        return modelAndView;
    }

    @PostMapping("/saveCommande/{commande}")
    public Object save(@PathVariable String commande){
        List<String> indices = Util.searchIndices(commande);
        if(indices.size()>0){
            sceCde.saveCommande(commande, indices);
            if(indices.indexOf("email")!=-1) return mailService.sendMail();
            if(indices.indexOf("history")!=-1) return getHistory();
            if(indices.indexOf("weather")!=-1) return showMeteo();
        }
        return "Votre commande st irrecevable";
    }

    @GetMapping("/meteo")
    public MeteoModified showMeteo(){
        Meteo meteo = restTemplate.getForObject(uri, Meteo.class);
        MeteoModified meteoM = new MeteoModified();
        meteoM.setCity(Util.transformToCityModified(meteo.getCity()));
        meteoM.setForeCast(Util.transformToCityModified(meteo.getForecast()));
        return meteoM;
    }

    public List<Commandes> getHistory(){
        return sceCde.getCommandes();
    }
}
