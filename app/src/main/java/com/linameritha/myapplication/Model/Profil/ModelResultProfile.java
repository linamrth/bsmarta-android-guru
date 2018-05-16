package com.linameritha.myapplication.Model.Profil;

import java.util.ArrayList;

public class ModelResultProfile {
    private String status;
    private Profile results;


    public String getStatus() {
        return status;
    }

    public Profile getResults() {
        return results;
    }

    public class Profile {
        private String namaguru, telepon, alamat, namacabang;
        private ArrayList<Program> program;

        public ArrayList<Program> getProgram() {
            return program;
        }

        public String getNamaguru() {
            return namaguru;
        }

        public String getTelepon() {
            return telepon;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getNamacabang() {
            return namacabang;
        }
    }

    public class Program {
        private String namaprogram, level;

        public String getNamaprogram() {
            return namaprogram;
        }

        public String getLevel() {
            return level;
        }
    }
}
