package genospace.daos;

import genospace.models.Drug;

import java.util.List;

public interface GenoSpaceInterface {

    List<Object> findByName(String name);

    Drug findDrugById(Integer id);

    List<Drug> findDrugForMechanism(Integer id);
}
