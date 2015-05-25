package edu.usc.lunchnlearn.springmvc.service.db;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import edu.usc.lunchnlearn.springmvc.service.GameService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void testFindAll() {
        assertNotNull(gameService);
        List<Game> findAll = gameService.findAll();
        assertEquals(6, findAll.size());
    }





    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
