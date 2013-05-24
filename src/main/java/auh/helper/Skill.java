package auh.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francesco on 23/05/13.
 */
public class Skill {

        public static final String MATEMATICA = "matematica";

        public static final String ECONOMIA = "economia";

        public static final String INFORMATICA = "informatica";

        public static final String INGEGNERIA_CIVILE = "ingegneria civile";

        public static final String INGEGNERIA_AMBIENTALE = "ingegneria ambientale";

        public static final String SOCIOLOGIA = "sociologia";

        public static final String PSICOLOGIA = "psicologia";

        public static final String ARCHITETTURA = "architettura";

        public static final String MEDICINA = "medicina";

        public static String[] skills;

        static {
                Skill.skills = new String[]{
                        Skill.MATEMATICA,
                        Skill.ECONOMIA,
                        Skill.INFORMATICA,
                        Skill.INGEGNERIA_CIVILE,
                        Skill.INGEGNERIA_AMBIENTALE,
                        Skill.SOCIOLOGIA,
                        Skill.PSICOLOGIA,
                        Skill.ARCHITETTURA,
                        Skill.MEDICINA
                };
        }

        public static double getWeightedScore(Integer skillValue){
                return (1-(1/(Math.pow(skillValue.doubleValue(),0.5))));
        }


}
