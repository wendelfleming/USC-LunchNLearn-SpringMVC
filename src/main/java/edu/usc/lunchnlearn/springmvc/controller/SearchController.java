package edu.usc.lunchnlearn.springmvc.controller;

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
public class SearchController {
    private static final String SEARCH_RESULT_PAGE = "searchResults";

    @Autowired
    private GameService gameService;

    @RequestMapping(value="/search")
    public String search(String searchTerm, ModelMap modelMap) {
        modelMap.addAttribute("searchresult", gameService.search(searchTerm));
        modelMap.addAttribute("searchterm", searchTerm);
        return SEARCH_RESULT_PAGE;
    }


    @RequestMapping(value="/search/{tablename:genre|platform|studio}")
    public String searchByTable(@PathVariable("tablename") String tableName, String searchTerm, ModelMap modelMap) {
        modelMap.addAttribute("searchterm", tableName + "=" + searchTerm);
        switch (tableName) {
            case("genre"):
                modelMap.addAttribute("searchresult", gameService.searchByGenre(searchTerm));
                break;
            case("platform"):
                modelMap.addAttribute("searchresult", gameService.searchByPlatform(searchTerm));
                break;
            default:
                modelMap.addAttribute("searchresult", gameService.searchByStudio(searchTerm));
                break;
        }

        return SEARCH_RESULT_PAGE;
    }


}
