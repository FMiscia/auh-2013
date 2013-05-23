package auh.helper;

/**
 * Created by francesco on 23/05/13.
 */
public class Topic {

        public static final String URBANISTICA = "urbanistica";

        public static final String ATTIVITA_SOCIALI = "attività sociali";

        public static final String SALUTE = "salute";

        public static final String SPORT = "sport";

        public static final String TURISMO = "turismo";

        public static final String LAVORO = "lavoro";

        public static final String TRASPORTI = "trasporti";

        public static final String ISTRUZIONE = "istruzione";

        public static final String TECNOLOGIA = "tecnologia";

        public static final String ECONOMIA = "economia";

        public static String[] Topics;

        static {
                Topic.Topics = new String[]{
                        Topic.URBANISTICA,
                        Topic.ATTIVITA_SOCIALI,
                        Topic.SALUTE,
                        Topic.SPORT,
                        Topic.TURISMO,
                        Topic.LAVORO,
                        Topic.TRASPORTI,
                        Topic.ISTRUZIONE,
                        Topic.TECNOLOGIA
                };
        }
}
