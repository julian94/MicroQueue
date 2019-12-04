package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResult {

    public LoginResult(User user, String token, boolean success){
        this.user = user;
        this.token = token;
        this.success = success;
    }

    public LoginResult(User user, String token){
        this.user = user;
        this.token = token;
        this.success = true;
    }

    public LoginResult(boolean success){
        this.success = success;
    }

    @Expose
	@SerializedName("token")
	private String token;

    @Expose
    @SerializedName("user")
    private User user;

    @Expose
    @SerializedName("success")
    private boolean success;

	public String getToken() {
		return token;
	}

    public void setToken(String token) {
        this.token = token;
    }
	
	public User getUser() {
		return user;
	}

    public void setUser(User user) {
        this.user = user;
    }
	
}
