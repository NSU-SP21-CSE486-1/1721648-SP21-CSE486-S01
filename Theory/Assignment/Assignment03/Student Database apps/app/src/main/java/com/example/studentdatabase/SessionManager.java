package com.example.studentdatabase;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    //variables
    SharedPreferences usersSession;
    SharedPreferences.Editor editor;
    Context context;
    private static String IS_LOGIN="IsLoggedIn";
    private static String KEY_EMAIL="email";
    private static String KEY_PASSWARD="passward";
    public SessionManager(Context _context){
        context = _context;
        usersSession=_context.getSharedPreferences("usersLoginSession",Context.MODE_PRIVATE);
        editor= usersSession.edit();

    }
  public void  createLoginSession(String email, String password){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASSWARD,password);
        editor.commit();

  }
  public HashMap<String,String> getUserDetailFromSession(){
        HashMap<String,String>useData = new HashMap<String,String>();
                useData.put(KEY_EMAIL,usersSession.getString(KEY_EMAIL,null));
                useData.put(KEY_PASSWARD,usersSession.getString(KEY_PASSWARD,null));
                return useData;

  }
  public boolean checkLogin(){
        if(usersSession.getBoolean(IS_LOGIN,false)){
            return true;
        }
        else{
            return false;

        }
  }
  public void logoutUserFromSession(){
        editor.clear();
        editor.commit();
  }


}
