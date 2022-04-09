package com.example.ramazontaqvim

import java.util.*
internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail = HashMap<String, List<String>>()
            val duolar: MutableList<String> = ArrayList()
            duolar.add("Ro‘za tutish (saharlik, og‘iz yopish) duosi\n" +
                    "\n" +
                    "نَوَيْتُ أَنْ أَصُومَ صَوْمَ شَهْرَ رَمَضَانَ مِنَ الْفَجْرِ إِلَى الْمَغْرِبِ، خَالِصًا لِلهِ تَعَالَى أَللهُ أَكْبَرُ\n" +
                    "\n" +
                    "Navaytu an asuvma sovma shahro ramazona minal fajri ilal mag‘ribi, xolisan lillahi ta'aalaa, Allohu akbar.\n" +
                    "\n" +
                    "Ma'nosi: Ramazon oyining ro‘zasini subhdan to kun botguncha tutmoqni niyat qildim. Xolis Alloh uchun Alloh buyukdir.")


 val duolar2: MutableList<String> = ArrayList()

            duolar2.add("Iftorlik (og‘iz ochish) duosi\n" +
                    "\n" +
                    "اَللَّهُمَّ لَكَ صُمْتُ وَ بِكَ آمَنْتُ وَ عَلَيْكَ تَوَكَّلْتُ وَ عَلَى رِزْقِكَ أَفْتَرْتُ، فَغْفِرْلِى مَا قَدَّمْتُ وَ مَا أَخَّرْتُ بِرَحْمَتِكَ يَا أَرْحَمَ الرَّاحِمِينَ\n" +
                    "\n" +
                    "Allohumma laka sumtu va bika amantu va a'alayka tavakkaltu va 'ala rizqika aftartu, fag‘firli, ya G‘offaru, ma qoddamtu vama axxortu.\n" +
                    "\n" +
                    "Ma'nosi: Ey Alloh, ushbu ro‘zamni Sen uchun tutdim va Senga iymon keltirdim va Senga tavakkal qildim va bergan rizqing bilan iftor qildim. Ey mehribonlarning eng mehriboni, mening avvalgi va keyingi gunohlarimni mag‘firat qilgil!")

//            val duolar3: MutableList<String> = ArrayList(
//                "«Лаа илааҳа иллаллоҳу Муҳаммадур Росуулуллоҳ»",
//                "«Ашҳаду аллаа илааҳа иллаллоҳу ва ашҳаду анна Муҳаммадан ъабдуҳу ва Росуулуҳ»",
//                "«Ашҳаду аллаа илааҳа иллаллоҳу ваҳдаҳу лаа шарика лаҳ, лаҳул мулку ва лаҳул ҳамд, йуҳйии ва йумийт ва ҳува ҳаййул лаа йамуут, бийадиҳил хойр ва ҳува ъалаа кулли шайъин қодийр».",
//                "«Аллоҳумма! Инни аъуузу бика мин ан ушрика бика шайъан ва ана аълам, ва астағфирука лима лаа аълам. Иннака анта ъалламул ғуйууб»",
//                "«Астағфируллоҳ, астағфируллоҳ, астағфируллоҳа таъала мин кулли замбин азнабтаҳу ъамдан ав хотоан, сиррон ав ъаланийя, ва атуубу илайҳи миназ-замбиллазии аъламу ва миназ-замбиллазии лаа аълам, иннака анта ъалламул ғуйууб»",
//                "«Субҳааналлоҳи, валҳамдулиллааҳи, ва лаа илааҳа иллаллоҳу, валлоҳу акбар. Лаа ҳавла ва лаа қуввата иллаа биллааҳил ъалиййил ъазийм.Маа шаа Аллоҳу каана ва маа лам йашаъ лам йакун»")
//

            expandableListDetail["Saharlik duosi"] = duolar
            expandableListDetail["Iftorlik duosi"] = duolar2


            return expandableListDetail
        }
}