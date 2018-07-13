package resource;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/stock")
public class middleResource {

    @Autowired
    RestTemplate restTemplate;

    
    
    

	@GetMapping("/deneme/")
    public String aa() {
    	
    	return "aaa";
    }
    
    
    @GetMapping("/{planeid}")
    public JSONObject getCurrentPos(@PathVariable("planeid") final Integer planeid) {

        ResponseEntity<JSONObject> coordResponse = restTemplate.exchange("http://localhost:8303/rest/db/" + planeid, HttpMethod.GET,
                null, new ParameterizedTypeReference<JSONObject>() {
                });


        JSONObject coords = coordResponse.getBody();
        return coords;
    }

    
//    @GetMapping("/all/{planeid}")
//    public List<List<Double>> getCurrentPos2(@PathVariable("planeid") final Integer planeid) {
//
//        ResponseEntity<List<List<Double>>> coordResponse = restTemplate.exchange("http://db-service/rest/db/" + planeid, HttpMethod.GET,
//                null, new ParameterizedTypeReference<List<List<Double>>>() {
//                });
//
//
//        List<List<Double>> coords = coordResponse.getBody();
//        return coords;
//    }   
    
}