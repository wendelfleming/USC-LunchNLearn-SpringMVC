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

import edu.usc.lunchnlearn.springmvc.dao.bean.Genre;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;

import edu.usc.lunchnlearn.springmvc.service.GenreService;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wfleming on 5/22/15.
 */

@RestController
public class DataAdminController {

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StudioService studioService;

    @RequestMapping(value = "/db/{tablename:genre|platform|studio}/admin/list", method = RequestMethod.GET, headers = "Accept=application/json")
    public List listData(@PathVariable("tablename") String tableName) {
        switch (tableName) {
            case ("genre"):
                return genreService.findAllByName();
            case ("platform"):
                return platformService.findAllByName();
            default:
                return studioService.findAllByName();
        }
    }


    @RequestMapping(value = "/db/{tablename:genre|platform|studio}/admin/delete/{dataId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Map<String, String> deleteData(@PathVariable("tablename") String tableName, @PathVariable("dataId") Long dataId) {
        Map<String, String> returnMap = new HashMap<String, String>();
        switch (tableName) {
            case ("genre"):
                genreService.delete(genreService.findOne(dataId));
                if (genreService.findOne(dataId) == null) {
                    returnMap.put("status", "deleted");
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("message", "Genre was not deleted.");
                }
                break;
            case ("platform"):
                platformService.delete(platformService.findOne(dataId));
                if (platformService.findOne(dataId) == null) {
                    returnMap.put("status", "deleted");
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("message", "Platform was not deleted.");
                }
                break;
            default:
                studioService.delete(studioService.findOne(dataId));
                if (studioService.findOne(dataId) == null) {
                    returnMap.put("status", "deleted");
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("message", "Studio was not deleted.");
                }
                break;
        }

        return returnMap;
    }


    @RequestMapping(value = "/db/{tablename:genre|platform|studio}/admin/add", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Map addData(@PathVariable("tablename") String tableName, String name) {
        Map returnMap = new HashMap();

        switch (tableName) {
            case ("genre"):
                Genre genre = new Genre();
                genre.setName(name);
                genreService.save(genre);
                if (genreService.findOne(genre.getId()) != null) {
                    returnMap.put("status", "added");
                    returnMap.put("data", genre);
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("data", genre);
                }
                break;
            case ("platform"):
                Platform platform = new Platform();
                platform.setName(name);
                platformService.save(platform);
                if (platformService.findOne(platform.getId()) != null) {
                    returnMap.put("status", "added");
                    returnMap.put("data", platform);
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("data", platform);
                }
                break;
            default:
                Studio studio = new Studio();
                studio.setName(name);
                studioService.save(studio);
                if (studioService.findOne(studio.getId()) != null) {
                    returnMap.put("status", "added");
                    returnMap.put("data", studio);
                } else {
                    returnMap.put("status", "error");
                    returnMap.put("data", studio);
                }
                break;
        }

        return returnMap;
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

