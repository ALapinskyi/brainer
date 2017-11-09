package com.boss.brainer.domain.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "active_game")
public class ActiveGame{

    private String _id;

    private List<GameUser> players;

    private GameMode mode;
    private GameType type;

    private String winner;

    private Date pendingTime;
    private String pendingUser;

    private List<Round> rounds;
    //private Round extraRound;

    private Date creationTime;
    private Date lastChangeTime;

}
