package genospace.repositories;

import genospace.models.Mechanism;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MechanismRepository extends CrudRepository<Mechanism, Integer> {

    @Query("select m from Mechanism m where m.name like :name%")
    List<Mechanism> findByName(@Param("name") String name);
}
