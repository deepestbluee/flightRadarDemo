package doc.umut.database.database.resource;
import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.RestController;

import model.plane;
import model.planes;
import planesRepository.planesRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/rest/db")
public class DatabaseResource {

	private planesRepository planesRepository; 
	
	
	
	public DatabaseResource(planesRepository planesRepository) {
		this.planesRepository = planesRepository;
	}
		
	
	@GetMapping("/{planeid}")
	public JSONObject getCoordinates(@PathVariable("planeid")	 final Integer planeid)
	{
		JSONObject obj = new JSONObject();
		
		obj.put("flights", getPlaneCoordinatesById(planeid));

		return obj;
	}
	
	
	@PostMapping("/add")
	public JSONObject add(@RequestBody final planes planes)
	{
		
		JSONObject obj = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		plane plane = new plane(planes.getPlaneid(),date, planes.getCoords().get(0) ,planes.getCoords().get(1));
		planes.getCoords()
        	.stream();
        
		planesRepository.save(plane);
		obj.put("flights", getPlaneCoordinatesById(planes.getPlaneid()));
		 
		return obj;
		 
	}
	
    @PostMapping("/delete/{planeid}")
    public List<List<Double>> delete(@PathVariable("planeid") final Integer planeid) {

        List<plane> planes = planesRepository.findByPlaneID(planeid);
        planesRepository.deleteAll(planes);

        return getPlaneCoordinatesById(planeid);
    }


    private List<List<Double>> getPlaneCoordinatesById(@PathVariable("planeid") Integer planeid) {
    	List<Double> listx = planesRepository.findByPlaneID(planeid)
                .stream()
                .map(plane::getX)
                .collect(Collectors.toList());
    	
    	List<Double> listy = planesRepository.findByPlaneID(planeid)
                .stream()
                .map(plane::getY)
                .collect(Collectors.toList());
    	
    	
    	List<List<Double>> retList = new ArrayList<List<Double>>();
    	
    	
    	for(int i=0 ; i<listx.size() ; i++) 
    	{
        	List<Double> listz = new ArrayList<Double>();
    		listz.add(listx.get(i));
    		listz.add(listy.get(i));
    		retList.add(listz);
    	}
    	return retList;
    	
    }	
	
	
	
	
	
	
	
	
}
