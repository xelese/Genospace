package genospace.repositories;

import genospace.models.Drug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends CrudRepository<Drug, Integer> {

    @Query("select d from Drug d where d.nameMain like :name%")
    List<Drug> findByName(@Param("name") String name);
}