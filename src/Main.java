import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;
    private String universitas;

    // Constructor
    public Mahasiswa(String nama, String nim, String universitas) {
        this.nama = nama;
        this.nim = nim;
        this.universitas = universitas;
    }

    // Method untuk menampilkan detail mahasiswa
    public void tampilDataMahasiswa() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Universitas: " + universitas);
    }

    // Method static untuk menampilkan universitas
    public static void tampilUniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();

        // Membuat array untuk menyimpan objek Mahasiswa
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan data untuk Mahasiswa ke-" + (i + 1) + ":");
            scanner.nextLine(); // membersihkan newline

            System.out.println("Nama: ");
            String nama = scanner.nextLine();

            System.out.println("NIM: ");
            String nim = scanner.nextLine();
            // Memeriksa panjang NIM
            while (nim.length() != 15) {
                System.out.println("Panjang NIM harus 15 angka. Masukkan NIM kembali: ");
                nim = scanner.nextLine();
            }

            System.out.println("Universitas: ");
            String universitas = scanner.nextLine();

            // Membuat objek Mahasiswa baru dan menyimpannya ke dalam array
            daftarMahasiswa[i] = new Mahasiswa(nama, nim, universitas);
        }

        System.out.println("\nData Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1) + ":");
            daftarMahasiswa[i].tampilDataMahasiswa();
            System.out.println();
        }

        // Memanggil method static tampilUniversitas dari kelas Mahasiswa
        Mahasiswa.tampilUniversitas();

        scanner.close();
    }
}