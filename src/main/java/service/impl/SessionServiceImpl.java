package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dao.impl.SessionDaoImpl;
import dto.FilmDto;
import dto.HallDto;
import dto.SessionDto;
import mapper.BeanMapper;
import model.Film;
import model.Hall;
import model.Session;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 18.12.2016.
 */
public class SessionServiceImpl implements Service<Integer, SessionDto> {

    private static SessionServiceImpl service;
    private Dao<Integer, Session> sessionDao;
    private BeanMapper beanMapper;


    private SessionServiceImpl(){
        sessionDao = DaoFactory.getInstance().getSessionDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized SessionServiceImpl getInstance() {
        if (service == null) {
            service = new SessionServiceImpl();
        }
        return service;
    }

    @Override
    public List<SessionDto> getAll() {
        List<Session> sessions = sessionDao.getAll();

        List<SessionDto> sessionDtos = beanMapper.listMapToList(sessions,SessionDto.class);

        for (int i = 0; i < sessions.size(); i++){
            sessionDtos.get(i).setFilmDto(beanMapper.singleMapper(sessions.get(i).getFilm(),FilmDto.class));
            HallDto hallDto = new HallDto();
            hallDto.setId(sessions.get(i).getHall().getId());
            sessionDtos.get(i).setHallDto(hallDto);
        }
        return sessionDtos;
    }

    @Override
    public SessionDto getById(Integer id) {
        Session session = sessionDao.getById(id);
        SessionDto sessionDto = beanMapper.singleMapper(session,SessionDto.class);
        sessionDto.setFilmDto(beanMapper.singleMapper(session.getFilm(), FilmDto.class));
        sessionDto.setHallDto(new HallDto());
        sessionDto.getHallDto().setName(session.getHall().getName());
        sessionDto.getHallDto().setId(session.getHall().getId());




//
//        sessionDto.setFilmDto(new FilmDto());
//        sessionDto.setId(session.getId());
//        sessionDto.setDate(session.getDate());
//sessionDto.setHallDto(beanMapper.singleMapper(session.getHall(), HallDto.class));


        return sessionDto;
    }

    @Override
    public SessionDto save(SessionDto entity) {
        Session session = new Session();
        session = beanMapper.singleMapper(entity, Session.class);
        Hall hall = new Hall();
        hall.setName(entity.getHallDto().getName());
        hall.setPlaces(entity.getHallDto().getPlaces());
        hall.setCountColume(entity.getHallDto().getCountColumn());
        hall.setCountRow(entity.getHallDto().getCountRow());
        hall.setId(entity.getHallDto().getId());


        session.setHall(hall);
        session.setFilm(beanMapper.singleMapper(entity.getFilmDto(), Film.class));
        sessionDao.save(session);
        return entity;
    }

    @Override
    public void delete(Integer key) {
        sessionDao.delete(key);
    }

    @Override
    public void update(SessionDto entity) {
        Session session = beanMapper.singleMapper(entity, Session.class);
        Hall hall = new Hall();
        hall.setName(entity.getHallDto().getName());
        hall.setPlaces(entity.getHallDto().getPlaces());
        hall.setCountColume(entity.getHallDto().getCountColumn());
        hall.setCountRow(entity.getHallDto().getCountRow());
        hall.setId(entity.getHallDto().getId());;
        session.setHall(hall);
        session.setFilm(beanMapper.singleMapper(entity.getFilmDto(), Film.class));

        sessionDao.update(session);
    }
    public List<SessionDto> getSessionByIdFilm(int id){

        List<Session> sessions =((SessionDaoImpl) sessionDao).getByFilmId(id);
        List<SessionDto> sessionDtos = new ArrayList<>();
        for (Session session : sessions) {
            SessionDto sessionDto = new SessionDto();
            sessionDto.setHallDto(new HallDto());
            sessionDto.getHallDto().setName(session.getHall().getName());
            sessionDto.getHallDto().setId(session.getHall().getId());

            sessionDto.setId(session.getId());
            sessionDto.setDate(session.getDate());
            sessionDtos.add(sessionDto);
        }

        return sessionDtos;
    }
}
