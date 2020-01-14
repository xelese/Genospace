package genospace.daos;

import genospace.models.Drug;
import genospace.models.Mechanism;
import genospace.repositories.DrugRepository;
import genospace.repositories.MechanismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a data access object that does the actual fetching of the data.
 */
@Component
public class GenoSpaceDao implements GenoSpaceInterface {

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    MechanismRepository mechanismRepository;

    @Override
    public List<Object> findByName(String name) {
        List<Drug> drugs = drugRepository.findByName(name);
        List<Mechanism> mechanisms = mechanismRepository.findByName(name);

        List returnList = new ArrayList();

        returnList.add(drugs);
        returnList.add(mechanisms);

        return returnList;
    }

    @Override
    public Drug findDrugById(Integer id) {
        return drugRepository.findById(id).get();
    }

    @Override
    public List<Drug> findDrugForMechanism(Integer id) {
        return mechanismRepository.findDrugForMechanismById(id);
    }
}
