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
package edu.usc.lunchnlearn.springmvc.service.db;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import edu.usc.lunchnlearn.springmvc.dao.bean.Genre;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;
import edu.usc.lunchnlearn.springmvc.service.GameService;
import edu.usc.lunchnlearn.springmvc.service.GenreService;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by wfleming on 5/25/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test-application-context.xml"})
@EnableJpaRepositories(basePackages = "edu.usc.lunchnlearn.springmvc.dao")
public class HamcrestTestGameServiceImpl {

    @Autowired
    private GameService gameService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StudioService studioService;

    @Test
    public void testFindAll() {
        assertThat(gameService, notNullValue());
        List<Game> findAll = gameService.findAll();
        assertThat(6, is(findAll.size()));
        assertThat("", findAll.get(0).getName(), is("World of Warcraft"));
        assertThat(findAll, hasItem(
                allOf(
                        hasProperty("name", equalTo("World of Warcraft")),
                        hasProperty("studio", isA(Studio.class)),
                        hasProperty("studio",
                                allOf(
                                        hasProperty("name", equalTo("Blizzard"))
                                )),
                        hasProperty("genre", isA(Genre.class)),
                        hasProperty("genre",
                                allOf(
                                        hasProperty("name", equalTo("MMORPG"))
                                )),
                        hasProperty("platform", isA(Platform.class)),
                        hasProperty("platform",
                                allOf(
                                        hasProperty("name", equalTo("PC"))
                                ))
                )
        ));
    }









    public void setGameService(GameService gameService) {
        this.gameService = gameService;
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
