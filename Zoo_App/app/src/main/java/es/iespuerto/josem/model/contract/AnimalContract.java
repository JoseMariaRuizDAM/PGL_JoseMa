package es.iespuerto.josem.model.contract;

import android.provider.BaseColumns;

public class AnimalContract {

    public static abstract class AnimalEntry implements BaseColumns {

        public static final String TABLE_NAME ="animal";
        public static final String N_IDENTIFICACION = "numeroIdentificacion";
        public static final String ESPECIE = "especie";
        public static final String SEXO ="sexo";
        public static final String PAIS_ORIGEN= "paisOrigen";
        public static final String CONTINENTE = "continente";
        public static final String ANO_NACIMIENTO = "añoNacimiento";

    }
}
