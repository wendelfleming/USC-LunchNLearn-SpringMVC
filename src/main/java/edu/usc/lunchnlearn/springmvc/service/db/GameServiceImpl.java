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

