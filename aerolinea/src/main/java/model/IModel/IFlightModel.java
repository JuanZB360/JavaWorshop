package model.IModel;

import entity.FlightEntity;
import persistence.CRUD.*;

public interface IFlightModel extends   Create<FlightEntity>,
                                        Delete<FlightEntity>,
                                        Read<FlightEntity>,
                                        Update<FlightEntity>,
                                        ReadAll<FlightEntity>{}
