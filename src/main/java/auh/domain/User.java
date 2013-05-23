package auh.domain;

import java.util.HashMap;

/**
 * Created by francesco on 23/05/13.
 */
public class User {

        private String name;

        private String info;

        private HashMap<String,Integer> skill;

        public User(String n, String i){
                this.name = n;
                this.info = i;
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
}
