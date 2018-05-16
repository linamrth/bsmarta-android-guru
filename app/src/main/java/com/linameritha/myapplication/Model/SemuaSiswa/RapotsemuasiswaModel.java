package com.linameritha.myapplication.Model.SemuaSiswa;

public class RapotsemuasiswaModel {
    private String materi;
    private String hasil;
    private String halketercapaian;
    private String catatanguru;
    private String rewardhasil;
    private String rewardsikap;
    private String namaguru;

    public RapotsemuasiswaModel(String materi, String hasil, String halketercapaian, String catatanguru, String rewardhasil, String rewardsikap, String namaguru) {
        this.materi = materi;
        this.hasil = hasil;
        this.halketercapaian = halketercapaian;
        this.catatanguru = catatanguru;
        this.rewardhasil = rewardhasil;
        this.rewardsikap = rewardsikap;
        this.namaguru = namaguru;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getHalketercapaian() {
        return halketercapaian;
    }

    public void setHalketercapaian(String halketercapaian) {
        this.halketercapaian = halketercapaian;
    }

    public String getCatatanguru() {
        return catatanguru;
    }

    public void setCatatanguru(String catatanguru) {
        this.catatanguru = catatanguru;
    }

    public String getRewardhasil() {
        return rewardhasil;
    }

    public void setRewardhasil(String rewardhasil) {
        this.rewardhasil = rewardhasil;
    }

    public String getRewardsikap() {
        return rewardsikap;
    }

    public void setRewardsikap(String rewardsikap) {
        this.rewardsikap = rewardsikap;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }
}
