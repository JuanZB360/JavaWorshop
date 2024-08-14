package persistence.IModel;

import entity.AuthorEntity;
import persistence.CRUD.*;

public interface IAuthorModel extends Create<AuthorEntity>,
        Delete<AuthorEntity, AuthorEntity>,
        ReadById<AuthorEntity,AuthorEntity>,
        ReadAll<AuthorEntity>,
        Update<AuthorEntity> {
}
