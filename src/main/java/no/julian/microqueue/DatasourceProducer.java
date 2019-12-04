package no.julian.microqueue;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import static no.julian.microqueue.DatasourceProducer.JNDI_NAME;


@Singleton
@DataSourceDefinition(
    name = JNDI_NAME,
    className = "org.h2.jdbcx.JdbcDataSource",
    url = "jdbc:h2:~/database")
public class DatasourceProducer {
    public static final String JNDI_NAME =  "java:app/jdbc/default";

    @Resource(lookup=JNDI_NAME)
    DataSource ds;

    @Produces
    public DataSource getDatasource() {
        return ds;
    }
}
