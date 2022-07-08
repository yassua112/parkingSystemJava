# ParkingSystem_Spring_Rest

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

Project ini adalah sebuah sistem parkir sederhana. Seperti sistem parkir pada umumnya, sistem parkir yang saya buat ini dapat mencatat setiap transaksi kendaraan yang
parkir. Kemudian ketika kendaraan tersebut sudah keluar dari tempat parkir, maka data transaksi kendaraan tersebut akan masuk kedalam data arsip. Dalam projek saya ini, 
terdapat dua kategori kendaraan yaitu roda 2 dan roda 4 dengan tarif yang berbeda.

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* Spring IoC
* Java Stream
* Native SQL Query

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Installation

Clone the repo
   ```sh
   git clone https://github.com/muhammadtuni/ParkingSystem_Spring_Rest.git
   ```
   
<p align="right">(<a href="#top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage

Cara menjalankan project ini menggunakan Postman(https://www.postman.com/)
<div align="center">
  <a href="https://github.com/muhammadtuni/ParkingSystem_Spring_Rest.git">
    <img src="image/ss postman.png" alt="Logo" width="200" height="200">
  </a>
</div>
  
* All Category (GET)
   ```sh
   {{base_url}}/category
   ```
* Insert Category (POST)
   ```sh
   {{base_url}}/category
   ```
   ```sh
   input body:
   {
    "id" : "id yang ingin di tambah",
    "tarif" : "set tarif",
    "tariflanjut" : "set tarif lanjut"
    }
   ```
* Delete Category (DELETE)
  ```sh
  {{base_url}}/category/{id}
  ```
* Update Category (PUT)
   ```sh
   {{base_url}}/category
   ```
   ```sh
   input body:
   {
    "id" : "id yang ingin di update",
    "tarif" : "set tarif baru",
    "tariflanjut" : "set tarif lanjut baru"
    }
   ```
* Masuk Motor (POST)
   ```sh
   {{base_url}}/transaction/motor
   ```
* Masuk Mobil (POST)
   ```sh
   {{base_url}}/transaction/mobil
   ``` 
* Keluar Parkir (POST)
   ```sh
   {{base_url}}/transaction/keluar?id="masukkan id yang ingin di keluarkan"
   ``` 
* All Transaction (GET)
   ```sh
   {{base_url}}/transaction
   ```  
* All Arsip (GET)
   ```sh
   {{base_url}}/arsip
   ```    
   
{{base_url}} adalah link localhost anda.

<p align="right">(<a href="#top">back to top</a>)</p>

