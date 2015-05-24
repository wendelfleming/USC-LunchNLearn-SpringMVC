package edu.usc.lunchnlearn.springmvc.service;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;

import java.util.List;


/**
 * Created by wfleming on 5/23/15.
 */

public interface GameService extends TableService<Game, Long> {

    List<Game> search(String param);

    List<Game> searchByGenre(String genreName);

    List<Game> searchByStudio(String studioName);

    List<Game> searchByPlatform(String platformName);
}
