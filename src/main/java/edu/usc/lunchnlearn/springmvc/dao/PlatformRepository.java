package edu.usc.lunchnlearn.springmvc.dao;

import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wfleming on 5/22/15.
 */
public interface PlatformRepository extends JpaRepository<Platform, Long>{

//    List<Platform> findAllOrderByNameOrderByNameAsc();

}
