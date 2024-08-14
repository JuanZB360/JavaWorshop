package model.IModel;

import entity.FlightEntity;
import entity.PassengerEntity;
import persistence.CRUD.*;

public interface IPassengerModel extends    Create<PassengerEntity>,
                                            Delete<PassengerEntity>,
                                            Read<PassengerEntity>,
                                            Update<PassengerEntity>,
                                            ReadAll<PassengerEntity>{}
