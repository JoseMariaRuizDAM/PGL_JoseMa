package es.iespuerto.josem.model.contract;

import android.provider.BaseColumns;

public class ZooContract {
    public static abstract class ZooEntry implements BaseColumns {

        public static final String TABLE_NAME ="zoo";
        public static final String NOMBRE = "nombreZoo";
        public static final String CIUDAD = "ciudad";
        public static final String PAIS ="pais";
        public static final String TAMANO = "tamano";
        public static final String PRESUPUESTO = "presupuesto";

    }
}
