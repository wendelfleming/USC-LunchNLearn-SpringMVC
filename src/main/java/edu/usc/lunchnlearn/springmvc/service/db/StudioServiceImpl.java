package edu.usc.lunchnlearn.springmvc.service.db;

import edu.usc.lunchnlearn.springmvc.dao.StudioRepository;
import edu.usc.lunchnlearn.springmvc.dao.bean.Studio;
import edu.usc.lunchnlearn.springmvc.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;

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
