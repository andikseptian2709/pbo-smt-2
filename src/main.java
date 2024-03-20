import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data diri
        System.out.println("Masukkan nama:");
        String nama = scanner.nextLine();

        System.out.println("Masukkan jenis kelamin (P/L):");
        String jenisKelaminInput = scanner.nextLine();
        String jenisKelamin = jenisKelaminInput.equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan";

        System.out.println("Masukkan tanggal lahir (yyyy-MM-dd):");
        String tanggalLahirString = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString, DateTimeFormatter.ISO_DATE);

        // Menghitung umur
        LocalDate tanggalSekarang = LocalDate.now();
        int umur = tanggalSekarang.getYear() - tanggalLahir.getYear();

        // Output data diri dan umur
        System.out.println("Data Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Tanggal Lahir: " + tanggalLahir.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println("Umur: " + umur + " tahun");

        scanner.close();
    }
}