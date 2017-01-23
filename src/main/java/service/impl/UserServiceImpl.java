package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dao.impl.UserDaoImpl;
import dto.UserDto;
import mapper.BeanMapper;
import model.User;
import service.api.Service;

import java.util.List;

/**
 * Created by Alexandr on 16.12.2016.
 */
public class UserServiceImpl implements Service<Integer, UserDto> {

    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;


    private UserServiceImpl(){
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();
        List<UserDto> userDtos = beanMapper.listMapToList(users, UserDto.class);
        return userDtos;
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userDao.getById(id);
        UserDto userDto = beanMapper.singleMapper(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = beanMapper.singleMapper(userDto, User.class);
        userDao.save(user);
        return userDto;
    }
    public List<UserDto> getUserByLogin(String login){
        List<User> users = ((UserDaoImpl) userDao).readAllByLogin(login);
        List<UserDto> userDtos = beanMapper.listMapToList(users,UserDto.class);
        return userDtos;
    }

    @Override
    public void delete(Integer key) {
        userDao.delete(key);
    }

    @Override
    public void update(UserDto entity) {
        User user = beanMapper.singleMapper(entity, User.class);
        user.setClient(entity.getIsClient());
        userDao.update(user);
    }


}
