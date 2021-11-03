package es.iespuerto.josem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.iespuerto.josem.model.helper.EspecieHelper;
import es.iespuerto.josem.vo.Animal;

public class ModelAnimalUnitTest extends ComunUtilsTest{

    @Test
    public void finfAnimalTest(){
        Animal animalFind = EspecieHelper.getById(animal.getNumeroIdentificacion());
        assertNotNull("El usuario encontrado es null", animalFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",animalFind, animal);
    }

    @Test
    public void finfAnimalesTest(){
        List<Animal> animales = EspecieHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", animales.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",animales.get(0), animal);
    }
}
