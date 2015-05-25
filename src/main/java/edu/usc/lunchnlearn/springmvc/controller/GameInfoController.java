package edu.usc.lunchnlearn.springmvc.controller;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import edu.usc.lunchnlearn.springmvc.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wfleming on 5/23/15.
 */

@Controller
public class GameInfoController {
    private static final String GAME_INFO_PAGE = "gameInfo";

    @Autowired
    private GameService gameService;


    @RequestMapping(value = "/gameinfo/{id}/")
    public String getGameInfo(@PathVariable("id") Long id, ModelMap modelMap) {
        Game game = gameService.findOne(id);

        modelMap.addAttribute("game", game);

        return GAME_INFO_PAGE;
    }

}
