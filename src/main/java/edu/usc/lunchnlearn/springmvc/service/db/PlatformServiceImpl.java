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

import edu.usc.lunchnlearn.springmvc.dao.PlatformRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by wfleming on 5/23/15.
 */
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public List<Platform> findAllByName() {
        return platformRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    @Override
    public Platform findOne(Long id) {
        return platformRepository.findOne(id);
    }

    @Override
    public void delete(Platform entity) {
        platformRepository.delete(entity);
    }

    @Override
    public void save(Platform entity) {
        platformRepository.save(entity);
    }


    public void setPlatformRepository(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }
}
