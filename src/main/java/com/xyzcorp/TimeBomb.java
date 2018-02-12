package com.xyzcorp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class TimeBomb {
    public void thisWillThrowASQLException() throws SQLException {
        throw new SQLException("Can't connect to db");
    }

    public void thisWillThrowAIOException() throws IOException {
        throw new IOException("IO Exception");
    }

    public void thisWillThrowAMalformedURLException() throws
        MalformedURLException {
        throw new MalformedURLException("Bad url!");
    }
}
