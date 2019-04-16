package database;

import play.db.jpa.JPAApi;

        import javax.inject.*;
        import javax.persistence.*;
        import java.util.concurrent.*;

@Singleton
public class JPARepository {
    private JPAApi jpaApi;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JPARepository(JPAApi api, DatabaseExecutionContext executionContext) {
        this.jpaApi = api;
        this.executionContext = executionContext;
    }
}