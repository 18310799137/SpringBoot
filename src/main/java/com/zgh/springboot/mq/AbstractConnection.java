package com.zgh.springboot.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface AbstractConnection {

	Object getConnection() throws IOException, TimeoutException;

	void close(Object... connect);

}
