package genospace.repositories;

import genospace.models.Drug;
import genospace.models.MechanismsMolecular;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MechanismMolecularRepository extends CrudRepository<MechanismsMolecular, Integer> {

    @Query("select m.drug from MechanismsMolecular m where m.mechanism.id =:id")
    List<Drug> findDrugForMechanismById(@Param("id") Integer id);

}
