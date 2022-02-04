


Merhabalar,

Bu proje Harun ISIK tarafından Rise Technology için hazırlanmıştır.

Negatif ve pozitif olmak üzere Amazon alışveriş sitesinde yapılan Functional test senaryolarını
ve bunların WebDriver otomasyon kodunu içerir. OOP kavramları, Page Object Model(POM), singleton driver,
paralel test, test raporlama, hatalı testlerin tekrar otomatik çalışması, istenen ekran görüntülerinin alınması,
dosyadan veri okuma gibi işlevleri sunan java programlama dili ile kodlanmış Maven demo projesidir.

Ekip işbirliğini artırmak için Gherkin diline sahip Cucumber BDD aracı seçildi.
(IDE'nizin plugins kısmından "Gherkin" ve "Cucumber for java" indirebilirsiniz.)

Testlerin farklı ortamlarda(env) kolaylıkla çalışmasını sağlamak için Url,browser ve kullanıcı bilgileri
configuration properties dosyasında saklandı. 

Aynı test senaryosunu farklı veriler ile çalıştırmak için Scenario outline kullanıldı.
Before After methotları Hooks sınıfında saklandı. Tüm metodolojiler bakımı kolay ve dinamik bir 
kod elde etmek üzere yazıldı. Testlerin paralel olarak çalıştırılabilmesi için özel 
bir driver sınıfı oluşturuldu. Maven cucumber report kullanılarak test raporları oluşturuldu.
Başarısız test senaryoları otomatik tekrar çalışacak şekilde ayarlandı ve başarısız test senaryolarının
ekran görüntüleri rapora dahil edilir. Ayrıca başarısız test senaryolarının yolu rerun.txt dosyasına otomatik kaydedilir.



İyi çalışmalar
Sağlıklı ve Mutlu Kalın
Harun ISIK
isikharun@outlook.com

