package org.example.PlanerTasks.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSimpleTrMatch() {
        SimpleTask simpleTask = new SimpleTask(10, "Сделать домашнее задание");

        Todos todos = new Todos();

        boolean actual = simpleTask.matches("Сделать");

        Assertions.assertTrue(actual);
    }

    @Test
    public void SimpleFlMatch() {
        SimpleTask simpleTask = new SimpleTask(123, "Записать в дневник");

        Todos todos = new Todos();

        boolean actual = simpleTask.matches("Заполнить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void SimpleAroundMatch() {
        SimpleTask simpleTask = new SimpleTask(10, "Сделать презентацию");

        Todos todos = new Todos();

        boolean actual = simpleTask.matches("сделать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void SimpleLactMatch() {
        SimpleTask simpleTask = new SimpleTask(10, "Испечь пирожки по бабушкиному рецепту");

        Todos todos = new Todos();

        boolean actual = simpleTask.matches("по");

        Assertions.assertTrue(actual);
    }

    @Test
    public void SimpleSpaceMatch() {
        SimpleTask simpleTask = new SimpleTask(10, "здесь несколько пробелов");

        Todos todos = new Todos();

        boolean actual = simpleTask.matches(" ");

        Assertions.assertTrue(actual);
    }

    @Test
    public void EpicTrMatch() {
        String[] subtasks = {"Бабушка", "Дедушка", "Тетя"};
        Epic epic = new Epic(10, subtasks);

        Todos todos = new Todos();

        boolean actual = epic.matches("Бабушка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void EpicFalMatch() {
        String[] subtasks = {"Бабушка", "Дедушка", "Тетя"};
        Epic epic = new Epic(10, subtasks);

        Todos todos = new Todos();

        boolean actual = epic.matches("Брат");

        Assertions.assertFalse(actual);
    }

    @Test
    public void MeetingFalMatch() {
        Meeting meeting = new Meeting(
                895,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        boolean actual = meeting.matches("Релиз");

        Assertions.assertFalse(actual);
    }

    @Test
    public void MeetingTrMatch() {
        Meeting meeting = new Meeting(
                385,
                "Релиз новой платежной системы",
                "Банк хоум",
                "После ужина"
        );

        Todos todos = new Todos();

        boolean actual = meeting.matches("хоум");

        Assertions.assertTrue(actual);
    }

    @Test
    public void MeetingYetOneTrMatch() {
        Meeting meeting = new Meeting(
                85,
                "Выходной день",
                "Новый год",
                "Целый день"
        );

        Todos todos = new Todos();

        boolean actual = meeting.matches("день");

        Assertions.assertTrue(actual);
    }

    @Test
    public void SearchTasksEmpty() {
        SimpleTask simpleTask = new SimpleTask(78, "Написать стих");

        String[] subtasks = {"Ластик", "Карандаш", "Ручка"};
        Epic epic = new Epic(8, subtasks);

        Meeting meeting = new Meeting(
                142,
                "Реализация нового функционала",
                "х7",
                "Ночью после 12"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Обед");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchTasksOne() {
        SimpleTask simpleTask = new SimpleTask(45, "Повесить шторы");

        String[] subtasks = {"Пластины", "Отвертка", "Крепежи"};
        Epic epic = new Epic(80, subtasks);

        Meeting meeting = new Meeting(
                765,
                "Провести регресс",
                "Батутный центр сайт",
                "Целый день"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Отвертка");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchTasksAll() {
        SimpleTask simpleTask = new SimpleTask(86, "Купить Продукты");

        String[] subtasks = {"Конфеты", "Подарок", "Продукты"};
        Epic epic = new Epic(91, subtasks);

        Meeting meeting = new Meeting(
                423,
                "Подготовить к сдаче проект",
                "Продукты банка",
                "Вечер после 5"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Продукт");
        Assertions.assertArrayEquals(expected, actual);
    }





}
