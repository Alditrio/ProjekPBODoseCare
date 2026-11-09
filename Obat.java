// Kelas Obat mengimplementasikan LayananMedis (Konsep Enkapsulasi, Relasi & Interface)
public class Obat implements LayananMedis {
    private String namaObat;
    private String dosis;
    private String aturanMinum;
    private String waktuMinum;
    private int stok;
    private int batasMinimum;
    private Pengguna pengguna;

    public Obat(String namaObat, String dosis, String aturanMinum, String waktuMinum, int stok, int batasMinimum, Pengguna pengguna) {
        this.namaObat = namaObat;
        this.dosis = dosis;
        this.aturanMinum = aturanMinum;
        this.waktuMinum = waktuMinum;
        this.stok = stok;
        this.batasMinimum = batasMinimum;
        this.pengguna = pengguna;
        if (pengguna != null) {
            pengguna.tambahJadwal();
        }
    }

    @Override
    public void kirimPengingat() {
        System.out.println("  [PENGINGAT MEDIS]");
        System.out.println("  Hai " + (pengguna != null ? pengguna.getNama() : "Pasien") + "!");
        System.out.println("  Waktunya minum obat : " + namaObat + " (" + dosis + ")");
        System.out.println("  Aturan Minum        : " + aturanMinum);
        System.out.println("  Jadwal Waktu        : " + waktuMinum);
        System.out.println("  Sisa Stok Saat Ini  : " + stok + " unit");
        if (cekStokMenipis()) {
            System.out.println("  PERINGATAN: Stok obat ini hampir habis! Segera lakukan restock.");
        }
    }

    @Override
    public void catatKonsumsi(boolean tepatWaktu) {
        if (stok <= 0) {
            System.out.println("  [GAGAL] Stok " + namaObat + " habis! Tidak dapat meminum obat.");
            return;
        }
        stok--;
        if (pengguna != null) {
            pengguna.catatMinumObat(tepatWaktu);
        }
        System.out.println("  [BERHASIL] 1 dosis " + namaObat + " telah diminum (" + (tepatWaktu ? "Tepat Waktu" : "Terlambat") + ").");
        System.out.println("  Sisa stok obat sekarang: " + stok + " unit.");
        if (cekStokMenipis()) {
            System.out.println("  [PERINGATAN] Stok obat mencapai batas minimum (" + batasMinimum + ")!");
        }
    }

    @Override
    public boolean cekStokMenipis() {
        return stok <= batasMinimum;
    }

    public void restock(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
            System.out.println("  [SUKSES] Restock " + namaObat + " sebanyak " + jumlah + " unit berhasil! Total stok: " + this.stok);
        } else {
            System.out.println("  [GAGAL] Jumlah penambahan stok harus lebih dari 0.");
        }
    }

    public void tampilkanDetail() {
        String namaPasien = pengguna != null ? pengguna.getNama() : "-";
        String statusStok = cekStokMenipis() ? "[MENIPIS]" : "[AMAN]";
        System.out.printf("  %-14s | %-10s | %-18s | %-8s | %-4d unit | %-9s | Pasien: %s\n",
                namaObat, dosis, aturanMinum, waktuMinum, stok, statusStok, namaPasien);
    }

    public String getNamaObat() {
        return namaObat;
    }

    public int getStok() {
        return stok;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }
}

