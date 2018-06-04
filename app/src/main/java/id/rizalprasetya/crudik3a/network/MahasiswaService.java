package id.rizalprasetya.crudik3a.network;

import id.rizalprasetya.crudik3a.model.Mahasiswa;
import id.rizalprasetya.crudik3a.model.MahasiswaResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Rizal Prasetya on 28/05/2018.
 */

public interface MahasiswaService {

    @GET("mahasiswa")
    Call<MahasiswaResult> getMahasiswas();

    @GET("mahasiswa/{id}")
    Call<MahasiswaResult> getMahasiswa(@Path("id") int id);

    @POST("mahasiswa")
    Call<String> setMahasiswa(@Body Mahasiswa mahasiswa);

    //put nanti dulu

    @DELETE("mahasiswa/{id}")
    Call<String> hapusMahasiswa(@Path("id") int id);
}
