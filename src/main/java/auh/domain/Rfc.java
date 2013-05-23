package auh.domain;

import java.util.*;

/**
 * Created by francesco on 23/05/13.
 */
public class Rfc {

        private String title;

        private String content;

        private LinkedList<String> topics;

        private Calendar start;

        private Calendar end;

        private LinkedList<Comment> comments;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public LinkedList<String> getTopic() {
                return topics;
        }

        public Calendar getStart() {
                return start;
        }

        public void setStart(Calendar start) {
                this.start = start;
        }

        public Calendar getEnd() {
                return end;
        }

        public void setEnd(Calendar end) {
                this.end = end;
        }

        public Queue<Comment> getComments() {
                return this.comments;
        }

        public void addComment(Comment comment) {
                ListIterator<Comment> it = this.comments.listIterator();
                if(this.comments.getFirst().getRank()<comment.getRank())
                        this.comments.addFirst(comment);
                else{
                        for(int i=0; i<this.comments.size(); i++)
                                if(this.comments.get(i).getRank()<comment.getRank())
                                        this.comments.set(i,comment);
                }
        }

        public void addTopic(String ...topic){
                for(String t: topics)
                        this.topics.add(t);
        }


}
