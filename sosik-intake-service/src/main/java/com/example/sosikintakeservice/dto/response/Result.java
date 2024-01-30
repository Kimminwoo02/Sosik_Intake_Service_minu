package com.example.sosikintakeservice.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T>{
    private String resultCode;
    private T result;

    public static Result<Void> error(String errorCode){
        return new Result<>(errorCode,null);
    }

    public static Result<Void> success(){
        return new Result<Void>("데이터 전송에 성공하였습니다!",null);
    }

    public static <T> Result<T> success(T result){
        return new Result<T>("데이터 전송에 성공하였습니다!",result);
    }

    public String toStream(){
        if(result ==null){
            return "{" +
                    "\"resultCode\":" + "\""+resultCode + "\"," +
                    "\"result\":" + null + "}";
        }
        {
            return "{" +
                    "\" resultCode\":" +"\""+resultCode + "\"," +
                    "\"result\" :" + "\"" + result + "\"" + "}";

        }

    }
}
