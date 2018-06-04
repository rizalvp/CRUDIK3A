package id.rizalprasetya.crudik3a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import id.rizalprasetya.crudik3a.adapter.MahasiswaAdapter;
import id.rizalprasetya.crudik3a.model.Mahasiswa;
import id.rizalprasetya.crudik3a.model.MahasiswaResult;
import id.rizalprasetya.crudik3a.network.ApiClient;
import id.rizalprasetya.crudik3a.network.MahasiswaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView ivCobaGambar = (ImageView)findViewById(R.id.iv_coba_gambar);

        //todo muat gambar dari URL
        /*int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try {
                URL url = new URL("https://picsum.photos/200/300?random");
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                ivCobaGambar.setImageBitmap(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
        //Picasso.with(this).load("https://picsum.photos/200/300?random").into(ivCobaGambar);

        //todo 1 menyiapkan sumber data
        //todo 1.1 mengambil data string 1 dimensi
        //String[] user = new String[]{"Rizal", "Jono", "Joko", "Yono"};

        /*ArrayAdapter<String> userAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, user);*/

        //todo 1.2 mengambil data POJO (Plain Old Java Object) lebih dari 1 dimensi
       /* Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.setNama("Rizal");
        mahasiswa1.setNim("3.34.15.0.20");
        mahasiswa1.setEmail("rizalvp@gmail.com");
        mahasiswa1.setFoto("https://picsum.photos/200/300?random");*/

        /*Mahasiswa mahasiswa2 = new Mahasiswa(
                "Prasetya",
                "3.34.15.2.24",
                "pra@gmail.com",
                "https://picsum.photos/200/300?random"
        );*/

        ArrayList<Mahasiswa> user = new ArrayList<>();
        /*user.add(mahasiswa1);
        user.add(mahasiswa2);*/

        final ListView lvUser = (ListView)findViewById(R.id.lv_user);

        //todo 1.3 sumber data dari API / JSON object dari internet
        MahasiswaService mahasiswaService = ApiClient.getRetrofit().create(MahasiswaService.class);
        Call<MahasiswaResult> mahasiswas = mahasiswaService.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            //jika dapat data
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                List<Mahasiswa> user = response.body().getMahasiswas();
                MahasiswaAdapter userAdapter = new MahasiswaAdapter(getApplicationContext(), 0, user);

                lvUser.setAdapter(userAdapter);
                Toast.makeText(getApplicationContext(),
                        "Jumlah mahasiswa: " + response.body().getMahasiswas().size(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            //jika gagal dapat data
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {

            }
        });

        //todo 2 menyiapkan adapter


        //todo 3 inisialisasi + tampilan aplikasi



    }
}
