package com.example.volley02;

import com.android.volley.AuthFailureError;

import com.android.volley.Response;

import com.android.volley.toolbox.StringRequest;



import java.util.HashMap;

import java.util.Map;





public class RegisterRequest extends StringRequest {



    //현재 안드로이드앱을 에뮬레이터로 돌리므로 에뮬레이터가 설치된 서버에 있는 아파치 서버에 접근하려면

    //다음과 같이 10.0.2.2:포트번호 로 접근해야합니다 저는 8080 포트를 써서 다음과 같이 했습니다

    final static private String URL = "http://203.250.133.143:14732/android";

    private Map<String, String> parameters;



    //생성자

    public RegisterRequest(String id, String pw, String name, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();

        parameters.put("id", id);

        parameters.put("name", name);

        parameters.put("pw", pw);




    }



    //추후 사용을 위한 부분

    @Override

    protected Map<String, String> getParams() throws AuthFailureError {

        return parameters;

    }

}
