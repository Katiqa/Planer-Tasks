package org.example.PlanerTasks.Task;

public class Meeting extends Task {

    protected String topic;
    protected String project;
    protected String start;

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.project = project;
        this.topic = topic;
        this.start = start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}
