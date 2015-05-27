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
package edu.usc.lunchnlearn.springmvc.dao;

import edu.usc.lunchnlearn.springmvc.dao.bean.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wfleming on 5/22/15.
 */
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByGenre_Name(String genreName);

    List<Game> findByStudio_Name(String studioName);

    List<Game> findByPlatform_Name(String platformName);

    List<Game> findByNameContainingOrGenre_NameContainingOrStudio_NameContainingOrPlatform_NameContaining(String name, String genreName, String studioName, String platformName);

}
