// Subclass OrangTuaBalita mewarisi Pengguna (Konsep Pewarisan & Polimorfisme)
public class OrangTuaBalita extends Pengguna {
    private String namaBalita;
    private int usiaBulan;

    public OrangTuaBalita(String id, String nama, String noHp, String email, String namaBalita, int usiaBulan) {
        super(id, nama, noHp, email);
        this.namaBalita = namaBalita;
        this.usiaBulan = usiaBulan;
    }

    @Override
    public String getPeran() {
        return "Orang Tua Balita";
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("-------------------------------------------------------");
        System.out.println("ID Pengguna       : " + getId());
        System.out.println("Nama Pengguna     : " + getNama());
        System.out.println("Kategori Peran    : " + getPeran());
        System.out.println("Kontak HP         : " + getNoHp());
        System.out.println("Email             : " + getEmail());
        System.out.println("Nama Balita       : " + namaBalita);
        System.out.println("Usia Balita       : " + usiaBulan + " bulan");
        System.out.printf("Tingkat Kepatuhan : %.1f%% (%d/%d tepat waktu)\n",
                hitungPersentaseKepatuhan(), getTotalTepatWaktu(), getTotalJadwal());
        System.out.println("-------------------------------------------------------");
    }

    public String getNamaBalita() {
        return namaBalita;
    }

    public int getUsiaBulan() {
        return usiaBulan;
    }
}

