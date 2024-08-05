package persistence.IModel;

import entity.AuthorEntity;
import persistence.CRUD.*;

public interface IAuthorModel extends Create<AuthorEntity>,
        Delete<AuthorEntity>,
        ReadById<AuthorEntity>,
        ReadAll<AuthorEntity>,
        Update<AuthorEntity> {}
