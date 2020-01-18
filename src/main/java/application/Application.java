package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);
  private String[] handlebarsTypes;
  private String[] availableMaterials;
  private String[] availableCircuits;
  private String[] availableHandles;
  private String selectedHandlebarsType;
  private String selectedMaterial;
  private String selectedCircuit;
  private String selectedHandle;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @RequestMapping("/")
  public String index() {
    return "index.html";
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner getHandlebarsTypes(RestTemplate restTemplate) throws Exception { //Zugriff auf GET-Methode für die Lenkertypen
    return args -> {
      String[] handlebarsTypes = restTemplate.getForObject(
              "https://www.maripavi.at/produkt/lenkertyp", String[].class);
      this.handlebarsTypes = handlebarsTypes; //Die drei Lenkertypen sind jetzt in dem Array HandlebarsTypes gespeichert -> Auswahlmöglichkeiten für Dropdown-Menü
      log.info("Lenkertypen geladen.");
    };
  }

  //TODO: Lenkertyp, der im Dropdown-Menü ausgewählt wurde unter selectedHandlebarsType speichern.

  @Bean
  public CommandLineRunner getAvailableMaterials(RestTemplate restTemplate) throws Exception { //Zugriff auf GET-Methode für die Materialien, abhängig vom gewünschten Lenkertyp
    return args -> {
      String[] materials = restTemplate.getForObject(
              "https://www.maripavi.at/produkt/material?lenkertyp="+selectedHandlebarsType, String[].class);
      this.availableMaterials = materials; //Die verfügbaren Materialien sind jetzt im Array availableMaterials gespeichert -> Auswahlmöglichkeit für Dropdown-Menü
      log.info("Verfügbare Materialien geladen.");
      for (String s : materials) {
        System.out.println(s);
      }
    };
  }

  //TODO: Material, das im Dropdown-Menü ausgewählt wurde unter selectedMaterial speichern.

  @Bean
  public CommandLineRunner getAvailableCircuits(RestTemplate restTemplate) throws Exception { //Zugriff auf GET-Methode für die Schaltungen, abhängig vom gewünschten Lenkertyp
    return args -> {
      String[] circuits = restTemplate.getForObject(
              "https://www.maripavi.at/produkt/schaltung?lenkertyp="+selectedHandlebarsType, String[].class);
      this.availableCircuits = circuits; //Die verfügbaren Schaltungen sind jetzt im Array availableCircuits gespeichert -> Auswahlmöglichkeit für Dropdown-Menü
      log.info("Verfügbare Schaltungen geladen.");
      for (String s : circuits) {
        System.out.println(s);
      }
    };
  }

  //TODO: Die Schaltung, die im Dropdown-Menü ausgewählt wurde unter selectedCircuit speichern.

  @Bean
  public CommandLineRunner getAvailableHandles(RestTemplate restTemplate) throws Exception { //Zugriff auf GET-Methode für die Griffe, abhängig vom gewünschten Material
    return args -> {
      String[] handles = restTemplate.getForObject(
              "https://www.maripavi.at/produkt/griff?material="+selectedMaterial, String[].class);
      this.availableHandles = handles; //Die verfügbaren Griffe sind jetzt im Array availableHandles gespeichert -> Auswahlmöglichkeit für Dropdown-Menü
      log.info("Verfügbare Schaltungen geladen.");
      for (String s : handles) {
        System.out.println(s);
      }
    };
  }

  //TODO: Der Griff, der im Dropdown-Menü ausgewählt wurde unter selectedHandle speichern.

  //TODO: Zugriff auf Post-Methode für die Bestellung mit den gesammelten Daten (Lenkertyp, Material, etc.)


}