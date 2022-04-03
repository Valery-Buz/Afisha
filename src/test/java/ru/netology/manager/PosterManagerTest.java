package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    Poster first = new Poster(1, "http://", "Бладшот", "боевик");
    Poster second = new Poster(2, "ссылка", "Вперёд", "мультфильм");
    Poster third = new Poster(3, "ссылка", "Отель Белград", "комедия");
    Poster fourth = new Poster(4, "ссылка", "Джентельмены", "боевик");
    Poster fifth = new Poster(5, "ссылка", "Человек-невидимка", "ужасы");
    Poster sixth = new Poster(6, "ссылка", "Тролли.Мировой тур", "мультфильм");
    Poster seventh = new Poster(7, "ссылка", "Номер один", "комедия");
    Poster eighth = new Poster(8, "ссылка", "Человек-паук: Нет пути домой", "фантастика");
    Poster ninth = new Poster(9, "ссылка", "Смерть на ниле", "детектив");
    Poster tenth = new Poster(10, "ссылка", "Старик Генри", "вестерн");

    Poster[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

    @Test
    void shouldAdd() {
        PosterManager manager = new PosterManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Poster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowInReverseOrder() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        Poster[] expected = {fifth, fourth, third, second, first};
        Poster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldAddNew() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Poster posterAddNew = new Poster(11, "Три икса", "http://", "боевик");
        manager.add(posterAddNew);
        Poster[] actual = manager.getLastAdd();
        Poster[] expected = {new Poster(11, "Три икса", "http://", "боевик"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);

    }

    @Test
    void showPoster() {
        PosterManager manager = new PosterManager();
        Poster[] actual = manager.getLastAdd();
        Poster[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowOverMax() {
        PosterManager manager = new PosterManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Poster[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }
}