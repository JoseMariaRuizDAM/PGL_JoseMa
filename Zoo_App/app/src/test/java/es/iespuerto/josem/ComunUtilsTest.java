package es.iespuerto.josem;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import es.iespuerto.josem.model.helper.AnimalHelper;
import es.iespuerto.josem.model.helper.EspecieHelper;
import es.iespuerto.josem.model.helper.ZooHelper;
import es.iespuerto.josem.vo.Animal;
import es.iespuerto.josem.vo.Especie;
import es.iespuerto.josem.vo.Zoo;

public class ComunUtilsTest {

    static Context appContext = null;
    static Zoo zoo = null;
    static ZooHelper zooHelper;
    static Especie especie = null;
    static EspecieHelper especieHelper;
    static Animal animal = null;
    static AnimalHelper animalHelper;
    @BeforeClassZoo
    public static void beforeClassZoo() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            zooHelper = new ZooHelper(appContext);
            zoo = new Zoo("Loro Parque", "Tenerife", "España", 10000, 50000);
            zooHelper.save(zoo);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }
    @BeforeClassEspecie
    public static void beforeClassEspecie() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            especieHelper = new EspecieHelper(appContext);
            especie = new Especie("León", "Panthera Leo", "Felidae", false);
            especieHelper.save(especie);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }
    @BeforeClassAnimal
    public static void beforeClassAnimal() {
        try {
            appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            animalHelper = new AnimalHelper(appContext);
            animal = new Animal(1, "Felidae", "Masculino", "Mozambique", "Africa", 1999);
            animalHelper.save(animal);
        }catch (Exception ex) {
            fail("Se ha producido un error creando el elemento:"+ex.getMessage());
        }
    }


}
