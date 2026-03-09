# 04 - Smart Bank Console 🏦

Bu proje, Java ile geliştirilmiş temel bir bankacılık kayıt simülasyonudur. Projenin ana odak noktası **veri doğrulaması (validation)** ve **hata yönetimidir**.

## 🚀 Özellikler
* **Kullanıcı Kaydı:** Kullanıcıdan isim ve başlangıç bakiyesi alınır.
* **Otomatik Hesap Numarası:** Sistem, gerçekçi bir senaryo olarak 16 haneli hesap numarasını otomatik üretir.
* **Akıllı Doğrulama:** * Başlangıç bakiyesi negatif girildiğinde sistem hata verir ve işlemi durdurur (`Guard Clause` prensibi).
    * Üretilen hesap numarasının uzunluğu sistem tarafından otomatik olarak test edilir.

## 🛠️ Teknik Detaylar
* **Dil:** Java
* **Kullanılan Yapılar:** `Scanner`, `Random`, `For Loop`, `Control Flow (if-else/return)`, `String Manipulation`.

## 🧪 Test Senaryoları (Tester Bakış Açısı)
Bir Test Mühendisi adayı olarak projede şu senaryolar kontrol edilmiştir:
1. **Negatif Bakiye Testi:** Kullanıcı `-100` girdiğinde sistemin hesap oluşturup oluşturmadığı kontrol edildi. (Sonuç: Başarıyla engellendi).
2. **Hesap No Uzunluk Testi:** Üretilen numaranın tam 16 karakter olduğu doğrulandı.
3. **Büyük/Küçük Harf Testi:** Kullanıcı ismi çıktı ekranında daha kurumsal görünmesi için otomatik olarak büyük harfe (`toUpperCase`) çevrildi.

---
*Bursa Teknik Üniversitesi - Bilgisayar Mühendisliği öğrencisi olarak Java yolculuğumun 4. projesidir.* 🎓
