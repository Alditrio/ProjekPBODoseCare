import java.util.ArrayList;
import java.util.Scanner;

// Kelas Utama Aplikasi Terminal DoseCare - Projek Mata Kuliah Pemrograman Berorientasi Objek
public class Main {
    private static final ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    private static final ArrayList<Obat> daftarObat = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiDataAwal();

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n=======================================================");
            System.out.println("   SISTEM MANAJEMEN PENGINGAT OBAT DOSECARE (CLI)");
            System.out.println("   Projek Mata Kuliah Pemrograman Berorientasi Objek");
            System.out.println("=======================================================");
            System.out.println("1. Tampilkan Profil Pasien/Pengguna (Polimorfisme)");
            System.out.println("2. Tampilkan Pengingat & Jadwal Obat (Interface)");
            System.out.println("3. Konfirmasi Minum Obat (Catat Kepatuhan & Stok)");
            System.out.println("4. Restock Obat");
            System.out.println("5. Tambah Pasien Baru (Lansia / Kronis / Balita)");
            System.out.println("6. Tambah Jadwal & Obat Baru");
            System.out.println("0. Keluar");
            System.out.println("=======================================================");
            System.out.print("Pilih menu (0-6): ");

            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1" -> tampilkanSemuaPengguna();
                case "2" -> kirimSemuaPengingat();
                case "3" -> menuKonfirmasiMinum();
                case "4" -> menuRestockObat();
                case "5" -> menuTambahPengguna();
                case "6" -> menuTambahObat();
                case "0" -> {
                    System.out.println("Terima kasih telah menggunakan sistem DoseCare CLI!");
                    berjalan = false;
                }
                default -> System.out.println("[ERROR] Pilihan menu tidak valid!");
            }
        }
    }

    private static void inisialisasiDataAwal() {
        // Objek konkret dari turunan kelas abstrak Pengguna (Pewarisan & Polimorfisme)
        Lansia sari = new Lansia("P01", "Sari Rahayu", "081200000001", "sari@dosecare.com", "Budi Rahayu", "081200000011");
        PasienKronis budi = new PasienKronis("P02", "Budi Santoso", "081200000002", "budi@dosecare.com", "Diabetes Melitus Tipe 2");
        OrangTuaBalita aya = new OrangTuaBalita("P03", "Aya Prasetya", "081200000003", "aya@dosecare.com", "Alya Prasetya", 10);

        daftarPengguna.add(sari);
        daftarPengguna.add(budi);
        daftarPengguna.add(aya);

        // Objek Obat yang mengimplementasikan interface LayananMedis
        daftarObat.add(new Obat("Ramipril", "1 tablet", "Setelah sarapan", "08:00 WIB", 12, 5, sari));
        daftarObat.add(new Obat("Metformin", "500 mg", "Bersama makan pagi", "07:30 WIB", 15, 5, budi));
        daftarObat.add(new Obat("Paracetamol", "5 ml sirup", "Bila demam / nyeri", "12:00 WIB", 2, 3, aya)); // Stok menipis

        // Simulasi kepatuhan awal
        sari.catatMinumObat(true);
        budi.catatMinumObat(true);
    }

    private static void tampilkanSemuaPengguna() {
        System.out.println("=== DAFTAR PROFIL PASIEN / PENGGUNA (POLIMORFISME) ===");
        // Pemanggilan method polimorfik tampilkanProfil()
        for (Pengguna p : daftarPengguna) {
            p.tampilkanProfil();
        }
    }

    private static void kirimSemuaPengingat() {
        System.out.println("=== DAFTAR PENGINGAT & STATUS STOK OBAT ===");
        System.out.println("Daftar Obat Terdaftar:");
        for (int i = 0; i < daftarObat.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarObat.get(i).tampilkanDetail();
        }
        System.out.println();

        System.out.println("Eksekusi Pengingat Medis (Interface LayananMedis):");
        for (Obat o : daftarObat) {
            o.kirimPengingat();
            System.out.println("-------------------------------------------------------");
        }
    }

    private static void menuKonfirmasiMinum() {
        System.out.println("=== KONFIRMASI MINUM OBAT ===");
        if (daftarObat.isEmpty()) {
            System.out.println("Belum ada obat terdaftar.");
            return;
        }

        for (int i = 0; i < daftarObat.size(); i++) {
            Obat o = daftarObat.get(i);
            String namaPasien = o.getPengguna() != null ? o.getPengguna().getNama() : "-";
            System.out.println((i + 1) + ". " + o.getNamaObat() + " (Pasien: " + namaPasien + ", Sisa stok: " + o.getStok() + ")");
        }

        System.out.print("Pilih nomor obat (1-" + daftarObat.size() + "): ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (idx >= 0 && idx < daftarObat.size()) {
                System.out.print("Apakah diminum tepat waktu? (y/n) [Enter: y]: ");
                String tepat = scanner.nextLine().trim();
                boolean tepatWaktu = !tepat.equalsIgnoreCase("n");

                daftarObat.get(idx).catatKonsumsi(tepatWaktu);
            } else {
                System.out.println("[ERROR] Nomor obat tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Masukkan angka yang benar!");
        }
    }

    private static void menuRestockObat() {
        System.out.println("=== RESTOCK OBAT ===");
        for (int i = 0; i < daftarObat.size(); i++) {
            Obat o = daftarObat.get(i);
            System.out.println((i + 1) + ". " + o.getNamaObat() + " (Stok sekarang: " + o.getStok() + ")");
        }

        System.out.print("Pilih nomor obat (1-" + daftarObat.size() + "): ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (idx >= 0 && idx < daftarObat.size()) {
                System.out.print("Masukkan jumlah penambahan stok: ");
                int qty = Integer.parseInt(scanner.nextLine().trim());
                daftarObat.get(idx).restock(qty);
            } else {
                System.out.println("[ERROR] Nomor obat tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Masukkan angka yang valid!");
        }
    }

    private static void menuTambahPengguna() {
        System.out.println("=== TAMBAH PASIEN / PENGGUNA BARU ===");
        System.out.println("1. Lansia");
        System.out.println("2. Pasien Kronis");
        System.out.println("3. Orang Tua Balita");
        System.out.print("Pilih kategori (1-3): ");
        String jenis = scanner.nextLine().trim();

        System.out.print("ID Pasien (contoh: P04) : ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama Lengkap           : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Nomor HP               : ");
        String hp = scanner.nextLine().trim();
        System.out.print("Email                  : ");
        String email = scanner.nextLine().trim();

        switch (jenis) {
            case "1" -> {
                System.out.print("Nama Pendamping        : ");
                String pendamping = scanner.nextLine().trim();
                System.out.print("Kontak Pendamping      : ");
                String kontak = scanner.nextLine().trim();
                daftarPengguna.add(new Lansia(id, nama, hp, email, pendamping, kontak));
                System.out.println("[SUKSES] Pasien Lansia berhasil ditambahkan!");
            }
            case "2" -> {
                System.out.print("Riwayat Penyakit Kronis: ");
                String penyakit = scanner.nextLine().trim();
                daftarPengguna.add(new PasienKronis(id, nama, hp, email, penyakit));
                System.out.println("[SUKSES] Pasien Kronis berhasil ditambahkan!");
            }
            case "3" -> {
                System.out.print("Nama Anak Balita       : ");
                String balita = scanner.nextLine().trim();
                System.out.print("Usia Balita (bulan)    : ");
                int usia = Integer.parseInt(scanner.nextLine().trim());
                daftarPengguna.add(new OrangTuaBalita(id, nama, hp, email, balita, usia));
                System.out.println("[SUKSES] Data Orang Tua Balita berhasil ditambahkan!");
            }
            default -> System.out.println("[ERROR] Kategori tidak valid!");
        }
    }

    private static void menuTambahObat() {
        System.out.println("=== TAMBAH JADWAL OBAT BARU ===");
        if (daftarPengguna.isEmpty()) {
            System.out.println("[ERROR] Belum ada pasien terdaftar!");
            return;
        }

        System.out.println("Pilih Pasien Penanggung Jawab:");
        for (int i = 0; i < daftarPengguna.size(); i++) {
            Pengguna p = daftarPengguna.get(i);
            System.out.println((i + 1) + ". " + p.getNama() + " (" + p.getPeran() + ")");
        }
        System.out.print("Pilih nomor pasien: ");
        int idxPasien = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (idxPasien < 0 || idxPasien >= daftarPengguna.size()) {
            System.out.println("[ERROR] Pasien tidak valid!");
            return;
        }
        Pengguna pasien = daftarPengguna.get(idxPasien);

        System.out.print("Nama Obat              : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Dosis (contoh: 1 tablet): ");
        String dosis = scanner.nextLine().trim();
        System.out.print("Aturan Minum (contoh: Sesudah makan): ");
        String aturan = scanner.nextLine().trim();
        System.out.print("Waktu Minum (contoh: 08:00 WIB)     : ");
        String waktu = scanner.nextLine().trim();
        System.out.print("Jumlah Stok Awal       : ");
        int stok = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Batas Minimum Stok     : ");
        int min = Integer.parseInt(scanner.nextLine().trim());

        daftarObat.add(new Obat(nama, dosis, aturan, waktu, stok, min, pasien));
        System.out.println("[SUKSES] Jadwal dan stok obat " + nama + " berhasil ditambahkan untuk " + pasien.getNama() + "!");
    }
}

