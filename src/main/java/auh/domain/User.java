package auh.domain;

import auh.helper.Skill;

import java.util.HashMap;
import java.util.LinkedList;

public class User
{
        private String name;

        private String info;

        private HashMap<String,Integer> skill = new HashMap<String, Integer>();

        private LinkedList<User> skillGiver = new LinkedList<User>();

        public User(String n, String i){
                this.name = n;
                this.info = i;
                for(int j=0; j<Skill.skills.length; j++) {
                        this.skill.put(Skill.skills[j],0);
                }
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

        public HashMap<String, Integer> getSkill() {
                return skill;
        }

        public void setSkill(HashMap<String, Integer> skill) {
                this.skill = skill;
        }

        public Boolean addSkill(String skill, Integer value){
                if(this.skill.containsKey(skill)){
                        this.skill.put(skill,value);
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
}
