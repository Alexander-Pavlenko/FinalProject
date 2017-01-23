package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.DescriptionDto;
import mapper.BeanMapper;
import model.Description;
import service.api.Service;

import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class DescriptionServiceImpl implements Service<Integer, DescriptionDto> {
    private static DescriptionServiceImpl service;
    private Dao<Integer, Description> descriptionDao;
    private BeanMapper beanMapper;

    private DescriptionServiceImpl(){
        descriptionDao = DaoFactory.getInstance().getDescriptionDao();
        beanMapper = BeanMapper.getInstance();
    }
    public static synchronized DescriptionServiceImpl getInstance() {
        if (service == null) {
            service = new DescriptionServiceImpl();
        }
        return service;
    }

    @Override
    public List<DescriptionDto> getAll() {
        List<Description> descriptions = descriptionDao.getAll();
        List<DescriptionDto> descriptionDtos = beanMapper.listMapToList(descriptions, DescriptionDto.class);
        return descriptionDtos;
    }

    @Override
    public DescriptionDto getById(Integer id) {

        Description description = descriptionDao.getById(id);
        DescriptionDto descriptionDto = beanMapper.singleMapper(description, DescriptionDto.class);
        return descriptionDto;
    }

    @Override
    public DescriptionDto save(DescriptionDto entity) {
        Description description = beanMapper.singleMapper(entity, Description.class);
        description = descriptionDao.save(description);
        entity = beanMapper.singleMapper(description, DescriptionDto.class);
        return entity;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(DescriptionDto entity) {
        Description description = beanMapper.singleMapper(entity,Description.class);
        descriptionDao.update(description);
    }
}
