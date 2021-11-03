package es.iespuerto.josem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.iespuerto.josem.model.helper.ZooHelper;
import es.iespuerto.josem.vo.Zoo;

public class ModelZooUnitTest extends ComunUtilsTest{
    @Test
    public void testFindZooByID(){
        Zoo zooFind = zooHelper.getById(zoo.getNumeroIdentificacion());
        assertNotNull("El usuario encontrado es null", zooFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",zooFind, zoo);
    }

    @Test
    public void testFindAllZoo(){
        List<Zoo> zoos = ZooHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", zoos.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",zoos.get(0), zoo);
    }
}
