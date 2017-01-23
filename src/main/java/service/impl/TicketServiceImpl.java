package service.impl;

import dao.DaoFactory;
import dao.api.Dao;
import dto.*;
import mapper.BeanMapper;
import model.*;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 18.12.2016.
 */
public class TicketServiceImpl implements Service<Integer, TicketDto> {

    private static TicketServiceImpl service;
    private Dao<Integer, Ticket> ticketDao;
    private BeanMapper beanMapper;


    private TicketServiceImpl(){
        ticketDao = DaoFactory.getInstance().getTicketDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized TicketServiceImpl getInstance() {
        if (service == null) {
            service = new TicketServiceImpl();
        }
        return service;
    }


    @Override
    public List<TicketDto> getAll() {
        List<Ticket> tickets = ticketDao.getAll();
        List<TicketDto> ticketDtos = beanMapper.listMapToList(tickets, TicketDto.class);
        for (int i = 0; i <tickets.size() ; i++) {
            ticketDtos.get(i).setUserDto(beanMapper.singleMapper(tickets.get(i).getUser(),UserDto.class));
            ticketDtos.get(i).setSessionDto(beanMapper.singleMapper(tickets.get(i).getSession(), SessionDto.class));
            ticketDtos.get(i).getSessionDto().setFilmDto(beanMapper.singleMapper(tickets.get(i).getSession().getFilm(), FilmDto.class));


            ticketDtos.get(i).setPlace(tickets.get(i).getPlace());

        }
        return ticketDtos;
    }

    @Override
    public TicketDto getById(Integer id) {
        Ticket ticket =  ticketDao.getById(id);
        TicketDto ticketDto = beanMapper.singleMapper(ticket,TicketDto.class);

        ticketDto.setUserDto(beanMapper.singleMapper(ticket.getUser(),UserDto.class));
        ticketDto.setSessionDto(beanMapper.singleMapper(ticket.getSession(), SessionDto.class));
        ticketDto.getSessionDto().setFilmDto(beanMapper.singleMapper(ticket.getSession().getFilm(), FilmDto.class));


        ticketDto.setPlace(ticket.getPlace());
        return ticketDto;
    }
    public List<TicketDto> getListByIdUser(Integer id){
        List<TicketDto> list = getAll();
        List<TicketDto> ticketDtoList = new ArrayList<>();
        for (TicketDto ticketDto : list) {
            if(ticketDto.getUserDto().getId() == id)
                ticketDtoList.add(ticketDto);
        }
        return ticketDtoList;

    }

    @Override
    public TicketDto save(TicketDto entity) {
        Ticket ticket = new Ticket();
        ticket = beanMapper.singleMapper(entity, Ticket.class);
        ticket.setSession(beanMapper.singleMapper(entity.getSessionDto(),Session.class));
        ticket.getSession().setFilm(beanMapper.singleMapper(entity.getSessionDto().getFilmDto(),Film.class));
        ticket.setUser(beanMapper.singleMapper(entity.getUserDto(), User.class));




        ticketDao.save(ticket);
        return entity;
    }
    public void saveList(List<TicketDto> ticketDtoList){
        for (TicketDto ticketDto : ticketDtoList) {
            TicketServiceImpl.getInstance().save(ticketDto);
        }
    }

    public List<TicketDto> returnTickets(String s, HallDto hallDto, UserDto userDto, SessionDto sessionDto){
        List<TicketDto> list = hallDto.booking(s);
        double sum = returnSum(list);
        sum = userDto.getDiscountPrice(sum/list.size())*list.size();
        userDto = UserServiceImpl.getInstance().getById(userDto.getId());
        if(sum <= userDto.getMoney())
        {
            for (TicketDto ticketDto : list) {
                ticketDto.setPrice(sum/list.size());
                ticketDto.setUserDto(userDto);
                ticketDto.setSessionDto(sessionDto);
            }
            userDto.setMoney(userDto.getMoney() - sum);
            userDto.changeDiscount(list.size());
            UserServiceImpl.getInstance().update(userDto);
            HallServiceImpl.getInstance().update(hallDto);
            TicketServiceImpl.getInstance().saveList(list);

        }
      else {
            list = null;
        }
        return list;
    }
    private double returnSum(List<TicketDto> list){
        double sum  = 0;
        for (TicketDto ticketDto : list) {
            sum += ticketDto.getPrice();
        }
        return sum;
    }


    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(TicketDto entity) {

    }
}
