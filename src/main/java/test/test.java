package test;

import dto.DescriptionDto;
import dto.UserDto;
import model.FormatFilm;
import service.impl.DescriptionServiceImpl;
import service.impl.UserServiceImpl;

import java.time.LocalDateTime;

/**
 * Created by Alexandr on 16.12.2016.
 */
public class test {
    public static void main(String[] args) {
//        UserDto userDto = new UserDto();
//        userDto.setFirstName("Sasha");
//        userDto.setClient(true);
//        UserServiceImpl.getInstance().save(userDto);
//        System.out.println(UserServiceImpl.getInstance().getById(1));

//        DescriptionDto descriptionDto = new DescriptionDto();
//        descriptionDto.setMark(2.2);
//        descriptionDto.setPicture("2");
//        descriptionDto.setFormatFilm(FormatFilm.COMMON);
//        descriptionDto.setDuration(120);
//        descriptionDto.setRelease(new Date(2016, 12,29));
//
//        DescriptionServiceImpl.getInstance().save(descriptionDto);
//        for (DescriptionDto dto : DescriptionServiceImpl.getInstance().getAll()) {
//            System.out.println(dto);
//        }

//        HallDto hallDto = new HallDto();
//        hallDto.setCountColume(10);
//        hallDto.setCountRow(4);
//        hallDto.setName("Red");
//        hallDto.setPlaces(new Place[4][10]);
//
//        HallServiceImpl.getInstance().save(hallDto);
//
//        for (HallDto dto : HallServiceImpl.getInstance().getAll()) {
//            System.out.println(dto);
//
//        }
//        UserDto userDto = UserServiceImpl.getInstance().getById(1);
//      //  HallDto hallDto = HallServiceImpl.getInstance().getById(1);
//        DescriptionDto descriptionDto = DescriptionServiceImpl.getInstance().getById(1);
//
////        FilmDto filmDto = new FilmDto();
////        filmDto.setDescription(descriptionDto);
////        filmDto.setName("Matrix");
////        FilmServiceImpl.getInstance().save(filmDto);
////
//       FilmDto filmDto1 = FilmServiceImpl.getInstance().getById(1);
////        System.out.println(filmDto1);
////
////        SessionDto sessionDto = new SessionDto();
////        sessionDto.setFilmDto(filmDto1);
////        sessionDto.setHallDto(hallDto);
////        sessionDto.setDate(new Date(2000,10,10));
////
////        SessionServiceImpl.getInstance().save(sessionDto);
////
////        System.out.println(SessionServiceImpl.getInstance().getById(1));
//
//
//
////        TicketDto ticketDto = new TicketDto();
////        ticketDto.setUserDto(userDto);
////        ticketDto.setSessionDto(sessionDto1);
////        ticketDto.setPlace(new Place(10,10));
////        ticketDto.setPrice(1.2);
////
////        TicketServiceImpl.getInstance().save(ticketDto);
////
////
////        TicketDto ticketDto1 = TicketServiceImpl.getInstance().getById(1);
////        System.out.println(ticketDto1.getId());
////        HallServiceImpl.getInstance().delete(5);
////
////        List<SessionDto> sessionDtos = SessionServiceImpl.getInstance().getSessionByIdFilm(1);
//  //   HallDto hallDto1 = HallServiceImpl.getInstance().getById(7);
////        HallDto hallDto = new HallDto(4,10);
////
////        hallDto.setName("Red");
////
//////
////    HallServiceImpl.getInstance().save(hallDto);
////
////        HallDto hallDto = new HallDto(10,10);
////        hallDto.setName("Black");
////        hallDto.setId(1);
////        HallServiceImpl.getInstance().update(hallDto);
        DescriptionDto descriptionDto1 = new DescriptionDto();
        LocalDateTime localDate = LocalDateTime.now();

        System.out.println(localDate.toString());
        descriptionDto1.setRelease(localDate);
        descriptionDto1.setFormatFilm(FormatFilm.COMMON);
        descriptionDto1 = DescriptionServiceImpl.getInstance().save(descriptionDto1);
        System.out.println();


        UserDto userDto = new UserDto();
        userDto = UserServiceImpl.getInstance().save(userDto);
        System.out.println();
//        List<HallDto> hallDtos = HallServiceImpl.getInstance().getAll();
//        System.out.println(hallDtos);

//        UserDto userDto1 = new UserDto();
//      userDto1 = (UserServiceImpl.getInstance().getUserByLogin("Vasya")).get(0);
//      System.out.println(userDto1);
//
//      userDto1.setLogin("sasha");
//
//      UserServiceImpl.getInstance().update(userDto1);
//        SessionDto sessionDto = new SessionDto();
//               sessionDto = SessionServiceImpl.getInstance().getById(1);
//        System.out.println(sessionDto);
    }
}
