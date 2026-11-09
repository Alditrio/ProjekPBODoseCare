// Interface untuk layanan medis dan pengingat obat (Konsep Abstraksi)
public interface LayananMedis {
    void kirimPengingat();
    void catatKonsumsi(boolean tepatWaktu);
    boolean cekStokMenipis();
}

