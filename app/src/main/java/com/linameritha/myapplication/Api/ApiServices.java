package com.linameritha.myapplication.Api;

import com.linameritha.myapplication.Model.Login.ModelResultLogin;
import com.linameritha.myapplication.Model.Profil.ModelResultProfile;
import com.linameritha.myapplication.Model.SemuaSiswa.DetailsemuasiswaresultModel;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaresultModel;
import com.linameritha.myapplication.Model.Siswa.DetailsiswaresultModel;
import com.linameritha.myapplication.Model.Siswa.SiswaresultModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ApiServices {
    public static String BASE_URL = "http://192.168.43.198/bsmarta/admin/api/";

    public static PostServices services_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.PostServices.class);
    public static GetServices services_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.GetServices.class);

    public interface PostServices{
        @FormUrlEncoded
        @POST("login/login")
        Call<ModelResultLogin> login(
                @Field("username") String username,
                @Field("password") String password
        );
    }
    public interface GetServices{
        @GET("guruprofil/{id}")
        Call<ModelResultProfile> getProfile(@Path("id") int id);

        @GET("gurusiswa/index/{id}")
        Call<SiswaresultModel> getSiswa(@Path("id") int id);

        @GET("gurusiswa/view/{id}")
        Call<DetailsiswaresultModel> getDetailsiswa(@Path("id") int id);

        @GET("gurusiswa/allsiswa/{id}")
        Call<SemuasiswaresultModel> getSemuasiswa(@Path("id")int id);

        @GET("gurusiswa/allsiswaview/{id}")
        Call<DetailsemuasiswaresultModel> getDetailsemuasiswa(@Path("id") int id);
    }
}
