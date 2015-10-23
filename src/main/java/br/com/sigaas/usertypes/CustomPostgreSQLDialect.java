package br.com.sigaas.usertypes;
import java.sql.Types;
import org.hibernate.dialect.PostgreSQL9Dialect;
public class CustomPostgreSQLDialect extends PostgreSQL9Dialect{
	public CustomPostgreSQLDialect() {
        super();
        this.registerColumnType(Types.ARRAY, "varchar[]");
        this.registerColumnType(Types.ARRAY, "timestamp[]");
    }
}
