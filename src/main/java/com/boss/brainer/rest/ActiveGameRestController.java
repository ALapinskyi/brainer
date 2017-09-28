package com.boss.brainer.rest;

import com.boss.brainer.domain.GameMode;
import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.domain.mongo.GameType;
import com.boss.brainer.domain.mysql.User;
import com.boss.brainer.logic.GameHandler;
import com.boss.brainer.service.ActiveGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Component
@Path("/game")
public class ActiveGameRestController {

    @Autowired
    private GameHandler gameHandler;

    @Autowired
    private ActiveGameService activeGameService;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<BaseActiveGame> findActiveGames() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return activeGameService.findListByUsername(user.getUsername());
    }

    @GET
    @Produces("application/json")
    public ActiveGame findActiveGame(@QueryParam(value="gameId")String id) {
        return activeGameService.findByGameId(id);
    }

    @GET
    @Path("new")
    @Produces("application/json")
    public ActiveGame createNew(@QueryParam(value="mode") String mode) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        NewGameModel newGame = new NewGameModel();
        newGame.setUser(user);
        newGame.setMode(GameMode.getValue(mode));
        newGame.setType(GameType.R5_Q5);

        return gameHandler.createNewGame(newGame);
    }

    @GET
    @Path("new")
    @Produces("application/json")
    public ActiveGame createNextRound(@QueryParam(value="game") String gameId, @QueryParam(value="category") String category) {


        return null;
    }
}