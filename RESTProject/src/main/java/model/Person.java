package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("fullName")
    public String fullName;



    //public Object id;
   // public Object name;


    public Person() {
    }


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName;}

    public void setFullName(Object name) { this.fullName = fullName;}
}
