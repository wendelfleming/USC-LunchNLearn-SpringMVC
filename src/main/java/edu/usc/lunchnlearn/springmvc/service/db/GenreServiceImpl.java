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

import edu.usc.lunchnlearn.springmvc.dao.GenreRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Genre;
import edu.usc.lunchnlearn.springmvc.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by wfleming on 5/23/15.
 */
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAllByName() {
        return genreRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public Genre findOne(Long id) {
        return genreRepository.findOne(id);
    }

    @Override
    public void delete(Genre entity) {
        genreRepository.delete(entity);
    }

    @Override
    public void save(Genre entity) {
        genreRepository.save(entity);
    }


    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
}
