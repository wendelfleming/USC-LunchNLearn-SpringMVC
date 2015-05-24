package edu.usc.lunchnlearn.springmvc.controller;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import edu.usc.lunchnlearn.springmvc.dao.bean.Genre;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;

import edu.usc.lunchnlearn.springmvc.service.GameService;
import edu.usc.lunchnlearn.springmvc.service.GenreService;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import edu.usc.lunchnlearn.springmvc.service.StudioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.beans.PropertyEditorSupport;

/**
 * Created by wfleming on 5/22/15.
 */

@Controller
public class GameDataController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private GameService gameService;


    @RequestMapping(value="/db/game/", method = RequestMethod.GET)
    public String gameList(ModelMap modelMap) {
        Game game = new Game();
        modelMap.put("newGame", game);
        modelMap.put("genres", genreService.findAll());
        modelMap.put("platforms", platformService.findAll());
        modelMap.put("studios", studioService.findAll());
        modelMap.put("games", gameService.findAll());
        return "gamedata";
    }

    @RequestMapping(value="/db/game/", method = RequestMethod.POST)
    public String newGame(@ModelAttribute("newGame") Game game,  ModelMap modelMap) {
        modelMap.put("genres", genreService.findAll());
        modelMap.put("platforms", platformService.findAll());
        modelMap.put("studios", studioService.findAll());

        gameService.save(game);
        modelMap.put("newGame", new Game());

        modelMap.put("games", gameService.findAll());

        return "gamedata";
    }


    @RequestMapping(value="/db/game/delete", method = RequestMethod.POST)
    public String deleteGame(Long gameId,  ModelMap modelMap) {
        modelMap.put("genres", genreService.findAll());
        modelMap.put("platforms", platformService.findAll());
        modelMap.put("studios", studioService.findAll());

        gameService.delete(gameService.findOne(gameId));

        modelMap.put("newGame", new Game());

        modelMap.put("games", gameService.findAll());

        return "redirect:/spring/db/game/";
    }




    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Genre.class, "genre", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue((text.equals(""))?null:genreService.findOne(Long.parseLong((String)text)));
            }
        });
        binder.registerCustomEditor(Platform.class, "platform", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue((text.equals(""))?null:platformService.findOne(Long.parseLong((String) text)));
            }
        });
        binder.registerCustomEditor(Studio.class, "studio", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue((text.equals(""))?null:studioService.findOne(Long.parseLong((String)text)));
            }
        });
    }

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
    }

    public void setStudioService(StudioService studioService) {
        this.studioService = studioService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}

