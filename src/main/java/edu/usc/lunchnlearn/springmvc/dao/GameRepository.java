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

//    List<Game> findAllOrderByNameOrderByNameAsc();

}
