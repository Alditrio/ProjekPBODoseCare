# ProjekPBODoseCare

Nama : Aldi Trio Prabowo  
NIM  : H1D025027  

Sistem Manajemen Pengingat Obat DoseCare - Tugas Projek Mata Kuliah Pemrograman Berorientasi Objek (PBO)

---

## 📂 Struktur File Program

| Nama File | Keterangan / Konsep PBO |
|---|---|
| `LayananMedis.java` | **Interface**: Mendefinisikan kontrak method abstraksi (`kirimPengingat`, `catatKonsumsi`, `cekStokMenipis`). |
| `Pengguna.java` | **Abstract Class**: Data dasar pasien/pengguna, enkapsulasi, perhitungan kepatuhan, dan method abstrak `tampilkanProfil()`. |
| `Lansia.java` | **Subclass**: Mewarisi `Pengguna` dengan data pendamping lansia dan method overriding. |
| `PasienKronis.java` | **Subclass**: Mewarisi `Pengguna` dengan data riwayat penyakit kronis. |
| `OrangTuaBalita.java` | **Subclass**: Mewarisi `Pengguna` dengan data nama balita dan usia balita. |
| `Obat.java` | **Class Implementasi & Relasi**: Mengimplementasikan `LayananMedis`, relasi dengan `Pengguna`, dosis, jadwal, dan kontrol stok. |
| `Main.java` | **Runner Terminal**: Menu konsol interaktif yang berjalan langsung di terminal IntelliJ IDEA. |

---

## 🧬 Konsep PBO yang Diterapkan

1. **Abstraksi (Abstraction)**: Penggunaan `interface LayananMedis` dan `abstract class Pengguna`.
2. **Pewarisan (Inheritance)**: `Lansia`, `PasienKronis`, dan `OrangTuaBalita` mewarisi `Pengguna`.
3. **Polimorfisme (Polymorphism)**: Overriding `tampilkanProfil()` dan `getPeran()` pada tiap subclass serta pemanggilan dinamis via `ArrayList<Pengguna>`.
4. **Enkapsulasi (Encapsulation)**: Hak akses `private` pada seluruh atribut dengan `getter`, `setter`, dan method bisnis.

---

## 🚀 Cara Menjalankan di IntelliJ IDEA

1. Buka folder ini di **IntelliJ IDEA**.
2. Buka file **`Main.java`**.
3. Klik tombol hijau **▶ Run 'Main'** (atau tekan **Shift + F10**).
4. Menu interaktif akan langsung berjalan di terminal IntelliJ IDEA.
