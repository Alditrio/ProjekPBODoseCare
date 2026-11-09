// Subclass Lansia mewarisi Pengguna (Konsep Pewarisan & Polimorfisme)
public class Lansia extends Pengguna {
    private String namaPendamping;
    private String kontakPendamping;

    public Lansia(String id, String nama, String noHp, String email, String namaPendamping, String kontakPendamping) {
        super(id, nama, noHp, email);
        this.namaPendamping = namaPendamping;
        this.kontakPendamping = kontakPendamping;
    }

    @Override
    public String getPeran() {
        return "Lansia";
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("-------------------------------------------------------");
        System.out.println("ID Pengguna       : " + getId());
        System.out.println("Nama Pasien       : " + getNama());
        System.out.println("Kategori Peran    : " + getPeran());
        System.out.println("Kontak HP         : " + getNoHp());
        System.out.println("Email             : " + getEmail());
        System.out.println("Nama Pendamping   : " + namaPendamping);
        System.out.println("Kontak Pendamping : " + kontakPendamping);
        System.out.printf("Tingkat Kepatuhan : %.1f%% (%d/%d tepat waktu)\n",
                hitungPersentaseKepatuhan(), getTotalTepatWaktu(), getTotalJadwal());
        System.out.println("-------------------------------------------------------");
    }

    public String getNamaPendamping() {
        return namaPendamping;
    }

    public String getKontakPendamping() {
        return kontakPendamping;
    }
}

