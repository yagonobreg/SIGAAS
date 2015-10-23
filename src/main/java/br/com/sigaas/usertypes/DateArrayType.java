package br.com.sigaas.usertypes;
import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
public class DateArrayType implements UserType {
	@Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return this.deepCopy(cached);
    }
 
    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }
 
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Date[]) this.deepCopy(value);
    }
 
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
 
        if (x == null) {
            return y == null;
        }
        return x.equals(y);
    }
 
    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }
 
    @Override
    public boolean isMutable() {
        return true;
    }
 
    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names,
            SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        Array array = resultSet.getArray(names[0]);
        Date[] javaArray = (Date[]) array.getArray();
        return javaArray;
    }
 
    @Override
    public void nullSafeSet(PreparedStatement statement, Object value,
            int index, SessionImplementor session) throws HibernateException,
            SQLException {
        Connection connection = statement.getConnection();
        Date[] castObject = (Date[]) value;
        Array array = connection.createArrayOf("timestamp", castObject);
        statement.setArray(index, array);
    }
 
    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }
 
    @Override
    public Class<Date[]> returnedClass() {
        return  Date[].class;
    }
 
    @Override
    public int[] sqlTypes() {
        return new int[] { Types.ARRAY };
    }
}
