package auh.domain;

/**
 * Created by francesco on 23/05/13.
 */
public class Comment {


        private User creator;

        private String content;

        private Integer rank=0;

        public Comment(User u, String c){
                this.creator = u;
                this.content = c;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public User getCreator() {
                return creator;
        }

        public void setCreator(User creator) {
                this.creator = creator;
        }

        public Integer getRank() {
                return rank;
        }

        public void setRank(Integer rank) {
                this.rank = rank;
        }



}
