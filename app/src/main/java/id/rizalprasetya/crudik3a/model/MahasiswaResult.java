package id.rizalprasetya.crudik3a.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rizal Prasetya on 28/05/2018.
 */

public class MahasiswaResult {

    @SerializedName("mahasiswas")
    @Expose
    private List<Mahasiswa> mahasiswas = null;

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

}
