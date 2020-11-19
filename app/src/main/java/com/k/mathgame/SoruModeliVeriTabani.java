package com.k.mathgame;

import java.util.ArrayList;
import java.util.List;

public class SoruModeliVeriTabani {
    List<SoruModel> soruModelList = new ArrayList<>();

    public SoruModeliVeriTabani(String seviyeAdi) {
        if(seviyeAdi.equals("Seviye 1")){
            seviyeBir();
        }else if(seviyeAdi.equals("Seviye 2")){
            seviyeİki();
        }else if(seviyeAdi.equals("Seviye 3")){
            seviyeUc();
        }else if(seviyeAdi.equals("Seviye 4")){
            seviyeDort();
        }else if(seviyeAdi.equals("Seviye 5")){
            seviyeBes();
        }
    }


    public void seviyeBir(){
       soruModelList.add(new SoruModel(9,1,3,6,5));
       soruModelList.add(new SoruModel(11,0,9,1,1));
       soruModelList.add(new SoruModel(13,3,7,4,2));
       soruModelList.add(new SoruModel(15,4,6,7,5));
       soruModelList.add(new SoruModel(17,10,8,1,6));
       soruModelList.add(new SoruModel(21,6,7,8,4));
       soruModelList.add(new SoruModel(23,8,11,4,7));
       soruModelList.add(new SoruModel(25,1,12,8,5));
       soruModelList.add(new SoruModel(30,11,9,10,8));
       soruModelList.add(new SoruModel(33,9,15,4,11));
       soruModelList.add(new SoruModel(36,7,21,8,23));
       soruModelList.add(new SoruModel(40,20,10,8,12));
       soruModelList.add(new SoruModel(42,14,20,16,6));
       soruModelList.add(new SoruModel(45,30,7,8,11));
       soruModelList.add(new SoruModel(53,40,5,20,3));
       soruModelList.add(new SoruModel(59,9,25,24,10));
       soruModelList.add(new SoruModel(61,23,33,5,9));
       soruModelList.add(new SoruModel(64,34,12,22,30));

    }

    private void seviyeİki() {
        soruModelList.add(new SoruModel(24,7,3,14,15));
        soruModelList.add(new SoruModel(31,10,11,15,5));
        soruModelList.add(new SoruModel(39,19,13,16,10));
        soruModelList.add(new SoruModel(41,13,12,16,15));
        soruModelList.add(new SoruModel(47,17,17,16,13));
        soruModelList.add(new SoruModel(48,16,16,16,15));
        soruModelList.add(new SoruModel(51,21,13,16,14));
        soruModelList.add(new SoruModel(56,20,14,21,15));
        soruModelList.add(new SoruModel(57,18,32,7,15));
        soruModelList.add(new SoruModel(63,20,23,20,25));
        soruModelList.add(new SoruModel(65,15,25,35,5));
        soruModelList.add(new SoruModel(69,23,26,20,25));
        soruModelList.add(new SoruModel(72,21,32,22,29));
        soruModelList.add(new SoruModel(76,21,30,26,25));
        soruModelList.add(new SoruModel(81,31,33,16,17));
        soruModelList.add(new SoruModel(83,29,23,36,24));
        soruModelList.add(new SoruModel(85,43,22,24,18));
        soruModelList.add(new SoruModel(88,29,36,30,22));

    }
    private void seviyeUc() {
        soruModelList.add(new SoruModel(70,20,5,45,7));
        soruModelList.add(new SoruModel(77,10,7,4,60));
        soruModelList.add(new SoruModel(80,20,55,75,5));
        soruModelList.add(new SoruModel(86,43,42,23,20));
        soruModelList.add(new SoruModel(92,23,60,9,54));
        soruModelList.add(new SoruModel(96,23,44,14,38));
        soruModelList.add(new SoruModel(98,64,53,23,22));
        soruModelList.add(new SoruModel(90,33,45,34,23));
        soruModelList.add(new SoruModel(91,24,46,34,11));
        soruModelList.add(new SoruModel(95,28,29,32,34));
        soruModelList.add(new SoruModel(97,35,43,36,26));
        soruModelList.add(new SoruModel(98,35,34,29,25));
        soruModelList.add(new SoruModel(100,24,34,22,42));
        soruModelList.add(new SoruModel(105,15,55,25,35));
        soruModelList.add(new SoruModel(112,54,24,48,10));
        soruModelList.add(new SoruModel(118,33,43,53,42));
        soruModelList.add(new SoruModel(120,43,33,44,49));
        soruModelList.add(new SoruModel(121,54,39,49,33));
    }
    private void seviyeDort() {
        soruModelList.add(new SoruModel(123,41,51,40,42));
        soruModelList.add(new SoruModel(130,20,50,40,70));
        soruModelList.add(new SoruModel(133,43,27,65,56));
        soruModelList.add(new SoruModel(137,20,53,47,37));
        soruModelList.add(new SoruModel(145,55,85,65,25));
        soruModelList.add(new SoruModel(148,46,26,45,76));
        soruModelList.add(new SoruModel(152,34,56,46,50));
        soruModelList.add(new SoruModel(154,38,44,46,64));
        soruModelList.add(new SoruModel(159,53,22,84,31));
        soruModelList.add(new SoruModel(160,52,54,54,50));
        soruModelList.add(new SoruModel(170,56,46,66,68));
        soruModelList.add(new SoruModel(172,58,26,88,31));
        soruModelList.add(new SoruModel(174,24,58,34,82));
        soruModelList.add(new SoruModel(180,60,45,15,105));
        soruModelList.add(new SoruModel(183,20,61,41,81));
        soruModelList.add(new SoruModel(189,63,7,56,119));
        soruModelList.add(new SoruModel(190,64,53,10,116));
        soruModelList.add(new SoruModel(191,5,65,58,68));
    }
    private void seviyeBes() {
        soruModelList.add(new SoruModel(200,68,14,12,17,120,89,54,91));
        soruModelList.add(new SoruModel(203,78,69,98,12,122,56,55,23));
        soruModelList.add(new SoruModel(220,74,63,32,56,83,45,68,10));
        soruModelList.add(new SoruModel(256,86,78,66,68,104,19,77,98));
        soruModelList.add(new SoruModel(265,89,32,32,56,84,92,78,4));
        soruModelList.add(new SoruModel(280,102,94,103,50,136,104,43,105));
        soruModelList.add(new SoruModel(284,96,42,35,5,183,37,89,39));
        soruModelList.add(new SoruModel(300,24,75,100,98,51,149,78,49));
        soruModelList.add(new SoruModel(302,65,102,67,58,98,142,32,42));
        soruModelList.add(new SoruModel(305,103,98,97,78,105,75,4,65));
        soruModelList.add(new SoruModel(310,34,46,104,64,71,135,76,32));
        soruModelList.add(new SoruModel(320,108,67,47,165,86,77,59,66));
        soruModelList.add(new SoruModel(333,65,111,4,37,218,86,107,97));
        soruModelList.add(new SoruModel(340,114,67,50,16,176,63,156,77));
        soruModelList.add(new SoruModel(345,115,344,115,302,115,43,0,27));

    }

}
