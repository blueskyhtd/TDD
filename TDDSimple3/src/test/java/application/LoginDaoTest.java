package application;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import application.LoginBean;
import application.LoginDao;

import com.viettel.config.DatabaseTest;

public class LoginDaoTest {

	public static final String fileData = "./datatest/user.xml";

	public static final String SERVER_ROOT = "F:\\Tool\\apache-tomcat-8.0.36\\wtpwebapps\\TDDSimple3";

	private IDataSet dataset;
	private IDatabaseConnection conn;

	private HttpServletRequest request;

	@Before
	public void setup() throws Exception {
		request = Mockito.mock(HttpServletRequest.class);
		Mockito.when(request.getRealPath(".")).thenReturn(SERVER_ROOT);

		conn = DatabaseTest.getInstance().connect(request);
		dataset = DatabaseTest.readDataset(fileData);
		DatabaseTest.insertData(conn, dataset);

	}

	@Test
	public void testValidate() throws SQLException {
		LoginBean loginBean = Mockito.mock(LoginBean.class);
		Mockito.when(loginBean.getUsername()).thenReturn("usertest");
		Mockito.when(loginBean.getPassword()).thenReturn("123456a@");

		Assert.assertEquals("logic successfull", true,
				LoginDao.validate(loginBean, request));
	}
}
