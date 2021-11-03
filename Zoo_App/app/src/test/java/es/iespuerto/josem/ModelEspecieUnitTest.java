package es.iespuerto.josem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import es.iespuerto.josem.model.helper.EspecieHelper;
import es.iespuerto.josem.vo.Especie;

public class ModelEspecieUnitTest extends ComunUtilsTest{

    @Test
    public void finfEspecieTest(){
        Especie especieFind = EspecieHelper.getById(especie.getNombreVulgar());
        assertNotNull("El usuario encontrado es null", especieFind);
        assertEquals("El objeto almacenado y encontrado no son iguales",especieFind, especie);
    }

    @Test
    public void finfEspeciesTest(){
        List<Especie> especies = EspecieHelper.getAll();
        assertNotNull("El numero de usuarios encontrado es menor de 1", especies.size() < 1);
        assertEquals("El objeto almacenado y encontrado no son iguales",especies.get(0), especie);
    }
}
