package com.shhrrtnvr.restest.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "post")
    private JSONObject post;

    public Post(JSONObject post) {
        this.uuid = UUID.randomUUID();
        this.post = post;
    }
    public JSONObject jsn() {
        return this.post;
    }
}
