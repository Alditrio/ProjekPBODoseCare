// Superclass Abstrak merepresentasikan Pengguna/Pasien (Konsep Abstraksi & Enkapsulasi)
public abstract class Pengguna {
    private String id;
    private String nama;
    private String noHp;
    private String email;
    private int totalJadwal;
    private int totalTepatWaktu;

    public Pengguna(String id, String nama, String noHp, String email) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
        this.email = email;
        this.totalJadwal = 0;
        this.totalTepatWaktu = 0;
    }

    public void tambahJadwal() {
        this.totalJadwal++;
    }

    public void catatMinumObat(boolean tepatWaktu) {
        if (tepatWaktu) {
            this.totalTepatWaktu++;
        }
    }

    public double hitungPersentaseKepatuhan() {
        if (totalJadwal == 0) return 0.0;
        return (double) totalTepatWaktu / totalJadwal * 100.0;
    }

    // Metode Abstrak yang wajib di-override oleh Subclass (Polimorfisme)
    public abstract void tampilkanProfil();
    public abstract String getPeran();

    // Getter dan Setter (Enkapsulasi)
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalJadwal() {
        return totalJadwal;
    }

    public int getTotalTepatWaktu() {
        return totalTepatWaktu;
    }
}

