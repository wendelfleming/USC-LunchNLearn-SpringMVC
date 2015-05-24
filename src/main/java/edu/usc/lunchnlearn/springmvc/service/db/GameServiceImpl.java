package edu.usc.lunchnlearn.springmvc.service.db;

import edu.usc.lunchnlearn.springmvc.dao.GameRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import edu.usc.lunchnlearn.springmvc.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by wfleming on 5/23/15.
 */

public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findAllByName() {
        return gameRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public Game findOne(Long id) {
        return gameRepository.findOne(id);
    }

    @Override
    public void delete(Game entity) {
        gameRepository.delete(entity);
    }

    @Override
    public void save(Game entity) {
        gameRepository.save(entity);
    }

    @Override
    public List<Game> search(String param) {
        return gameRepository.findByNameContainingOrGenre_NameContainingOrStudio_NameContainingOrPlatform_NameContaining(param, param, param, param);
    }

    @Override
    public List<Game> searchByGenre(String genreName) {
        return gameRepository.findByGenre_Name(genreName);
    }

    @Override
    public List<Game> searchByStudio(String studioName) {
        return gameRepository.findByStudio_Name(studioName);
    }

    @Override
    public List<Game> searchByPlatform(String platformName) {
        return gameRepository.findByPlatform_Name(platformName);
    }



    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


}

