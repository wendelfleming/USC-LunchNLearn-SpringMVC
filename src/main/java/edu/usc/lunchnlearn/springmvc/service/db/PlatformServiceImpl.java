package edu.usc.lunchnlearn.springmvc.service.db;

import edu.usc.lunchnlearn.springmvc.dao.PlatformRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Platform;
import edu.usc.lunchnlearn.springmvc.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;

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
