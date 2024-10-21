package pertemuan8;

import java.util.Scanner;


class Barang {
    String kode;
    String nama;
    int harga;

    public Barang(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }
}

class Transaksi {
    Barang barang;
    int jumlahBeli;
    int jumlahBayar;

    public Transaksi(Barang barang, int jumlahBeli) {
        this.barang = barang;
        this.jumlahBeli = jumlahBeli;
        this.jumlahBayar = barang.harga * jumlahBeli;
    }
}

public class TokoSerbaAda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barang[] daftarBarang = {
            new Barang("001", "Pulpen", 5000),
            new Barang("002", "Buku", 8000),
            new Barang("003", "Pensil", 3000),
            new Barang("004", "Spidol", 10000),
            new Barang("005", "Penghapus", 3000)
        };

        System.out.print("Masukkan Item Barang: ");
        int jumlahBarang = scanner.nextInt();
        Transaksi[] transaksi = new Transaksi[jumlahBarang];

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("Data ke " + (i + 1));
            System.out.print("Masukkan Kode: ");
            String kode = scanner.next();

            Barang barangDipilih = null;
            for (Barang b : daftarBarang) {
                if (b.kode.equals(kode)) {
                    barangDipilih = b;
                    break;
                }
            }

            if (barangDipilih == null) {
                System.out.println("Kode barang tidak ditemukan!");
                i--; 
                continue;
            }

            System.out.print("Masukkan jumlah beli: ");
            int jumlahBeli = scanner.nextInt();
            transaksi[i] = new Transaksi(barangDipilih, jumlahBeli);
        }

        System.out.println("\nTOKO SERBA ADA");
        System.out.println("=======================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-10s %-15s\n", "No", "Kode", "Nama Barang", "Harga", "Jumlah", "Jumlah Bayar");
        System.out.println("=======================================================================");

        int totalBayar = 0;
        for (int i = 0; i < transaksi.length; i++) {
            Transaksi t = transaksi[i];
            System.out.printf("%-5d %-10s %-15s %-10d %-10d %-15d\n", 
                (i + 1), t.barang.kode, t.barang.nama, t.barang.harga, t.jumlahBeli, t.jumlahBayar);
            totalBayar += t.jumlahBayar;
        }

        System.out.println("======================================================================");
        System.out.printf("%-54s %-25d\n", "Total Bayar", totalBayar);
        System.out.println("======================================================================");
    }
}