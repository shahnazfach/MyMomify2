package com.shahnazfachri.mymomify;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.shahnazfachri.mymomify.Adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class insightmenu extends AppCompatActivity{

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insightmenu);


        expListView = findViewById(R.id.expLV);
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                return false;
            }
        });

    }
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Kehamilan normal");
        listDataHeader.add("Apakah normal bila vagina mengeluarkan cairan selama hamil?");
        listDataHeader.add("Berapa berat badan ideal selama hamil?");
        listDataHeader.add("Masalah umum seputar kehamilan");
        listDataHeader.add("Apakah persalinan akan merusak vagina?");
        listDataHeader.add("Olahraga apa yang baik selama kehamilan?");
        listDataHeader.add("Makanan apa yang harus dikonsumsi atau dihindari?");
        listDataHeader.add("Apakah normal jika ibu hamil merasa kram atau mengalami pendarahan?");
        listDataHeader.add("Kondisi apa yang mengharuskan segera hubungi dokter?");
        listDataHeader.add("Apakah Mama merasa khawatir terhadap janin di dalam kandungan ketika melakukan hubungan intim?");
        listDataHeader.add("Bagaimana penanganan siklus haid tdk lancar?");
        listDataHeader.add("Apakah penyebab keguguran & bagaimana mengatasinya? ");
        listDataHeader.add("Bagaimana cara penanganan morning sickness pada awal kehamilan?");
        listDataHeader.add("Bagaimana mengetahui penyebab kehamilan beresiko tinggi?");
        listDataHeader.add("Apa yang harus diketahui selama persalinan dan melahirkan?");
        listDataHeader.add("Apa nutrisi untuk ibu hamil?");
        listDataHeader.add("Apa aktifitas fisik untuk ibu hamil?");
        listDataHeader.add("Apa saja tanda bahaya kehamilan?");



        // Adding child data
        List<String> NormalPregnant = new ArrayList<>();
        NormalPregnant.add("Gejala kehamilan normal yang umum biasanya terjadi perdarahan ringan dari vagina yang normal terjadi biasanya berlangsung selama 1–2  hari atau beberapa jam saja. \n" + "\n"+
                "Kemudian terjadinya Morning sickness, kondisi ini sering disertai dengan keluhan sering meludah. Tanda kehamilan normal ini sering muncul di trimester awal kehamilan, namun sebagian ibu hamil ada yang masih mengalami morning sickness hingga akhir trimester kedua." +
                "Lalu gejala yang ketiga salah satu tanda kehamilan normal yang dirasakan oleh hampir setiap ibu hamil adalah  payudara yang menjadi kencang dan padat, serta terkadang terasa nyeri saat disentuh. \n" + "\n"+
                "Kemudian Ketika kondisi kehamilan Bumil normal dan sehat, biasanya Bumil akan mulai merasakan gerakan janin di saat usia kehamilan memasuki trimester kedua atau tepatnya di usia kehamilan16–25 minggu. Janin yang bergerak secara berkala adalah tanda bahwa janin dalam kondisi sehat. " +
                "Lalu berat badan naik secara bertahap mulai dari 1–2 kg pada trimester pertama dan terus bertambah sekitar 0,5–1 kg di setiap minggu berikutnya.");


        List<String> Vagin = new ArrayList<>();
        Vagin.add("Asalkan keputihan atau cairan yang keluar dari vagina jumlahnya sedikit, berwarna bening atau sedikit putih (mirip putih telur),\n" +
                "\n" +
                "dan tidak berbau menyengat, maka hal tersebut merupakan hal yang normal terjadi." +
                "Namun, jika cairan yang keluar berwarna hijau atau kekuningan, \n" + "\n"+
                "berbau tidak sedap, disertai darah, dan rasa gatal atau nyeri pada vagina," +
                "Bumil sebaiknya segera memeriksakan diri ke dokter kandungan.");


                List<String> Ideal = new ArrayList<>();
        Ideal.add("Sebagian ibu hamil mungkin sungkan atau enggan menanyakan hal tersebut ke dokter." +
                "Padahal, topik ini penting untuk di diskusikan karena berat badan merupakan aspek penting dalam kehamilan sehat. " +
                "Berat badan ideal pada tiap ibu hamil tidak sama, tergantung usia kehamilan dan berat badan sebelum hamil. " +
                "Oleh karena itu, akan lebih baik jika Bumil menanyakan langsung tentang berapa berat badan ideal selama hamil ke dokter kandungan. \n");

        List<String> common = new ArrayList<>();
        common.add("sejumlah masalah yang paling umum dialami oleh ibu hamil di tiap usia kehamilan beserta penyebabnya, yaitu: \n" +
                "\n" +
                "   - Sembelit: Ibu hamil biasanya akan mengalami sembelit alias susah BAB di trimester pertama kehamilan, Mengutip dari American Pregnancy, sembelit atau konstipasi pada ibu hamil disebabkan oleh perubahan hormon dan tekanan dari rahim yang menekan usus. \n" + "\n" +
                "   - Kaki kram: Kram kaki pada malam hari sering menjadi keluhan ibu hamil selama trimester kedua, baik hamil anak laki-laki atau perempuan. Kram disebabkan oleh beban tambahan yang dibawa ibu saat kehamilan yang membuat otot menjadi tegang. " +
                "   - Perut kram: Biasanya kram atau nyeri ini dimulai pada trimester kedua kehamilan. Kram sering dialami saat berolahraga, setelah bangun dari tempat tidur atau kursi, bersin, batuk, ketawa, atau saat membuat gerakan tiba-tiba atau aktivitas lainnya. \n"+ "\n" +
                "   - Tangan dan kaki bengkak: Ibu hamil juga sering mengalami keluhan berupa kaki dan tangan bengkak, termasuk jari-jarinya. Hal ini disebabkan karena peningkatan cairan tubuh saat sedang hamil. " +
                "   - Sakit punggung: Mengutip dari Pregnancy Birth Baby, kehamilan membuat ligamen yang menghubungkan antar tulang menjadi lebih lunak dan meregang untuk mempersiapkan persalinan.\n" + "\n");

        List<String> shorte= new  ArrayList<>();
        shorte.add("Tentu saja tidak. Setelah melahirkan, vagina memang akan menjadi lebih longgar dan terluka karena baru saja menjadi jalan lahir bayi. " +
                "Namun, bukan berarti hal tersebut membuat vagina rusak. Setelah beberapa waktu, luka pada jalan lahir akan membaik. \n" + "\n" +
                "Untuk membuat otot-otot vagina kembali mengencang, ibu yang sudah melahirkan bisa melakukan senam Kegel secara rutin sebanyak 4-6 kali sehari. Senam Kegel sangat mudah dilakukan. Caranya adalah dengan membuat otot dasar panggul berkontraksi seolah-olah sedang menahan kencing selama beberapa detik. Setelah itu, lemaskan otot kembali.\n");

        List<String> lasting = new  ArrayList<>();
        lasting.add("Tetap aktif selama kehamilan membuat Bunda dan bayi tetap sehat dan membantu mengurangi gejala kehamilan, mulai dari mudah beser hingga kecemasan. Terlebih lagi, banyak kegiatan kebugaran yang aman dalam kehamilan. \n" +
                "Jika Anda seorang yang teratur di kelas tertentu sebelum hamil, kemungkinan Anda tetap melanjutkan olahraga selama kehamilan, meskipun Anda harus memastikan untuk memeriksakan diri ke dokter terlebih dahulu. Secara umum, Anda harus sedikit ekstra hati-hati, kata Kristina Mixer, M.D., OB-GYN dengan Spectrum Health United Hospital di Greenville, MI, dilansir Very Well Family. \n");

        List<String> irregular = new  ArrayList<>();
        irregular.add("Pola makan bergizi, makanan lengkap sangat ideal. Dokter Bunda kemungkinan akan meresepkan vitamin prenatal. \n" +
                "\n" +
                "Anda harus berusaha mendapatkan 1500 mg kalsium antara pola makan dan suplemen, kata Karen Deighan, M.D., associate professor department obstetrics and gynecology, Loyola University, Chicago.\n" +
                "\n" +
                "Makanan apa yang harus dihindari?\n" +
                "\n"+
                "Hindari ikan mentah, keju lunak, susu atau jus yang tidak dipasteurisasi, dan beberapa ikan yang mungkin mengandung merkuri tinggi, demikian menurut Deighan.\n");

        List<String> prenatal = new  ArrayList<>();
        prenatal.add("Beberapa kram atau bercak adalah normal pada trimester pertama, sebagai implan telur yang dibuahi dan mulai tumbuh di dalam rahim\n" +
                "\n" +
                "Namun, jika mengalami kram dan / atau perdarahan yang persisten, Bunda harus menghubungi dokter. Ia menambahkan, karena itu bisa jadi tanda infeksi vagina atau rahim, bahkan sesuatu yang lebih serius seperti kehamilan ektopik.\n");

        List<String> relieve= new  ArrayList<>();
        relieve.add("Bagi banyak ibu hamil, pertanyaan besarnya adalah apa yang normal, dan apa yang tidak. \n" +
                "\n" +
                "Pada salah satu kunjungan pertama, Bunda harus bertanya kepada dokter kandungan soal ini. Bunda perlu tahu gejala yang normal atau tidak normal selama kehamilan.\n");
        List<String> intim= new  ArrayList<>();
        intim.add("Melakukan hubungan intim di usia kehamilan trimester pertama masih terbilang nyaman, karena kondisi perut belum terlalu besar. \n" + "\n" +
                "Nah, pertanyaan saat konsultasi kehamilan selanjutnya adalah tentang cara berhubungan seks yang benar. \n"+ "\n" +
                "Jika selama kehamilan Mama dinyatakan sehat oleh dokter, maka boleh-boleh saja berhubungan intim pada saat hamil. Namun tetap memerhatikan beberapa hal, salah satunya adalah posisi.\n"+ "\n" +
                "dan jika memungkinkan suami menggunakan kontrasepsi kondom saat berhubungan untuk mencegah terjadinya kontraksi pada ibu karena sperma dapat merangsang kontraksi.\n");

        List<String> haid= new  ArrayList<>();
        haid.add("Penanganan tergantung penyebab kenapa siklus haid nya tidak lancar. \n" +
                "\n");

        List<String> misbirth= new  ArrayList<>();
        misbirth.add("Banyak keadaan atau penyakit yang dapat mengakibatkan keguguran, antara lain : kelainan kromosom, infeksi (Toksoplasma, CMV, Rubella), kelainan imunologi (APS), kelainan darah," +
                "ketidak cocokan golongan darah ibu - janin, kelinan hormon, kelainan bentuk rahim dan mulut rahim, faktor usia ibu dan suami, pola hidup yang tidak sehat.\n" +
                "\n"+
                "Untuk mencegah terjadinya keguguran berulang tentunya harus dicari dan diatasi sesuai penyebabnya.\n");

        List<String> morningsicknees= new  ArrayList<>();
        morningsicknees.add("- Beristirahat dengan cukup karena kelelahan dapat memperparah morning sickness. \n" +
                "    - Ketika bangun tidur di pagi hari, sebelum beranjak dari tempat tidur, cobalah langsung makan sedikit roti kering atau biskuit. Lakukan juga ketika terbangun pada malam hari. \n" +
                "    - Minum air putih yang cukup pada pagi hari bisa membantu mengurangi rasa mual. \n" +
                "    - Sebaiknya jangan makan makanan yang panas, karena aromanya akan lebih tercium dibanding ketika makanannya sudah lebih dingin.\n" +
                "    - Pilihlah makanan yang tinggi kandungan protein dan karbohidrat serta mudah dicerna, misalnya keju, kraker, susu dan yoghurt, selai kacang, atau apel. \n" +
                "    - Ibu hamil dapat berjalan-jalan di luar rumah pada pagi hari atau sore hari untuk mendapat udara segar. Jangan lupa untuk membuka jendela agar sirkulasi udara di dalam rumah baik. \n" +
                "    - Jangan terlalu memikirkan morning sickness. Alihkan perhatian Anda pada aktivitas ringan yang menyenangkan. \n");

        List<String> resiko= new  ArrayList<>();
        resiko.add("penyebab kehamilan berisiko tinggi: " +
                "Mama dengan penyakit penyerta (asthma, diabetes, kelainan jantung, dan sebagainya). " +
                "Hamil dengan penyakit penyulit (pre-eklamsia, eklamsia, enfeksi, dan sebaginya). \n" + "\n"+
                "Usia ibu hamil juga mempengaruhi kehamilan berisiko tinggi. " +
                "Kekurangan zat gizi makro dan mikro. \n"+ "\n"+
                "Tidak hanya itu, Mama juga perlu mengetahui tanda bahaya pada kehamilan yang bisa menyebabkan kehamilan berisiko tinggi.\n"+ "\n"+
                "Tanda bahaya diantaranya, keluar cairan berlebih atau perdarahan pada vagina, nyeri pada perut, nyeri pada ulu hati, muntah yang terus menerus, bengkak pada wajah dan tangan, nyeri kepala hebat dan menetap, demam melebihi suhu 38 derajat celcius yang disertai menggigil, dan jumlah urin yang berkurang. \n"+
                "Jika Mama mengalami hal-hal yangs sudah disebutkan, ada kemungkinan Mama mengalami kehamilan berisiko tinggi. Sebaiknya konsultasikan pada dokter spesialis kandungan ya, Ma.\n");

        List<String> pregnant= new  ArrayList<>();
        pregnant.add("Persalinan dan melahirkan bisa sangat bervariasi, tergantung pada tempat Bunda melahirkan. Apakah itu di rumah sakit, di bidan, atau di rumah. " +
                "Jelang melahirkan, perawat atau bidan akan lebih sering melakukan pemeriksaan serviks untuk menentukan dilatasi dan penipisan serviks.  \n" + "\n" +
                "Ia juga bisa merekomendasikan intervensi untuk keselamatan Bunda dan bayi. \n");

        List<String> nutrisi= new  ArrayList<>();
        nutrisi.add("- Mengonsumsi aneka ragam makanan yang lebih banyak. \n" +
                "       Ibu hamil perlu mengonsumsi aneka ragam makanan yang lebih banyak untuk memenuhi kebutuhan energi, protein dan zat gizi mikro (vitamin dan mineral). \n" +
                "    - Vitamin \n" +
                "       Buah berwarna merupakan sumber vitamin yang baik bagi tubuh dan buah yang berserat karena dapat melancarkan buang air besar sehingga mengurangi risiko sembelit pada ibu hamil.\n" +
                "    - Protein \n" +
                "       Untuk pertumbuhan janin dan untuk mempertahankan kesehatan ibu. Ibu hamil sangat dianjurkan untuk mengonsumsi makanan sumber protein. Kebutuhan protein pada ibu hamil bertambah, akan tetapi tidak boleh berlebihan \n" +
                "       Konsumsi protein lebih baik didapat dari sumber makanan seperti daging, telur, ikan maupun susu. Kebutuhan protein pada ibu hamil rata-rata 60 – 75 gram/hari. \n" +
                "    - Energi \n" +
                "       Selain protein, energi juga sangat penting diperlukan oleh ibu hamil diantaranya untuk proses pertumbuhan dan perkembangan janin dan tubuh ibu, juga efektif untuk menurunkan kejadian BBLR dan kematian perinatal.Kebutuhan kalori pada ibu hamil bertambah 285 - 300 kalori/hari. \n" +
                "    - Zat Besi \n" +
                "       Ibu hamil rentan menderita anemia karena adanya peningkatan volume darah merah 20 – 30 % dan plasma 50 % sehingga darah menjadi encer, karena untuk pembentukan plasenta, janin dan cadangan zat besi dalam ASI. \n" +
                "    - Asam Folat \n" +
                "       Sayuran hijau seperti bayam dan kacang-kacangan banyak mengandung asam folat yang sangat diperlukan pada masa kehamilan. Waktu pemberian asam folat dimulai dari dua bulan sebelum konsepsi dan berlanjut sampai trimester I kehamilan. \n"+
                "    -Kalsium \n" +
                "       Kebutuhan kalsium untuk janin diambil dari ibunya, janin tidak akan kekurangan karena suplai kalsium yang tidak mencukupi membuat janin mengambil cadangan kalsium dari tulang ibunya. \n" +
                "       Pada daerah dengan intake kalsium yang rendah direkomendasikan pemberian suplementasi tablet kalsium pada ibu hamil sebesar 1.500 -2.000 mg secara oral dibagi dalam 3x pemberian per hari. \n" +
                "       Interaksi dapat terjadi antara suplemen  kalsium dan besi. Kalsium dapat mengganggu penyerapan zat besi di saluran pencernaan, sehingga minum kalsium tidak boleh bersamaan dengan tablet zat besi. Oleh karena harus ada jarak pemberian selama beberapa jam. \n" +
                "    -Iodium \n" +
                "       Iodium merupakan bagian hormon tiroksin (T4) dan triodotironin (T3) yang berfungsi untuk mengatur pertumbuhan dan perkembangan bayi. Sumber iodium yang baik adalah makanan laut seperti ikan, udang, kerang, rumput laut. Setiap memasak diharuskan menggunakan garam beriodium. \n" );


        List<String> aktifitas= new  ArrayList<>();
        aktifitas.add("Ibu hamil yang sehat dapat melakukan aktivitas fisik sehari-hari dengan memperhatikan kondisi ibu dan keamanan janin yang dikandungnya.  \n" +
                "Menjaga kondisi kesehatan ibu hamil dengan tetap melakukan aktivitas fisik selama kurang lebih 30 menit dengan ringan sampai sedang dan menghindari gerakan-gerakan yang membahayakan seperti mengangkat benda-benda berat, jalan dengan sepatu/sandal hak tinggi atau sepatu/sandal licin, jongkok lebih dari 90 derajat, mengejan. \n" +
                "Berikut aktivitas fisik dan latihan fisik yang diperbolehkan pada ibu hamil:  \n" +
                "   - Aktivitas fisik sehari – hari seperti Belanja, Menyapu, Mencuci dan Berbelanja \n" +
                "   - Latihan fisik ringan seperti Jalan kaki, Senam, dan Peregangan \n" +
                "   - Jenis latihan fisik yang diperbolehkan menurut usia kehamilan sebagai berikut \n" +
                "     a. Trimester I (0 – 12 minggu)  " +
                "        Pemanasan atau stretching, aerobic, kegel exercise, pendinginan/ + stretching \n" +
                "     b. Trimester II (13 – 28 minggu) " +
                "        Pemanasan atau stretching, aerobic, kegel exercise, pendinginan/ + stretching \n" +
                "     c. Trimester III (0 – 12 minggu) " +
                "        Pemanasan atau stretching, kegel exercise, senam hamil, pendinginan/ + stretching \n" +
                "   - Exercise/Senam Hamil \n" +
                "     Dengan mengikuti senam hamil secara teratur dan intensif, ibu hamil dapat menjaga kesehatan tubuh dan janin yang dikandung secara optimal. Senam hamil adalah terapi latihan gerak untuk mempersiapkan ibu hamil, secara fisik atau mental, pada persalinan cepat, aman, dan spontan. \n" );


        List<String> bahaya= new  ArrayList<>();
        bahaya.add("Tanda-Tanda Bahaya Pada Masa Kehamilan:  \n" +
                "   a. Tidak Mau Makan dan Muntah Terus-Menerus \n" +
                "      Mual-muntah memang banyak dialami oleh ibu hamil, terutama ibu hamil pada trimester pertama kehamilan. Namun jika mual-muntah tersebut terjadi terus-menerus dan berlebihan bisa menjadi tanda bahaya pada masa kehamilan. Hal itu dikarenakan dapat menyebabkan kekurangan gizi, dehidrasi, dan penurunan kesadaran. Segera temui dokter jika hal ini terjadi agar mendapatkan penanganan dengan cepat.  \n" +
                "   b. Mengalami Demam Tinggi \n" +
                "      Ibu hamil harus mewaspadai hal ini jika terjadi. Hal ini dikarenakan bisa saja jika demam dipicu karena adanya infeksi. Jika demam terlalu tinggi, ibu hamil harus segera diperiksakan ke rumah sakit untuk mendapatkan pertolongan pertama.\n" +
                "   c. Pergerakan Janin di Kandungan Kurang \n" +
                "      Pergerakan janin yang kurang aktif atau bahkan berhenti merupakan tanda bahaya selanjutnya. Hal ini menandakan jika janin mengalami kekurangan oksigen atau kekurangan gizi. Jika dalam dua jam janin bergerak di bawah sepuluh kali, segera periksakan kondisi tersebut ke dokter\n" +
                "   d. Beberapa Bagian Tubuh Membengkak \n" +
                "      Selama masa kehamilan ibu hamil sering mengalami perubahan bentuk tubuh seperti bertambahnya berat badan. Ibu hamil akan mengalami beberapa pembengkakan seperti pada tangan, kaki dan wajah karena hal tersebut. Namun, jika pembengkakan pada kaki, tangan dan wajah disertai dengan pusing kepala, nyeri ulu hati, kejang dan pandangan kabur segera bawa ke dokter untuk ditangani, karena bisa saja ini pertanda terjadinya pre-eklampsia. \n" +
                "   e. Terjadi Pendarahan \n" +
                "      Ibu hamil harus waspada jika mengalami pendarahan, hal ini bisa menjadi tanda bahaya yang dapat mengancam pada baik pada janin maupun pada ibu. Jika mengalami pendarahan hebat pada saat usia kehamilan muda, bisa menjadi tanda mengalami keguguran. Namun, jika mengalami pendarahan pada usia hamil tua, bisa menjadi pertanda plasenta menutupi jalan lahir. \n" +
                "   f. Air Ketuban Pecah Sebelum Waktunya \n" +
                "      Jika ibu hamil mengalami pecah ketuban sebelum waktunya segera periksakan diri ke dokter, karena kondisi tersebut dapat membahayakan kondisi ibu dan bayi. Hal ini dapat mempermudah terjadinya infeksi dalam kandungan.\n" +
                        "Nah, itulah tanda bahaya pada masa kehamilan yang harus ibu hamil ketahui agar dapat terhindar dari hal-hal yang tidak diinginkan. Jika anda mengalami salah satu atau lebih tanda bahaya tersebut segera hubungi petugas kesehatan yaitu Dokter atau Bidan terdekat.\n" +
                "https://youtu.be/ZlIkayILd7U \n");

        listDataChild.put(listDataHeader.get(0), NormalPregnant); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Vagin);
        listDataChild.put(listDataHeader.get(2), Ideal);
        listDataChild.put(listDataHeader.get(3), common);
        listDataChild.put(listDataHeader.get(4), shorte);
        listDataChild.put(listDataHeader.get(5), lasting);
        listDataChild.put(listDataHeader.get(6), irregular);
        listDataChild.put(listDataHeader.get(7), prenatal);
        listDataChild.put(listDataHeader.get(8), relieve);
        listDataChild.put(listDataHeader.get(9), intim);
        listDataChild.put(listDataHeader.get(10), haid);
        listDataChild.put(listDataHeader.get(11), misbirth);
        listDataChild.put(listDataHeader.get(12), morningsicknees);
        listDataChild.put(listDataHeader.get(13), resiko);
        listDataChild.put(listDataHeader.get(14), pregnant);
        listDataChild.put(listDataHeader.get(15), nutrisi);
        listDataChild.put(listDataHeader.get(16), aktifitas);
        listDataChild.put(listDataHeader.get(17), bahaya);

    }
}



