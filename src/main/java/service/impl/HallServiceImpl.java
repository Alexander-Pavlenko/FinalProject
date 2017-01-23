package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.HallDto;
import mapper.BeanMapper;
import model.Hall;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class HallServiceImpl implements Service<Integer, HallDto>{

    private static HallServiceImpl service;
    private Dao<Integer, Hall> hallDao;
    private BeanMapper beanMapper;


    private HallServiceImpl(){
        hallDao = DaoFactory.getInstance().getHallDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized HallServiceImpl getInstance() {
        if (service == null) {
            service = new HallServiceImpl();
        }
        return service;
    }


    @Override
    public List<HallDto> getAll() {
        List<Hall> halls = hallDao.getAll();
    //   List<HallDto> hallDtos = beanMapper.listMapToList(halls, HallDto.class);
        List<HallDto> hallDtos = new ArrayList<>();
        HallDto hallDto;

        for (Hall hall : halls) {
            hallDto  = new HallDto();
            hallDto.setName(hall.getName());
            hallDto.setPlaces(hall.getPlaces());
            hallDto.setCountColumn(hall.getCountColume());
            hallDto.setCountRow(hall.getCountColume());
            hallDto.setId(hall.getId());
            hallDtos.add(hallDto);

        }
        return hallDtos;
    }

    @Override
    public HallDto getById(Integer id) {
        Hall hall = hallDao.getById(id);
        HallDto hallDto  = new HallDto();
        hallDto.setName(hall.getName());
        hallDto.setPlaces(hall.getPlaces());
        hallDto.setCountColumn(hall.getCountColume());
        hallDto.setCountRow(hall.getCountRow());
        hallDto.setId(hall.getId());
        return hallDto;
    }

    @Override
    public HallDto save(HallDto entity) {
        Hall hall = new Hall();
     //   Hall hall = beanMapper.singleMapper(entity,Hall.class);

        hall.setCountRow(entity.getCountRow());
        hall.setPlaces(entity.getPlaces());
        hall.setCountColume(entity.getCountColumn());
        hall.setName(entity.getName());
        hallDao.save(hall);
        return entity;
    }

    @Override
    public void delete(Integer key) {
        hallDao.delete(key);
    }

    @Override
    public void update(HallDto entity) {
        Hall hall = new Hall();
        hall.setId(entity.getId());
        hall.setCountRow(entity.getCountRow());
        hall.setPlaces(entity.getPlaces());
        hall.setCountColume(entity.getCountColumn());
        hall.setName(entity.getName());
        hallDao.update(hall);

    }
}
