package auh.domain;

import auh.activity.RfcActivity;

import java.util.*;

public class Rfc
{
        public enum RfcType
        {
                SIMPLE,
                BOOLEAN,
                CHOISE;
        }

        private String title;

        private String content;

        private LinkedList<String> topics = new LinkedList<String>();

        private Calendar start;

        private Calendar end;

        private LinkedList<Comment> comments = new LinkedList<Comment>();

        private RfcType _type;

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

        public RfcType getType()
        {
                return this._type;
        }

        public Rfc setType(RfcType type)
        {
                this._type = type;

                return this;
        }

        public void setEnd(Calendar end) {
                this.end = end;
        }

        public Queue<Comment> getComments() {
                return this.comments;
        }

        public void addComment(Comment comment) {

                if (this.comments.isEmpty()) {
                        this.comments.add(comment);
                } else {
                        for(int i=0; i<this.comments.size(); i++) {
                                if(this.comments.get(i).getRank() < comment.getRank()) {
                                        this.comments.set(i,comment);
                                        break;
                                }
                        }
                }
        }

        public void addTopic(String... topic){
                for (int i = 0; i < topic.length; ++i) {
                        this.topics.add(topic[i]);
                }
        }


}
