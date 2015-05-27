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
import edu.usc.lunchnlearn.springmvc.service.GameService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import edu.usc.lunchnlearn.springmvc.service.GenreService;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wfleming on 5/24/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test-application-context.xml"})
@EnableJpaRepositories(basePackages = "edu.usc.lunchnlearn.springmvc.dao")
public class TestGameServiceImpl {

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
        assertNotNull(gameService);
        List<Game> findAll = gameService.findAll();
        assertEquals(6, findAll.size());
        assertEquals("World of Warcraft", findAll.get(0).getName());
    }

    @Test
    public void testFindAllByName() {
        assertNotNull(gameService);
        List<Game> findAll = gameService.findAllByName();
        assertEquals(6, findAll.size());
        assertEquals("Diablo", findAll.get(0).getName());
    }

    @Test
    public void testFindOne() {
        assertNotNull(gameService);
        Game findOne = gameService.findOne(1L);
        assertEquals("World of Warcraft", findOne.getName());
    }

    @Test
    public void testSaveAndDelete() {
        assertNotNull(gameService);

        Game newAwesomeGame = new Game();
        newAwesomeGame.setName("Everything is Awesome");
        newAwesomeGame.setGenre(genreService.findOne(1l));
        newAwesomeGame.setPlatform(platformService.findOne(1L));
        newAwesomeGame.setStudio(studioService.findOne(1L));

        gameService.save(newAwesomeGame);

        List<Game> findAll = gameService.findAll();
        assertEquals(7, findAll.size());

        assertEquals("World of Warcraft", findAll.get(0).getName());
        assertEquals("Everything is Awesome", findAll.get(6).getName());

        gameService.delete(gameService.findOne(7L));

        List<Game> findAll2 = gameService.findAll();
        assertEquals(6, findAll2.size());
        Game deleted = gameService.findOne(7L);
        assertNull(deleted);
    }

    @Test
    public void testSearch() {
        assertNotNull(gameService);
        List<Game> searchDiablo = gameService.search("Diablo");
        assertEquals(5, searchDiablo.size());
        assertEquals("Diablo 3", searchDiablo.get(0).getName());
        assertEquals("PC", searchDiablo.get(0).getPlatform().getName());
    }

    @Test
    public void testSearchByGenre() {
        assertNotNull(gameService);
        List<Game> searchMMO = gameService.searchByGenre("MMORPG");
        assertEquals(1, searchMMO.size());
        assertEquals("World of Warcraft", searchMMO.get(0).getName());
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
