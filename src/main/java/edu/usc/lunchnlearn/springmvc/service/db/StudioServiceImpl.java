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

import edu.usc.lunchnlearn.springmvc.dao.StudioRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by wfleming on 5/23/15.
 */
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    @Override
    public List<Studio> findAll() {
        return studioRepository.findAll();
    }

    @Override
    public List<Studio> findAllByName() {
        return studioRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public Studio findOne(Long id) {
        return studioRepository.findOne(id);
    }

    @Override
    public void delete(Studio entity) {
        studioRepository.delete(entity);
    }

    @Override
    public void save(Studio entity) {
        studioRepository.save(entity);
    }

    public void setStudioRepository(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }
}
