package auh.domain;

import android.widget.ImageView;
import auh.helper.Skill;

import java.util.HashMap;
import java.util.LinkedList;

public class User
{
        private String name;

        private String photo;

        private String info;

        private HashMap<String,Double> skill = new HashMap<String, Double>();

        private LinkedList<User> skillGiver = new LinkedList<User>();

        public User(String n, String i, String p){
                this.name = n;
                this.info = i;
                for(int j=0; j<Skill.skills.length; j++) {
                        this.skill.put(Skill.skills[j],0.0);
                }
                this.photo = p;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getInfo() {
                return info;
        }

        public void setInfo(String info) {
                this.info = info;
        }

        public HashMap<String, Double> getSkill() {
                return skill;
        }

        public void setSkill(HashMap<String, Double> skill) {
                this.skill = skill;
        }

        public Boolean addSkill(String skill,Double value){
                if(this.skill.containsKey(skill)){
                        Double newValue = this.skill.get(skill) + value;
                        this.skill.put(skill, newValue);
                        return true;
                }
                return false;
        }

        public LinkedList<User> getSkillGiver() {
                return skillGiver;
        }
        
        public void addSkillGiver(User... users){
                for (int i = 0; i < users.length; ++i) {
                        this.skillGiver.add(users[i]);
                }
        }

        public String getPhoto() {
                return photo;
        }

        public void setPhoto(String photo) {
                this.photo = photo;
        }
}
