package com.boss.brainer.domain.mysql;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Friends {

    @EmbeddedId
    private Key key = new Key();

    @ManyToOne
    @MapsId( "userId")
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id")
    private User friendId;

    @Data
    @Embeddable
    public static class Key implements Serializable {
        private Integer userId;
        private Integer friendId;
    }
}
