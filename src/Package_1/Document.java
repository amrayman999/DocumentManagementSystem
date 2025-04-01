package Package_1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    public String Name;
    public String storagefolderpath;
    private Topic topic;
    public final DateFormat creationDate;
    public List<String> tags;

    public Document(String name, String folderpath, String topicName, int topicId, String creation_date, List<String> tags) {
        this.Name = name;
        this.storagefolderpath = folderpath;
        this.topic = new Topic(topicId, topicName);
        this.creationDate = DateFormat.getDateInstance(DateFormat.SHORT);
        this.tags = new ArrayList<>(tags);
    }

    public String getTopicName() {
        return topic.getName();
    }

    public int getTopicId() {
        return topic.getId();
    }

    public List<String> getTags() {
        return new ArrayList<>(tags);
    }

    public void addTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public abstract void ADD_data();

    public abstract void Edit_data();

    public abstract void Display_data();

    public abstract void Delete();

    private class Topic {
        private int id;
        private String name;

        public Topic(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}