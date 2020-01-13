package genospace.controllers;

import genospace.daos.GenoSpaceDao;
import genospace.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class GenoSpaceController {

    @Autowired
    GenoSpaceDao genoSpaceDao;

    @GetMapping("/find")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<Object> findByName(@RequestParam String name) {
        return genoSpaceDao.findByName(name);
    }

    @GetMapping("/find/drug/{drugId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public Drug findDrugById(@PathVariable("drugId") String id) {
        return genoSpaceDao.findDrugById(Integer.parseInt(id));
    }

    @GetMapping("/find/mechanism/{mechanismId}")
    @CrossOrigin(value = "http://localhost:8000", allowCredentials = "true")
    public List<Drug> findAllDrugsForMechanism(@PathVariable("mechanismId") String id) {
        return genoSpaceDao.findDrugForMechanism(Integer.parseInt(id));
    }
}
