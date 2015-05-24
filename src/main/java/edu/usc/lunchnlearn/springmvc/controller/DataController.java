package edu.usc.lunchnlearn.springmvc.controller;

import edu.usc.lunchnlearn.springmvc.service.GenreService;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wfleming on 5/22/15.
 */

@Controller
public class DataController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StudioService studioService;

    @RequestMapping(value = "/db/{tablename:genre|platform|studio}/", method = RequestMethod.GET)
    public String listData(@PathVariable("tablename")String tableName, ModelMap modelMap) {
        modelMap.addAttribute("pathName", tableName);
        switch (tableName) {
            case("genre"):
                modelMap.addAttribute("dataset", genreService.findAll());
                modelMap.addAttribute("pageName", "Genre");
                return "data";
            case("platform"):
                modelMap.addAttribute("dataset", platformService.findAll());
                modelMap.addAttribute("pageName", "Platform");
                return "data";
            default:
                modelMap.addAttribute("dataset", studioService.findAll());
                modelMap.addAttribute("pageName", "Studio");
                return "data";
        }
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
}
