package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("findAllCars");
        try{
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars= typedQuery.getResultList();
            return copyCarsToDto(cars);
        }
        catch(Exception ex){throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        LOG.info("copyCarsToDto");

        List<CarDto> carDtoList=new ArrayList<>();

        for(Car c: cars){
            Long idTemp=c.getId();
            String lpTemp=c.getLicensePlate();
            String psTemp=c.getParkingSpot();
            User owner=c.getOwner(); String ownerName=owner.getUsername();
            CarDto cd=new CarDto(idTemp,lpTemp,psTemp,ownerName);
            carDtoList.add(cd);
        }

        return carDtoList;
    }

public void createCar(String licensePlate, String parkingSpot, Long userId)
{
    LOG.info("createCar");
    Car car=new Car();
    car.setLicensePlate(licensePlate);
    car.setParkingSpot(parkingSpot);

    User user = entityManager.find(User.class, userId);
    user.getCars().add(car);
    car.setOwner(user);
    entityManager.persist(car);
}
    public CarDto findById(Long carId) {

        CarDto car=new CarDto();
        List<CarDto> carDtoList = this.findAllCars();
        for(CarDto cd: carDtoList){
            if(cd.getId()==carId){ car=cd; }
        }
        return car;
    }


    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        LOG.info("updateCar");

        Car car=entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        //Old owner --> Remove
        User oldUser=car.getOwner();
        oldUser.getCars().remove(car);

        //New user --> Add
        User user=entityManager.find(User.class,userId);
        user.getCars().add(car);
        car.setOwner(user);

    }
}
