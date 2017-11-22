package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.*;
import com.boss.brainer.domain.NewGameModel;
import com.boss.brainer.domain.mysql.User;
import com.boss.brainer.logic.GameHandler;
import com.boss.brainer.service.ActiveGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<BaseActiveGame> findActiveGames() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return activeGameService.findListByUsername(user.getUsername());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ActiveGame findActiveGame(@QueryParam(value="gameId")String id) {
        return activeGameService.findByGameId(id);
    }

    @GET
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public ActiveGame createNew(@QueryParam(value="mode") String mode) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        NewGameModel newGame = new NewGameModel();
        newGame.setUser(user);
        newGame.setMode(GameMode.getValue(mode));
        newGame.setType(GameType.R5_Q5);

        ActiveGame pendingGame = activeGameService.findPendingGame(newGame);

        if(pendingGame != null){
            gameHandler.populateNextUser(newGame, pendingGame);
            return pendingGame;
        }

        return gameHandler.createNewGame(newGame);
    }

    @POST
    @Path("persistRound")
    @Consumes(MediaType.APPLICATION_JSON)
    public void persistRound(ActiveGame activeGame){
        ActiveGame storedGame = activeGameService.findByGameId(activeGame.get_id());

        storedGame.setRounds(activeGame.getRounds());

        activeGameService.saveOrUpdate(storedGame);
    }

}