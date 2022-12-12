package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsersBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch(Exception e){
            throw new EJBException(e);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        LOG.info("copyUsersToDto");

        List<UserDto> userDtoList=new ArrayList<UserDto>();

        for(User u: users){
            String emailTemp =u.getEmail();
            String usernameTemp=u.getUsername();
            Long userId=u.getId();
            UserDto udt=new UserDto(emailTemp,usernameTemp,userId);
            userDtoList.add(udt);
        }

        return userDtoList;
    }
}
