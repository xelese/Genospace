package genospace;

import genospace.daos.GenoSpaceDao;
import genospace.models.*;
import genospace.repositories.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GenospaceWebApplicationTests {

    @Autowired
    GenoSpaceDao genoSpaceDao;

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    NamesCodeRepository namesCodeRepository;

    @Autowired
    NamesBrandRepository namesBrandRepository;

    @Autowired
    MechanismRepository mechanismRepository;

    @Autowired
    DevelopmentStatusSummaryRepository dssRepository;

    @Autowired
    AdministrationRoutesRepository arRepository;

    @Autowired
    OrganizationsRepository orgRepository;

    @Test
    public void contextLoads() {
    }

    // Generate data.
    @Test
    public void createData() {

        Drug drug1 = new Drug();
        drug1.setId(108485);
        drug1.setNameMain("Temozolomide");

        // name generic
        drug1.setNameGeneric("Temozolomide");

        drugRepository.save(drug1);

        Drug drug = drugRepository.findById(108485).get();

        // namescode
        NamesCode code1 = new NamesCode();
        code1.setName("CCRG-81045");
        code1.setDrugForNameCode(drug);

        NamesCode code2 = new NamesCode();
        code2.setName("M&amp;B-39831");
        code2.setDrugForNameCode(drug);

        NamesCode code3 = new NamesCode();
        code3.setName("NSC-362856");
        code3.setDrugForNameCode(drug);

        NamesCode code4 = new NamesCode();
        code4.setName("Sch-52365");
        code4.setDrugForNameCode(drug);

        namesCodeRepository.save(code1);
        namesCodeRepository.save(code2);
        namesCodeRepository.save(code3);
        namesCodeRepository.save(code4);
        drugRepository.save(drug);

        // namesbrand
        NamesBrand brand1 = new NamesBrand();
        brand1.setName("Temodal");
        brand1.setDrugForNamesBrand(drug);

        NamesBrand brand2 = new NamesBrand();
        brand2.setName("Temodar");
        brand2.setDrugForNamesBrand(drug);

        namesBrandRepository.save(brand1);
        namesBrandRepository.save(brand2);
        drugRepository.save(drug);

        //Mechanism
        Mechanism mechanism1 = new Mechanism();
        mechanism1.setId(4076);
        mechanism1.setDescription("DNA Topoisomerase II alpha Inhibitors");

        mechanismRepository.save(mechanism1);


        Mechanism mechanism2 = new Mechanism();
        mechanism2.setId(1895);
        mechanism2.setDescription("DNA Alkylating Drugs");

        mechanismRepository.save(mechanism2);


        Mechanism mechanism3 = new Mechanism();
        mechanism3.setId(5296);
        mechanism3.setDescription("TEP II Inhibitors");

        mechanismRepository.save(mechanism3);

        mechanism1 = mechanismRepository.findById(4076).get();
        mechanism2 = mechanismRepository.findById(1895).get();
        mechanism3 = mechanismRepository.findById(5296).get();

        drug.setMechanismForDrug(mechanism1);
        drug.setMechanismForDrug(mechanism2);
        drug.setMechanismForDrug(mechanism3);

        drugRepository.save(drug);

        mechanism1.setDrugForMechanism(drug);
        mechanism2.setDrugForMechanism(drug);
        mechanism3.setDrugForMechanism(drug);

        mechanismRepository.save(mechanism1);
        mechanismRepository.save(mechanism2);
        mechanismRepository.save(mechanism3);

        DevelopmentStatusSummary dss1 = new DevelopmentStatusSummary();
        dss1.setDrug(drug);
        dss1.setConditionId(1325);
        dss1.setConditionDescription("Neurologic cancer");
        dss1.setPhaseHighestId(6);
        dss1.setPhaseHighestDescription("Launched");
        dss1.setConditionInActiveDevelopment(false);
        dss1.setYear(2010);

        dssRepository.save(dss1);

        dss1 = dssRepository.findById(1325).get();

        Organizations org = new Organizations();
        org.setId(424);
        org.setDescription("Merck &amp; Co.");

        AdministrationRoutes ar = new AdministrationRoutes();
        ar.setId(48);
        ar.setDevelopmentStatusSummary(dss1);
        ar.setDescription("parenteral");

        orgRepository.save(org);

        org = orgRepository.findById(424).get();

        dss1.setOrgForDSS(org);

        arRepository.save(ar);
        dssRepository.save(dss1);


        DevelopmentStatusSummary dss2 = new DevelopmentStatusSummary();
        dss2.setDrug(drug);
        dss2.setConditionId(582);
        dss2.setConditionDescription("Astrocytoma");
        dss2.setPhaseHighestId(6);
        dss2.setPhaseHighestDescription("Launched");
        dss2.setConditionInActiveDevelopment(false);
        dss2.setYear(1999);

        dssRepository.save(dss2);

        dss2 = dssRepository.findById(582).get();

        dss2.setOrgForDSS(org);

        AdministrationRoutes ar1 = new AdministrationRoutes();
        ar1.setId(3);
        ar1.setDevelopmentStatusSummary(dss2);
        ar1.setDescription("intravenous");

        AdministrationRoutes ar2 = new AdministrationRoutes();
        ar2.setId(1);
        ar2.setDevelopmentStatusSummary(dss2);
        ar2.setDescription("oral");

        arRepository.save(ar1);
        arRepository.save(ar2);
        dssRepository.save(dss2);
    }

    @Test
    public void checkDAO() {
        List<Object> x = genoSpaceDao.findByName("te");
        System.out.println("---------------------------------------");
        for (Object o : x) {
            System.out.println(o.toString());
        }
        System.out.println("---------------------------------------");
        System.out.println("DrugById: " + genoSpaceDao.findDrugById(108485).toString());
        System.out.println("---------------------------------------");
        System.out.println("DrugByIdForMechanisms: " + genoSpaceDao.findDrugForMechanism(5296).toString());
        System.out.println("---------------------------------------");

    }

    @Test
    public void checkDAO2() {

        Drug drug = genoSpaceDao.findDrugById(108485);

        System.out.println(drug.toString());
    }
}
