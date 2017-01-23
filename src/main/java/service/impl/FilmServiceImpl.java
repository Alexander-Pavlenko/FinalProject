package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.FilmDto;
import mapper.BeanMapper;
import model.Film;
import service.api.Service;

import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class FilmServiceImpl implements Service<Integer, FilmDto> {

    private static FilmServiceImpl service;
    private Dao<Integer, Film> filmDao;
    private BeanMapper beanMapper;


    private FilmServiceImpl(){
        filmDao = DaoFactory.getInstance().getFilmDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized FilmServiceImpl getInstance() {
        if (service == null) {
            service = new FilmServiceImpl();
        }
        return service;
    }
    @Override
    public List<FilmDto> getAll() {
        List<Film> films = filmDao.getAll();
        List<FilmDto> filmDtos = beanMapper.listMapToList(films, FilmDto.class);
        return filmDtos;
    }

    @Override
    public FilmDto getById(Integer id) {
        Film film = filmDao.getById(id);
        FilmDto filmDto = beanMapper.singleMapper(film, FilmDto.class);
        return filmDto;
    }

    @Override
    public FilmDto save(FilmDto entity) {
        Film film = beanMapper.singleMapper(entity, Film.class);
        filmDao.save(film);
        entity = beanMapper.singleMapper(film, FilmDto.class);
        return entity;
    }

    @Override
    public void delete(Integer key) {
        filmDao.delete(key);
    }

    @Override
    public void update(FilmDto entity) {
        Film film = beanMapper.singleMapper(entity,Film.class);
        filmDao.update(film);
    }
}
