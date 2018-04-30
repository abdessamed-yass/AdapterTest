package com.example.yassineabdessamad.test.data;
/**
 * Created by yessine on 26-02-18.
 */


import java.util.ArrayList;
import java.util.Arrays;


public class DataValuesGenerate {
    public static ArrayList<String> name = new ArrayList<>(Arrays.asList(
            "SuperNatural",
            "How to get Away with Merder",
            "Game of Thrones",
            "Narcos",
            "Casa del papel"));


    public static ArrayList<String> description = new ArrayList<>(Arrays.asList(
            "La Casa de Papel est une série TV de Álex Pina avec Álvaro Morte (El Profesor)...",
            "Murder est une série télévisée américaine créée par Peter Nowalk...",
            "Game of Thrones, également désignée par le titre français de l'œuvre romanesque dont elle est adaptée..",
            "Narcos est une série télévisée américaine créée par Chris Brancato...",
            "La casa de papel ou La maison de papier est une série télévisée espagnole réalisée par Álex Pina..."));


    public static ArrayList<String> urls = new ArrayList<>(Arrays.asList(
            "https://toptech360.com/wp-content/uploads/2017/12/wkfFvZD-1021x580.jpg",
            "https://www.cineseries-mag.fr/wp-content/uploads/2016/03/How-To-get-away-with-murder-saison-2-critique-peter-nowalk.jpg",
            "http://geeko.lesoir.be/wp-content/uploads/sites/58/2015/02/game.jpg",
            "http://img0.ndsstatic.com/narcos/narcos-saison-4_270798_w696.jpg",
            "https://statics.lesinrocks.com/content/thumbs/uploads/2018/03/width-1125-height-612-srcset-1/casa-2-2.jpg"));


    public static RowData getRow() {
        int i = randomWithRange(0, 4);
        return new RowData(name.get(i), description.get(i), urls.get(i));
    }

    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static ArrayList<RowData> getAll() {
        ArrayList<RowData> listAll = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            listAll.add(new RowData(name.get(i), description.get(i), urls.get(i)));

        }
        return listAll;
    }
}
