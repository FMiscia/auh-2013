package auh.helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

        public static HashMap<String,String[]> Topics;

        static {
                Topic.Topics = new HashMap<String,String[]>();
                        Topics.put(Topic.URBANISTICA,new String[]{Skill.ARCHITETTURA,Skill.INGEGNERIA_AMBIENTALE,Skill.INGEGNERIA_CIVILE,Skill.ECONOMIA,Skill.MATEMATICA});
                        Topics.put(Topic.ATTIVITA_SOCIALI,new String[]{Skill.ECONOMIA,Skill.PSICOLOGIA,Skill.SOCIOLOGIA});
                        Topics.put(Topic.SALUTE,new String[]{Skill.SOCIOLOGIA,Skill.PSICOLOGIA,Skill.MEDICINA});
                        Topics.put(Topic.SPORT,new String[]{Skill.MEDICINA,Skill.PSICOLOGIA,Skill.SOCIOLOGIA});
                        Topics.put(Topic.TURISMO,new String[]{Skill.SOCIOLOGIA, Skill.ECONOMIA,Skill.INFORMATICA,Skill.INGEGNERIA_AMBIENTALE});
                        Topics.put(Topic.LAVORO,new String[]{Skill.ECONOMIA,Skill.SOCIOLOGIA,Skill.PSICOLOGIA});
                        Topics.put(Topic.TRASPORTI,new String[]{Skill.ECONOMIA,Skill.INGEGNERIA_AMBIENTALE,Skill.INFORMATICA,Skill.MATEMATICA});
                        Topics.put(Topic.ISTRUZIONE,new String[]{Skill.PSICOLOGIA,Skill.SOCIOLOGIA,Skill.MATEMATICA,Skill.INFORMATICA,Skill.MEDICINA,Skill.ECONOMIA});
                        Topics.put(Topic.TECNOLOGIA,new String[]{Skill.INFORMATICA,Skill.ECONOMIA,Skill.MATEMATICA});

        }
}
