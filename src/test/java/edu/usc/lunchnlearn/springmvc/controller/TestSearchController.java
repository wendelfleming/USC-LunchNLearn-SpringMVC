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
package edu.usc.lunchnlearn.springmvc.controller;

import edu.usc.lunchnlearn.springmvc.dao.bean.Genre;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Created by wfleming on 5/25/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-application-context.xml", "classpath:mvc-example-servlet.xml"})
@WebAppConfiguration
public class TestSearchController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MockHttpSession session;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testSearchForDiablo() throws Exception {
        mockMvc.perform(
                get("/search")
                        .session(session)
                        .param("searchTerm", "Diablo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("searchResults"))
                .andExpect(forwardedUrl("/WEB-INF/pages/searchResults.jsp"))
                .andExpect(model().attribute("searchterm", equalTo("Diablo")))
                .andExpect(model().attribute("searchresult", hasSize(5)))
                .andExpect(model().attribute("searchresult", hasItem(
                                allOf(
                                        hasProperty("name", equalTo("Diablo 3")),
                                        hasProperty("studio", isA(Studio.class)),
                                        hasProperty("studio",
                                                allOf(
                                                        hasProperty("name", equalTo("Blizzard"))
                                                )),
                                        hasProperty("genre", isA(Genre.class)),
                                        hasProperty("genre",
                                                allOf(
                                                        hasProperty("name", equalTo("RPG"))
                                                )),
                                        hasProperty("platform", isA(Platform.class)),
                                        hasProperty("platform",
                                                allOf(
                                                        hasProperty("name", equalTo("PC"))
                                                ))
                                )
                        )
                ))
        ;
    }



    @Test
    public void testSearchGenreForRPG() throws Exception {
        mockMvc.perform(
                get("/search/genre")
                        .session(session)
                        .param("searchTerm","RPG"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("searchResults"))
                .andExpect(forwardedUrl("/WEB-INF/pages/searchResults.jsp"))
                .andExpect(model().attribute("searchterm", equalTo("genre=RPG")))
                .andExpect(model().attribute("searchresult", hasSize(5)))
                .andExpect(model().attribute("searchresult", hasItem(
                                allOf(
                                        hasProperty("name", equalTo("Diablo 3")),
                                        hasProperty("studio", isA(Studio.class)),
                                        hasProperty("studio",
                                                allOf(
                                                        hasProperty("name", equalTo("Blizzard"))
                                                )),
                                        hasProperty("genre", isA(Genre.class)),
                                        hasProperty("genre",
                                                allOf(
                                                        hasProperty("name", equalTo("RPG"))
                                                )),
                                        hasProperty("platform", isA(Platform.class)),
                                        hasProperty("platform",
                                                allOf(
                                                        hasProperty("name", equalTo("PC"))
                                                ))
                                )
                        )
                ))
        ;
    }





}



