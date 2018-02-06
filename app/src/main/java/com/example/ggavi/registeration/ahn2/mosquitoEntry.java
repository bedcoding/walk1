package com.example.ggavi.registeration.ahn2;

public class mosquitoEntry {
    private Long id;
    private String mGrade;
    private String defence_activity;
    private String aggressive_activity;
    private String organization_activity;


    // Setter and Getter for id
    public void setmId(long id) {
        this.id = id;
    }
    public long getmId() {
        return id;
    }

    // Setter and Getter for InputType
    public void setmGrade(String mGrade) {
        this.mGrade = mGrade;
    }
    public String getmGrade() {
       return mGrade;
    }


    // Setter and Getter for Comment
    public void setDefence_activity(String mComment) {
        this.defence_activity = mComment;
    }
    public String getDefence_activity() {
        return defence_activity;
    }

    public void setAggressive_activity(String mComment) {
        this.aggressive_activity = mComment;
    }
    public String getAggressive_activity() {
        return aggressive_activity;
    }
    public void setOrganization_activity(String mComment) {
        this.organization_activity = mComment;
    }
    public String getOrganization_activity() {
        return organization_activity;
    }
}
