package utilities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import apiPojos.ApiError;

public class DataManager {
	private static DataManager dataManager = null;
	private String token;
	private List<ApiError> apiErrors;

	private DataManager() {

	}

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}

	public static void cleanUp() {
		dataManager = null;
	}

	public String getToken() {
		assertNotNull(token, "Datamanager - token is not available");
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<ApiError> getApiErrors() {
		assertNotNull(apiErrors);
		return apiErrors;
	}

	public void setApiErrors(List<ApiError> apiErrors) {
		this.apiErrors = apiErrors;
	}

}
