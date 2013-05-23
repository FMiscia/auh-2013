package auh.helper;

import android.app.Application;
import auh.domain.Comment;
import auh.domain.Rfc;
import auh.domain.User;

import java.util.Calendar;

/**
 * Created by francesco on 23/05/13.
 */
public class NativeApp extends Application{

        private static NativeApp instance = null;


        private NativeApp(){
                this.initializeData();
        }

        private void initializeData(){


                User francesco = new User("Francesco","Mente brillante. In questo momento sta partecipando all'AUHackathon");
                francesco.addSkill(Skill.INFORMATICA,50);
                francesco.addSkill(Skill.MATEMATICA,30);
                francesco.addSkill(Skill.SOCIOLOGIA,28);
                francesco.addSkill(Skill.MEDICINA,18);

                User daniele = new User("Daniele","Un super nerd, amante della linea di comando e soprattutto di Nano e non Vim");
                daniele.addSkill(Skill.INFORMATICA,85);
                daniele.addSkill(Skill.MATEMATICA,20);
                daniele.addSkill(Skill.ECONOMIA,23);
                francesco.addSkill(Skill.PSICOLOGIA,19);

                User genni = new User("Genni","Morosa di Daniele,studentessa di Medicina");
                genni.addSkill(Skill.MEDICINA,88);
                genni.addSkill(Skill.INFORMATICA,18);
                genni.addSkill(Skill.PSICOLOGIA,25);
                genni.addSkill(Skill.SOCIOLOGIA,10);

                User francesca = new User("Francesca","Morosa di Francesco (il genio brillante), studentessa in biotecnologie");
                francesca.addSkill(Skill.ECONOMIA,38);
                francesca.addSkill(Skill.MEDICINA,50);
                francesca.addSkill(Skill.ARCHITETTURA,70);
                francesca.addSkill(Skill.PSICOLOGIA,47);
                francesca.addSkill(Skill.SOCIOLOGIA,34);

                User giuseppe = new User("Giuseppe","Insegnante all'istituto tecnico industriale di L'Aquila, ingegnere civile.");
                giuseppe.addSkill(Skill.ARCHITETTURA,61);
                giuseppe.addSkill(Skill.INGEGNERIA_AMBIENTALE,47);
                giuseppe.addSkill(Skill.INGEGNERIA_CIVILE,90);
                giuseppe.addSkill(Skill.ECONOMIA,63);
                giuseppe.addSkill(Skill.INFORMATICA,25);

                francesco.addSkillGiver(daniele,genni,giuseppe);
                daniele.addSkillGiver(francesco,giuseppe);
                genni.addSkillGiver(francesca,francesco);
                francesca.addSkillGiver(genni,daniele,francesco,giuseppe);
                giuseppe.addSkillGiver(daniele,genni,francesco);

                Rfc piscina = new Rfc();
                piscina.setContent("Sed sed accumsan urna. Mauris dolor odio, convallis sit amet eleifend ac, pellentesque sit amet neque. " +
                        "Aliquam aliquet orci rhoncus lorem ultrices ut semper nibh fermentum. Aliquam erat volutpat. " +
                        "Nam urna velit, varius at sollicitudin eu, luctus nec neque. Curabitur interdum nibh quis nisl rhoncus " +
                        "sit amet venenatis velit condimentum. Aenean eros dolor, ornare consequat dignissim tincidunt, vulputate non quam.");
                piscina.setTitle("Proposta costruzione piscina comunale");
                Calendar cal = Calendar.getInstance();
                cal.set(2012,10,10);
                piscina.setStart(cal);
                cal.set(2013,9,11);
                piscina.setEnd(cal);
                piscina.addTopic(Topic.ATTIVITA_SOCIALI,Topic.LAVORO,Topic.URBANISTICA,Topic.SPORT);
                piscina.addComment(new Comment(giuseppe,"bell'iniziativa"));


        }

        public static NativeApp getInstance(){
                if(NativeApp.instance==null)
                        NativeApp.instance = new NativeApp();

                return NativeApp.instance;
        }

}
