package com.linameritha.myapplication.Api;

import com.linameritha.myapplication.Model.Jadwal.JadwalresultModel;
import com.linameritha.myapplication.Model.Login.ModelResultLogin;
import com.linameritha.myapplication.Model.Profil.ModelResultProfile;
import com.linameritha.myapplication.Model.SemuaSiswa.DetailsemuasiswaresultModel;
import com.linameritha.myapplication.Model.SemuaSiswa.GurusemuasiswaModel;
import com.linameritha.myapplication.Model.SemuaSiswa.InputrapotresultsemuasiswaModel;
import com.linameritha.myapplication.Model.SemuaSiswa.MaterihalamansemuasiswaModel;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaresultModel;
import com.linameritha.myapplication.Model.SemuaSiswa.ViewrapotModel;
import com.linameritha.myapplication.Model.Siswa.DetailsiswaresultModel;
import com.linameritha.myapplication.Model.Siswa.GuruModel;
import com.linameritha.myapplication.Model.Siswa.IsirapotresultModel;
import com.linameritha.myapplication.Model.Siswa.LihatrapotModel;
import com.linameritha.myapplication.Model.Siswa.MaterihalamanModel;
import com.linameritha.myapplication.Model.Siswa.SiswaresultModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public class ApiServices {
    public static String BASE_URL = "http://lina.jagopesan.com/admin/api/";

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

        @FormUrlEncoded
        @POST("gurusiswa/inputrapot")
        Call<IsirapotresultModel> rapot(
                @Query("id") String id,
                @Field("idguru") Integer idguru,
                @Field("materi") String materi,
                @Field("halamanketercapaian") Integer halamanketercapaian,
                @Field("hasil") String hasil,
                @Field("catatanguru") String catatanguru,
                @Field("rewardhasil") Integer rewardhasil,
                @Field("rewardsikap") Integer rewardsikap
        );

        @FormUrlEncoded
        @POST("gurusiswa/allsiswainputrapot")
        Call<InputrapotresultsemuasiswaModel> rapotallsiswa(
                @Query("id") String id,
                @Field("idguru") Integer idguru,
                @Field("materi") String materi,
                @Field("halamanketercapaian") Integer halamanketercapaian,
                @Field("hasil") String hasil,
                @Field("catatanguru") String catatanguru,
                @Field("rewardhasil") Integer rewardhasil,
                @Field("rewardsikap") Integer rewardsikap
        );
    }
    
    public interface GetServices{
        @GET("guruprofil/{id}")
        Call<ModelResultProfile> getProfile(@Path("id") int id);

        @GET("gurusiswa/index/{id}")
        Call<SiswaresultModel> getSiswa(@Path("id") int id);

        @GET("gurusiswa/view/{id}")
        Call<DetailsiswaresultModel> getDetailsiswa(@Path("id") int id);

        @GET("gurusiswa/lihatrapot/{id}")
        Call<LihatrapotModel> getLihatrapotsiswa(@Path("id") String id);

        @GET("gurusiswa/guru/{id}")
        Call<GuruModel> getGuru(@Path("id") int id);

        @GET("gurusiswa/materihalaman")
        Call<MaterihalamanModel> getMaterihalaman(@Query("id") String id);

        @GET("gurusiswa/allsiswa/{id}")
        Call<SemuasiswaresultModel> getSemuasiswa(@Path("id")int id);

        @GET("gurusiswa/allsiswaview/{id}")
        Call<DetailsemuasiswaresultModel> getDetailsemuasiswa(@Path("id") int id);

        @GET("gurusiswa/allsiswalihatrapot/{id}")
        Call<ViewrapotModel> getViewrapotsemuasiswa(@Path("id") String id);

        @GET("gurusiswa/allsiswamaterihalaman")
        Call<MaterihalamansemuasiswaModel> getMaterihalamansemuasiswa(@Query("id") String id);

        @GET("gurusiswa/allsiswaguru/{id}")
        Call<GurusemuasiswaModel> getGurusemuasiswa(@Path("id") int id);

        @GET("gurujadwal/index")
        Call<JadwalresultModel> getJadwal(@Query("id") String id);
    }
}
