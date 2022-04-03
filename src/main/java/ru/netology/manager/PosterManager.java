package ru.netology.manager;

import ru.netology.domain.Poster;

public class PosterManager {

    private Poster[] posters = new Poster[0];
    private int numberOfFilms = 10;

    public PosterManager(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public PosterManager() {
    }

    public void add(Poster poster) {
        int length = posters.length +1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(posters, 0, tmp, 0, posters.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = poster;
        posters = tmp;
    }

    public Poster[] getLastAdd() {
        int resultLength;
        if (posters.length > numberOfFilms) {
            resultLength = numberOfFilms;
        }
        else {
            resultLength = posters.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = posters.length - i - 1;
            result[i] = posters[index];
        }
        return result;
    }




}
