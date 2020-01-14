package genospace.daos;

import genospace.models.Drug;

import java.util.List;

public interface GenoSpaceInterface {

    /**
     * Finds all the drugs and mechanism that start by this name. E.g. if input is given as "t" it will match all
     * records that start with "t" like Temozolomide, tee from drugs and TEP II Inhibitors from mechanisms.
     *
     * @param name input given by the user.
     * @return list of drugs followed by list of mechanism.
     */
    List<Object> findByName(String name);

    /**
     * Returns the details of the drug by id.
     *
     * @param id drug id.
     * @return the drug with specific id.
     */
    Drug findDrugById(Integer id);

    /**
     * Returns a list of drugs that match a given mechanism.
     *
     * @param id mechanism id.
     * @return list of drugs matching the mechanism id.
     */
    List<Drug> findDrugForMechanism(Integer id);
}
