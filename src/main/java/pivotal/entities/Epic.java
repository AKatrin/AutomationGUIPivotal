package pivotal.entities;

import java.util.List;

public class Epic {
    private String name;
    private String id;
    private String description;
    private String label;
    private List<Follower> followers;
    private List<Story> Stories;

    public Epic() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<Story> getStories() {
        return Stories;
    }

    public void setStories(List<Story> stories) {
        Stories = stories;
    }
}
