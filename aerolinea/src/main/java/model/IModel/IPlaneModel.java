package model.IModel;

import entity.FlightEntity;
import entity.PlaneEntity;
import persistence.CRUD.*;

public interface IPlaneModel extends    Create<PlaneEntity>,
                                        Delete<PlaneEntity>,
                                        Read<PlaneEntity>,
                                        Update<PlaneEntity>,
                                        ReadAll<PlaneEntity>{}
