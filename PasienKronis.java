// Subclass PasienKronis mewarisi Pengguna (Konsep Pewarisan & Polimorfisme)
public class PasienKronis extends Pengguna {
    private String jenisPenyakit;

    public PasienKronis(String id, String nama, String noHp, String email, String jenisPenyakit) {
        super(id, nama, noHp, email);
        this.jenisPenyakit = jenisPenyakit;
    }

    @Override
    public String getPeran() {
        return "Pasien Kronis";
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("-------------------------------------------------------");
        System.out.println("ID Pengguna       : " + getId());
        System.out.println("Nama Pasien       : " + getNama());
        System.out.println("Kategori Peran    : " + getPeran());
        System.out.println("Kontak HP         : " + getNoHp());
        System.out.println("Email             : " + getEmail());
        System.out.println("Riwayat Penyakit  : " + jenisPenyakit);
        System.out.printf("Tingkat Kepatuhan : %.1f%% (%d/%d tepat waktu)\n",
                hitungPersentaseKepatuhan(), getTotalTepatWaktu(), getTotalJadwal());
        System.out.println("-------------------------------------------------------");
    }

    public String getJenisPenyakit() {
        return jenisPenyakit;
    }
}

