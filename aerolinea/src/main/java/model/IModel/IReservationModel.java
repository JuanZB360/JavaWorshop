package model.IModel;

import entity.ReservationEntity;
import persistence.CRUD.*;

public interface IReservationModel extends  Create<ReservationEntity>,
                                            Delete<ReservationEntity>,
                                            Read<ReservationEntity>,
                                            Update<ReservationEntity>,
                                            ReadAll<ReservationEntity>,
                                            ReadUnique<ReservationEntity>{}
