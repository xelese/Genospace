package genospace.controllers;

import genospace.daos.GenoSpaceDao;
import genospace.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents a controller that exposes the api keys that can be hit by the frontend.
 */
@RestController
@CrossOrigin()
public class GenoSpaceController {

    @Autowired
    GenoSpaceDao genoSpaceDao;

    /**
     * This api finds all the drugs and mechanisms by the name (string provided by the user).
     *
     * @param name input given by user for the name of the drug or mechanism.
     * @return the list of drug objects followed by mechanism objects.
     */
    @GetMapping("/find")
    @CrossOrigin(value = "http://genospace.us-east-1.elasticbeanstalk.com/", allowCredentials = "true")
    public List<Object> findByName(@RequestParam String name) {
        return genoSpaceDao.findByName(name);
    }

    /**
     * This api finds the details of the drug.
     *
     * @param id drug id to be searched in the table.
     * @return drug object that has all the details of the drug.
     */
    @GetMapping("/find/drug/{drugId}")
    @CrossOrigin(value = "http://genospace.us-east-1.elasticbeanstalk.com/", allowCredentials = "true")
    public Drug findDrugById(@PathVariable("drugId") String id) {
        return genoSpaceDao.findDrugById(Integer.parseInt(id));
    }

    /**
     * This api finds all the drugs that are related to given mechanism id.
     *
     * @param id id of the mechanism.
     * @return list of all the drugs that are related to given mechanism.
     */
    @GetMapping("/find/mechanism/{mechanismId}")
    @CrossOrigin(value = "http://genospace.us-east-1.elasticbeanstalk.com/", allowCredentials = "true")
    public List<Drug> findAllDrugsForMechanism(@PathVariable("mechanismId") String id) {
        return genoSpaceDao.findDrugForMechanism(Integer.parseInt(id));
    }
}
