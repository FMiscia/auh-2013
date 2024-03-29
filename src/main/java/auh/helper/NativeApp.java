package auh.helper;

import android.app.Application;
import auh.domain.Comment;
import auh.domain.Rfc;
import auh.domain.User;
import it.auh.R;

import java.util.ArrayList;
import java.util.Calendar;


public class NativeApp extends Application
{
        private static NativeApp instance = null;

        private ArrayList<User> _users = new ArrayList<User>();
        private ArrayList<Rfc>  _rfcs = new ArrayList<Rfc>();

        private String loggedName;

        private NativeApp(){
                this.initializeData();
        }

        private void initializeData()
        {
                User francesco = new User("fra.miscia@gmail.com","Mente brillante. In questo momento sta partecipando all'AUHackathon","photo");
                francesco.addSkill(Skill.INFORMATICA,50.0);
                francesco.addSkill(Skill.MATEMATICA,30.0);
                francesco.addSkill(Skill.SOCIOLOGIA,28.0);
                francesco.addSkill(Skill.MEDICINA,18.0);

                User daniele = new User("dnlrlnd@gmail.com","Un super nerd, amante della linea di comando e soprattutto di Nano e non Vim","dan");
                daniele.addSkill(Skill.INFORMATICA,85.0);
                daniele.addSkill(Skill.MATEMATICA,20.0);
                daniele.addSkill(Skill.ECONOMIA,23.0);
                francesco.addSkill(Skill.PSICOLOGIA,19.0);

                User genni = new User("Genni","Morosa di Daniele,studentessa di Medicina","genni");
                genni.addSkill(Skill.MEDICINA,88.0);
                genni.addSkill(Skill.INFORMATICA,18.0);
                genni.addSkill(Skill.PSICOLOGIA,25.0);
                genni.addSkill(Skill.SOCIOLOGIA,10.0);

                User francesca = new User("Francesca","Morosa di Francesco (il genio brillante), studentessa in biotecnologie","fra");
                francesca.addSkill(Skill.ECONOMIA,38.0);
                francesca.addSkill(Skill.MEDICINA,50.0);
                francesca.addSkill(Skill.ARCHITETTURA,70.0);
                francesca.addSkill(Skill.PSICOLOGIA,47.0);
                francesca.addSkill(Skill.SOCIOLOGIA,34.0);

                User giuseppe = new User("Giuseppe","Insegnante all'istituto tecnico industriale di L'Aquila, ingegnere civile.","giuseppe");
                giuseppe.addSkill(Skill.ARCHITETTURA,61.0);
                giuseppe.addSkill(Skill.INGEGNERIA_AMBIENTALE,47.0);
                giuseppe.addSkill(Skill.INGEGNERIA_CIVILE,90.0);
                giuseppe.addSkill(Skill.ECONOMIA,63.0);
                giuseppe.addSkill(Skill.INFORMATICA,25.0);

                francesco.addSkillGiver(daniele,genni,giuseppe);
                daniele.addSkillGiver(francesco,giuseppe);
                genni.addSkillGiver(francesca,francesco);
                francesca.addSkillGiver(genni,daniele,francesco,giuseppe);
                giuseppe.addSkillGiver(daniele,genni,francesco);


                this._users.add(francesco);
                this._users.add(francesca);
                this._users.add(daniele);
                this._users.add(genni);
                this._users.add(giuseppe);

                Rfc piscina = new Rfc();
                piscina.setContent(R.drawable.splash_pages_widget);
                piscina.setTitle("Proposta costruzione piscina comunale");
                Calendar cal1 = Calendar.getInstance();
                cal1.set(2012, 10, 10);
                piscina.setStart(cal1);
                cal1.set(2013, 9, 11);
                piscina.setEnd(cal1);
                piscina.addTopic(Topic.ATTIVITA_SOCIALI,Topic.LAVORO,Topic.URBANISTICA,Topic.SPORT);
                piscina.addComment(new Comment(giuseppe,"Proposta 1"));
                piscina.addComment(new Comment(genni,"Proposta 2"));
                piscina.setType(Rfc.RfcType.BOOLEAN);

                Rfc attivita = new Rfc();
                attivita.setContent(R.drawable.splash_pages_marked_widget);
                attivita.setTitle("Contributi per attivita' sportive");
                Calendar cal2 = Calendar.getInstance();
                cal2.set(2012, 10, 10);
                attivita.setStart(cal2);
                cal2.set(2013, 9, 11);
                attivita.setEnd(cal2);
                attivita.addTopic(Topic.ATTIVITA_SOCIALI, Topic.SPORT);
                attivita.addComment(new Comment(giuseppe, "Proposta 1"));
                attivita.addComment(new Comment(daniele, "Proposta 2"));
                attivita.addComment(new Comment(genni,"Proposta 3"));
                attivita.setType(Rfc.RfcType.CHOISE);

                Rfc spese = new Rfc();
                spese.setContent(R.drawable.splash_chart_widget);
                spese.setTitle("Report delle spese");
                Calendar cal3 = Calendar.getInstance();
                cal3.set(2012, 10, 10);
                spese.setStart(cal3);
                cal3.set(2013, 9, 11);
                spese.setEnd(cal3);
                spese.addTopic(Topic.ECONOMIA);
                spese.addComment(new Comment(francesco, "Proposta 1"));
                spese.addComment(new Comment(francesca, "Proposta 2"));
                spese.setType(Rfc.RfcType.SIMPLE);

                Rfc acqua = new Rfc();
                acqua.setContent(R.drawable.splash_pages_widget);
                acqua.setTitle("Avvisso sul servizio idrico.");
                Calendar cal4 = Calendar.getInstance();
                cal4.set(2012, 10, 10);
                acqua.setStart(cal4);
                cal4.set(2013, 9, 11);
                acqua.setEnd(cal4);
                acqua.addTopic(Topic.SALUTE, Topic.URBANISTICA);
                acqua.addComment(new Comment(francesco, "Proposta 1"));
                acqua.addComment(new Comment(francesca, "Proposta 2"));
                acqua.setType(Rfc.RfcType.SIMPLE);

                this._rfcs.add(piscina);
                this._rfcs.add(attivita);
                this._rfcs.add(spese);
                this._rfcs.add(acqua);
        }

        public static NativeApp getInstance(){
                if(NativeApp.instance==null)
                        NativeApp.instance = new NativeApp();

                return NativeApp.instance;
        }

        public
        ArrayList<User> getUsers()
        {
                return this._users;
        }

        public
        ArrayList<Rfc> getRfcs()
        {
                return this._rfcs;
        }

        public void setLoggedName(String name){
                this.loggedName = name;
        }

        public String getLoggedName(){
                return this.loggedName;
        }
}
