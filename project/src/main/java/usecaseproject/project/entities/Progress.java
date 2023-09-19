package usecaseproject.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Progress {
    @Id
    private long id;

    private long no_of_modulesassigned;
    private String progressPercent;
    private Boolean completed;
    private String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNo_of_modulesassigned() {
        return no_of_modulesassigned;
    }

    public void setNo_of_modulesassigned(long modulesassigned) {
        this.no_of_modulesassigned = modulesassigned;
    }

    public String getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(String progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
