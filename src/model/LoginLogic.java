package model;

public class LoginLogic {
	public boolean LoginCheck(User user) {
		boolean isLogin = false;
		if(user.getPass().equals("1234")) isLogin = true;
		return isLogin;
	}

}
