/**
 * Copyright 2015 wendel fleming
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    @RequestMapping(value = "/search")
    public String search(String searchTerm, ModelMap modelMap) {
        modelMap.addAttribute("searchresult", gameService.search(searchTerm));
        modelMap.addAttribute("searchterm", searchTerm);
        return SEARCH_RESULT_PAGE;
    }


    @RequestMapping(value = "/search/{tablename:genre|platform|studio}")
    public String searchByTable(@PathVariable("tablename") String tableName, String searchTerm, ModelMap modelMap) {
        modelMap.addAttribute("searchterm", tableName + "=" + searchTerm);
        switch (tableName) {
            case ("genre"):
                modelMap.addAttribute("searchresult", gameService.searchByGenre(searchTerm));
                break;
            case ("platform"):
                modelMap.addAttribute("searchresult", gameService.searchByPlatform(searchTerm));
                break;
            default:
                modelMap.addAttribute("searchresult", gameService.searchByStudio(searchTerm));
                break;
        }

        return SEARCH_RESULT_PAGE;
    }


}
