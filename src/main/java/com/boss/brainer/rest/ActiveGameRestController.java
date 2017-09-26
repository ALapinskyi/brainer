package com.boss.brainer.rest;

import com.boss.brainer.domain.mongo.ActiveGame;
import com.boss.brainer.domain.mongo.BaseActiveGame;
import com.boss.brainer.domain.mysql.User;
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
@Path("/games")
public class ActiveGameRestController {

    @Autowired
    private ActiveGameService activeGameService;

    /*public LoginRestController(UserService userService) {
        this.userService = userService;
    }*/

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
}